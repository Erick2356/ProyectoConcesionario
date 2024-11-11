package co.edu.konradlorenz.model;

/**
 * Clase publica Motocicleta, esta hereda de la clase abstracta Automovil, e
 * implementa la interface Vehiculo, de esta clase si se crearan objetos en el
 * controller del programa
 */
public class Motocicleta extends Automovil implements Vehiculo {

	private boolean encendido;
	private double velocidadActual;
	private int cilindraje;
	private String tipoMoto;

	/**
	 * Sobrecarga de contructores, vacio lleno y los contructores de la clase padre
	 */
	public Motocicleta() {
	}

	public Motocicleta(int cilindraje, String tipoMoto) {
		this.cilindraje = cilindraje;
		this.tipoMoto = tipoMoto;
	}

	public Motocicleta(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio,
			double precio, int cilindraje, String tipoMoto) {
		super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
		this.cilindraje = cilindraje;
		this.tipoMoto = tipoMoto;
	}

	// GETTERS AND SETTERS
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipoMoto() {
		return tipoMoto;
	}

	public void setTipoMoto(String tipoMoto) {
		this.tipoMoto = tipoMoto;
	}

	/**
	 * Metodo sobreesctrito toString
	 */
	@Override
	public String toString() {
		return super.toString() + ", Motocicleta [Cilindraje: " + cilindraje + ", Tipo moto: " + tipoMoto + "]";
	}

	/**
	 * Metodos implementados de la interface, aqui se encuentra el cuerpo de los
	 * metodos y se utiliza el polimorfismo
	 */
	@Override
	public void encender() {
		this.encendido = true;

	}

	@Override
	public void apagar() {
		this.encendido = false;

	}

	@Override
	public void acelerar(double velocidad) {
		if (encendido) {
			this.velocidadActual += velocidad;
		}

	}

	@Override
	public void frenar() {
		if (encendido) {
			this.velocidadActual = 0;
		}
	}

	@Override
	public boolean isEncendido() {
		return encendido;
	}

	@Override
	public double getVelocidadActual() {
		return velocidadActual;
	}

	@Override
	public double calcularInterecesCredito(double precio, double cant) {
		return precio * (INTERECES / AÑO) * cant;

	}

	@Override
	public double montoTotal(double precio, double interes) {

		return precio + interes;
	}

	@Override
	public double calcularValorDecuota(double montoTotal, double cant) {

		return montoTotal / cant;
	}

}
