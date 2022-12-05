from bs4 import BeautifulSoup
import requests
from csv import writer

url= "https://www.linkedin.com/jobs/search/?currentJobId=3362033747&keywords=software%20engineer%20internship"
page = requests.get(url)
# print(page) 
 # will display HTTP reponse codes 200 - 299 is sucessful

soup = BeautifulSoup(page.content, 'html.parser')
# print(soup)


contents = soup.find_all('div', class_= "base-search-card__info")
# print(contents)

with open('softwareinternship.csv', 'w', encoding='utf8', newline='') as f:
    thewriter = writer(f)
    header = ['Title', 'Company', 'Link']
    thewriter.writerow(header)

    for content in contents:
        title = content.find('h3', class_="base-search-card__title").text.replace('\n            \n        ', '')
        info = content.find('h4', class_="base-search-card__subtitle").text.replace('\n\n            ','')
        for link in content.find_all('a'):
            links = link.get('href')
        info = [title,info,links]
        print(info)
        thewriter.writerow(info)
