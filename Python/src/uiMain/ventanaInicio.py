import tkinter as tk

class VentanaInicio(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Ventana inicio")
        self.geometry("800x600")
        self.option_add("*tearOff", False)

        
        #Creacion Menu:
        menuBar = tk.Menu(self)
        self.config(menu=menuBar)
        menu1 = tk.Menu(menuBar)
        menuBar.add_cascade(label="Inicio", menu=menu1)

        menu1.add_command(label="Descripción", command=self.mostrarDescripcion)
        menu1.add_command(label="Salir", command=self.destroy)

        self.frame = FrameIzquierdo(self)
        self.frame.pack(side="left", anchor="n")

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
        titulo = tk.Label(frameP3, text="Bienvenido al Salon de Bellez POOderoso", font=("Arial",18))
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