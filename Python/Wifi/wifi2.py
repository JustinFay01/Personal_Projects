import subprocess
import re

process = subprocess.run(["netsh", "wlan", "show", "profile"], capture_output=True).stdout.decode()
#print(process)
profile_names_raw = process.split("All User Profile     : ")
#print(profile_names_raw)
profile_names = []
for name in profile_names_raw:
    if('All User Profile' not in name):
         profile_names.append(name.strip())
del profile_names[0]
del profile_names[1]
#print(profile_names)
wifi = []

if len(profile_names) != 0:
    for i in range(len(profile_names)):
        name = profile_names[i]
       
        wifi_profile = {}
        wifi_profile["ssid"] = profile_names[i]

        cmd = ('netsh', 'wlan', 'show', 'profile', name, "key=clear")
        info_pass =  profile_info_pass = subprocess.run(["netsh", "wlan", "show", "profile", name, "key=clear"], capture_output = True).stdout.decode()
        password = re.search("Key Content            : (.*)\r", info_pass)

        if password == None:
            continue
        else:
            wifi_profile["password"] = password[1].strip()
        wifi.append(wifi_profile)
with open("pswrds.txt", "w") as f:
    print(wifi, file=f)
    for x in range(len(wifi)):
        print(wifi[x])

