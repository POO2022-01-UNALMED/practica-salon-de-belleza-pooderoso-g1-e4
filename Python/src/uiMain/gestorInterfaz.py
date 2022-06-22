

class gestorInterfaz:

    #metodos de entrada y salida por consola
    #    *
    #     * Imprime un objeto en la consola y salta una l�nea
    #     *
    #     * @param x El objeto a ser impreso.
    #      
    @staticmethod
    def escribir(x):
        print(x)

    #    *
    #     * Retorna un dato colocado por el usuario en la consola como String
    #     *
    #     * @return El dato colocado por el usuario en la consola como String
    #     
    @staticmethod
    def leer():
        return input()

    #    *
    #     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
    #     * usuario en la consola como String
    #     *
    #     * @param mensaje El mensaje que el usuario ver� antes de ingresar un dato.
    #     * @return El dato colocado por el usuario en la consola como String
    #     
    @staticmethod
    def leer(mensaje):
        gestorInterfaz.escribir(mensaje)
        return input()

    #    *
    #     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
    #     * usuario en la consola como entero
    #     *
    #     * @return El dato colocado por el usuario en la consola como entero
    #     * @throws NumberFormatException si el dato ingresado no representa un
    #     * entero.
    #     
    @staticmethod
    def leerEntero():
        return int(gestorInterfaz.leer())

    #    *
    #     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
    #     * usuario en la consola como entero
    #     *
    #     * @return El dato colocado por el usuario en la consola como long
    #     * @throws NumberFormatException si el dato ingresado no representa un
    #     * entero.
    #     
    @staticmethod
    def leerLong():
        return int((gestorInterfaz.leer()))

    @staticmethod
    def leerLong(mensaje):
        return int((gestorInterfaz.leer(mensaje)))

    #    *
    #     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
    #     * usuario en la consola como entero
    #     *
    #     * @param mensaje El mensaje que el usuario ver� antes de ingresar un dato.
    #     * @return El dato colocado por el usuario en la consola como entero
    #     * @throws Exception 
    #     * @throws NumberFormatException si el dato ingresado no representa un
    #     * entero.
    #     
    @staticmethod
    def leerEntero(mensaje):
        return int(gestorInterfaz.leer(mensaje))




