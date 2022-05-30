package gestorAplicacion.operacional;
import java.util.ArrayList;
import java.time.LocalDateTime;

import java.util.HashMap;

import java.io.Serializable;
import java.time.*;


public class Factura implements Serializable {  
	
	//-----------SERIALIZADOR-----------
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
	
	
	//-----------ATRIBUTOS-----------
	private int idFactura;
	private Cita cita;
	private double precioTotal;
	private LocalDateTime fecha;
	private String metodoPago;
	public static int NumFacturas=0;
	private HashMap<Producto, Integer> productosVendidos = new HashMap<Producto, Integer>(); // Dict con producto y cantidad
	
	
	//-----------CONSTRUCTORES-----------
	//-----------1. Para facturar una cita -----------
	public Factura(Cita cita, LocalDateTime fecha, String metodoPago) {
		Factura.NumFacturas++;
		this.idFactura = Factura.NumFacturas;
		this.cita = cita;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		facturas.add(this);
	}
	
	//-----------2. Para facturar productos -----------
	public Factura( HashMap<Producto, Integer> productosVendidos, LocalDateTime fechaCompra, String metodoPago) {
		Factura.NumFacturas++;
		this.idFactura = Factura.NumFacturas;
		this.fecha = fechaCompra;
		this.metodoPago = metodoPago;
		this.productosVendidos = productosVendidos;
		//this.cita.getCliente().addFactura(this);
		facturas.add(this);
	}
	
	//-----------GETTERS Y SETTERS-----------
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
	public HashMap<Producto, Integer> getProductosVendidos(){
		return this.productosVendidos;
	}
	public void setProductosVendidos(HashMap<Producto, Integer> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	
	
	//-----------OTROS METODOS -----------
	public float precioTotalProductos() {
		float totalPagar = 0;
		for(Producto p : this.productosVendidos.keySet()) {
			
			totalPagar = totalPagar +  p.getPrecioVenta() * this.productosVendidos.get(p);
		}
		
		this.precioTotal = totalPagar;
		return totalPagar;
	}
	
	public void agregarProductosAVender(Producto producto, int cantidad) {
		this.productosVendidos.put(producto, cantidad);
	}
	
	public float precioTotalServicios() {
		float totalPagar = 0;
		ArrayList<Servicio> servicios = this.cita.getServicios();
		
		for(Servicio s : servicios) {
			totalPagar += s.getPrecio();
		}
		
		return totalPagar;
	}
	
	public float totalFactura() { //deberia ejecutarse este metodo al crear un objeto de clase Factura?
		float ans = 0;
		ans = this.precioTotalProductos()+ this.precioTotalServicios();
		this.precioTotal = ans;
		return ans;
	}
	
	
	
	
}
