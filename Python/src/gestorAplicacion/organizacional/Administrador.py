
from  ..operacional.Cita import Cita
from ..operacional.Servicio import Servicio
from ..organizacional.Cliente import Cliente
from ..organizacional.Persona import Persona
from ..organizacional.Salario import Salario



class Administrador(Persona, Salario):

     _administrador = []   #serializador


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
       
        Administrador._administrador.append(self) #serializador
       


    #-----------GETTERS y SETTERS-----------

      @classmethod    #serializador
    def getAdministradores(cls):
        return cls._administrador

    @classmethod     #serializador
    def setAdministradores(cls, administrador):
        cls._administrador = administrador


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
        Cliente(nombre, apellido, id, edad, numero, anotaciones,False) 
        return Cliente(nombre, apellido, id, edad, numero, anotaciones,False)  

    #Metodo para consilidar una nueva cita-
    @staticmethod
    def consolidarCita(empleado, cliente, servicios, fechaReserva, fechaCita):
        duracion = Cita.duracionCita(servicios) #Cita
        nuevaCita = Cita(empleado, cliente, servicios,fechaReserva, fechaCita, duracion)#Cita
        return nuevaCita

    @staticmethod
    def consolidarCancelacion(cita):
        cita.setEstado("Cancelada")