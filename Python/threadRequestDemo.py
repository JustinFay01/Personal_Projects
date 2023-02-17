import requests
import threading

url = ""
data = {
    'field': 'value'
}


def do_request():
    for i in range(50):
        # response = requests.post(url, data=data).text
        # print(response)
        print("test")


threads = []

for i in range(50):
    t = threading.Thread(target=do_request)
    t.daemon = True
    threads.append(t)

for i in range(50):
    threads[i].start()

for i in range(50):
    threads[i].join()
