package co.edu.konradlorenz.model;

/**
 * Interface Vehiculo, aqui hay metodos sin cuerpo, el cuerpo de los metodos es
 * implementado de forma distinta(Polimorfismo) dependiendo cada clase que
 * implementa la interface
 */
public interface Vehiculo {
	void encender();

	void apagar();

	void acelerar(double velocidad);

	void frenar();

	boolean isEncendido();

	double getVelocidadActual();
}
