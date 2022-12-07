from bs4 import BeautifulSoup
import requests
from csv import writer

url= "https://www.linkedin.com/jobs/search/?currentJobId=3289565209&f_JT=I&geoId=103112676&keywords=software%20engineer%20internship&location=Chicago%2C%20Illinois%2C%20United%20States&refresh=true"
page = requests.get(url)
# print(page) 
 # will display HTTP reponse codes 200 - 299 is sucessful

soup = BeautifulSoup(page.content, 'html.parser')
# print(soup.prettify)

contents = soup.find_all('a', class_= "base-card__full-link")
#print(contents)

with open('softwareinternship.csv', 'w', encoding='utf8', newline='') as f:
    thewriter = writer(f)
    header = ['Title','Link', 'Company']
    thewriter.writerow(header)


    
    for content in contents:
        title = content.find('span', class_="sr-only").text.replace('\n            \n        \n        ', '').replace('\n      \n      \n          ','')
        links = content.get('href')
        company = soup.find_all_next('h4', class_= 'base-search-card__subtitle')
        info = [title, company, links]
        thewriter.writerow(info)


    


