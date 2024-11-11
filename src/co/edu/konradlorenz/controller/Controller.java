package co.edu.konradlorenz.controller;

//import java.util.ArrayList;
import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.View;

/**
 * Clase controller (Logica del programa)
 */
public class Controller {
	// private ArrayList<Persona> lista = new ArrayList<>();
	// private Cliente objCliente = new Cliente();
	// private Empleado objEmpleado = new Empleado();
	private Lista objLista = new Lista();
	private Nodo cabeza;
	private double total = 0;

	/**
	 * Metodo run
	 */
	public void run() {
		boolean running = true;
		while (running) {// Estructura while
			switch (View.mostrarMenu()) {// estructura switch-case que controla el primer menu
			case 1:
				boolean gestionAutomoviles = true;
				while (gestionAutomoviles) {
					switch (View.mostrarMenuGestionAutomoviles()) {// segundo switch-case para el segundo menu
					case 1:
						agregarAutomovil();
						break;
					case 2:
						eliminarAutomovil();
						break;
					case 3:
						View.mostrarMensaje("Introduzca el id del automovil a modificar");
						int id = View.pedirEntero();
						modificarAutomovil(id);
						break;
					case 4:
						mostrarAutomovil();
						break;
					case 5:
						View.mostrarMensaje("Introduzca el año de los automoviles a buscar");
						int anio = View.pedirEntero();
						buscarAutomovilAnio(anio);
						break;
					case 6:
						gestionAutomoviles = false; // Volver al menu principal
						break;
					default:
						View.mostrarMensaje("Opción no válida en Gestión de Automóviles");
						break;
					}
				}
				break;

			case 2:
				boolean gestionVentas = true;
				while (gestionVentas) {
					switch (View.mostrarMenuVentas()) {// switch-case para el menu de ventas
					case 1:
						registrarVenta();
						break;
					case 2:
						double entrada = totalIngresos(0);
						View.mostrarMensaje("El ingreso total de ventas es de: " + entrada);
						break;
					case 3:
						gestionVentas = false; // Volver al menu principal
						break;
					default:
						View.mostrarMensaje("Opción no válida en Ventas");
						break;
					}
				}
				break;

			case 3:
				boolean gestionClientesEmpleados = true;
				while (gestionClientesEmpleados) {
					switch (View.mostrarMenuClientesEmpleados()) {// estructura switch-case para el menu de clientes y
																	// empleados
					case 1:
						agregarEmpleado();
						obtenerEmpleados();
						break;
					case 2:
						agregarCliente();
						break;
					case 3:
						obtenerClientes();
						break;
					case 4:
						obtenerEmpleados();
						break;
					case 5:
						gestionClientesEmpleados = false; // Volver al menu principal
						break;
					default:
						View.mostrarMensaje("Opción no válida en Clientes y Empleados");
						break;
					}
				}
				break;

			case 4:
				View.mostrarMensaje("Saliendo del programa...");
				running = false;
				break;

			default:
				View.mostrarMensaje("Opción no válida en el menú principal");
				break;
			}
		}
	}// termina el metodo run

	/**
	 * Estructura de datos lista, por nodos
	 */
	public Controller() {
		this.cabeza = null;
	}

