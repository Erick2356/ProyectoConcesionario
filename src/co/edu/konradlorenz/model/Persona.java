package co.edu.konradlorenz.model;

/**
 * Clase abstracta Peronsa, de esta clase no se crearan objetos, pero si de sus
 * clases hijas
 */
public abstract class Persona {
	private String nombre;
	private String apellidos;
	private int cedula;

	/**
	 * sobrecarga de constructores, vacio y lleno
	 */
	public Persona() {
		super();

	}

	public Persona(String nombre, String apellidos, int cedula) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
	}

	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * Metodo sobreescrito toString
	 */
	@Override
	public String toString() {
		return "Persona \n" + "  nombre: " + nombre + ",\n" + "  Apellidos: " + apellidos + ",\n" + "  cedula: "
				+ cedula + "\n";
	}

}
