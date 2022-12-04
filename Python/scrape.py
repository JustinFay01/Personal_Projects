from bs4 import BeautifulSoup
import requests


url= "https://www.linkedin.com/jobs/search/?currentJobId=3380094907&keywords=software%20engineer%20internship"
page = requests.get(url)
print(page) 
 # will display HTTP reponse codes 200 - 299 is sucessful

soup = BeautifulSoup(page.content, 'html.parser')
print(soup)


titles = soup.find_all('h3', class_="base-search-card__title")
for title in titles:
    print(title.text)

links = soup.find_all('a', class_= "base-card__full-link")
for link in links:
    print(link.get('href'))
