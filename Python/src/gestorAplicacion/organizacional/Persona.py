import datetime



_persona=[]    #serializador

class Persona:


_persona=[]    #serializador

    #-----------CONSTRUCTOR-----------
    def __init__(self, nombre, apellido, id, edad, numero):
        #instance fields found by Java to Python Converter:
        self.nombre = None
        self.apellido = None
        self._id = 0
        self._Edad = 0
        self._Numero = 0
        self._fechaRegistro = None

        super().__init__()
        self.nombre = nombre
        self.apellido = apellido
        self._id = id
        self._fechaRegistro = datetime.datetime.now()
        self._Edad = edad
        self._Numero = numero
        Persona._persona.append(self)   #serializador



    #-----------GETTERS y SETTERS-----------

        @classmethod    #serializador
    def getPersonas(cls):
        return cls._persona

    @classmethod     #serializador
    def setEmpleados(cls, persona):
        cls._persona= persona

    def getNombre(self):
        return self.nombre
    def setNombre(self, nombre):
        self.nombre = nombre

    def getApellido(self):
        return self.apellido
    def setApellido(self, apellido):
        self.apellido = apellido

    def getId(self):
        return self._id
    def setId(self, id):
        self._id = id

    def getEdad(self):
        return self._Edad
    def setEdad(self, edad):
        self._Edad = edad

    def getNumero(self):
        return self._Numero
    def setNumero(self, numero):
        self._Numero = numero

    def getInicioVinculacion(self):
        return self._fechaRegistro

    def setFechaRegistro(self, nuevaFechaRegistro):

        self._fechaRegistro = nuevaFechaRegistro


    #-----------METODO ABSTRACTOS-----------

    def gestionSeguros(self):
        pass

    #-----------OTROS METODOS-----------
    def toString(self):
        return "Persona [nombre=" + self.nombre + ", apellido=" + self.apellido + ", id=" + str(self._id) + ", Edad=" + str(self._Edad) + ", Numero=" + str(self._Numero) + "]"