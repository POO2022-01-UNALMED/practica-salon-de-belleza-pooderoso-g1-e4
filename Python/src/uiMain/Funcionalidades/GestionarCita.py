
from calendar import month
from datetime import timedelta
import datetime
from operator import contains
from tkinter import FALSE

from numpy import append

from  gestorAplicacion.organizacional.Cliente import Cliente
from  gestorAplicacion.organizacional.Empleado import Empleado
from  gestorAplicacion.operacional.Servicio import Servicio
from  gestorAplicacion.operacional.Cita import Cita
from  gestorAplicacion.organizacional.Administrador import Administrador




class GestionarCita:

    #    *
    #     * Reune todos los parametros para poder generar una cita de manera correcta.
    #     *
    #     * @return Diferentes preguntas de confirmacion
    #
    # 
    # 
    # 
    @classmethod
    def reservarCitaEficiente(cls,idCliente,idEmpleado,servicios,hora):
        

        idCliente=int(idCliente)
        idEmpleado=int(idEmpleado)


        if(GestionarCita.devuelveCliente(idCliente) == None ):
            cliente=Cliente("Nuevo", "Cliente",idCliente,99,300000,"Ninguna",False)
        else:
            cliente=GestionarCita.devuelveCliente(idCliente)   

        if(GestionarCita.devuelveEmpleado(idEmpleado) == None):
            return "No existe el empleado"
        else:
            empleado= GestionarCita.devuelveEmpleado(idEmpleado)

        serviciosDepurados=GestionarCita.escogerServiciosModificado(servicios)

        horadepu=hora.split("-")
        mes=horadepu[0]
        dia=horadepu[1]
        hora=horadepu[2]
        tiene=GestionarCita.mostrarCitasEficiente(empleado,mes,dia)
        fechaCita =GestionarCita.gestionarFechaEficiente(tiene,empleado, mes, dia,hora,serviciosDepurados) #fecha

        if(fechaCita==False):
            return("Horas trocadas")
            
        citafinal=GestionarCita.generarCita(empleado, cliente, servicios, datetime.datetime.now(), fechaCita)
        return str(citafinal)

                    
 
    @classmethod
    def cancelarReseva(cls,idCita):
        cita=GestionarCita.devuelvecita(idCita)
        if(cita== None):
            return "No se enuentra la cita"
        else:
            cita.setEstado("Cancelada")
            return str(cita)   
        


    @classmethod
    def devuelvecita(cls,idcita):

        for c in Cita._cita:
            if Cita.getId == idcita:
                return c
        
        return None


     
         	
    @classmethod
    def reservarCita(cls):

        #Es un nuevo Cliente?
        print("                         ")
        print("[1] Cliente ya existente")
        print("[2] Nuevo Cliente")
        print("Digite Opcion: ")


        TipoCliente =int(input())

        clienteaAsignar = None

        if TipoCliente==1:

            print("")

            cedulaCliente =int(input("Digite la identificacion del cliente:"))

            clienteaAsignar=GestionarCita.devuelveCliente(cedulaCliente)

            while clienteaAsignar is None:
                cedulaCliente=int(input("Cliente no encontrado, digite nuevamente"))
                clienteaAsignar=GestionarCita.devuelveCliente(cedulaCliente) #Cliente
        else:
            clienteaAsignar=GestionarCita.crearNuevoCliente()

        print(" ")
        GestionarCita.mostrarEmpleados()
        print(" ")
        cedulaEmpleado =int(input("Digite la identificacion del empleado al cual se le asignara la cita: "))
        print(" ")
        print("---------------------------------------------")
        e =GestionarCita.devuelveEmpleado(cedulaEmpleado) #Empleado
        print(e)
        print(" ")
        #Escoger Servicios
        servicios =GestionarCita.escogerServicios() #Servicio
        print(" ")
        mes =GestionarCita.ingresarMes()
        dia =GestionarCita.ingresarDia(mes)
        print(" ")
        estado =GestionarCita.mostrarCitas(e,mes,dia)
        fechaCita =GestionarCita.gestionarFecha(estado,e, mes, dia,servicios) #fecha
        GestionarCita.generarCita(e, clienteaAsignar, servicios, datetime.datetime.now(), fechaCita)




    #    *
    #     * Muestra la lista de empleados actuales del salon de belleza
    #     * 
    #     *
    #     * @return Muestra por consola los empleados
    #     
    @classmethod
    def mostrarEmpleados(cls):
        print("======= Lista de empleados =======")
        print(" ")
        for e in Empleado._empleados:
            print(e)

    #    *
    #     * Crea un nuevo cliente
    #     * 
    #     *
    #     * @return Nuevo cliente del salon de belleza, verifica si ya existe otro igual.
    #     
    @staticmethod
    def crearNuevoCliente():

        print("Por favor ingrese los datos del cliente:")
        print("")

        c1 = Cliente("Julian", "Londono",10013,21,3212345,"Ninguna",True)



        nombre =input("Por favor ingrese nombre del cliente: ")
        apellido =input("Por favor ingrese apellido del cliente: ")
        id =int(input("Por favor ingrese identificacion del cliente: "))
        for cliente in Cliente._clientes:
            if cliente.getId()==id:
                print("")
                print("==== Cliente ya existente, verifique nuevamente la informacion ====")
                GestionarCita.crearNuevoCliente()

        edad =int(input("Por favor ingrese edad del cliente: "))
        numero =int(input("Por favor ingrese numero del cliente: "))
        anotaciones =input("Por favor ingrese anotaciones del cliente: ")

        nuevoCliente = Administrador.NuevoCliente(nombre, apellido, id, edad, numero, anotaciones)

        print("")
        print("El nuevo cliente es: "+ str(nuevoCliente))

        return nuevoCliente



    #    *
    #     * Devuelve un empleado 
    #     *
    #     * @param cedula, se ingresa la identificacion del empleado.
    #     * @return El empleado encontrado, a partir de la cedula
    #     
    @classmethod
    def devuelveEmpleado(cls,cedula):


        for e in Empleado._empleado:
            if e.getId()==cedula:
                return e

        #nuevaCedula =int(input("Empledo no encontrado, por favor ingrese nuevamente la identificacion del empleado:"))
        #return GestionarCita.devuelveEmpleado(nuevaCedula)
        return None



    #    *
    #     * Devuelve un cliente 
    #     *
    #     * @param cedula, se ingresa la identificacion del cliente.
    #     * @return El cliente encontrado, a partir de la cedula
    #     	
    @classmethod
    def devuelveCliente(cls,cedula):

        for c in Cliente._cliente:
            if c.getId()==cedula:
                print(c)
                return c

        return None

    #    *
    #     * Muestra las citas de un empleado 
    #     *
    #     * @param empleado: El empleado al cual se le buscan las citas
    #     * 		  mes: mes de las citas
    #     * 		  dia: dia de las citas	
    #     * @return imprime por consola las citas del empleado  y
    #     * 		  devulve true or false si tiene o no citas
    #     	
    @classmethod
    def mostrarCitas(cls,empleado, mes, dia):
        tiene=False
        print("------- Citas asignadas al empleado "+ empleado.getNombre() +" el dia: "+ str(dia)+ " del mes: "+ str(mes)+"----------")
        print(" ")
        for i in empleado.getCitasAsignadas():
            mescom=i.getFechaCita().month
            diacom=i.getFechaCita().day
            if(mes ==mescom and dia == diacom and i.getEstado()!="Cancelada"):
                tiene=True
                print(i)
                
        return tiene

    @classmethod
    def mostrarCitasEficiente(cls,empleado, mes, dia):
        tiene=False
        for i in empleado.getCitasAsignadas():
            mescom=i.getFechaCita().month
            diacom=i.getFechaCita().day
            if(mes ==mescom and dia == diacom and i.getEstado()!="Cancelada"):
                tiene=True
                print(i)
                
        return tiene

        





    @classmethod
    def escogerServicios(cls):

        print(" ")
        print("Escoja separado por espacios los servicos que requiere")
        print(" ")
        print("1. PEDICURE")
        print("2. MANICURE")
        print("3. ALIZADO")
        print("4. CEPILLADO")
        print("5. KERATINA")
        print("6. CORTE_CABALLERO")
        print("7. CORTE_DAMA")
        print("8. EXFOLIACION_FACIAL")
        print("9. CEJAS")
        print("10. DEPILACION_LASER")
        print(" ")

        print("Ingrese separado por espacios los servicos que requiere")
        reserva = input()
        arregloreservs = reserva.split(" ")
        print("fffsfsfsfsfs",arregloreservs)
        serviciosescogidos=[]
        

        for i in arregloreservs:
            if (int(i)>=1 and int(i)<=10):
                if(i=="1"):
                    if Servicio.PEDICURE not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.PEDICURE)
                elif(i=="2"):
                    if Servicio.MANICURE not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.MANICURE)
                elif(i=="3"):
                    if Servicio.ALIZADO not in serviciosescogidos:
                        #print(3,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                        serviciosescogidos.append(Servicio.ALIZADO)
                elif(i=="4"):
                    if Servicio.CEPILLADO not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CEPILLADO)                           
                elif(i=="5"):
                    if Servicio.KERATINA not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.KERATINA)                             
                elif(i=="6"):
                    if Servicio.CORTE_CABALLERO not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CORTE_CABALLERO)
                elif(i=="7"):
                    if Servicio.CORTE_DAMA not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CORTE_DAMA)                                                        
                elif(i=="8"):
                    if Servicio.EXFOLIACION_FACIAL not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.EXFOLIACION_FACIAL)
                elif(i=="9"):
                    if Servicio.CEJAS not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CEJAS)
                elif(i=="10"):
                    if Servicio.DEPILACION_LASER not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.DEPILACION_LASER)
        print("")
        print("Servicos escogidos")
        print(serviciosescogidos)

        return serviciosescogidos


    @classmethod
    def escogerServiciosModificado(cls,reserva):
        arregloreservs = reserva.split(" ")
        #print("fffsfsfsfsfs",arregloreservs)
        serviciosescogidos=[]
        

        for i in arregloreservs:
            if (int(i)>=1 and int(i)<=10):
                if(i=="1"):
                    if Servicio.PEDICURE not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.PEDICURE)
                elif(i=="2"):
                    if Servicio.MANICURE not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.MANICURE)
                elif(i=="3"):
                    if Servicio.ALIZADO not in serviciosescogidos:
                        #print(3,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                        serviciosescogidos.append(Servicio.ALIZADO)
                elif(i=="4"):
                    if Servicio.CEPILLADO not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CEPILLADO)                           
                elif(i=="5"):
                    if Servicio.KERATINA not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.KERATINA)                             
                elif(i=="6"):
                    if Servicio.CORTE_CABALLERO not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CORTE_CABALLERO)
                elif(i=="7"):
                    if Servicio.CORTE_DAMA not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CORTE_DAMA)                                                        
                elif(i=="8"):
                    if Servicio.EXFOLIACION_FACIAL not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.EXFOLIACION_FACIAL)
                elif(i=="9"):
                    if Servicio.CEJAS not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.CEJAS)
                elif(i=="10"):
                    if Servicio.DEPILACION_LASER not in serviciosescogidos:
                            serviciosescogidos.append(Servicio.DEPILACION_LASER)
        #print("")
        #print("Servicos escogidos")
        #print(serviciosescogidos)

        return serviciosescogidos        




    @classmethod
    def ingresarMes(cls):
        mes = int(input("Digite el mes de la cita:"))
        if(mes<(datetime.datetime.now()).month):
            print("El mes debe ser mayor al actual")
            return GestionarCita.ingresarMes()
        elif(mes<=0 or mes>12 ):
            print("El mes debe estar entre 0 y 12")   
            return GestionarCita.ingresarMes()
        else:
            return mes

    @classmethod
    def ingresarDia(cls,mes):
        dia=int(input("Digite el dia de la cita:"))         
        diaActual= datetime.datetime.now().day
        mesActual=datetime.datetime.now().month
        if(dia < diaActual and mes <= mesActual):
            print("El dia debe estar ser mayor al actual")
            return GestionarCita.ingresarDia(mes)
        elif(dia <=0 or dia>=31):
            print("El dia debe estar entre 0 y 31")    
            return GestionarCita.ingresarDia(mes)

        else:
            return dia   

    @classmethod
    def gestionarFecha(cls,citaAsig,em,mes,dia,serv):
        if(citaAsig==False):
            print(str(em.getNombre())+" no posee citas asignadas.")
            validar=False
            while(validar==False):
                hora=int(input("Ingrese el hora"))
                horafin=datetime.timedelta(year=2022,month=mes,days=dia,hours=hora)
                validar=Cita.validarHora(em,horafin,serv)
            return  horafin

        else:
            validar=False
            while(validar==False):
                hora=int(input("Ingrese el hora"))
                horafin=datetime.datetime(2022,mes,dia,hora)
                validar=Cita.validarHora(em,horafin,serv)

            return  horafin

    @classmethod
    def gestionarFechaEficiente(cls,citaAsig,em,mes,dia,hora,serv):

        horafin=datetime.datetime(year=2022,month=int(mes),day=int(dia),hour=int(hora))
        validar=Cita.validarHora(em,horafin,serv)
        if(validar==False):
            return False
        else:
            return horafin




    @classmethod
    def  generarCita(cls,empleado,cliente,servi,fecgare,fechaCita):
        citacreada= Administrador.consolidarCita(empleado,cliente,servi,fecgare,fechaCita)
        print("")
        print("================== Cita Generada exitosamente ==================")
        print("")
        print("Empleado: " +empleado.getNombre() + " "+ empleado.getApellido())
        print("Cliente: " +cliente.getNombre()+ " "+ cliente.getApellido())
        print("Fecha de la cita: " + str(fechaCita))
        print("Estado de la cita: " +citacreada.getEstado())
        print("")

    @classmethod
    def  generarCitaEficiente(cls,empleado,cliente,servi,fecgare,fechaCita):
        citacreada= Administrador.consolidarCita(empleado,cliente,servi,fecgare,fechaCita)
        return citacreada
        print("")
        print("================== Cita Generada exitosamente ==================")
        print("")
        print("Empleado: " +empleado.getNombre() + " "+ empleado.getApellido())
        print("Cliente: " +cliente.getNombre()+ " "+ cliente.getApellido())
        print("Fecha de la cita: " + str(fechaCita))
        print("Estado de la cita: " +citacreada.getEstado())
        print("")        

         
    @classmethod
    def gestionCancelar(cls):
        for cita in Cita._citas:
            if(cita.getEstado()!="Cancelada" or cita.getEstado()!="Exitosa"):
                print(str(cita.getId())+" "+str(cita))

        id=int(input("Escoga la cita a cancelar"))
        for cita in Cita._citas:
            if(cita.getId()==id):
                cita.setEstado("Cancelada")
                print("========== Cita cancelada ==========")
                print("")
                print(str(cita))


    



            


