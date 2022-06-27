#Import required libraries
from tkinter import *
from PIL import ImageTk, Image
import tkinter as tk
import os 
import pathlib

path = os.path.join(pathlib.Path(__file__).parent.absolute())
#Create an instance of tkinter window
win =Tk()
frame = Frame(win)
frame.pack()
#Define the geometry of the window
win.geometry("650x400")
image_size = (100,100)
#Create an object of tkinter ImageTk
img = ImageTk.PhotoImage(Image.open(path+"/paulahv1.jpeg").resize(image_size, Image.ANTIALIAS))
img2 = ImageTk.PhotoImage(Image.open(path+"/paulahv2.jpeg").resize(image_size, Image.ANTIALIAS))
img3 = ImageTk.PhotoImage(Image.open(path+"/paulahv3.jpeg").resize(image_size, Image.ANTIALIAS))
img4 = ImageTk.PhotoImage(Image.open(path+"/paulahv4.jpeg").resize(image_size, Image.ANTIALIAS))


#Create a Label Widget to display the text or Image
label1 = tk.Label(frame, image = img, width=120, height=120)
label1.grid(row=0, column=0)
#Create a Label Widget to display the text or Image
label2 = tk.Label(frame, image = img2, width=120, height=120)
label2.grid(row=0, column=1)
#Create a Label Widget to display the text or Image
label3 = tk.Label(frame, image = img3, width=120, height=120)
label3.grid(row=1, column=0)
#Create a Label Widget to display the text or Image
label4 = tk.Label(frame, image = img4, width=120, height=120)
label4.grid(row=1, column=1)

win.mainloop()