	/**
	 * Metodo que no retorna ni pide ningun parametro
	 */
	public void agregarAutomovil() {
		View.mostrarMensaje("Ingrese id");
		int id = View.pedirEntero();
		View.mostrarMensaje("Ingrese modelo");
		String modelo = View.pedirString();
		View.mostrarMensaje("Ingrese marca");
		String marca = View.pedirString();
		View.mostrarMensaje("Ingrese motor");
		String motor = View.pedirString();
		View.mostrarMensaje("Ingrese color");
		String color = View.pedirString();
		View.mostrarMensaje("Ingrese cantidad de puertas");
		int puertas = View.pedirEntero();
		View.mostrarMensaje("Ingrese año");
		int anio = View.pedirEntero();
		View.mostrarMensaje("Ingrese precio");
		double precio = View.pedirDouble();
		Automovil nAutomovil = null;

		switch (View.pedirTipoAutomovil()) {
		case 1: // Si el automovil es tipo camioneta
			View.mostrarMensaje("Ingrese capacidad de carga");
			int capacidad = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de camioneta(tracción)");
			String tipo = View.pedirString();
			// Se crea el objeto segun el tipo de automovil
			nAutomovil = new Camioneta(id, modelo, marca, motor, color, puertas, anio, precio, capacidad, tipo);
			break;

		case 2: // Si el tipo es electrico
			View.mostrarMensaje("Ingrese autonomia");
			int autonomia = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de bateria");
			String tipoBateria = View.pedirString();
			View.mostrarMensaje("Ingrese tiempo de carga");
			int tiempoCarga = View.pedirEntero();
			// Se crea el objeto
			nAutomovil = new Electrico(id, modelo, marca, motor, color, puertas, anio, precio, autonomia, tipoBateria,
					tiempoCarga);
			break;

		case 3: // Si es una motocicleta
			View.mostrarMensaje("Ingrese cilindraje");
			int cilindraje = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de motocicleta");
			String tipoMotocicleta = View.pedirString();
			// Se crea el objeto
			nAutomovil = new Motocicleta(id, modelo, marca, motor, color, puertas, anio, precio, cilindraje,
					tipoMotocicleta);
			break;

		default:
			View.mostrarMensaje("Tipo de automovil invalido");
			break;
		}
		/**
		 * Se crea un objeto Nodo, para utilizar la estructura de datos lista simple, y
		 * se agrega el automovil a la lista
		 */
		Nodo nuevoNodo = new Nodo(nAutomovil);
		if (cabeza == null) {
			cabeza = nuevoNodo;
		} else {
			Nodo aux = cabeza;
			while (aux.getNext() != null) {
				aux = aux.getNext();

			}
			aux.setNext(nuevoNodo);

		}

		View.mostrarMensaje("Automovil agregado exitosamente");

	}

	/**
	 * Metodo que no retorna ni recibe parametros, este muestra la lista de todos
	 * los automoviles añadidos al consesionario
	 */
	public void mostrarAutomovil() {
		if (cabeza == null) {
			View.mostrarMensaje("No hay automoviles");
		} else {
			Nodo aux = cabeza;
			while (aux != null) {
				Automovil automovil = aux.getAutomovil();
				View.mostrarMensaje(automovil.toString());
				aux = aux.getNext();

			}
		}
	}

	/**
	 * Metodo que no retorna ni recibe parametros este registra una venta de un
	 * automovil
	 */
	public void registrarVenta() {
		if (cabeza == null) {// Verifica si la lista de automoviles esta llena
			View.mostrarMensaje("No hay automóviles disponibles para venta.");
			return;
		}

		View.mostrarMensaje("Ingrese ID del automóvil:");
		int id = View.pedirEntero();

		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si el id coincide con algun vehiculo
			View.mostrarMensaje("Automóvil no encontrado con ID: " + id);
			return;
		}

		View.mostrarMensaje("El vehículo a vender es: " + actual.getAutomovil().toString());
		View.mostrarMensaje("Ingrese la forma de pago: ");
		int forma = View.pedirForma();// Pide al usuario la forma de pago, si es al contado o a credito

		double precio = actual.getAutomovil().getPrecio();
		if (forma == 1) {// Si es al contado
			View.mostrarMensaje("El precio a pagar: " + precio);

		} else if (forma == 2) {// si es a credito

			View.mostrarMensaje("Precio del Vehículo: " + precio);
			View.mostrarMensaje("Ingrese el número de cuotas:");
			double cuotas = View.pedirDouble();
			double interes = actual.getAutomovil().calcularInterecesCredito(precio, cuotas);
			double montoTotal = actual.getAutomovil().montoTotal(precio, interes);
			View.mostrarMensaje("Interés total acumulado: " + interes);
			View.mostrarMensaje(
					"Valor de cuota mensual: " + actual.getAutomovil().calcularValorDecuota(montoTotal, cuotas));
			View.mostrarMensaje("Valor total a pagar: " + montoTotal);
			precio = montoTotal;
		}

