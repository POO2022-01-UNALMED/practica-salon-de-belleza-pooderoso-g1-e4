package gestorAplicacion.operacional;
import java.util.ArrayList;

import java.io.Serializable;
import java.time.*;


public class Factura implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Factura> facturas;
	static {
		facturas = new ArrayList<Factura>();
	}
	
	public static ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public static void setFacturas(ArrayList<Factura> facturas) {
		Factura.facturas = facturas;
	}
	
	//también en cada constructor se debe poner el add al array
	// ahora si el codigo
	

	private int idFactura;
	private Cita cita;
	private double precioTotal;
	private LocalDateTime fecha;
	private String metodoPago;
	public static int NumFacturas=0;
	private ArrayList<Venta> productosVendidos = new ArrayList<Venta>();
	
	public Factura(Cita cita, LocalDateTime fecha, String metodoPago) {
		Factura.NumFacturas++;
		this.idFactura = Factura.NumFacturas;
		this.cita = cita;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		facturas.add(this);
	}
	
	public Factura( ArrayList<Venta> productosVendidos, LocalDateTime fechaCompra, String metodoPago) {
		Factura.NumFacturas++;
		this.idFactura = Factura.NumFacturas;
		this.fecha = fechaCompra;
		this.metodoPago = metodoPago;
		this.productosVendidos = productosVendidos;
		facturas.add(this);
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
	
	public void precioTotalProductos(ArrayList<Venta> productosVendidos) {
		
		float totalPagar = 0;
		
		for(Venta v : productosVendidos) {
			
			totalPagar = totalPagar +  v.getProductoVendido().getPrecioVenta() * v.getCantidadVendida();
			
		}
		
		this.precioTotal = totalPagar;
	}
}
