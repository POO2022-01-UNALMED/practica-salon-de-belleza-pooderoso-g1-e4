import tkinter as tk
from PIL import ImageTk, Image
import os 
import pathlib

path = os.path.join(pathlib.Path(__file__).parent.absolute())

class VentanaInicio(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Ventana inicio")
        self.geometry("1200x600")
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
        self.frameP1.mostrarDescripcion()

class FrameIzquierdo(tk.Frame):
    posCarrusel = 0
    def __init__(self, parent):
        super().__init__(parent)

        frameP3 = tk.Frame(self)
        frameP3.pack(side="top")
        titulo = tk.Label(frameP3, text="Bienvenido al Salon de Belleza POOderoso", font=("Arial",18))
        titulo.pack(side="top") 
        self.frameP3 = frameP3

        frameP4 = tk.Frame(self)
        frameP4.pack()
        self.image_size = (600,400)
        carrusel = ImageTk.PhotoImage(Image.open(path+"/imagenes/carrusel1.JPG").resize(self.image_size, Image.ANTIALIAS))
        #Create a Label Widget to display the text or Image
        labelCarrusel = tk.Label(frameP4, image = carrusel, width=self.image_size[0]+10, height=self.image_size[1]+10)
        labelCarrusel.image = carrusel
        labelCarrusel.bind("<Leave>",self.cambiarCarrusel)
        labelCarrusel.pack()
        self.labelCarrusel = labelCarrusel


        boton = tk.Button(frameP4,text="Ventana principal",command=parent.principal, font=("Arial",12), cursor="hand2")
        boton.pack(expand=True)
        self.frameP4 = frameP4
        
    
    def mostrarDescripcion(self):
        with open(path+"/textos/descripcion.txt") as f:
            textoDescripcion = f.read()
        descripcion = tk.Label(self.frameP3, text=textoDescripcion, font=("Arial",12), justify=tk.LEFT)
        descripcion.pack()

    def cambiarCarrusel(self,event):
        FrameIzquierdo.posCarrusel = (FrameIzquierdo.posCarrusel+1)%5

        new = ImageTk.PhotoImage(Image.open(path+"/imagenes/carrusel"+str(FrameIzquierdo.posCarrusel+1)+".JPG").resize(self.image_size, Image.ANTIALIAS))
        #Create a Label Widget to display the text or Image
        self.labelCarrusel.config(image=new)
        self.labelCarrusel.image = new    
        


class FrameDerecho(tk.Frame):
    personas = ["paula", "julian","marlon","juan"]
    persona = 0
    image_size = (220,220)

    def __init__(self, parent):
        super().__init__(parent)
        nombre = "paula"
        frameP5 = tk.Frame(self)
        frameP5.pack(side="top")
        hv = tk.Text(frameP5, height=5, font=("Arial", 12), cursor="hand2")
        with open(path+"/textos/"+nombre+".txt","r") as f:
            textoInicial = f.read()
        hv.insert(tk.END, textoInicial)
        hv.bind("<Button-1>", self.cambiarPersona)
        hv.config(state="disabled")
        hv.pack(side="top")
        self.hv = hv
        self.frameP5 = frameP5

        frameP6 = tk.Frame(self)
        frameP6.pack()
        
        #Create an object of tkinter ImageTk
        img = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv1.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img2 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv2.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img3 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv3.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img4 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv4.jpeg").resize(self.image_size, Image.ANTIALIAS))


        #Create a Label Widget to display the text or Image
        label1 = tk.Label(frameP6, image = img, width=self.image_size[0]+10, height=self.image_size[1]+10)
        label1.image = img
        label1.grid(row=0, column=0)
        self.label1 = label1
    
        label2 = tk.Label(frameP6, image = img2, width=self.image_size[0]+10, height=self.image_size[1]+10)
        label2.ima1e = img2
        label2.grid(row=0, column=1)
        self.label2 = label2
 
        label3 = tk.Label(frameP6, image = img3, width=self.image_size[0]+10, height=self.image_size[1]+10)
        label3.ima1e=img3
        label3.grid(row=1, column=0)
        self.label3 = label3

        label4 = tk.Label(frameP6, image = img4, width=self.image_size[0]+10, height=self.image_size[1]+10)
        label4.ima1e = img4
        label4.grid(row=1, column=1)
        self.label4 = label4

        self.frameP6 = frameP6
    

    def cambiarPersona(self, event):
        self.persona = (self.persona+1)%4
        nombre = self.personas[self.persona]
        with open(path+"/textos/"+nombre+".txt", "r") as hv:
            textoNuevo = hv.read()
        self.hv.config(state="normal")
        self.hv.delete("1.0", "end-1c")
        self.hv.insert(tk.END, textoNuevo)
        self.hv.config(state="disabled")

        
        img = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv1.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img2 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv2.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img3 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv3.jpeg").resize(self.image_size, Image.ANTIALIAS))
        img4 = ImageTk.PhotoImage(Image.open(path+"/imagenes/"+nombre+"hv4.jpeg").resize(self.image_size, Image.ANTIALIAS))

        #Create a Label Widget to display the text or Image
        self.label1 = tk.Label(self.frameP6, image = img, width=self.image_size[0]+10, height=self.image_size[1]+10)
        self.label1.image = img
        self.label1.grid(row=0, column=0)
    
        self.label2 = tk.Label(self.frameP6, image = img2, width=self.image_size[0]+10, height=self.image_size[1]+10)
        self.label2.ima1e = img2
        self.label2.grid(row=0, column=1)
 
        self.label3 = tk.Label(self.frameP6, image = img3, width=self.image_size[0]+10, height=self.image_size[1]+10)
        self.label3.ima1e=img3
        self.label3.grid(row=1, column=0)

        self.label4 = tk.Label(self.frameP6, image = img4, width=self.image_size[0]+10, height=self.image_size[1]+10)
        self.label4.ima1e = img4
        self.label4.grid(row=1, column=1)