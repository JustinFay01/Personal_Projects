#include <WinDef.h>
#include <winuser.h>
#include <stdio.h>
#include <iostream>

using namespace std;

int main() {
    POINT p;
    HWND hWnd{ 0 };
    for(int i = 0; i < 10;i++){
        GetCursorPos(&p);
        cout << "x = " << p.x << "y = " << p.y << endl;
       
    }
    SetCursorPos(50,87);
    mouse_event(MOUSEEVENTF_LEFTDOWN | MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
    
    return 0;
}
