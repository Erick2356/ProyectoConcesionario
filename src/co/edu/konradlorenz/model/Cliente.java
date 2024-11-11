package co.edu.konradlorenz.model;

/**
 * Clase publica Cliente esta hereda de la clase abstracta persona, de esta
 * clase Cliente si se crean objetos en el controller
 */
public class Cliente extends Persona {
	/**
	 * Sobrecarga de constructores, vacio, lleno y los constructores de la clase que
	 * hereda
	 */
	public Cliente() {
		super();

	}

	public Cliente(String nombre, String apellidos, int cedula) {
		super(nombre, apellidos, cedula);

	}

	/**
	 * Metodo sobreescrrito toString
	 */
	@Override
	public String toString() {
		return "Cliente [" + super.toString() + "]";
	}

}
