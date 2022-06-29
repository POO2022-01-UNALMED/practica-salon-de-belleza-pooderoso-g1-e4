import pathlib
import pickle
import os

from gestorAplicacion.organizacional.Empleado import Empleado
from gestorAplicacion.organizacional.Administrador import Administrador
from gestorAplicacion.organizacional.Cliente import Cliente
from gestorAplicacion.organizacional.Persona import Persona
from gestorAplicacion.organizacional.Salario import Salario

from gestorAplicacion.operacional.Cita import Cita
from gestorAplicacion.operacional.Factura import Factura
from gestorAplicacion.operacional.Inventario import Inventario
from gestorAplicacion.operacional.Venta import Venta
from gestorAplicacion.operacional.Producto import Producto
from gestorAplicacion.operacional.Servicio import Servicio


def serializar(lista, className):
    def camino(className):
        return os.path.join(pathlib.Path(__file__).parent.absolute(), f"temp\{className}.txt")

    try:
        # Crear el archivo pickle para guardar los objetos
        picklefile = open(camino(className), 'wb')

        # Pickle el objeto en el archivo
        pickle.dump(lista, picklefile)

        # Cerrar el archivo
        picklefile.close()
        
    except:
        print("Error de serializacion")

def serializarTodo():
    serializar(Cita.getCitas(), "citas")
    serializar(Factura.getFacturas(), "facturas")
    serializar(Producto.getProductos(), "productos")
    serializar(Venta.getVentas(), "ventas")
    serializar(Administrador.getAdministradores(), "administradores")
    serializar(Cliente.getClientes(), "clientes")
    serializar(Empleado.getEmpleados(), "empleados")
    serializar(Persona.getPersonas(), "personas")
    serializar(Inventario.getInventarios(), "inventario")
