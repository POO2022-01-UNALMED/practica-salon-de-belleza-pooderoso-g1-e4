import tkinter as tk
from uiMain.ventanaInicio import VentanaInicio
import os 
import pathlib
from uiMain.fieldFrame import FieldFrame
from uiMain.Funcionalidades.mostrarInformacionActual import mostrarClientes

path = os.path.join(pathlib.Path(__file__).parent.absolute())

#from baseDatos.serializador import serializarTodo


class  VentanaPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Salon de Belleza POOderoso")
        self.geometry("800x600")
        self.option_add("*tearOff", False)

        #Creacion de la barra de Menus
        self.menuBar = tk.Menu(self)
        self.config(menu=self.menuBar)

        # Primer Menu: Archivo: Aplicacion, Guardar y Salir
        menu1 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Archivo", menu=menu1)
        menu1.add_command(label="Aplicacion", command=self.aplicacion)
        menu1.add_command(label="Guardar y Salir",command=self.volver)


        # Segundo Menu: Funcionalidades del sistema, y mostrar informacion Actual
        menu2 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Procesos y Consultas", menu=menu2)
        menu2.add_command(label="Reservar Cita", command=self.reservarCita)
        menu2.add_command(label="Cancelar Cita", command=self.cancelarCita)
        menuFactura = tk.Menu(self.menuBar)
        menuFactura.add_command(label="Facturar Cita")
        menuFactura.add_command(label="Facturar Producto")
        menu2.add_cascade(label="Factura", menu=menuFactura)
        menu2.add_command(label="Balance Contable", command=self.balanceContable)
        menu2.add_command(label="Pago de Nomina")
        menu2.add_command(label="Mostrar Informacion Actual", command=self.mostrarInfo)
        

        # Tercer Menu: Ayuda: Acerca de
        menu3 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Ayuda", menu=menu3)
        menu3.add_command(label="Acerca de", command=self.acercaDe)

        # Frame por default
        self.frame1 = tk.Frame(self)
        self.frame1.pack()
        with open(path+"/textos/interfaz_inicio.txt","r") as f:
            texto = f.read()
        texto_inicio = tk.Text(self.frame1)
        texto_inicio.insert("1.0",texto)
        texto_inicio.pack(expand=True, anchor="n", padx=20, pady=20)
        
        self.frame2 = tk.Frame(self)
        self.frame2.pack()


    
        self.mainloop()


    def volver(self):
        self.destroy()
        serializarTodo()
        VentanaInicio()

    def aplicacion(self):
        wn = tk.Tk()
        wn.title("Aplicacion")

        with open(path+"/textos/aplicacion.txt","r") as f:
            textoAplicacion = f.read()
        aplicacionLabel = tk.Label(wn, text=textoAplicacion, font=("Arial", 14), justify="left", padx=20, pady=20)
        aplicacionLabel.pack()

    def acercaDe(self):
        wn = tk.Tk()
        wn.title("Acerca De")

        with open(path+"/textos/acercade.txt","r") as f:
            textoAcerca = f.read()
        acercaLabel = tk.Label(wn, text=textoAcerca, font=("Arial", 14), justify="left", padx=20, pady=20)
        acercaLabel.pack()

    def reservarCita(self):
        self.frame2.pack_forget()
        self.frame2 = tk.Frame()
        tituloProceso = tk.Label(self.frame2, text="Reservar Cita", font=("Arial",16))
        tituloProceso.pack(side="top")
        with open(path+"/textos/reservarCita.txt","r") as f:
            texto = f.read()
        descripcionProceso = tk.Label(self.frame2, text = texto, font=("Arial",12), justify="left")
        descripcionProceso.pack(side="top")
        self.frame2.pack(side="top")

        self.frame1.pack_forget()
        self.frame1 = FieldFrame(self, "Criterios", ["id Cliente","id Empleado","Servicios","Fecha y Hora"],"Valores")
        self.frame1.pack(side="top")

    def cancelarCita(self):
        self.frame2.pack_forget()
        self.frame2 = tk.Frame()
        tituloProceso = tk.Label(self.frame2, text="Cancelar Cita", font=("Arial",16))
        tituloProceso.pack(side="top")
        with open(path+"/textos/cancelarCita.txt","r") as f:
            texto = f.read()
        descripcionProceso = tk.Label(self.frame2, text = texto, font=("Arial",12), justify="left")
        descripcionProceso.pack(side="top")

        self.frame2.pack(side="top")
        self.frame1.pack_forget()
        self.frame1 = FieldFrame(self, "Criterios", ["id Cita"],"Valores")
        self.frame1.pack(side="top")    

    def balanceContable(self):
        self.frame2.pack_forget()
        self.frame2 = tk.Frame()
        tituloProceso = tk.Label(self.frame2, text="Balance Contable", font=("Arial",16))
        tituloProceso.pack(side="top")
        with open(path+"/textos/balanceContable.txt","r") as f:
            texto = f.read()
        descripcionProceso = tk.Label(self.frame2, text = texto, font=("Arial",12), justify="left")
        descripcionProceso.pack(side="top")

        self.frame2.pack(side="top")
        self.frame1.pack_forget()
        self.frame1 = FieldFrame(self, "Criterios", ["Numero Mes"],"Valores")
        self.frame1.pack(side="top") 

    def mostrarInfo(self):

        mostrarClientes()


        self.frame1.pack_forget()
        self.frame1 = tk.Frame(self)
        self.frame1.pack()
        with open(path+"/textos/mostrarInformacion.txt","r") as f:
            texto = f.read()
        texto_inicio = tk.Text(self.frame1)
        texto_inicio.insert("1.0",texto)
        texto_inicio.pack(expand=True, anchor="n", padx=20, pady=20)          

    

if __name__=='__main__':
    VentanaInicio()