import pyautogui as mouse
import keyboard  as kb # using module keyboard
import time

#Screen size = 2560 1440
#Box one x y = 777 1234
#Box one TL = 726 1184
#Box one BR = 824 1282

# Set Screen Size
screenWidth, screenHeight = mouse.size() # Get the size of the primary monitor.
print(screenWidth, screenHeight)

def click(x, y):
    mouse.leftClick(x, y)

state = 0
while True:  # making a loop
        if kb.is_pressed('q'):  # if key 'q' is pressed 
            print('You Pressed A Key!')
            break  # finishing the loop
        elif kb.is_pressed('1'):
            print(mouse.position())
            
print(int(screenWidth*0.696484375))
print(int(screenHeight*0.143055555))
print(int((screenWidth*0.03828125)/2))
           






