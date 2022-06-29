class Producto:
    
 
    #-----------ATRIBUTOS-----------
    numProducto = 0
    _producto = []     #serializador

    #-----------CONSTRUCTOR-----------
    def __init__(self, nombreProducto, precioVenta):
    
        self._productoId = 0
        self._nombreProducto = None
        self._precioVenta = 0

        self._productoId = Producto.numProducto
        #this.existencias = existencias
        self._nombreProducto = nombreProducto
        self._precioVenta = precioVenta
        Producto.numProducto += 1
        Producto._producto.append(self)     #serializador

    #-----------GETTERS y SETTERS-----------

    @classmethod          #serializador
    def getProductos(cls):
        return cls._producto

    @classmethod             #serializador
    def setProductos(cls, productos):
        cls._producto = productos

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
    def __str__(self):
        return "El producto= "+ self._nombreProducto +" "+ "tiene un precio de venta de = " + str(self._precioVenta)



