package co.edu.konradlorenz.model;

/**
 * Clase nodo, aqui esta una estructura de datos de listas como enlaces.
 */
public class Nodo {
	private Automovil automovil;
	public Nodo next;

	// Sobrecarga de constructores, lleno y vacio
	public Nodo(Automovil automovil) {
		this.automovil = automovil;
		this.next = null;
	}

	// GETTERS AND SETTERS
	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

}
