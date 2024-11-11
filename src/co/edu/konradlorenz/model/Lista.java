package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Lista {
	private ArrayList<Persona> listaPersona = new ArrayList<Persona>();

	/**
	 * / Constructor vacio y lleno, sobrecarga de constructores
	 */
	public Lista() {

	}

	public Lista(ArrayList<Persona> listaPersona) {

		this.listaPersona = listaPersona;
	}

	/**
	 * Getters y setters, los getters reciben y retornan variable, y los setters
	 * solo reciben
	 * 
	 * @param indice
	 * @return
	 */
	public Persona getListaJugadores(int indice) {
		return listaPersona.get(indice);
	}

	public void setListaPersona(Persona persona) {
		this.listaPersona.add(persona);
	}

	public ArrayList<Persona> getLista() {
		return listaPersona;
	}

	/**
	 * Metodo sobreescrito toString
	 */
	@Override
	public String toString() {
		return "Lista [listaPersona=" + listaPersona + "]";
	}

}
