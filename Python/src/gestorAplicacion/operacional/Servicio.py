from enum import Enum

class Servicio(Enum):    
    PEDICURE=(23000,60)
    MANICURE=(17000,60)
    ALIZADO=(30000,60)
    CEPILLADO=(27000,60)
    KERATINA=(55000,60)
    CORTE_CABALLERO=(16000,30)
    CORTE_DAMA=(21000,45)
    EXFOLIACION_FACIAL=(11000,60)
    CEJAS=(13000,30)
    DEPILACION_LASER=(107000,80)    

    def __init__(self,precio,duracion) -> None:
        self._precio=precio
        self._duracion=duracion

    @property
    def getDuracion(self):
        return self._duracion

    @property
    def getPrecio(self):
        return self._precio    