from gestorAplicacion.organizacional import Empleado



class Venta:

    """
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _ventas = None
    @staticmethod
    def _static_initializer():
        Venta._ventas = []

    _static_initializer()


    @staticmethod
    def getVentas():
        return Venta._ventas

    @staticmethod
    def setVentas(ventas):
        Venta._ventas = ventas

    """



    #-----------ATRIBUTOS-----------
    PORCENTAJECOMISION = 0.2
    numVenta = 0
    _ventas=[]

    #-----------CONSTRUCTOR-----------
    def __init__(self, productoVendido, empleadoComision, fechaVenta, cantidadVendida, inventario):
        #instance fields found by Java to Python Converter:
        self._productoVendido = productoVendido
        self._empleadoComision = empleadoComision
        self._empleadoComision.setProductosVendidos(productoVendido)
        self._fechaVenta = fechaVenta
        self._cantidadVendida = cantidadVendida
        Venta.numVenta += 1
        self._idVenta = Venta.numVenta
        self._inventario = inventario
        self._inventario.actualizarExistencias(productoVendido, cantidadVendida)
        Venta._ventas.append(self)



    #-----------GETTERS y SETTERS-----------
    def getProductoVendido(self):
        return self._productoVendido

    def setProductoVendido(self, productoVendido):
        self._productoVendido = productoVendido

    def getEmpleadoComision(self):
        return self._empleadoComision

    def setEmpleadoComision(self, empleadoComision):
        self._empleadoComision = empleadoComision

    def getFechaVenta(self):
        return self._fechaVenta

    def setFechaVenta(self, fechaVenta):
        self._fechaVenta = fechaVenta

    def getCantidadVendida(self):
        return self._cantidadVendida

    #-----------OTROS METODOS-----------
    def __str__(self):
        return "El empleado "+ self._empleadoComision.getNombre() +" "+self._empleadoComision.getApellido()+" "+"" + " realiza una venta de "+ self._productoVendido.getNombreProducto() + " en la fecha "+ str(self._fechaVenta) +" y recibe una comisi�n de: " + str(self.calcularComision(self._productoVendido))

    def calcularComision(self, productoVendido):
        comision= productoVendido.getPrecioVenta() * Venta.PORCENTAJECOMISION

        return comision
