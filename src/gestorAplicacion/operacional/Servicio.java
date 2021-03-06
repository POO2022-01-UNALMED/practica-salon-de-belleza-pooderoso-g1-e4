package gestorAplicacion.operacional;

public enum Servicio {
	
	PEDICURE (23000,60),
	MANICURE (17000,60),
	ALIZADO (30000,60),
	CEPILLADO (27000,60),
	KERATINA (55000,60),
	CORTE_CABALLERO (16000,30),
	CORTE_DAMA (21000,45),
	EXFOLIACION_FACIAL (11000,60),
	CEJAS (13000,30),
	DEPILACION_LASER (107000,80);
	
	private final float precio;
	private int duracion;
	
	private Servicio(float precio,int duracion){
		this.precio = precio;
		this.duracion = duracion;
	}
	
	public float getPrecio() {
		return precio;
	}

	public int getDuracion() {
		return duracion;
	}	
	
	

}
