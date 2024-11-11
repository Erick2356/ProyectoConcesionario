package co.edu.konradlorenz.model;

/**
 * Clase publica Cmioneta, esta hereda de la clase abstracta Automovil, de esta
 * si se crearan objetos, implementa de la interface Vahiculo
 */
public class Camioneta extends Automovil implements Vehiculo {

	private boolean encendido;
	private double velocidadActual;
	private int capacidadCarga;
	private String tipo;

	/**
	 * Constructor vacio
	 */
	public Camioneta() {
	}

	/**
	 * Constructor de dos variables, recibe dos variables de la clase
	 * 
	 * @param capacidadCarga
	 * @param tipo
	 */
	public Camioneta(int capacidadCarga, String tipo) {
		this.capacidadCarga = capacidadCarga;
		this.tipo = tipo;
	}

	/**
	 * Constructor lleno, recibe todas las variables de la clase, de la clase de la
	 * que hereda y de la interface
	 * 
	 * @param id
	 * @param modelo
	 * @param marca
	 * @param motor
	 * @param color
	 * @param cantidadPuertas
	 * @param anio
	 * @param precio
	 * @param capacidadCarga
	 * @param tipo
	 */
	public Camioneta(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio,
			double precio, int capacidadCarga, String tipo) {
		super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
		this.capacidadCarga = capacidadCarga;
		this.tipo = tipo;
	}

	// GETTERS AND SETTERS
	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo sobreescrito toString
	 */
	@Override
	public String toString() {
		return super.toString() + ", Camioneta [Capacidad carga: " + capacidadCarga + ", Tipo: " + tipo + "]";
	}

	/**
	 * POLIMORFISMO(Clases con el mismo nombre estan actuando de manera distinda
	 * dependiendo de donde sean llamadas) Metodos sobreescritos de la interface, en
	 * donde estan los cuerpos de cada metodo
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
