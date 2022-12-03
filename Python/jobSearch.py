import os
import datetime
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from google.cloud import bigquery
import nltk
from nltk.tokenize import word_tokenize, MWETokenizer

# got tired of warnings 🙃
import warnings
warnings.filterwarnings('ignore')

# Only need to run once
nltk.download('punkt')


data_url = '../input/data-analyst-job-postings-google-search/gsearch_jobs.csv'
jobs_all = pd.read_csv(data_url).replace("'","", regex=True)
jobs_all.date_time = pd.to_datetime(jobs_all.date_time) # convert to date time
jobs_all = jobs_all.drop(labels=['Unnamed: 0', 'index'], axis=1, errors='ignore')
jobs_all.description_tokens = jobs_all.description_tokens.str.strip("[]").str.split(",")




print("Big Query Statistics:")
print("---------------------")
print(f"🚣‍♀️ Rows of data: {len(jobs_all)}")

repeat_jobs = jobs_all.job_id.value_counts()
try:
    repeat_jobs = repeat_jobs[repeat_jobs>1].index[0]
    repeat_jobs = len(repeat_jobs)
except IndexError:
    repeat_jobs = "None"
print(f"👯‍♀️ Number jobs repeated: {repeat_jobs}")

first_date = jobs_all.date_time.dt.date.min()
today_date = datetime.date.today() #+ datetime.timedelta(days=2) # test function works
date_count = pd.DataFrame(jobs_all.date_time.dt.date.value_counts())
missing_dates = list(pd.date_range(start=first_date, end=today_date).difference(date_count.index))
if len(missing_dates) > 0:
    print("❌ Missing data for following dates:")
    for date in missing_dates:
        print(date)
else:
    print(f"✅ No missing dates of data since inception of: {first_date}")

delta_days = (today_date - (first_date - datetime.timedelta(days=2))).days # first day was actually day prior but UTC
jobs_day = round(len(jobs_all)/delta_days)
print(f"🧑‍💻 Average number of jobs per day: {jobs_day}")
print(f"📆 Collecting data for {delta_days} days now...")




def eda_plot(column, topn=10):
    plt.figure(figsize=(4, 2))
    jobs_all[column].value_counts().nlargest(topn).plot(kind='bar')
    plt.title(f"'{column}' column value counts")
    plt.ylabel("Counts")
    plt.xticks(rotation = 45, ha='right')
    plt.show()

columns = ['title', 'company_name', 'location', 'via', 'schedule_type', 'work_from_home']

for column in columns:
    eda_plot(column)