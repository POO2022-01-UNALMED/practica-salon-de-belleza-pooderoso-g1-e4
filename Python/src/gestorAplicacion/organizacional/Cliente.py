import datetime

from ..organizacional.Persona import Persona
#from ..organizacional.Administrador import Administrador

#from gestorAplicacion.operacional import Factura
#from uiMain.gestorInterfaz import 


class Cliente(Persona):

    """
    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self._anotaciones = None
        self._citasGeneradas = []
        self._facturas = []
        self._ClientePremiun = False
    
    
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _clientes = None

    @classmethod
    def static_initializer(cls):
        cls._clientes = []

    static_initializer()

    @staticmethod
    def getClientes():
        return Cliente._clientes

    @staticmethod
    def setClientes(clientes):
        Cliente._clientes = clientes
        Administrador.clientes=clientes
    """


    #-----------ATRIBUTOS-----------

    _clientes=[]
    #-----------CONSTRUCTORES-----------
#JAVA TO PYTHON CONVERTER TODO TASK: There is no Python equivalent to multiple constructors:
#ORIGINAL LINE: public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones)
    def __init__(self, nombre, apellido, id, edad, numero, anotaciones):
        from ..organizacional.Administrador import Administrador
        self._initialize_instance_fields()

        super().__init__(nombre, apellido, id, edad, numero)
        self._anotaciones = anotaciones
        self._citasGeneradas = []
        self._facturas = None
        self._ClientePremiun = False
        Administrador.clientes.append(self)
        Cliente._clientes.append(self)

#JAVA TO PYTHON CONVERTER TODO TASK: There is no Python equivalent to multiple constructors:
#ORIGINAL LINE: public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones, boolean clientePremiun)
    def __init__(self, nombre, apellido, id, edad, numero, anotaciones, clientePremiun):
        from ..organizacional.Administrador import Administrador
        self._initialize_instance_fields()

        super().__init__(nombre, apellido, id, edad, numero)
        self._anotaciones = anotaciones
        self._ClientePremiun = clientePremiun
        Administrador.clientes.append(self)
        Cliente._clientes.append(self)


#JAVA TO PYTHON CONVERTER TODO TASK: There is no Python equivalent to multiple constructors:
#ORIGINAL LINE: public Cliente(String nombre, String apellido, int id)
    def __init__(self, nombre, apellido, id):
        self(nombre,apellido,id,0,0," No posee anotaciones")

    #----------METODO ABSTRACTO-----------
    def gestionSeguros(self):

        #formato = format.DateTimeFormatter.ofPattern("yyyy-MM-dd")

        citasCliente = self.getCitasGeneradas()
        cadena = ""

        for c in citasCliente:

            fechaCita = c.getFechaCita()
            fechaFinalizacionCita = c.getFechaCita().plusMinutes(c.getDuracion())

            if datetime.datetime.now().isAfter(fechaFinalizacionCita):

                cadena = cadena + "El cliente " + super().getNombre() + " " + super().getApellido() + " estuvo asegurado en la cita No. " + c.getId() + " del " + fechaCita.isoformat() + " a " + fechaFinalizacionCita.isoformat() + "\n"
            else:

                cadena = cadena + "El cliente " + super().getNombre() + " " + super().getApellido() + " estar� asegurado en la cita No. " + c.getId() + " del " + fechaCita.isoformat() + " a " + fechaFinalizacionCita.isoformat() + "\n"

        return cadena



    #-----------GETTERS Y SETTERS-----------
    def getAnotaciones(self):
        return self._anotaciones
    def setAnotaciones(self, anotaciones):
        self._anotaciones = anotaciones

    def getCitasGeneradas(self):
        return self._citasGeneradas
    def setCitasGeneradas(self, citasGeneradas):
        self._citasGeneradas = citasGeneradas
    def addCita(self, cita):
        self._citasGeneradas.append(cita)


    def getFacturas(self):
        return self._facturas
    def setFacturas(self, facturas):
        self._facturas = facturas
    def addFactura(self, factura):
        self._facturas.append(factura)

    def isClientePremiun(self):
        return self._ClientePremiun
    def setClientePremiun(self, clientePremiun):
        self._ClientePremiun = clientePremiun

    #-----------OTROS METODOS-----------
    def toString(self):
        return "Cliente: "+ self.getNombre() +" "+ self.getApellido()+", anotaciones: "+ self._anotaciones

    @staticmethod
    def digitarServicio():
        return input() #poner el respectivo input ---------------------------- 

