import datetime

from ..organizacional.Persona import Persona
#from ..organizacional.Administrador import Administrador

#from gestorAplicacion.operacional import Factura
#from uiMain.gestorInterfaz import 


class Cliente(Persona):


    _cliente=[]  #serializador

        #-----------CONSTRUCTORES-----------
    def __init__(self, nombre, apellido, id, edad, numero, anotaciones):
            from ..organizacional.Administrador import Administrador
            self._initialize_instance_fields()

            super().__init__(nombre, apellido, id, edad, numero)
            self._anotaciones = anotaciones
            self._citasGeneradas = []
            self._facturas = None
            self._ClientePremiun = False
            Administrador.clientes.append(self)
            Cliente._cliente.append(self)    #serializador

    def __init__(self, nombre, apellido, id, edad, numero, anotaciones, clientePremiun):
            from ..organizacional.Administrador import Administrador
            #self._initialize_instance_fields()

            super().__init__(nombre, apellido, id, edad, numero)
            self._anotaciones = anotaciones
            self._citasGeneradas = []
            self._facturas = None
            self._ClientePremiun = False
            Administrador.clientes.append(self)
            Cliente._cliente.append(self)



  

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

    @classmethod    #serializador
    def getClientes(cls):
        return cls._cliente

    @classmethod     #serializador
    def setClientes(cls, cliente):
        cls._cliente= cliente

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
    def __str__(self):
        return "Cliente: "+ self.getNombre() +" "+ self.getApellido()+", anotaciones: "+ self._anotaciones

    @staticmethod
    def digitarServicio():
        return input() #poner el respectivo input ---------------------------- 

