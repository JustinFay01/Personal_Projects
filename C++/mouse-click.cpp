#include <WinDef.h>
#include <winuser.h>
#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

void lockin(){
    SetCursorPos(725,434);
}

int main() {
    //Gets cursor for cordinates
    POINT p;
    //sets display to be used 
    HWND hWnd{ 0 };
    
    int running = 1;

    printf("Hold R for Reyna, K for KillyJoy, or S for Sova.\n");
    while(running == 1){
        
        //Listens to designated key 
        //and uses bit order to check if it is up or down
       if(GetKeyState('R')& 0x8000){
        printf("Locking in Renya...\n");
        SetCursorPos(456,468);
        mouse_event(MOUSEEVENTF_LEFTDOWN | MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
        
        lockin();

       }
       else if(GetKeyState('K') & 0x8000){
         GetCursorPos(&p);
        cout << "x = " << p.x << "y = " << p.y << endl;
       }
       else if(GetKeyState('S') & 0x8000){
         GetCursorPos(&p);
        cout << "x = " << p.x << "y = " << p.y << endl;
       }

       //Used as quit command
       else if(GetKeyState('Q') & 0x8000){
        printf("Trying to quit\n");
        running = 0;
       }
    }
    printf("Locked in good luck.");
    return 0;
}


