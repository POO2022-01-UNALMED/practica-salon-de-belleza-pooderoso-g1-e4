package operacional;

public enum Servicio {
	
	PEDICURE (23000),
	MANICURE (17000),
	ALIZADO (30000),
	CEPILLADO (27000),
	KERATINA (55000),
	CORTE_CABALLERO (16000),
	CORTE_DAMA (21000),
	EXFOLIACION_FACIAL (11000),
	CEJAS (13000),
	DEPILACION_LASER (107000);
	
	private final float precio;
	
	Servicio(float precio){
		this.precio = precio;
	}
	

}
