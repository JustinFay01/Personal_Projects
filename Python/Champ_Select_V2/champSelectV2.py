import pyautogui as mouse
import keyboard  as kb # using module keyboard
import time

#Screen size = 2560 1440
#Box one x y = 777 1234
#box length = 112
#Lock in x y = 1279 1086

mouse.FAILSAFE = False
mouse.MINIMUM_DURATION = 0
mouse.PAUSE = 0
sleep = .01

#Pretty Console
def printSeperator():
    for i in range(100):
        print("=",end= "")
    print("\n")
  

# Set Screen Size
screenWidth, screenHeight = mouse.size() # Get the size of the primary monitor.


#Set original Box values for row one
boxOneX = int(screenWidth*0.303515625); boxOneY = int(screenHeight*0.8569444444444); boxLength = int(screenWidth*0.04375)
#screen 1279/width #screen height 1086/1440
lockInX = int(screenWidth*.5); lockInY = int(screenHeight*.75)

#Click Lock In Button
def lockIn():   
    time.sleep(sleep)
    mouse.moveTo(lockInX, lockInY)


#Console Welcome
print("Welcome to Auto Agent Select!")
printSeperator()

print("Hold down keys 1 - 10 (0) to automatically select the an agent within that box on the top row! Then press 'q' to quit")

while True:  # making a loop
        if kb.is_pressed('q'):  # if key 'q' is pressed 
            print('Good Luck!')
            break  # finishing the loop
        elif kb.is_pressed('1'):
            print("Locking in Agent 1")
            mouse.moveTo(boxOneX,boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('2'):
            print("Locking in Agent 2")
            mouse.moveTo(boxOneX + (1 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('3'):
            print("Locking in Agent 3")
            mouse.moveTo(boxOneX + (2 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('4'):
            print("Locking in Agent 4")
            mouse.moveTo(boxOneX + (3 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('5'):
            print("Locking in Agent 5")
            mouse.moveTo(boxOneX + (4 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('6'):
            print("Locking in Agent 6")
            mouse.moveTo(boxOneX + (5 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('7'):
            print("Locking in Agent 7")
            mouse.moveTo(boxOneX + (6 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('8'):
            print("Locking in Agent 8")
            mouse.moveTo(boxOneX + (7 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('9'):
            print("Locking in Agent 9")
            mouse.moveTo(boxOneX + (8 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        elif kb.is_pressed('0'):
            print("Locking in Agent 10")
            mouse.moveTo(boxOneX + (9 * boxLength),boxOneY)
            lockIn()
            time.sleep(sleep)
        
       
        
            

           






