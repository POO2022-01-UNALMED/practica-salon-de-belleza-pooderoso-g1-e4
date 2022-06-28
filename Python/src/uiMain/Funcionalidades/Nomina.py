from organizacional.Empleado import Empleado
from operacional.Cita import Cita



class Nomina:
    
    #//////////////////////////FUNCIONALIDAD NÓMINA ////////////////////////////////////////////////////////	

    @staticmethod
    def calcularNomina():
        print("=============Pago nomina mes vencido=============")

        fechas = java.util.TreeSet()
        for cita in gestorAplicacion.operacional.Cita.getCitas():
            fechas.add(cita.getFechaCita().get(java.time.temporal.ChronoField.MONTH_OF_YEAR))
        for venta in gestorAplicacion.operacional.Venta.getVentas():
            fechas.add(venta.getFechaVenta().get(java.time.temporal.ChronoField.MONTH_OF_YEAR))

        print("")
        print("Seleccione el mes a pagar:")

        meses = {}
        meses[1] = "Enero"
        meses[2] = "Febrero"
        meses[3] = "Marzo"
        meses[4] = "Abril"
        meses[5] = "Mayo"
        meses[6] = "Junio"
        meses[7] = "Julio"
        meses[8] = "Agosto"
        meses[9] = "Septiembre"
        meses[10] = "Octubre"
        meses[11] = "Noviembre"
        meses[12] = "Diciembre"
        value = fechas.iterator()
        i = 1
        while value.hasNext():
            print(str(i) + " " + meses[value.next()])
            i += 1

        print("Opcionn: ", end = '')
        texto = java.util.Scanner(System.in)
        opcion = texto.nextInt()

        value = fechas.iterator()
        i = 1
        mes_escogido = 0
        valor = 0
        while value.hasNext():
            valor = int(value.next())
            if i == opcion:
                mes_escogido = valor
                break
            i += 1

        #LOS EMPLEADOS
        print("")
        print("Seleccione el empleado a liquidar:")

        for emp in Empleado.getEmpleados():
            print(emp)

        print("Nombre: ", end = '')
        nombre = java.util.Scanner(System.in)
        empleado = nombre.next()

        #Citas que atendió el empleado
        empleadoEscogido = None
        for emp in gestorAplicacion.organizacional.Empleado.getEmpleados():
            if emp.getNombre() is empleado:
                empleadoEscogido = emp

                break
        citasMes = []
        for cita in gestorAplicacion.operacional.Cita.getCitas():
            if cita.getFechaCita().get(java.time.temporal.ChronoField.MONTH_OF_YEAR) == mes_escogido:

                if cita.getEmpleado().getNombre() is empleado:
                    citasMes.append(cita)

        #Productos que vendió el empleado

        ventasMes = []
        for venta in gestorAplicacion.operacional.Venta.getVentas():
            if venta.getFechaVenta().get(java.time.temporal.ChronoField.MONTH_OF_YEAR) == mes_escogido:
                if venta.getEmpleadoComision().getNombre() is empleado:
                    ventasMes.append(venta)
        totalComi = 0
        for venta in ventasMes:
            totalComi += (venta.getProductoVendido().getPrecioVenta() * gestorAplicacion.operacional.Venta.porcentajeComision)

        print(" ")
        print(" ")
        print(" ================================================================== ")
        print("                     Pago al empleado " + empleado)
        print(" ================================================================== ")
        print("  ")

        print("El empleado " + empleado + " atendio " + str(len(citasMes)) + " citas en el mes")
        print("Tiene un sueldo base de:  " + empleadoEscogido.getSueldo())
        print(" ")

        print("Vendio: " + str(len(ventasMes)) + " producto(s) en el mes, correspondientes a:")
        print(" ")
        for venta in ventasMes:
            print("  --> " + venta.getProductoVendido().getNombreProducto() + " $ " + venta.getProductoVendido().getPrecioVenta())
        print(" ")
        print("Por lo que recibe una comision del 20% de cada producto, es decir: " + str(totalComi))

        print(" ")
        totalTodo = empleadoEscogido.getSueldo() + totalComi
        print("Confirmacion:")
        print("El sueldo total a pagar debe ser: " + str(totalTodo))

