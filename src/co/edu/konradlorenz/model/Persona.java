package co.edu.konradlorenz.model;

public abstract class Persona {
     private String nombre;
     private String apellidos;
     private int cedula;
     
     
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(String nombre, String apellidos, int cedula) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
	}


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


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + "]";
	}
     
      
}
