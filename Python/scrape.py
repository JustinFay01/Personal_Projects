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


url= "https://www.linkedin.com/jobs/search/?currentJobId=3357016032&geoId=103644278&keywords=software%20engineer%20intern&location=United%20States&refresh=true"
page = make_request(url)
# print(page) 
 # will display HTTP reponse codes 200 - 299 is sucessful

soup = BeautifulSoup(page.content, 'html.parser')
# print(soup.prettify)

contents = soup.find_all('a', class_= "base-card__full-link")
#print(contents)

with open('softwareinternship.csv', 'w', encoding='utf8', newline='') as f:
	thewriter = writer(f)
	header = ['Title','Comapny', 'Link']
	thewriter.writerow(header)

	for stuff in contents:
		title = stuff.find('span', class_="sr-only").text.replace('\n            \n        \n        ', '').replace('\n      \n      \n          ','')
		links = stuff.get('href')

		companyPage = make_request(links)
		soup = BeautifulSoup(companyPage.content, 'html.parser')
		#print(soup.prettify)

		company = soup.find('div', class_="relative").find('span').find('a').text.strip()
		print(company)
	

		info = [title, company, links]
		thewriter.writerow(info)



	


