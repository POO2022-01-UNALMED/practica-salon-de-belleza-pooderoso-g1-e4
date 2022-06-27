
from  ..operacional.cita import Cita
from ..operacional.servicio import Servicio
from .cliente import Cliente
from .persona import Persona
from .salario import Salario



class Administrador(Persona, Salario):

    """
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _administradores = None
    @staticmethod
    def _static_initializer():
        gestorAplicacion.organizacional.Administrador._administradores = []

    _static_initializer()


    @staticmethod
    def getAdministradores():
        return gestorAplicacion.organizacional.Administrador._administradores

    @staticmethod
    def setAdministradores(administradores):
        Administrador._administradores = administradores


    """
    #-----------ATRIBUTOS DE INSTANCIA-----------


    #-----------ATRIBUTOS DE CLASE-----------
    clientes = []
    empleadosAsigandos = []


    #-----------CONSTRUCTOR-----------
    def __init__(self, nombre, apellido, id, edad, numero, horarioLaboral, nomina):
        #instance fields found by Java to Python Converter:
        self._horarioLaboral = None
        self._nomina = 0
        self._sueldo = 0
        self._duracionMesesSeguro = 1
        self._nivelARL = "II"

        super().__init__(nombre, apellido, id, edad, numero)
        self._horarioLaboral=horarioLaboral
        self._nomina=nomina
        #empleadosAsigandos = Administrador.empleadosAsigandos
        #self._sueldo = Salario.SALARIO_BASE * 3 ----------------------------------------------Cuando importe Salario
        #gestorAplicacion.organizacional.Administrador._administradores.append(self) ----------------Serializador


    #-----------GETTERS y SETTERS-----------
    def getHorarioLaboral(self):
        return self._horarioLaboral
    def setHorarioLaboral(self, horarioLaboral):
        self._horarioLaboral = horarioLaboral
    def getNomina(self):
        return self._nomina


    def setNomina(self, nomina):
        self._nomina = nomina

    def getEmpleadosAsigandos(self):
        return Administrador.empleadosAsigandos

    def setEmpleadosAsigandos(self, empleadosAsigandos):
        Administrador.empleadosAsigandos = empleadosAsigandos

    def getSueldo(self):
        return self._sueldo

    def setSueldo(self, sueldo):
        self._sueldo = sueldo

    def aumentarSueldo(self, porcentaje):
        self.setSueldo(self._sueldo*(1+porcentaje))

    def calcularPrima(self):
        return self._sueldo*0.5




    #-----------METODO ABSTRACTOS-----------
    def gestionSeguros(self):

        #formato = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")

        return "El administrador " + self.getNombre() + " " + self.getApellido() + " con ARL " + self._nivelARL + " esta asegurado de " + super().getInicioVinculacion() + " a " + super().getInicioVinculacion().replace(months = super().getInicioVinculacion() + self._duracionMesesSeguro) #Mirar lo delos meses



    #-----------OTROS METODOS-----------
    def toString(self):
        return "Administrador [horarioLaboral=" + self._horarioLaboral + ", nomina=" + str(self._nomina) + ", empleadosAsigandos=" + Administrador.empleadosAsigandos + "fecha registro " + super().getInicioVinculacion() +"]"

    #Metodo para crear nuevo cliente desde administrador
    @staticmethod
    def NuevoCliente(nombre, apellido, id, edad, numero, anotaciones):
        Cliente(nombre, apellido, id, edad, numero, anotaciones) 
        return Cliente(nombre, apellido, id, edad, numero, anotaciones)  

    #Metodo para crear nuevo cliente desde administrador solo para datos obligatorios
    @staticmethod
    def NuevoCliente(nombre, apellido, id):    
        return Cliente(nombre, apellido, id)


    #Metodo para consilidar una nueva cita-
    @staticmethod
    def consolidarCita(empleado, cliente, servicios, fechaReserva, fechaCita):
        duracion = Cita.duracionCita(servicios) #Cita
        nuevaCita = Cita(empleado, cliente, servicios,fechaReserva, fechaCita, duracion)#Cita
        return nuevaCita

    @staticmethod
    def consolidarCancelacion(cita):
        cita.setEstado("Cancelada")