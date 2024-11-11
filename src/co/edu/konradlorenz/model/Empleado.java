package co.edu.konradlorenz.model;

/**
 * Clase publica Empleado esta extiende de la clase abstracta Persona, de esta
 * clase si se crean objetos en el controller del programa
 */
public class Empleado extends Persona {
	private int codigo;

	/**
	 * Sobrecarga de contructores, lleno, vacio y los contructores de la clase padre
	 */
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String apellidos, int cedula, int codigo) {
		super(nombre, apellidos, cedula);
		this.codigo = codigo;
		// TODO Auto-generated constructor stub
	}

	public Empleado(int codigo) {
		this.codigo = codigo;
	}

	// GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo sobreescrito toString
	 */
	@Override
	public String toString() {
		return "Empleado [codigo=" + this.codigo + " " + super.toString() + "]";
	}

}
