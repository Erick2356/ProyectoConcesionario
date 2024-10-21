package co.edu.konradlorenz.model;

public class Cliente extends Persona {

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String apellidos, int cedula) {
		super(nombre, apellidos, cedula);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() +"]";
	}
     
	
	
}
