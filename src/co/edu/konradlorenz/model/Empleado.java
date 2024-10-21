package co.edu.konradlorenz.model;

public class Empleado extends Persona{
     private int codigo;
    
     
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


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Empleado [codigo=" + this.codigo + " " + super.toString() + "]";
	}
     
     
}
