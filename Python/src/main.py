##from uiMain.ventanaInicio import ventanaInicio
from gestorAplicacion.inicializar import inicializar
from baseDatos.deserializador import deserializarTodo
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


# Deserializar
deserializarTodo()

# Inicializar datos si no los hay
inicializar()

# Crear ventana de Tkinter
##ventana =  VentanaInicio()