		totalIngresos(precio);
		eliminarAutomovilDeVenta(id);
		View.mostrarMensaje("Venta Exitosa.");
	}

	/**
	 * Metodo que no recibe ni retorna parametros, aqui se elimina un automovil de
	 * la lista de automoviles
	 */
	public void eliminarAutomovil() {
		if (cabeza == null) {// Verifica si la lista esta vacia
			View.mostrarMensaje("No hay automoviles");
			return;
		}
		View.mostrarMensaje("Ingrese id del automovil a eliminar");
		int idd = View.pedirEntero();
		if (cabeza.getAutomovil().getId() == idd) {
			cabeza = cabeza.next;
			return;

		}
		Nodo actual = cabeza;
		while (actual.next != null && actual.next.getAutomovil().getId() != idd) {
			actual = actual.next;
		}
		if (actual.next == null) {
			View.mostrarMensaje("No se encontro ningun automovil con ID" + idd);
			return;
		}
		actual.setNext(actual.next.next);// Apunta el nodo al siguiente objeto de la lista para eliminarlo
		View.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito");

	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero, el id del
	 * automovil para eliminar despues de haberlo vendido
	 * 
	 * @param id
	 */
	public void eliminarAutomovilDeVenta(int id) {
		if (cabeza == null) {// Verifica si existe el automovil a eliminar
			View.mostrarMensaje("No hay automóviles para eliminar.");
			return;
		}

		if (cabeza.getAutomovil().getId() == id) {
			cabeza = cabeza.getNext();// Elimina el automovil apuntando la cabeza del nodo al siguiente elemento
			View.mostrarMensaje("Automóvil con ID " + id + " eliminado exitosamente.");
			return;
		}

		Nodo actual = cabeza;
		while (actual.getNext() != null && actual.getNext().getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual.getNext() == null) {
			View.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
		} else {
			actual.setNext(actual.getNext().getNext());
			View.mostrarMensaje("Automóvil con ID " + id + " eliminado después de la venta.");
		}
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el id
	 * del automovil a modificar
	 * 
	 * @param id
	 */
	public void modificarAutomovil(int id) {
		if (cabeza == null) {// Verifica si la lista de automoviles esta vacia
			View.mostrarMensaje("No hay automóviles.");
			return;
		}

		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si existe un automovil con ese id
			View.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
			return;
		}
		Automovil automod = actual.getAutomovil();
		View.mostrarMensaje("Automovil encontrado, digite los nuevos valores");
		View.mostrarMensaje("Introduzca nuevo id");
		int nuevoId = View.pedirEntero();
		View.mostrarMensaje("Introduzca nuevo modelo");
		String nuevoModelo = View.pedirString();
		View.mostrarMensaje("Introduzca nueva marca");
		String nuevaMarca = View.pedirString();
		View.mostrarMensaje("Introduzca nuevo motor");
		String nuevoMotor = View.pedirString();
		View.mostrarMensaje("Introduzca nuevo color");
		String nuevoColor = View.pedirString();
		View.mostrarMensaje("Introduzca nueva cantidad de puertas");
		int nuevaPuertas = View.pedirEntero();
		View.mostrarMensaje("Introduzca nuevo año");
		int nuevoAnio = View.pedirEntero();
		View.mostrarMensaje("Introduzca nuevo precio");
		double nuevoPrecio = View.pedirDouble();
		/**
		 * Se cambian los valores del automovil utilizando los metodos setter del
		 * objeto, se le añaden los datos recibidos por consola que se encuentran arriba
		 */
		automod.setId(nuevoId);
		automod.setModelo(nuevoModelo);
		automod.setMarca(nuevaMarca);
		automod.setMotor(nuevoMotor);
		automod.setColor(nuevoColor);
		automod.setCantidadPuertas(nuevaPuertas);
		automod.setAnio(nuevoAnio);
		automod.setPrecio(nuevoPrecio);

		if (automod instanceof Camioneta) {// Si es de tipo camioneta
			Camioneta camioneta = (Camioneta) automod;
			View.mostrarMensaje("Introduzca nueva capacidad de carga");
			camioneta.setCapacidadCarga(View.pedirEntero());// Cambia la capacidad de carga
			View.mostrarMensaje("Introduzca nuevo tipo (tracción)");
			camioneta.setTipo(View.pedirString());// Cambia el tipo de traccion

		} else if (automod instanceof Electrico) {// SI es un automovil electrico
			Electrico electrico = (Electrico) automod;
			View.mostrarMensaje("Introduzca nueva autonomía");
			electrico.setAutonomia(View.pedirEntero());// Cambia la autonomia
			View.mostrarMensaje("Introduzca nuevo tipo de batería");
			electrico.setTipoBateria(View.pedirString());// Cambia el tipo de bateria
			View.mostrarMensaje("Introduzca nuevo tiempo de carga");
			electrico.setTiempoCarga(View.pedirEntero());// Cambia el tiempo de carga

		} else if (automod instanceof Motocicleta) {// Si es una motocicleta
			Motocicleta motocicleta = (Motocicleta) automod;
			View.mostrarMensaje("Introduzca nuevo cilindraje");
			motocicleta.setCilindraje(View.pedirEntero());// Cambia el cilindraje
			View.mostrarMensaje("Introduzca nuevo tipo de motocicleta");
			motocicleta.setTipoMoto(View.pedirString());// Cambia el tipo de motocicleta
		}

		View.mostrarMensaje("Automóvil modificado exitosamente.");
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el
	 * año para buscar los automoviles por año
	 * 
	 * @param anio
	 */
	public void buscarAutomovilAnio(int anio) {
		if (cabeza == null) {// Verficia si la lista esta vacia
			View.mostrarMensaje("No hay automóviles.");
			return;
		}

		boolean encontrado = false;
		Nodo actual = cabeza;
		while (actual != null) {
			Automovil automovil = actual.getAutomovil();
			if (automovil.getAnio() == anio) {
				View.mostrarMensaje(automovil.toString());
				encontrado = true;
			}
			actual = actual.getNext();
		}
		if (!encontrado) {// Verifica si existen automoviles dentro de la lista que coincidan con el año
							// ingresado
			View.mostrarMensaje("No se encontró ningún automóvil del año " + anio);
		}
	}

	/**
	 * Metodo que no recibe ni retorna parametros, este agrega un objeto de tipo
	 * cliente a una lista
	 */
	public void agregarCliente() {
		View.mostrarMensaje("Ingrese los datos del cliente:");
		String n, f;
		int t;
		View.mostrarMensaje("Ingrese el nombre:");
		n = (View.pedirString());
		View.mostrarMensaje("Ingrese el apellido: ");
		f = (View.pedirString());
		View.mostrarMensaje("Ingrese la cedula: ");
		t = (View.pedirEntero());
		objLista.setListaPersona(new Cliente(n, f, t));// Se crea el objeto cliente con las variables recibidas por
														// teclado anteriormente
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, agrega un empleado
	 */
	public void agregarEmpleado() {
		View.mostrarMensaje("Ingrese los datos del empleado: ");
		String n, f;
		int t, l;
		View.mostrarMensaje("Ingrese el nombre:");
		n = (View.pedirString());
		View.mostrarMensaje("Ingrese el apellido: ");
		f = (View.pedirString());
		View.mostrarMensaje("Ingrese la cedula: ");
		t = View.pedirEntero();
		View.mostrarMensaje("Ingrese el codigo");
		l = View.pedirEntero();
		objLista.setListaPersona(new Empleado(n, f, t, l));// Se crea el objeto Empleado que hereda de persona con las
															// variables pedidas por teclado anteriormente
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, obtiene la lista de
	 * clientes registrados
	 */
	public void obtenerClientes() {
		for (Object cliente : objLista.getLista()) {// Por cada objeto de tipo cliente el la lista de personas
			if (cliente instanceof Cliente) {
				View.mostrarMensaje(cliente.toString());

			}
		}
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, obtiene la lista de los
	 * empleados registrados
	 */
	public void obtenerEmpleados() {
		for (Object empleado : objLista.getLista()) {// Por cada objeto de tipo empleado en la lista de personas
			if ((empleado instanceof Empleado)) {
				View.mostrarMensaje(empleado.toString());

			}
		}
	}

	/**
	 * Metodo que recibe una variable de tipo double(El ingreso) y retorna una
	 * variable de tipo double (el total), el metodo calcula el total de ingresos en
	 * total que tiene el consesionario
	 * 
	 * @param ingreso
	 * @return
	 */
	public double totalIngresos(double ingreso) {
		total += ingreso;
		return total;
	}

}