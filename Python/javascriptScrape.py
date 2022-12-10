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
#preforms actions
from selenium import webdriver

from selenium.webdriver.common.by import By

from selenium.webdriver.chrome.service import Service

#key strokes
from selenium.webdriver.common.keys import Keys

from selenium.webdriver.chrome.options import Options

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


# Write here the job position and local for search
position = "software engineer iternships"
local = "United States"


# formating to linkedin model
position = position.replace(' ', "%20")
local = local.replace(' ', "%20")


url = "https://www.linkedin.com/jobs/search/?currentJobId=3379159561&geoId=103644278&keywords=software%20engineer%20internships&location=United%20States&refresh=true"

# Variables
# Linkedin ID and PASSWORD
email = "Justin.Fay@hope.edu"
password = "zKswiG4cRt6TU*!" 


# ## Setup chrome options
chrome_options = Options()
#chrome_options.add_argument("--headless") # Ensure GUI is off
#chrome_options.add_argument("--no-sandbox")

#chrome_options.add_argument('--proxy-server=%s' % proxy)

#Set driver path
homedir = os.path.expanduser("~")
webdriver_service = Service(f"{homedir}/chromedriver/stable/chromedriver")
driver = Chrome(executable_path=f"{homedir}/chromedriver/stable/chromedriver")

#get browser using chrome options
driver = webdriver.Chrome(service=webdriver_service)

# Opening linkedin website
driver.get("https://www.linkedin.com")


# waiting load
time.sleep(1)

# Maximizing browser window to avoid hidden elements
driver.set_window_size(1024, 600)
driver.maximize_window()

"""
Can Access Elements in Selenium by
Id - Guaranteed to be unique
Name - Not Guaranteed to be unique but might be okay 
Class - Worse situation
Tag
"""

search = driver.find_element(By.NAME,"session_key")
time.sleep(2)
search.send_keys(email)
search.send_keys(Keys.RETURN)
time.sleep(1)

search = driver.find_element(By.NAME, "session_password")
time.sleep(2)
search.send_keys(password)
search.send_keys(Keys.RETURN)
time.sleep(2)

#Get Software Engineer Page
driver.get(url)
time.sleep(1)


job_listings = driver.find_elements(By.XPATH,"//main/div[1]/section/div[1]/ul/li")
print(job_listings)

frame = []
try:
	# Extract the job title and other relevant details from each listing
	for listing in job_listings:

		title = WebDriverWait(listing, 10).until(
			EC.presence_of_element_located((By.XPATH,".//div/div/div/div[2]/div/a"))
		)

		company = WebDriverWait(listing, 10).until(
			EC.presence_of_element_located((By.XPATH,".//div/div/div/div[2]/div[2]/a"))
		)

		location = WebDriverWait(listing, 10).until(
			EC.presence_of_element_located((By.XPATH,".//div/div/div/div[2]/div[3]/ul/li"))
		)
		info = [title.text,company.text, location.text]
		# Print the job title, company, and location
		#print(f"{title.text} at {company.text} in {location.text}")
		frame.append(info)
		time.sleep(1)
finally:
	time.sleep(1)
	driver.quit()

df = pd.DataFrame(frame)
print(frame)