package co.edu.konradlorenz.model;

public class Nodo {
    private Automovil  automovil;
    public Nodo next;

    public Nodo(Automovil automovil) {
        this.automovil = automovil;
        this.next = null;
    }

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
