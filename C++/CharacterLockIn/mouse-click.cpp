#include <WinDef.h>
#include <winuser.h>
#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

void lockin()
{
    SetCursorPos(1292, 1054);
    click();
}

void click(){
     mouse_event(MOUSEEVENTF_LEFTDOWN | MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
}
/**
Character Cordinates for Main Monitor
Estimate
Lock in Button -> 1283 1083
Astra -> x = 774y = 1228
Breach -> x = 896y = 1220
Brim -> x = 1005y = 1228
Chamber -> x = 1114y = 1237
Cypher -> x = 1234y = 1238
Fade -> x = 1349y = 1240
Jett -> x = 1453y = 1239
Kayo -> x = 1566y = 1233
KillJoy -> x = 1683y = 1237
Omen -> x = 1792y = 1242
Phoenix -> x = 782y = 1337
Raze -> x = 886y = 1334
Reyna -> x = 1118y = 1341
Sage -> x = 1121y = 1347
Skye -> x = 1233y = 1347
Neon -> x = 1336y = 1344
Yoru ->x = 1456y = 1346
x = 1570y = 1347
x = 1679y = 1344
*/ 

int main()
{
    // Gets cursor for cordinates
    POINT p;
    // sets display to be used
    HWND hWnd{0};

    printf("Welcome to instant character select\nPress Q to quit, C to print current mouse cordinates or hold the corresponding number for the character you want:\n");
    printf("1 -> Reyna..\n2 -> KillyJoy..\n3 -> Jett..\n4 -> Chamber..\n5-> Reyna on alt..\n");

    int running = 1;
    while (running == 1)
    {

        // Check key (listents to designated key and checks bit order to determine pressed or released)
        if (GetKeyState('1') & 0x8000)
        {
            // print which character is being locked in
            printf("Locking in Renya...\n");
            // set and click
            SetCursorPos(1118, 1341);
            click();
            lockin();
        }
        else if (GetKeyState('2') & 0x8000)
        {
            printf("Locking in KillyJoy...\n");
            SetCursorPos(1683,1237);
            click();

            lockin();
        }
        else if (GetKeyState('3') & 0x8000)
        {
            printf("Locking in Jett...\n");
            SetCursorPos(1453, 1239);
            click();
            lockin();
        }
        else if (GetKeyState('4') & 0x8000)
        {
            printf("Locking in Chamber...\n");
            SetCursorPos(1114, 1237);
            click();
            lockin();
        }
        else if (GetKeyState('5') & 0x8000)
        {
            printf("Locking in Reyna on Alt...\n");
            SetCursorPos(1220, 1213);
            click();
            lockin();
        }
        else if (GetKeyState('C') & 0x8000)
        {
            GetCursorPos(&p);
            cout << "x = " << p.x << "y = " << p.y << endl;
        }
        // Used as quit command
        else if (GetKeyState('Q') & 0x8000)
        {
            printf("Trying to quit\n");
            printf("Good Luck\n");
            running = 0;
        }
    }

    return 0;
}
