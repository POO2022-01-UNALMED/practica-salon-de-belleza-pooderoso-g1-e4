import tkinter as tk
class FieldFrame(tk.Frame):
    default_font = ("Arial",12)
    def __init__(self, parent, tituloCriterios, criterios, tituloValores, valores=None, habilitado=None):
        super().__init__(parent)
        criteriosLabel = tk.Label(self, text=tituloCriterios, font=("Arial",14))
        valoresLabel = tk.Label(self, text=tituloValores, font=("Arial",14))
        criteriosLabel.grid(row=0, column=0)
        valoresLabel.grid(row=0, column=1)

        for i, titulo in enumerate(criterios, 1):
            ejecutar1 = f"criterio{i}Label = tk.Label(self, text='{titulo}', font=FieldFrame.default_font, padx=10, pady=10)\ncriterio{i}Label.grid(row={i}, column=0, sticky=tk.W)\nself.criterio{i}Label=criterio{i}Label"
            exec(ejecutar1)
            if valores is None:
                print("Valores is None")
                ejecutar2 = f"criterio{i}Entry = tk.Entry(self, font=FieldFrame.default_font)\ncriterio{i}Entry.grid(row={i},column=1)\nself.criterio{i}Entry = criterio{i}Entry"
                exec(ejecutar2)
            else:
                print("Me fui por aca", valores[i-1])
                ejecutarEspecial = f"criterio{i}Entry = tk.Entry(self, font=FieldFrame.default_font)\ncriterio{i}Entry.insert(0, '{valores[i-1]}')\ncriterio{i}Entry.grid(row={i},column=1)\nself.criterio{i}Entry = criterio{i}Entry"
                exec(ejecutarEspecial)
            if habilitado != None:
                if titulo in habilitado:
                    ejecutarHabilitado = f"criterio{i}Entry.config(state='disabled')"
                    exec(ejecutarHabilitado)


if __name__ == "__main__":
    #Para testear que si este funcionando...
    root = tk.Tk()
    root.geometry("600x300")
    criterios = ["Codigo","Nombre","Descripcion"]
    a = FieldFrame(root, "Criterio", criterios,"Valor",[10013,"Julian","Soy un campeon"], ["Codigo"])
    a.pack()
    root.mainloop()

