package co.edu.konradlorenz.model;

public interface Interes {
    static double INTERECES = 0.19;
    static double AÑO = 12;
    public double calcularInterecesCredito(double precio, double cant);
    public double montoTotal(double precio, double interes);
    public double calcularValorDecuota(double montoTotal, double cant);
    
}
