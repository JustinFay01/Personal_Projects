import requests

proxy = '35.193.113.186:80' 

r = requests.get('http://httpbin.org/ip', proxies = {'http' : proxy, 'https' : proxy}, timeout = 3)
print(r.status_code)

 