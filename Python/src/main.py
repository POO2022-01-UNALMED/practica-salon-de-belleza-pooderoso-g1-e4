##from uiMain.ventanaInicio import ventanaInicio
from gestorAplicacion.inicializar import inicializar
from baseDatos.deserializador import deserializarTodo
from gestorAplicacion.operacional import *
from gestorAplicacion.organizacional import *


# Deserializar
deserializarTodo()

# Inicializar datos si no los hay
inicializar()
print(Cita.getCitas())
# Crear ventana de Tkinter
##ventana =  VentanaInicio()

