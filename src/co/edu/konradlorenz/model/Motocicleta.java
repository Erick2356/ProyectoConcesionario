package co.edu.konradlorenz.model;

public class Motocicleta extends Automovil implements Vehiculo {


    private boolean encendido;
    private double velocidadActual;
    private int cilindraje;
    private String tipoMoto;

    public Motocicleta() {
    }

    public Motocicleta(int cilindraje, String tipoMoto) {
        this.cilindraje = cilindraje;
        this.tipoMoto = tipoMoto;
    }

    public Motocicleta(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio, double precio, int cilindraje, String tipoMoto) {
        super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
        this.cilindraje = cilindraje;
        this.tipoMoto = tipoMoto;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    @Override
public String toString() {
    return super.toString() + ", Motocicleta [Cilindraje: " + cilindraje + ", Tipo moto: " + tipoMoto + "]";
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
