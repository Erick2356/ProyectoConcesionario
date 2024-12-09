package co.edu.konradlorenz.model;

/**
 * Clase abstracta y publica Automovil, inplementa de la interface Interes, de
 * esta clase no se van a crear objetos, se crearan de sus clases hijas ya que
 * es una clase abstracta
 */
public abstract class Automovil implements Interes {
	private int id;
	private String modelo;
	private String marca;
	private String motor;
	private String color;
	private int cantidadPuertas;
	private int anio;
	private double precio;
	private Cliente cliente;

	/**
	 * Constructor vacio
	 */
	public Automovil() {
	}

	/**
	 * Constructor lleno, recibe todas las variables de la clase
	 * 
	 * @param id
	 * @param modelo
	 * @param marca
	 * @param motor
	 * @param color
	 * @param cantidadPuertas
	 * @param anio
	 * @param precio
	 */
	public Automovil(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio,
			double precio) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.motor = motor;
		this.color = color;
		this.cantidadPuertas = cantidadPuertas;
		this.anio = anio;
		this.precio = precio;
	}

	/**
	 * Getters y setters
	 * 
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Metodo sobreescrito override
	 */
	@Override
	public String toString() {
		return "Automovil \n" + "  ID: " + id + ",\n" + "  Modelo: '" + modelo + "',\n" + "  Marca: '" + marca + "',\n"
				+ "  Motor: '" + motor + "',\n" + "  Color: '" + color + "',\n" + "  Cantidad de puertas: "
				+ cantidadPuertas + ",\n" + "  Año: " + anio + ",\n" + "  Precio: $" + precio + "\n";
	}
}
