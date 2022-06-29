

from gestorAplicacion.organizacional.empleado import Empleado
from gestorAplicacion.organizacional.administrador import Administrador
from gestorAplicacion.organizacional.cliente import Cliente
from gestorAplicacion.organizacional.persona import Persona
from gestorAplicacion.organizacional.salario import Salario

from gestorAplicacion.operacional.cita import Cita
from gestorAplicacion.operacional.factura import Factura
from gestorAplicacion.operacional.inventario import Inventario
from gestorAplicacion.operacional.venta import Venta
from gestorAplicacion.operacional.producto import Producto
from gestorAplicacion.operacional.servicio import Servicio



def inicializar():
    if len(Administrador.getAdministradores()) == 0:
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

