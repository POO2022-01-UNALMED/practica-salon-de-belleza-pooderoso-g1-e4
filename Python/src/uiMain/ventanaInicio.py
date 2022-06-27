import tkinter as tk
from PIL import ImageTk, Image
import os 
import pathlib

path = os.path.join(pathlib.Path(__file__).parent.absolute())

class VentanaInicio(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Ventana inicio")
        self.geometry("1000x600")
        self.option_add("*tearOff", False)

        
        #Creacion Menu:
        menuBar = tk.Menu(self)
        self.config(menu=menuBar)
        menu1 = tk.Menu(menuBar)
        menuBar.add_cascade(label="Inicio", menu=menu1)

        menu1.add_command(label="Descripción", command=self.mostrarDescripcion)
        menu1.add_command(label="Salir", command=self.destroy)

        self.frameP1 = FrameIzquierdo(self)
        self.frameP1.place(relx=0.01, rely=0.01, relwidth=0.48, relheight=1)

        self.frameP2 = FrameDerecho(self)
        self.frameP2.place(relx=0.51, rely=0.01, relwidth=0.48, relheight=1)

        self.mainloop()

    def principal(self):
        from ventanaPrincipal import VentanaPrincipal
        self.destroy()
        VentanaPrincipal()


    def mostrarDescripcion(self):
        self.frame.mostrarDescripcion()

class FrameIzquierdo(tk.Frame):
    def __init__(self, parent):
        super().__init__(parent)

        frameP3 = tk.Frame(self)
        frameP3.pack(side="top")
        titulo = tk.Label(frameP3, text="Bienvenido al Salon de Belleza POOderoso", font=("Arial",18))
        titulo.pack(side="top") 
        self.frameP3 = frameP3

        frameP4 = tk.Frame(self)
        frameP4.pack()
        boton = tk.Button(frameP4,text="Ventana principal",command=parent.principal)
        boton.pack(expand=True)
        self.frameP4 = frameP4
        
    
    def mostrarDescripcion(self):
        descripcion = tk.Label(self.frameP3, text="Esta seria una descripcion valida, si tan solo\ntuviera una buena y completa", font=("Arial",18))
        descripcion.pack()



class FrameDerecho(tk.Frame):
    def __init__(self, parent):
        super().__init__(parent)

        frameP5 = tk.Frame(self)
        frameP5.pack(side="top")
        hv = tk.Text(frameP5, height=6, font=("Arial", 14))
        hv.insert(tk.END, "Maria Paula\nEsta seria su descripcion\n\n\n\n\n\n\n\n\n\n\nY aca terminaria...")
        hv.pack(side="top")
        self.frameP5 = frameP5

        frameP6 = tk.Frame(self)
        frameP6.pack()
        image_size = (200,200)
        #Create an object of tkinter ImageTk
        img = ImageTk.PhotoImage(Image.open(path+"/imagenes/paulahv1.jpeg").resize(image_size, Image.ANTIALIAS))
        img2 = ImageTk.PhotoImage(Image.open(path+"/imagenes/paulahv2.jpeg").resize(image_size, Image.ANTIALIAS))
        img3 = ImageTk.PhotoImage(Image.open(path+"/imagenes/paulahv3.jpeg").resize(image_size, Image.ANTIALIAS))
        img4 = ImageTk.PhotoImage(Image.open(path+"/imagenes/paulahv4.jpeg").resize(image_size, Image.ANTIALIAS))


        #Create a Label Widget to display the text or Image
        label1 = tk.Label(frameP6, image = img, width=image_size[0]*1.1, height=image_size[1]*1.1)
        label1.image = img
        label1.grid(row=0, column=0)
    
        label2 = tk.Label(frameP6, image = img2, width=image_size[0]*1.1, height=image_size[1]*1.1)
        label2.ima1e = img2
        label2.grid(row=0, column=1)
 
        label3 = tk.Label(frameP6, image = img3, width=image_size[0]*1.1, height=image_size[1]*1.1)
        label3.ima1e=img3
        label3.grid(row=1, column=0)

        label4 = tk.Label(frameP6, image = img4, width=image_size[0]*1.1, height=image_size[1]*1.1)
        label4.ima1e = img4
        label4.grid(row=1, column=1)

        label5 = tk.Label(frameP6, text="Como asi wey")
        label5.grid(row=2, column=0, columnspan=2)       
        self.frameP6 = frameP6

