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


def deserializar(lista, className):
        def camino(className):
            return os.path.join(pathlib.Path(__file__).parent.absolute(), f"temp\{className}.txt")

        # Leer el archivo
        try:
            picklefile = open(camino(className), 'rb')

        except:
            picklefile = open(camino(className), 'x')
            picklefile = open(camino(className), 'rb')

        # Unpickle los datos
        if os.path.getsize(camino(className)) > 0:
            lista = pickle.load(picklefile)
        
        # Cerrar el archivo
        picklefile.close()

        return lista

def deserializarTodo():

 	Cita.cita=deserializar(Cita.cita, "citas");
	Factura.factura=deserializar(Factura.factura, "facturas");
	Producto.producto=deserializar(Producto.producto, "productos");
	Venta.venta=deserializar(Venta.venta(), "ventas");
	Administrador.administradordeserializar(Administrador.administrador(), "administradores");
	Cliente.cliente=deserializar(Cliente.cliente(), "clientes");
	Empleado.empleado=deserializar(Empleado.empleado(), "empleados");
	Persona.persona= deserializar(Persona.persona(), "personas");
	Inventario.inventario=deserializar(Inventario.inventario(), "inventario");

	
