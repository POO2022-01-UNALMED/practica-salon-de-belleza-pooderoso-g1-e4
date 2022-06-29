##from uiMain.ventanaInicio import ventanaInicio
from gestorAplicacion.inicializar import inicializar
from baseDatos.deserializador import deserializarTodo
from uiMain.ventanaInicio import VentanaInicio



# Deserializar
deserializarTodo()

# Inicializar datos si no los hay
inicializar()

# Crear ventana de Tkinter
ventana =  VentanaInicio()

