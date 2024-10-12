package co.edu.konradlorenz.model;

public class Camioneta extends Automovil implements Vehiculo {

    private boolean encendido;
    private double velocidadActual;
    private int capacidadCarga;
    private String tipo;

    public Camioneta() {
    }

    public Camioneta(int capacidadCarga, String tipo) {
        this.capacidadCarga = capacidadCarga;
        this.tipo = tipo;
    }

    public Camioneta(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio, double precio, int capacidadCarga, String tipo) {
        super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
        this.capacidadCarga = capacidadCarga;
        this.tipo = tipo;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return super.toString() + ", Camioneta [Capacidad carga: " + capacidadCarga + ", Tipo: " + tipo + "]";
    }
    


    @Override
    public void encender() {
        this.encendido = true;

    }

    @Override
    public void apagar() {
        this.encendido = false;

    }

    @Override
    public void acelerar(double velocidad) {
        if(encendido){
            this.velocidadActual += velocidad;
        }

    }

    @Override
    public void frenar() {
        if(encendido){
            this.velocidadActual = 0;
        }
    }

    @Override
    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public double getVelocidadActual() {
        return velocidadActual;
    }
}
