import tkinter as tk
from ventanaInicio import VentanaInicio

class VentanaPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Ventana principal")
        self.geometry("800x600")
        self.menuBar = tk.Menu(self)
        self.config(menu=self.menuBar)
        menu1 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Archivo", menu=menu1)
        menu1.add_command(label="Salir",command=self.volver)
        self.mainloop()


    def volver(self):
        self.destroy()
        VentanaInicio()



if __name__=='__main__':
    VentanaInicio()