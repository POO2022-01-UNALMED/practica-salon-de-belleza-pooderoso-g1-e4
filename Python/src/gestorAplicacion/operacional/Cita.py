import datetime
from types import ClassMethodDescriptorType

#from ..organizacional.Cliente import Cliente
#from ..organizacional.Empleado import Empleado
#from uiMain.gestorInterfaz import 


class Cita:
    
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _citas = None

    @classmethod
    def _static_initializer(cls):
        cls._citas = []

    #_static_initializer()

    @staticmethod
    def getCitas():
        return Cita._citas


    @staticmethod
    def setCitas(citas):
        Cita._citas = citas

    

    #-----------ATRIBUTOS-----------
    NumCitas =0


    #-----------CONSTRUCTOR-----------
    def __init__(self, empleado, cliente, servicios, fechaReserva, fechaCita, duracion):

        Cita.NumCitas = len(Cita.getCitas()) +1
        self._idCita = Cita.NumCitas
        self._estado = "Pendiente"
        self._empleado = empleado
        self._cliente = cliente
        self._servicios = servicios
        self._fechaReserva = fechaReserva
        self._fechaCita = fechaCita
        self._duracion = duracion
        cliente.addCita(self)

        empleado.getCitasAsignadas().append(self) #Se le anade una a la lista de citas el empleado



        Cita._citas.append(self) #del Serializador


    #-----------GETTERS Y SETTERS-----------
    def getId(self):
        return self._idCita
    def setId(self, id):
        self._idCita = id

    def getEstado(self):
        return self._estado

    def setEstado(self, estado):
        self._estado=estado

    def getEmpleado(self):
        return self._empleado
    def setEmpleado(self, empleado):
        self._empleado = empleado

    def getCliente(self):
        return self._cliente
    def setCliente(self, cliente):
        self._cliente = cliente

    def getServicios(self):
        return self._servicios
    def setServicios(self, servicios):
        self._servicios = servicios

    def getFechaReserva(self):
        return self._fechaReserva
    def setFechaReserva(self, fechaReserva):
        self._fechaReserva = fechaReserva
    def getFechaCita(self):
        return self._fechaCita
    def setFechaCita(self, fechaCita):
        self._fechaCita = fechaCita

    def getDuracion(self):
        return self._duracion
    def setDuracion(self, duracion):
        self._duracion = duracion

    def getFactura(self):
        return self._factura
    def setFactura(self, factura):
        self._factura = factura



    #-----------OTROS METODOS-----------
    def toString(self):
        #formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm")
        #format = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        return self._cliente + ", fecha de la cita: " + self._fechaCita.strftime("%d/%m/%Y %H:%M")  + ", duracion:" + str(self._duracion) + ". Termina a las "+ (self._fechaCita + self._duracion).strftime("%H:%M")+". "+ self._estado


    def compareTo(self, o):
        # TODO Auto-generated method stub
        return self._fechaCita.compareTo(o.getFechaCita())

    #	 *     
    #	 * Devuelve la duracion de una cita a partir una cita	
    #    * @param servicios: lista de servicios 
    #    * 
    #    * @return la duracion de una cita a partir de los servicios escogidos
    #    
    @staticmethod
    def duracionCita(servicios):

        duracion =0
        for ser in servicios:
            duracion += ser.getDuracion()
        return duracion

    #	  *
    #     * Verifica que una cita se pueda llevar a cabo 
    #     *
    #     * @param 
    #     * 		  Empleado: empleado para verificar las citas
    #     * 		  horaTentativa: posible hora a validar
    #     * 		  servicios: los servicios que se quieren de una cita	
    #     * @return true en caso de que se pueda generar una cita false de lo contrario
    #     

    @staticmethod
    def validarHora(p, horaTentativa, servicios):

        
        duracion =Cita.duracionCita(servicios)
        horaTentativaFin =horaTentativa + duracion

        if horaTentativa.timedelta()<(Empleado.HORAINICIO) or horaTentativa.timedelta()>(Empleado.HORAFINAL):
            print("Recuerde que los horarios de atencion son de: 9 a 18 ")
            return False


        for cita in p.getCitasAsignadas():
            mesComparacion =cita.getFechaCita().month #Mes cita
            diaComparacion =cita.getFechaCita().day #Dia cita
            existenteInicial =cita.getFechaCita() #hora Inicial
            existenteFinal =cita.getFechaCita() + cita.getDuracion() #hora Final
            if((horaTentativa.month== mesComparacion) and (horaTentativa.day== diaComparacion) and cita.getCita()!=("Cancelada")):
                if((horaTentativa<existenteInicial) and (horaTentativaFin<existenteFinal) or ((horaTentativa>existenteInicial) and (horaTentativaFin >existenteFinal))):
                    print(" ")
                    print("Es posible generar la cita")
                    return True                    
                else:
                    print("Eexiten horarior trocados con la cita: "+ cita)
                    return False
        return True
