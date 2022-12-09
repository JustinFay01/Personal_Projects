#Import OS
import os.path
import time

#BS4 Imports
from bs4 import BeautifulSoup
import pandas as pd

#Requests
from requests.adapters import HTTPAdapter, Retry
import requests

#Selenium
from selenium.webdriver import Chrome
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys

from selenium.webdriver.chrome.options import Options

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def make_request(url):
	session = requests.Session()
	retry = Retry(connect=3, backoff_factor=0.5)
	adapter = HTTPAdapter(max_retries=retry)
	session.mount('http://', adapter)
	session.mount('https://', adapter)

	return session.get(url)


# Variables
# Linkedin ID and PASSWORD
email = "JustinFay74@gmail.com"
password = "topsecret123"

# Write here the job position and local for search
position = "software engineer iternships"
local = "United States"


# formating to linkedin model
position = position.replace(' ', "%20")
local = local.replace(' ', "%20")




url = "https://www.linkedin.com/jobs/search/?currentJobId=3303863689&f_JT=I&f_WT=2%2C3&geoId=103644278&keywords={position}&location={local}&refresh=true"



# ## Setup chrome options
chrome_options = Options()
#chrome_options.add_argument("--headless") # Ensure GUI is off
# chrome_options.add_argument("--no-sandbox")

#Set driver path
homedir = os.path.expanduser("~")
webdriver_service = Service(f"{homedir}/chromedriver/stable/chromedriver")
driver = Chrome(executable_path=f"{homedir}/chromedriver/stable/chromedriver")

#get browser using chrome options
driver = webdriver.Chrome(service=webdriver_service, options=chrome_options)

# Opening linkedin website
driver.get(url)
# waiting load
time.sleep(2)

# Maximizing browser window to avoid hidden elements
driver.set_window_size(1024, 600)
driver.maximize_window()



disc_list = []
for i in range(1, 5):
    # click button to change the job list
    driver.find_element(By.XPATH, f'//button[@aria-label="Page {i}"]').click()
    # each page show us some jobs, sometimes show 25, others 13 or 21 ¯\_(ツ)_/¯
    jobs_lists = driver.find_element(By.CLASS_NAME,
       'scaffold-layout__list-container')  # here we create a list with jobs
    jobs = driver.find_element(By.CLASS_NAME,
        'jobs-search-results__list-item')  # here we select each job to count
    # waiting load
    time.sleep(1)
    # the loop below is for the algorithm to click exactly on the number of jobs that is showing in list
    # in order to avoid errors that will stop the automation
    for job in range(1, len(jobs)+1):
        # job click
        driver.find_element(By.XPATH, 
            f'/html/body/div[4]/div[3]/div[4]/div/div/main/div/section[1]/div/ul/li[1]').click()
        # waiting load
        time.sleep(1)
        # select job description
        job_desc = driver.find_element(By.CLASS_NAME, f'jobs-search__right-rail')
        # get text
        soup = BeautifulSoup(job_desc.get_attribute(
            'outerHTML'), 'html.parser')
        # add text to list
        disc_list.append(soup.text)


df = pd.DataFrame(disc_list)

df = df.replace(['\n',
                 '^.*?Expect',
                 '^.*?Qualifications',
                 '^.*?Required',
                 '^.*?expected',
                 '^.*?Responsibilities',
                 '^.*?Requisitos',
                 '^.*?Requirements',
                 '^.*?Qualificações',
                 '^.*?QualificationsRequired1',
                 '^.*?você deve ter:',
                 '^.*?experiência',
                 '^.*?você:',
                 '^.*?Desejável',
                 '^.*?great',
                 '^.*?Looking For',
                 '^.*?ll Need',
                 '^.*?Conhecimento',
                 '^.*?se:',
                 '^.*?habilidades',
                 '^.*?se:',
                 '^.*?REQUISITOS'
                 ], '', regex=True)



print(df)

