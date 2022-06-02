package gestorAplicacion.organizacional;

public interface Salario {
	public final static double SALARIO_BASE = 100;
	public abstract double getSueldo();
	public abstract void setSueldo(double sueldo);
	public abstract void aumentarSueldo(double porcentaje);
	public abstract double calcularPrima();
}
