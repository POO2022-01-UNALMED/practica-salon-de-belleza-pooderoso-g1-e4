import tkinter as tk
from tkinter import messagebox
from uiMain.Funcionalidades.GestionarCita import GestionarCita

class FieldFrame(tk.Frame):
    default_font = ("Arial",12)
    def __init__(self, parent, tituloCriterios, criterios, tituloValores, valores=None, habilitado=None, validar= None):
        super().__init__(parent)
        self.parent = parent
        self.tituloCriterios = tituloCriterios; self.criterios = criterios; self.tituloValores = tituloValores; self.valores = valores; self.habilitado=habilitado
        self.validar = validar
        criteriosLabel = tk.Label(self, text=tituloCriterios, font=("Arial",14))
        valoresLabel = tk.Label(self, text=tituloValores, font=("Arial",14))
        criteriosLabel.grid(row=0, column=0)
        valoresLabel.grid(row=0, column=3)
        self.entries = []
        for i, titulo in enumerate(criterios, 1):
            ejecutar1 = f"criterio{i}Label = tk.Label(self, text='{titulo}', font=FieldFrame.default_font, padx=10, pady=10)\ncriterio{i}Label.grid(row={i}, column=0, columnspan=2, sticky=tk.W)\nself.criterio{i}Label=criterio{i}Label"
            exec(ejecutar1)
            if valores is None:
                ejecutar2 = f"criterio{i}Entry = tk.Entry(self, font=FieldFrame.default_font)\ncriterio{i}Entry.grid(row={i},column=2, columnspan=3)\nself.criterio{i}Entry = criterio{i}Entry\nself.entries.append(criterio{i}Entry)"
                exec(ejecutar2)
            else:
                ejecutarEspecial = f"criterio{i}Entry = tk.Entry(self, font=FieldFrame.default_font)\ncriterio{i}Entry.insert(0, '{valores[i-1]}')\ncriterio{i}Entry.grid(row={i},column=2, columnspan=3)\nself.criterio{i}Entry = criterio{i}Entry\nself.entries.append(criterio{i}Entry)"
                exec(ejecutarEspecial)
            size = f"self.grid_rowconfigure({i-1}, weight=1)\nself.grid_columnconfigure(0, weight=1)\nself.grid_columnconfigure(1, weight=1)"
            exec(size)

            if habilitado != None:
                if titulo in habilitado:
                    ejecutarHabilitado = f"criterio{i}Entry.config(state='disabled')"
                    exec(ejecutarHabilitado)
        
        botonAceptar = tk.Button(self, text="Aceptar", font=FieldFrame.default_font, command=self.aceptar)
        botonBorrar = tk.Button(self, text="Borrar", font=FieldFrame.default_font, command = self.borrar)
        botonAceptar.grid(row=i+1, column=1, pady=20)
        botonBorrar.grid(row=i+1, column=3, pady=20)




    def getValue(self, criterio):
        pos = self.criterios.index(criterio)
        valor = eval(f"self.criterio{pos+1}Entry.get()")
        return valor


    def aceptar(self):
        vacios = []
        for j,entrada in enumerate(self.entries):
            if not entrada.get():
                vacios.append(self.criterios[j])
        
        if len(vacios)>0:
            cuales = ", ".join(vacios[:-1])
            if len(vacios)>1:
                cuales += " y "+vacios[-1]
                textoError = f"Los campos {cuales} estan vacios. Por favor completarlos y presionar el boton Aceptar"
            else:
                textoError = f"El campo {vacios[0]} esta vacio. Por favor completarlo y presionar el boton Aceptar"
            messagebox.showerror("Faltan datos por ingresar",textoError)
        else:
            self.validarEntradas()


    def borrar(self):
        for entrada in self.entries:
            entrada.delete(0, tk.END)


    def validarEntradas(self):
        exec(self.validar)
        

if __name__ == "__main__":
    #Para testear que si este funcionando...
    root = tk.Tk()
    root.geometry("600x300")
    criterios = ["idCliente","idEmpleado","Fecha"]
    a = FieldFrame(root, "Criterio", criterios,"Valor",)#[10013,"Julian","Soy un campeon"], ["Codigo"])
    a.pack(fill="both", expand=True)
    root.mainloop()

