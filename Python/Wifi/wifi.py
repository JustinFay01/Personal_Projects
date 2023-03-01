import subprocess
import re

process = subprocess.run(["netsh", "wlan", "show", "profile"], capture_output=True).stdout.decode()

profile_names = (re.findall("All User Profile     : (.*)\r", process))
wifi = []

if len(profile_names) != 0:
    for i in range(len(profile_names)):
        name = profile_names[i]
       
        wifi_profile = {}
        info = subprocess.run(["netsh", "wlan", "show", "profile", name], capture_output = True).stdout.decode()
        if re.search("Security key           : Absent", info):
            continue
        else:
            wifi_profile["ssid"] = profile_names[i]

            cmd = ('netsh', 'wlan', 'show', 'profile', name, "key=clear")
            info_pass =  profile_info_pass = subprocess.run(["netsh", "wlan", "show", "profile", name, "key=clear"], capture_output = True).stdout.decode()
            password = re.search("Key Content            : (.*)\r", info_pass)

            if password == None:
                wifi_profile["password"] = None
            else:
                wifi_profile["password"] = password[1].strip()

            wifi.append(wifi_profile)
with open("pswrds.txt", "w") as f:
    print(wifi, file=f)
    for x in range(len(wifi)):
        print(wifi[x])

