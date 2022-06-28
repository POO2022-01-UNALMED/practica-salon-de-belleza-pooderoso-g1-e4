class Factura:

    """
    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self._idFactura = 0
        self._cita = None
        self._precioTotal = 0
        self._fecha = None
        self._metodoPago = None
        self._productosVendidos = {}


    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _facturas = None
    @staticmethod
    def _static_initializer():
        Factura._facturas = []

    _static_initializer()

    @staticmethod
    def getFacturas():
        return Factura._facturas

    @staticmethod
    def setFacturas(facturas):
        Factura._facturas = facturas
    """

    #-----------ATRIBUTOS-----------
    NumFacturas =0
    _facturas = []

    #-----------CONSTRUCTORES-----------
    #-----------1. Para facturar una cita -----------
#JAVA TO PYTHON CONVERTER TODO TASK: There is no Python equivalent to multiple constructors:
#ORIGINAL LINE: public Factura(Cita cita, java.time.LocalDateTime fecha, String metodoPago)
    def __init__(self, cita, fecha, metodoPago):
        self._initialize_instance_fields()

        Factura.NumFacturas += 1
        self._idFactura = Factura.NumFacturas
        self._cita = cita
        self._fecha = fecha
        self._metodoPago = metodoPago
        self._cita.setFactura(self)
        self._cita.setEstado("Exitosa")
        Factura._facturas.append(self)

    #-----------2. Para facturar productos -----------
#JAVA TO PYTHON CONVERTER TODO TASK: There is no Python equivalent to multiple constructors:
#ORIGINAL LINE: public Factura(java.util.HashMap<Producto, Integer> productosVendidos, java.time.LocalDateTime fechaCompra, String metodoPago)
    def __init__(self, productosVendidos, fechaCompra, metodoPago):
        self._initialize_instance_fields()

        Factura.NumFacturas += 1
        self._idFactura = Factura.NumFacturas
        self._fecha = fechaCompra
        self._metodoPago = metodoPago
        self._productosVendidos = productosVendidos
        #this.cita.getCliente().addFactura(this)
        Factura._facturas.append(self)

    #-----------GETTERS Y SETTERS-----------
    def getIdFactura(self):
        return self._idFactura
    def setIdFactura(self, idFactura):
        self._idFactura = idFactura

    def getCita(self):
        return self._cita
    def setCita(self, cita):
        self._cita = cita

    def getPrecioTotal(self):
        return self._precioTotal
    def setPrecioTotal(self, precioTotal):
        self._precioTotal = precioTotal

    def getFecha(self):
        return self._fecha
    def setFecha(self, fecha):
        self._fecha = fecha

    def getMetodoPago(self):
        return self._metodoPago
    def setMetodoPago(self, metodoPago):
        self._metodoPago = metodoPago
    def getProductosVendidos(self):
        return self._productosVendidos
    def setProductosVendidos(self, productosVendidos):
        self._productosVendidos = productosVendidos



    #-----------OTROS METODOS -----------
    def precioTotalProductos(self):
        totalPagar = 0
        for p in self._productosVendidos.keys():

            totalPagar = totalPagar + p.getPrecioVenta() * self._productosVendidos[p]

        self._precioTotal = totalPagar
        return totalPagar

    def agregarProductosAVender(self, producto, cantidad):
        self._productosVendidos[producto] = cantidad

    def precioTotalServicios(self):
        totalPagar = 0
        servicios = self._cita.getServicios()

        for s in servicios:
            totalPagar += s.getPrecio()

        return totalPagar

    def totalFactura(self):
        ans = 0
        ans = self.precioTotalProductos()+ self.precioTotalServicios()
        self._precioTotal = ans
        return ans

    def __strt__(self):
        return "Factura, id=" + str(self._idFactura) + ", " + self._cita + ", precio total=" + str(self._precioTotal) + ", fecha=" + self._fecha + ", metodo pago=" + self._metodoPago + ", productos vendidos=" + self._productosVendidos




