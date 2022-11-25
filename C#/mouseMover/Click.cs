using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.InteropServices;
using System.Data;
using System.Drawing;
using System.Windows.Forms;


namespace mouseMover{

    class Click
    {
        [DllImport("user32.dll")]
        static extern void mouse_event(int dwFlags, int dx, int dy, int dwData, int dwExtraInfo);

        [Flags]
        public enum MouseEventFlags
        {
            LEFTDOWN = 0x00000002,
            LEFTUP = 0x00000004,
            MIDDLEDOWN = 0x00000020,
            MIDDLEUP = 0x00000040,
            MOVE = 0x00000001,
            ABSOLUTE = 0x00008000,
            RIGHTDOWN = 0x00000008,
            RIGHTUP = 0x00000010
        }

        public void leftClick(Point p){//point where mouse is going to click
            Cursor.position = p;
            mouse_event((int)(MouseEventFlags.LEFTDOWN),0,0,0,0);
            mouse_event((int)(MouseEventFlags.LEFTUP),0,0,0,0);
            
        }
         public void rightClick(Point p){
            Cursor.position = p;
            mouse_event((int)(MouseEventFlags.RIGHTDOWN),0,0,0,0);
            mouse_event((int)(MouseEventFlags.RIGHTUP),0,0,0,0);
            
        }
         public void doubleClick(Point p){
            Cursor.position = p;
            mouse_event((int)(MouseEventFlags.LEFTDOWN),0,0,0,0);
            mouse_event((int)(MouseEventFlags.LEFTUP),0,0,0,0);
            mouse_event((int)(MouseEventFlags.LEFTDOWN),0,0,0,0);
            mouse_event((int)(MouseEventFlags.LEFTUP),0,0,0,0);
            
        }
    }

    
}