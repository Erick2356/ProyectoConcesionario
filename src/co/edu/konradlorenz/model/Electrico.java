package co.edu.konradlorenz.model;

/**
 * Clase publica Electrico, esta hereda de la clase Automovil e implementa de la
 * interface Vehiculo, de esta clase Electrico si se crearan objetos en en
 * controller
 */
public class Electrico extends Automovil implements Vehiculo {

	private boolean encendido;
	private double velocidadActual;
	private int autonomia;
	private String tipoBateria;
	private int tiempoCarga;

	/**
	 * Sobrecarga de constructores vacio, lleno y los contructores de la clase padre
	 */
	public Electrico() {
	}

	public Electrico(int autonomia, String tipoBateria, int tiempoCarga) {
		this.autonomia = autonomia;
		this.tipoBateria = tipoBateria;
		this.tiempoCarga = tiempoCarga;
	}

	public Electrico(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio,
			double precio, int autonomia, String tipoBateria, int tiempoCarga) {
		super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
		this.autonomia = autonomia;
		this.tipoBateria = tipoBateria;
		this.tiempoCarga = tiempoCarga;
	}

	// GETTERS AND SETTERS
	public int getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}

	public String getTipoBateria() {
		return tipoBateria;
	}

	public void setTipoBateria(String tipoBateria) {
		this.tipoBateria = tipoBateria;
	}

	public int getTiempoCarga() {
		return tiempoCarga;
	}

	public void setTiempoCarga(int tiempoCarga) {
		this.tiempoCarga = tiempoCarga;
	}

	// Metodo toString
	@Override
	public String toString() {
		return super.toString() + ", Electrico [Autonomía: " + autonomia + ", Tipo Batería: " + tipoBateria
				+ ", Tiempo de Carga: " + tiempoCarga + "]";
	}

	/**
	 * Metodos sobreescritos de la interface, aqui se encuentra el cuerpo de los
	 * metodos y el Polimorfismo,
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
		// TODO Auto-generated method stub
		return precio * (INTERECES / AÑO) * cant;

	}

	@Override
	public double montoTotal(double precio, double interes) {
		// TODO Auto-generated method stub
		return precio + interes;
	}

	@Override
	public double calcularValorDecuota(double montoTotal, double cant) {
		// TODO Auto-generated method stub
		return montoTotal / cant;
	}
}
