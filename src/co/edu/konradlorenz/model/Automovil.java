package co.edu.konradlorenz.model;

public  abstract class Automovil {
    private int id;
    private String modelo;
    private String marca;
    private String motor;
    private String color;
    private int cantidadPuertas;
    private int anio;
    private double precio;

    public Automovil() {
    }

    public Automovil(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio, double precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
        this.color = color;
        this.cantidadPuertas = cantidadPuertas;
        this.anio = anio;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", motor='" + motor + '\'' +
                ", color='" + color + '\'' +
                ", cantidadPuertas=" + cantidadPuertas +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }
}
