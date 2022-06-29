from gestorAplicacion.organizacional import Empleado



class Venta:

    #-----------ATRIBUTOS-----------
    PORCENTAJECOMISION = 0.2
    numVenta = 0
    _venta=[]         #serializador

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
        Venta._venta.append(self)           #serializador




    #-----------GETTERS y SETTERS-----------
    @classmethod           #serializador
    def getVentas(cls):
        return cls._venta

    @classmethod               #serializador
    def setVentas(cls, ventas):
        cls._venta = ventas

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
        return "El empleado "+ self._empleadoComision.getNombre() +" "+self._empleadoComision.getApellido()+" "+"" + " realiza una venta de "+ self._productoVendido.getNombreProducto() + " en la fecha "+ str(self._fechaVenta) +" y recibe una comision de: " + str(self.calcularComision(self._productoVendido))

    def calcularComision(self, productoVendido):
        comision= productoVendido.getPrecioVenta() * Venta.PORCENTAJECOMISION

        return comision
