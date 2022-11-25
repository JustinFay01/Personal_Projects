#include <WinDef.h>
#include <winuser.h>
#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

int main() {
    POINT p;
    HWND hWnd{ 0 };
    for(int i = 0; i < 10;i++){
        GetCursorPos(&p);
        cout << "x = " << p.x << "y = " << p.y << endl;
       
    }

    cout << "What champ you want foo?" << endl;
    string champ;
    getline(cin, champ);
    cout << champ << " it is." << endl;
    
    SetCursorPos(50,87);
    mouse_event(MOUSEEVENTF_LEFTDOWN | MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);



    
    return 0;
}
