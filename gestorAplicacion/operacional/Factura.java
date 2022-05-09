package operacional;
import java.util.ArrayList;
import organizacional.*;
import java.time.*;

public class Factura {
	private int idFactura;
	private Cita cita;
	private double precioTotal;
	private LocalDateTime fecha;
	private String metodoPago;
	public static int NumFacturas=0;
	
	public Factura(Cita cita, LocalDateTime fecha, String metodoPago) {
		Factura.NumFacturas++;
		this.idFactura = Factura.NumFacturas;
		this.cita = cita;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
	}
	
	//Metodos get y set:
	public int getIdFactura() {
		return this.idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	public Cita getCita() {
		return this.cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public String getMetodoPago() {
		return this.metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
}
