package co.edu.konradlorenz.model;

public interface Vehiculo {
        void encender();
        void apagar();
        void acelerar(double velocidad);
        void frenar();
        boolean isEncendido();
        double getVelocidadActual();
    }


