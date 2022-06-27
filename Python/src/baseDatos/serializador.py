import pathlib
import pickle
import os

from gestorAplicacion.organizacional.empleado import Empleado
from gestorAplicacion.organizacional.administrador import Administrador
from gestorAplicacion.organizacional.cliente import Cliente
from gestorAplicacion.organizacional.persona import Persona
from gestorAplicacion.organizacional.salario import Salario

from gestorAplicacion.operacional.cita import Cita
from gestorAplicacion.operacional.factura import Factura
from gestorAplicacion.operacional.inventario import Inventario
from gestorAplicacion.operacional.venta import Venta
from gestorAplicacion.operacional.producto import Producto
from gestorAplicacion.operacional.servicio import Servicio


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
    serializar(Inventario.getInventario(), "inventario")
    serializar(Inventario.getInventarios(), "inventarios")