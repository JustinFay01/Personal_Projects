from bs4 import BeautifulSoup
import requests
from csv import writer
from requests.adapters import HTTPAdapter, Retry





def make_request(url):
	session = requests.Session()
	retry = Retry(connect=3, backoff_factor=0.5)
	adapter = HTTPAdapter(max_retries=retry)
	session.mount('http://', adapter)
	session.mount('https://', adapter)

	return session.get(url)

url= "https://contacts.google.com/directory"
page = make_request(url)


soup = BeautifulSoup(page.content, 'html.parser')
print(soup.prettify)