package co.edu.konradlorenz.controller;

import javax.swing.JOptionPane;

//import java.util.ArrayList;
import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.AutomovilesWindow;

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
    private AutomovilesWindow pedir = new AutomovilesWindow(null);
	/**
	 * Metodo run
	 */
	public void run() {

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
	public void agregarAutomovil(int opcion) { 
//		AutomovilesWindow pedir = new AutomovilesWindow(null);
        int id = pedir.pedirInt("Ingrese ID:");
        String modelo = pedir.pedirString("Ingrese Modelo");
        String marca = pedir.pedirString("Ingrese Marca");
        String motor = pedir.pedirString("Ingrese Motor");
        String color = pedir.pedirString("Ingrese Color");
        int puertas = pedir.pedirInt("Ingrese Cantidad de Puertas");
        int anio = pedir.pedirInt("Ingrese Año");
        double precio = pedir.pedirDouble("Ingrese Precio");
        Automovil nAutomovil = null;
		switch (opcion) {
		case 1: // Si el automovil es tipo camioneta
			 int capacidad = pedir.pedirInt("Ingrese la Capacidad");
             String traccion = pedir.pedirString("Ingrese Traccion");
             new Camioneta(id, modelo, marca, motor, color, puertas, anio, precio, capacidad, traccion);
             break;
			

		case 2: // Si el tipo es electrico
    		 int autonomia = pedir.pedirInt("Ingrese autonomia");
            String bateria = pedir.pedirString("Ingrese Tipo de Bateria");
            int tiempoCarga = pedir.pedirInt("Ingrese el tiempo de Carga");
            new Electrico(id, modelo, marca, motor, color, puertas, anio, precio, autonomia, bateria, tiempoCarga);
            
			break;

		case 3: // Si es una motocicleta
			  int cilindraje = pedir.pedirInt("Ingrese Cilindraje");
              String tipoMoto = pedir.pedirString("Ingrese tipo de Moto");
              new Motocicleta(id, modelo, marca, motor, color, puertas, anio, precio, cilindraje, tipoMoto);
			break;

		default:
//			View.mostrarMensaje("Tipo de automovil invalido");
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

//		View.mostrarMensaje("Automovil agregado exitosamente");

	}

	/**
	 * Metodo que no retorna ni recibe parametros, este muestra la lista de todos
	 * los automoviles añadidos al consesionario
	 */
	public void mostrarAutomovil() {
		if (cabeza == null) {
//			View.mostrarMensaje("No hay automoviles");
		} else {
			Nodo aux = cabeza;
			while (aux != null) {
				Automovil automovil = aux.getAutomovil();
//				View.mostrarMensaje(automovil.toString());
				aux = aux.getNext();

			}
		}
	}

	/**
	 * Metodo que no retorna ni recibe parametros este registra una venta de un
	 * automovil
	 */
	public void registrarVenta(int formaPago) {
		if (cabeza == null) {// Verifica si la lista de automoviles esta llena
			//View.mostrarMensaje("No hay automóviles disponibles para venta.");
			return;
		}

		
		int id = pedir.pedirInt("Ingrese ID:");
		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si el id coincide con algun vehiculo
//			View.mostrarMensaje("Automóvil no encontrado con ID: " + id);
			return;
		}

//		View.mostrarMensaje("El vehículo a vender es: " + actual.getAutomovil().toString());
//		View.mostrarMensaje("Ingrese la forma de pago: ");
		int forma = formaPago;

		double precio = actual.getAutomovil().getPrecio();
		if (forma == 1) {// Si es al contado
//			View.mostrarMensaje("El precio a pagar: " + precio);

		} else if (forma == 2) {// si es a credito

//			View.mostrarMensaje("Precio del Vehículo: " + precio);
//			View.mostrarMensaje("Ingrese el número de cuotas:");
			double cuotas = pedir.pedirDouble("Ingrese El Numero de Cuotas");
			double interes = pedir.pedirDouble("Ingrese Intereses");
			double montoTotal = actual.getAutomovil().montoTotal(precio, interes);
//			View.mostrarMensaje("Interés total acumulado: " + interes);
//			View.mostrarMensaje("Valor de cuota mensual: " + actual.getAutomovil().calcularValorDecuota(montoTotal, cuotas));
//			View.mostrarMensaje("Valor total a pagar: " + montoTotal);
			precio = montoTotal;
		}

		totalIngresos(precio);
		eliminarAutomovilDeVenta(id);
//		View.mostrarMensaje("Venta Exitosa.");
	}

	/**
	 * Metodo que no recibe ni retorna parametros, aqui se elimina un automovil de
	 * la lista de automoviles
	 */
	public void eliminarAutomovil() {
		if (cabeza == null) {// Verifica si la lista esta vacia
//			View.mostrarMensaje("No hay automoviles");
			return;
		}
//		View.mostrarMensaje("Ingrese id del automovil a eliminar");
		int idd = pedir.pedirInt("Ingrese ID");
		if (cabeza.getAutomovil().getId() == idd) {
			cabeza = cabeza.next;
			return;

		}
		Nodo actual = cabeza;
		while (actual.next != null && actual.next.getAutomovil().getId() != idd) {
			actual = actual.next;
		}
		if (actual.next == null) {
//			View.mostrarMensaje("No se encontro ningun automovil con ID" + idd);
			return;
		}
		actual.setNext(actual.next.next);// Apunta el nodo al siguiente objeto de la lista para eliminarlo
//		View.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito");

	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero, el id del
	 * automovil para eliminar despues de haberlo vendido
	 * 
	 * @param ventaId
	 */
	public void eliminarAutomovilDeVenta(int ventaId) {
		if (cabeza == null) {// Verifica si existe el automovil a eliminar
//			View.mostrarMensaje("No hay automóviles para eliminar.");
			return;
		}

		if (cabeza.getAutomovil().getId() == ventaId) {
			cabeza = cabeza.getNext();// Elimina el automovil apuntando la cabeza del nodo al siguiente elemento
//			View.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado exitosamente.");
			return;
		}

		Nodo actual = cabeza;
		while (actual.getNext() != null && actual.getNext().getAutomovil().getId() != ventaId) {
			actual = actual.getNext();
		}

		if (actual.getNext() == null) {
//			View.mostrarMensaje("No se encontró ningún automóvil con ID " + ventaId);
		} else {
			actual.setNext(actual.getNext().getNext());
//			View.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado después de la venta.");
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
//			View.mostrarMensaje("No hay automóviles.");
			return;
		}

		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si existe un automovil con ese id
//			View.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
			return;
		}
		Automovil automod = actual.getAutomovil();
//		View.mostrarMensaje("Automovil encontrado, digite los nuevos valores");
//		View.mostrarMensaje("Introduzca nuevo id");
		int nuevoId = pedir.pedirInt("Ingrese ID:");
//		View.mostrarMensaje("Introduzca nuevo modelo");
		String nuevoModelo = pedir.pedirString("Ingrese Modelo");
//		View.mostrarMensaje("Introduzca nueva marca");
		String nuevaMarca =  pedir.pedirString("Ingrese Marca");
//		View.mostrarMensaje("Introduzca nuevo motor");
		String nuevoMotor = pedir.pedirString("Ingrese Motor");
//		View.mostrarMensaje("Introduzca nuevo color");
		String nuevoColor = pedir.pedirString("Ingrese Color");
//		View.mostrarMensaje("Introduzca nueva cantidad de puertas");
		int nuevaPuertas = pedir.pedirInt("Ingrese Numero de Puertas");
//		View.mostrarMensaje("Introduzca nuevo año");
		int nuevoAnio = pedir.pedirInt("Ingrese Año");
//		View.mostrarMensaje("Introduzca nuevo precio");
		double nuevoPrecio = pedir.pedirDouble("Ingrese Precio");
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
//			View.mostrarMensaje("Introduzca nueva capacidad de carga");
			camioneta.setCapacidadCarga(pedir.pedirInt("Ingrese Capacidad"));// Cambia la capacidad de carga
//			View.mostrarMensaje("Introduzca nuevo tipo (tracción)");
			camioneta.setTipo(pedir.pedirString("Ingrese tipo de Traccion"));// Cambia el tipo de traccion

		} else if (automod instanceof Electrico) {// SI es un automovil electrico
			Electrico electrico = (Electrico) automod;
//			View.mostrarMensaje("Introduzca nueva autonomía");
			electrico.setAutonomia(pedir.pedirInt("Ingrese Autonomia"));// Cambia la autonomia
//			View.mostrarMensaje("Introduzca nuevo tipo de batería");
			electrico.setTipoBateria(pedir.pedirString("Ingrese Tipo de bateria"));// Cambia el tipo de bateria
//			View.mostrarMensaje("Introduzca nuevo tiempo de carga");
			electrico.setTiempoCarga(Integer.parseInt("Ingrese Tiempo de Carga"));// Cambia el tiempo de carga

		} else if (automod instanceof Motocicleta) {// Si es una motocicleta
			Motocicleta motocicleta = (Motocicleta) automod;
//			View.mostrarMensaje("Introduzca nuevo cilindraje");
			motocicleta.setCilindraje(pedir.pedirInt("Ingrese Cilindraje"));// Cambia el cilindraje
//			View.mostrarMensaje("Introduzca nuevo tipo de motocicleta");
			motocicleta.setTipoMoto(pedir.pedirString("Ingrese tipo de moto"));// Cambia el tipo de motocicleta
		}

//		View.mostrarMensaje("Automóvil modificado exitosamente.");
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el
	 * año para buscar los automoviles por año
	 * 
	 * @param anio
	 */
	public void buscarAutomovilAnio(int anio) {
		if (cabeza == null) {// Verficia si la lista esta vacia
//			View.mostrarMensaje("No hay automóviles.");
			return;
		}

		boolean encontrado = false;
		Nodo actual = cabeza;
		while (actual != null) {
			Automovil automovil = actual.getAutomovil();
			if (automovil.getAnio() == anio) {
//				View.mostrarMensaje(automovil.toString());
				encontrado = true;
			}
			actual = actual.getNext();
		}
		if (!encontrado) {// Verifica si existen automoviles dentro de la lista que coincidan con el año
							// ingresado
//			View.mostrarMensaje("No se encontró ningún automóvil del año " + anio);
		}
	}

	/**
	 * Metodo que no recibe ni retorna parametros, este agrega un objeto de tipo
	 * cliente a una lista
	 */
	public void agregarCliente() {
//		View.mostrarMensaje("Ingrese los datos del cliente:");
		String n, f;
		int t;
//		View.mostrarMensaje("Ingrese el nombre:");
		n = (pedir.pedirString("Ingrese el nombre"));
//		View.mostrarMensaje("Ingrese el apellido: ");
		f = pedir.pedirString("Ingrese el apellido");
//		View.mostrarMensaje("Ingrese la cedula: ");
		t = pedir.pedirInt("Ingrese Cedula");
		objLista.setListaPersona(new Cliente(n, f, t));// Se crea el objeto cliente con las variables recibidas por
														// teclado anteriormente
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, agrega un empleado
	 */
	public void agregarEmpleado() {
//		View.mostrarMensaje("Ingrese los datos del empleado: ");
		String n, f;
		int t, l;
//		View.mostrarMensaje("Ingrese el nombre:");
		n = pedir.pedirString("Ingrese Nombre");
//		View.mostrarMensaje("Ingrese el apellido: ");
		f = pedir.pedirString("Ingrese Apellido");
//		View.mostrarMensaje("Ingrese la cedula: ");
		t =  pedir.pedirInt("Ingrese cedula");
//		View.mostrarMensaje("Ingrese el codigo");
		l =  pedir.pedirInt("Ingrese Codigo");
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
//				View.mostrarMensaje(cliente.toString());

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
//				View.mostrarMensaje(empleado.toString());

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


	public String mostrarVentas() {
		
	}

	public void registrarVenta(String clienteId, String automovilId) {
		if (cabeza == null) {// Verifica si la lista de automoviles esta llena
			return;
		}

		int id = pedir.pedirInt("Ingrese ID del automóvil:");

		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si el id coincide con algun vehiculo
			return;
		}

		
		int forma = pedir.pedirInt("Ingrese forma de pago:");// Pide al usuario la forma de pago, si es al contado o a credito

		double precio = actual.getAutomovil().getPrecio();
		if (forma == 1) {// Si es al contado

		} else if (forma == 2) {// si es a credito

			double cuotas = pedir.pedirDouble("Ingrese número de cuotas");
			double interes = actual.getAutomovil().calcularInterecesCredito(precio, cuotas);
			double montoTotal = actual.getAutomovil().montoTotal(precio, interes);
			precio = montoTotal;
		}

		totalIngresos(precio);
		eliminarAutomovilDeVenta(id);
		
	}

	public void eliminarCliente(String id) {
		
	}

	public void eliminarEmpleado(String id) {
		
	}

	public void agregarEmpleado(String id, String nombre) {
		String n, f;
		int t, l;
		n = (pedir.pedirString("Ingrese nombre"));
		f = (pedir.pedirString("Ingrese apellido"));
		t = (int) pedir.pedirDouble("Ingrese la cedula");
		l = pedir.pedirInt("Ingrese el código");
		objLista.setListaPersona(new Empleado(n, f, t, l));
		
	}

	public String mostrarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarCliente(String id, String nombre) {
		String n, f;
		int t;
		n = (pedir.pedirString("Ingrese nombre"));
		f = (pedir.pedirString("Ingrese apellido"));
		t = (int) pedir.pedirDouble("Ingrese la cedula");
		objLista.setListaPersona(new Cliente(n, f, t));
		
	}

}