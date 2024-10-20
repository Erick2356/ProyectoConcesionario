package co.edu.konradlorenz.model;

public class Electrico extends Automovil implements Vehiculo {

    private boolean encendido;
    private double velocidadActual;
    private int autonomia;
    private String tipoBateria;
    private int tiempoCarga;


    public Electrico() {
    }

    public Electrico(int autonomia, String tipoBateria, int tiempoCarga) {
        this.autonomia = autonomia;
        this.tipoBateria = tipoBateria;
        this.tiempoCarga = tiempoCarga;
    }

    public Electrico(int id, String modelo, String marca, String motor, String color, int cantidadPuertas, int anio, double precio, int autonomia, String tipoBateria, int tiempoCarga) {
        super(id, modelo, marca, motor, color, cantidadPuertas, anio, precio);
        this.autonomia = autonomia;
        this.tipoBateria = tipoBateria;
        this.tiempoCarga = tiempoCarga;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public String getTipoBateria() {
        return tipoBateria;
    }

    public void setTipoBateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }

    public int getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Electrico [Autonomía: " + autonomia + ", Tipo Batería: " + tipoBateria + ", Tiempo de Carga: " + tiempoCarga + "]";
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
    @Override
	public double calcularInterecesCredito(double precio, double cant) {
		// TODO Auto-generated method stub
		return precio*(INTERECES/AÑO)*cant;
		
	}

	@Override
	public double montoTotal(double precio, double interes) {
		// TODO Auto-generated method stub
		return precio + interes;
	}

	@Override
	public double calcularValorDecuota(double montoTotal, double cant) {
		// TODO Auto-generated method stub
		return montoTotal/cant;
	}
}
