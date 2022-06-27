class Factura:

    #-----------ATRIBUTOS-----------
    NumFacturas =0
    _facturas = []

    #-----------CONSTRUCTORES-----------
    #-----------1. Para facturar por cita o por Productos-----------

    def __init__(self, citaOproductos, fecha, metodoPago, esCita=True):
        Factura.NumFacturas += 1
        self._idFactura = Factura.NumFacturas
        self._fecha = fecha
        self._metodoPago = metodoPago
        self._precioTotal = 0
        if esCita:
            self._cita = citaOproductos
            self._cita.setFactura(self)
            self._cita.setEstado("Exitosa")
            self._productosVendidos = {}
        else:
            self._productosVendidos = citaOproductos
            self._cita = None
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

    def toString(self):
        return "Factura, id=" + str(self._idFactura) + ", " + self._cita + ", precio total=" + str(self._precioTotal) + ", fecha=" + self._fecha + ", metodo pago=" + self._metodoPago + ", productos vendidos=" + self._productosVendidos




