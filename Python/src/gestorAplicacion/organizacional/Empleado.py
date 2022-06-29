from datetime import datetime,timedelta


from ..organizacional.Persona import Persona
from ..organizacional.Salario import Salario



class Empleado(Persona, Salario):


   _empleado=[]  #serializador


    #Constantes de tiempos de atenci�n de los empleados (9 am - 6 pm)

    HORAINICIO = timedelta(hours=9, minutes=0)
    HORAFINAL = timedelta(hours=18, minutes=0)



    def __init__(self, nombre, apellido, id, edad, numero, especialidad):
        from ..organizacional.Administrador import Administrador
        #instance fields found by Java to Python Converter:
        self._especialidad = None
        self._serviciosRealizados = []
        self._citasAsignadas = []
        self._productosVendidos = []
        self._sueldo = 0
        self._duracionMesesSeguro = 6
        self._nivelARL = "III"

        super().__init__(nombre, apellido, id, edad, numero)
        self._especialidad = especialidad
        self._sueldo = Salario.SALARIO_BASE
        Administrador.empleadosAsigandos.append(self) #Cardinalidad de clases
        Empleado._empleado.append(self)   #serializador


    #-----------METODO ABSTRACTOS-----------
    def gestionSeguros(self):

        inicioVinculacion = super().getInicioVinculacion()
        finVinculacion = super().getInicioVinculacion().replace(months = super().getInicioVinculacion().month + self._duracionMesesSeguro)

        

        if datetime.now()>(finVinculacion):

            return "Empleado " + self.getNombre() + " " + self.getApellido() + " con ARL " + self._nivelARL + " tiene vencido el seguro, caduc� el: " + finVinculacion.isoformat()

        else:
            return "Empleado " + self.getNombre() + " " + self.getApellido() + " con ARL " + self._nivelARL + " esta asegurado de " + inicioVinculacion.isoformat()+ " a " + finVinculacion.isoformat()



        @classmethod    #serializador
    def getEmpleados(cls):
        return cls._empleado

    @classmethod     #serializador
    def setEmpleados(cls, empleado):
        cls._empleado= empleado

    def getEspecialidad(self):
        return self._especialidad

    def setEspecialidad(self, especialidad):
        self._especialidad = especialidad

    def getServiciosRealizados(self):
        return self._serviciosRealizados

    def setServiciosRealizados(self, servicio):
        self._serviciosRealizados.append(servicio)

    def getProductosVendidos(self):
        return self._productosVendidos

    def setProductosVendidos(self, producto):
        self._productosVendidos.append(producto)

    def getSueldo(self):
        return self._sueldo
    def setSueldo(self, sueldo):
        self._sueldo = sueldo
    def aumentarSueldo(self, porcentaje):
        self.setSueldo(self._sueldo*(1+porcentaje))
    def calcularPrima(self):
        return self._sueldo*0.5


    def getCitasAsignadas(self):
        return self._citasAsignadas

    def setCitasAsignadas(self, citasAsignadas):
        self._citasAsignadas = citasAsignadas

    def __str__(self):        
        return "Nombre= " + super().getNombre() + ", especialista= " + self.getEspecialidad()+ ", id: "+str(self.getId()) + " fecha registro: " + super().getInicioVinculacion().isoformat()





    def compareTo(self, o):

        return 0

