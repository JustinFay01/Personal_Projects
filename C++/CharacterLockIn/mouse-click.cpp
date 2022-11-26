#include <WinDef.h>
#include <winuser.h>
#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

void lockin()
{
    SetCursorPos(725, 434);
}

int main()
{
    // Gets cursor for cordinates
    POINT p;
    // sets display to be used
    HWND hWnd{0};

    printf("Welcome to instant character select\nPress Q to quit or hold the corresponding number for the character you want:\n");
    printf("1 -> Champ 1..\n2 -> Champ 2..\n");

    int running = 1;
    while (running == 1)
    {

        // Check key (listents to designated key and checks bit order to determine pressed or released)
        if (GetKeyState('1') & 0x8000)
        {
            // print which character is being locked in
            printf("Locking in Renya...\n");
            // set and click
            SetCursorPos(456, 468);
            mouse_event(MOUSEEVENTF_LEFTDOWN | MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);

            lockin();
        }
        else if (GetKeyState('2') & 0x8000)
        {
            GetCursorPos(&p);
            cout << "x = " << p.x << "y = " << p.y << endl;
        }
        else if (GetKeyState('3') & 0x8000)
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
