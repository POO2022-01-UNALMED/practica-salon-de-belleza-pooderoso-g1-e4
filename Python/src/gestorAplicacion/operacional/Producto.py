class Producto:
    
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _productos = None
    @staticmethod
    def _static_initializer():
        Producto._productos = []

    _static_initializer()

    @staticmethod
    def getProductos():
        return Producto._productos

    @staticmethod
    def setProductos(productos):
        Producto._productos = productos


    #-----------ATRIBUTOS-----------
    numProducto = 0

    #-----------CONSTRUCTOR-----------
    def __init__(self, nombreProducto, precioVenta):
        #instance fields found by Java to Python Converter:
        self._productoId = 0
        self._nombreProducto = None
        self._precioVenta = 0

        self._productoId = Producto.numProducto
        #this.existencias = existencias
        self._nombreProducto = nombreProducto
        self._precioVenta = precioVenta
        Producto.numProducto += 1
        Producto._productos.append(self)

    #-----------GETTERS y SETTERS-----------
    def getProductoId(self):
        return self._productoId
    def setProductoId(self, productoId):
        self._productoId = productoId

    def getNombreProducto(self):
        return self._nombreProducto
    def setNombreProducto(self, nombreProducto):
        self._nombreProducto = nombreProducto
    def getPrecioVenta(self):
        return self._precioVenta
    def setPrecioVenta(self, precioVenta):
        self._precioVenta = precioVenta

    #-----------OTROS METODOS-----------
    def toString(self):
        return "El producto= "+ self._nombreProducto +" "+ "tiene un precio de venta de = " + str(self._precioVenta)



