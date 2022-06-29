import os 
import pathlib


from  gestorAplicacion.organizacional.Persona import Persona
from  gestorAplicacion.organizacional.Administrador import Administrador
from  gestorAplicacion.organizacional.Empleado import Empleado
from  gestorAplicacion.organizacional.Cliente import Cliente
from  gestorAplicacion.organizacional.Salario import Salario

from  gestorAplicacion.operacional.Cita import Cita
from  gestorAplicacion.operacional.Venta import Venta
from  gestorAplicacion.operacional.Inventario import Inventario
from  gestorAplicacion.operacional.Servicio import Servicio
from  gestorAplicacion.operacional.Factura import Factura
from  gestorAplicacion.operacional.Producto import Producto






def mostrarClientes():


        path = os.path.join(pathlib.Path(__file__).parent.parent.absolute())
        path_archivo = path+"\\textos\\mostrarInformacion.txt"
        file = open(path_archivo, "w")
        print("=========================================", file=file)
        print("=============== Clientes ===============", file=file)
        print("=========================================", file=file)

        for clientes in Cliente._cliente:
            print(clientes, file=file)

        print("=========================================", file=file)
        print("=============== Empleados ===============", file=file)
        print("=========================================", file=file)

        for emp in Empleado._empleado:
            print(emp, file=file)

        print("=========================================", file=file)
        print("=============== Citas ===============", file=file)
        print("=========================================", file=file)

        for cit in Cita._cita:
            print(cit, file=file)

        print("=========================================", file=file)
        print("=============== Ventas ===============", file=file)
        print("=========================================", file=file)

        for ven in Venta._venta:
            print(ven, file=file)
            


        print("=========================================", file=file)
        print("=============== Producto ===============", file=file)
        print("=========================================", file=file)

        for pro in Producto._producto:
            print(pro, file=file)

        print("=========================================", file=file)
        print("=============== Factura ===============", file=file)
        print("=========================================", file=file)

        for fac in Factura._factura:
            print(fac, file=file)

        file.close()
    
