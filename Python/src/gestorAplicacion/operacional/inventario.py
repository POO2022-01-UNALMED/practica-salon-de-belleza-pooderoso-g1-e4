class Inventario:
    """
    #-----------SERIALIZADOR-----------
    _SERIALVERSIONUID = 1

    _inventario = None
    _inventarios = None
    @staticmethod
    def _static_initializer():
        gestorAplicacion.operacional.Inventario._inventario = {}
        gestorAplicacion.operacional.Inventario._inventarios = []

    _static_initializer()


    @staticmethod
    def getInventario():
        return gestorAplicacion.operacional.Inventario._inventario
    @staticmethod
    def getInventarios():
        return gestorAplicacion.operacional.Inventario._inventarios

    """

    #-----------ATRIBUTOS-----------
    _inventario = []
    _inventarios = []

    #-----------CONSTRUCTOR-----------
    def __init__(self, lista):
        #instance fields found by Java to Python Converter:
        self._listaProductos = {}

        self._listaProductos = lista
        Inventario._inventario = lista
        Inventario._inventarios.append(self)

    #-----------GETTERS y SETTERS-----------
    def getListaProductos(self):
        return self._listaProductos
    def setListaProductos(self, listaProductos):
        self._listaProductos = listaProductos


    #-----------OTROS METODOS-----------
    def agregarProducto(self, producto, existencias):
        self._listaProductos[producto] = existencias
        #Inventario.inventario.put(producto, existencias)
    def calcularPatrimonio(self):
        total = 0
        for set in self._listaProductos.entrySet():
            total += set.getKey().getPrecioVenta()*set.getValue()
        return total

    def actualizarExistencias(self, producto, cantidad):
        if self.sePuedeVender(producto, cantidad):
            oldValue = self._listaProductos[producto]
            self._listaProductos[producto] = oldValue - cantidad
            #Inventario.inventario.put(producto, oldValue - cantidad)

    def sePuedeVender(self, producto, cantidad):

        if self._listaProductos[producto] >= cantidad:
            return True

        return False

    def mostrarExistencias(self):
        texto = ""
        for p in self._listaProductos.keys():

            texto = texto + p.getNombreProducto() + " " + str(self._listaProductos[p]) + " "

        return texto

    def toString(self):
        return "Cantidades= "+ self._listaProductos.values()

