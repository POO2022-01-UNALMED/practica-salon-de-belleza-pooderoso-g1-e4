
import datetime


#from ..gestorAplicacion.organizacional.Persona import Persona
from  gestorAplicacion.organizacional.Administrador import Administrador
from  gestorAplicacion.organizacional.Empleado import Empleado
from  gestorAplicacion.organizacional.Cliente import Cliente
from  gestorAplicacion.organizacional.Salario import Salario

from  gestorAplicacion.operacional.Cita import Cita
from  gestorAplicacion.operacional.Venta import Venta
from  gestorAplicacion.operacional.Inventario import Inventario
from  gestorAplicacion.operacional.Servicio import Servicio
from  gestorAplicacion.operacional.Factura import Factura
from  gestorAplicacion.operacional.Producto import Producto

from .uiMain.gestorInterfaz import  gestorInterfaz


if __name__ == "__main__":
    #Deserializador.deserializarTodo()


    superAdministador = Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222)


    gomina = Producto("Gomina", 2500)
    keratina = Producto("keratina", 30000)
    colagenoCapilar = Producto("Colageno Capilar", 3000)
    balsamo = Producto("Balsamo", 1500)
    esmalte = Producto("Esmalte", 4000)
    removedor = Producto("Removedor", 5500)
    acondicionador = Producto("Acondicionador", 700)


    c1 = Cliente("Julian", "Londono",10013,21,3212345,"Ninguna",True)
    c2 = Cliente("Pepito","Martinez",5234,24,32156778,"Ninguna", False)
    s1 = [Servicio.ALIZADO, Servicio.CEJAS, Servicio.CORTE_CABALLERO]
    s2 = [Servicio.CEJAS]
    s3 = [Servicio.DEPILACION_LASER, Servicio.EXFOLIACION_FACIAL]
    s4 = [Servicio.CORTE_DAMA]

    empleado1 = Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "Unas")
    empleado2 = Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo")

    fechaPrueba = datetime.datetime(2021, 5,1,12,0)
    empleado2.setFechaRegistro(fechaPrueba)

    cita1 = Cita(empleado1, c1, s1, datetime.datetime(2022, 5,1,12,0), datetime.datetime(2022, 5,30,14,0),60)
    cita2 = Cita(empleado2, c1, s2, datetime.datetime(2022, 5,10,12,0), datetime.datetime(2022, 5,31,14,0),60)
    cita3 = Cita(empleado1, c2, s3, datetime.datetime(2022, 5,1,12,0), datetime.datetime(2022, 6,15,14,0),60)
    cita4 = Cita(empleado1, c1, s4, datetime.datetime(2022, 5,3,12,0), datetime.datetime(2022, 8,21,14,0),60)

    stockInicial = {}
    stockInicial[gomina] = 23
    stockInicial[keratina] = 11
    stockInicial[colagenoCapilar] = 34
    stockInicial[balsamo] = 21
    stockInicial[esmalte] = 34

    #Inventario
    inventario = Inventario(stockInicial)

    venta1 = Venta(gomina, empleado1, datetime.datetime(2022, 5,10,12,0),5, inventario)
    venta2 = Venta(keratina, empleado2, datetime.datetime(2022, 8,14,12,0),5, inventario)



    def mostrarClientes():

        gestorInterfaz.escribir("=========================================")
        gestorInterfaz.escribir("=============== Clientes ===============")
        gestorInterfaz.escribir("=========================================")

        for clientes in Cliente.getClientes():
            print(clientes)


    condition = True
    while condition:

        try:
            gestorInterfaz.escribir("              ")
            gestorInterfaz.escribir("              ")
            gestorInterfaz.escribir("    ========== BIENVENIDO A EL SOFTWARE ADMINISTRADOR ========== ")
            gestorInterfaz.escribir("                     SALON DE BELLEZA POODEROSO   ")
            gestorInterfaz.escribir("    ===========================================================")
            gestorInterfaz.escribir("              ")
            gestorInterfaz.escribir(" Que desea realizar?")
            gestorInterfaz.escribir(" =====================")
            gestorInterfaz.escribir("                       ")
            gestorInterfaz.escribir("1.Reservar cita")
            gestorInterfaz.escribir("2.Cancelar cita")
            gestorInterfaz.escribir("3.Facturar")
            gestorInterfaz.escribir("4.Balance Contable")
            gestorInterfaz.escribir("5.Pagar nomina")
            gestorInterfaz.escribir("6.Guardar y salir")
            gestorInterfaz.escribir("7.Guardar y continuar")
            gestorInterfaz.escribir("8.Mostrar informacion actual")
            gestorInterfaz.escribir("9.Gestionar seguros")
            gestorInterfaz.escribir("10.Mostrar inventario")



            gestorInterfaz.escribir("                       ")
            gestorInterfaz.escribir(" Digite Opcion: ")
            opcion = gestorInterfaz.leer()

            if opcion == 1:
                #GestionarCita.reservarCita()
                print(1)
            elif opcion == 2:
                #GestionarCita.gestionCancelar()
                print(2)
            elif opcion == 3:
                #Facturacion.facturar()
                print(3)
            elif opcion == 4:
                #BalanceContable.calcularBalance()
                print(4)                
            elif opcion == 5:
                #Nomina.calcularNomina()
                print(5)
            elif opcion == 6:
                #Serializador.serializarTodo()
                print(6)
                condition=False
            elif opcion == 7:
                #Serializador.serializarTodo()
                print(7)
            elif opcion == 8:
                mostrarClientes()
            elif opcion == 9:
                print(9)
                #Otras.gestionarSeguros()
            elif opcion == 10:
                print(10)
                #Otras.mostrarInventario()


        except Exception as e:


            gestorInterfaz.escribir("----Upps, hemos vuelto al menu principal----")
            #System.out.println(e)
            #e.printStackTrace()
            gestorInterfaz.escribir(" ")
            opcion=5555


        
    



