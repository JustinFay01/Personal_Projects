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
sleep = .025

# Set Screen Size
screenWidth, screenHeight = mouse.size() # Get the size of the primary monitor.


#Set original Box values for row one
boxOneX = int(screenWidth*0.303515625); boxOneY = int(screenHeight*0.8569444444444); boxLength = int(screenWidth*0.04375)
#screen 1279/width #screen height 1086/1440
lockInX = int(screenWidth*.5); lockInY = int(screenHeight*.75)

#Click Lock In Button
def lockIn():   
    time.sleep(sleep)
    mouse.click(lockInX, lockInY)

#Character Select Sequence
def agentSelect(character):
    if kb.is_pressed('Ctrl'):
        #print("locking in Agent", character + 11, "...")
        mouse.click(boxOneX + (character * boxLength), boxOneY + boxLength)
        lockIn()
        time.sleep(sleep)
    else:
        #print("Locking in Agent", character + 1, "...")
        mouse.click(boxOneX + (character * boxLength), boxOneY)
        lockIn()
        time.sleep(sleep)


#Console Welcome
#print("Welcome to Auto Agent Select!")
#printSeperator()
# Astra Breach Brim CHamber Cy Fade HArbor Jett Kayo KJ 
# Neon omen phoneix raze reyna sage skye sova viper yoru

agents = ["Astra", "Breach", "Brim", "Chamber", "Cypher", "Fade", "Harbor", "Jett", "Kayo", "KJ",
             "Neon", "Omen", "Phoneix", "Raze", "Reyna", "Sage", "Skye", "Sova", "Viper", "Yoru" ]        

while True: 
    input = kb.read_key()
    match input:
        case 'q':
            #print('Good Luck!')
            break  # finishing the loop
        case '1':
            agentSelect(0)
        case '2':
            agentSelect(1)
        case '3':
            agentSelect(2)
        case '4':
            agentSelect(3)
        case '5':
            agentSelect(4)
        case '6':
            agentSelect(5)
        case '7':
            agentSelect(6)
        case '8':
            agentSelect(7)
        case '9':
            agentSelect(8)
        case '0':
            agentSelect(9)
        
            

           






