package co.edu.konradlorenz.model;

public class Nodo {
    private int dato;
    public Nodo next;

    public Nodo(int dato) {
        this.dato = dato;
        this.next = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                '}';
    }
}
