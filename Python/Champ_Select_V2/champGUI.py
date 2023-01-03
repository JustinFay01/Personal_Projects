import tkinter as tk
from tkinter import messagebox
import customtkinter as ck

WINDOW_SIZE = "800x500"

class champGUI:
    def __init__(self):
        ck.set_appearance_mode("light")
        ck.set_default_color_theme("dark-blue")

        #Constructer
        self.root = ck.CTk()

        

        #menu
        self.menubar = tk.Menu(self.root)

        #File Menu inside of menu bar
        self.filemenu = tk.Menu(self.menubar, tearoff=0)
        self.filemenu.add_command(label="Close", command=exit)
        self.filemenu.add_separator()
        self.filemenu.add_checkbutton(label="Keyboard Mode", onvalue=1, offvalue=0) # 0 = on 
        self.filemenu.add_checkbutton(label="Help", command=self.help)
     

        #menu bar settings
        self.menubar.add_cascade(menu=self.filemenu, label="File")
        self.root.config(menu=self.menubar)


        #Size and title
        self.root.geometry(WINDOW_SIZE)
        self.root.title("Auto Agent Select")
        
        #Button images
        click_astra= tk.PhotoImage(file='Python/Champ_Select_V2/images/astra.png')
        self.astra = tk.Button(self.root, image=click_astra, command=self.lock_in).pack(padx=10, pady=10)


        #Keyboard Input
        self.root.bind("<KeyPress>", self.short_cut)
        

        #run loop
        self.root.mainloop()
    
    def lock_in(self):
        print("locked in")
    
    def short_cut(self, event):
            if event.state == 12 and event.keysym == 'q':
                self.root.destroy()
        
    def help(self):
        messagebox.showinfo(title="Commands", message="Use q to quit at anytime")
        

champGUI()