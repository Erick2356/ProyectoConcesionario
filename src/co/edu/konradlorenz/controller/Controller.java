package co.edu.konradlorenz.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

//import java.util.ArrayList;
import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.AutomovilesWindow;
import co.edu.konradlorenz.view.ClientesEmpleadosWindow;
import co.edu.konradlorenz.view.VentasWindow;

/**
 * Clase controller (Logica del programa)
 */
public class Controller {
	private ArrayList<Persona> lista = new ArrayList<>();
	private ArrayList<String> registro = new ArrayList<>();
	private Cliente objCliente = new Cliente();
	private Empleado objEmpleado = new Empleado();
	private Lista objLista = new Lista();
	private Nodo cabeza;
	private double total = 0;
	private AutomovilesWindow pedir = new AutomovilesWindow(null);
	private VentasWindow ventas = new VentasWindow(null);
	private ClientesEmpleadosWindow persona = new ClientesEmpleadosWindow(null);

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
			nAutomovil = new Camioneta(id, modelo, marca, motor, color, puertas, anio, precio, capacidad, traccion);
			break;

		case 2: // Si el tipo es electrico
			int autonomia = pedir.pedirInt("Ingrese autonomia");
			String bateria = pedir.pedirString("Ingrese Tipo de Bateria");
			int tiempoCarga = pedir.pedirInt("Ingrese el tiempo de Carga");
			nAutomovil = new Electrico(id, modelo, marca, motor, color, puertas, anio, precio, autonomia, bateria,
					tiempoCarga);

			break;

		case 3: // Si es una motocicleta
			int cilindraje = pedir.pedirInt("Ingrese Cilindraje");
			String tipoMoto = pedir.pedirString("Ingrese tipo de Moto");
			nAutomovil = new Motocicleta(id, modelo, marca, motor, color, puertas, anio, precio, cilindraje, tipoMoto);
			break;

		default:
			pedir.mostrarMensaje("Tipo de automovil invalido");
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
			pedir.mostrarMensaje("No hay Auntomoviles");
		} else {
			ArrayList<String> listaAutomoviles = new ArrayList<>();
			Nodo aux = cabeza;
			while (aux != null) {
				Automovil automovil = aux.getAutomovil();
//				View.mostrarMensaje(automovil.toString());
				if (automovil != null) {
					listaAutomoviles.add(automovil.toString());
//				En busca de mostrar los elementos de una forma mas ideal
				} else {
					listaAutomoviles.add("Automóvil no definido en este nodo.");
				}
				aux = aux.getNext();

			}
			pedir.mostrarLista(listaAutomoviles, "Lista de Automoviles");
		}
	}

	/**
	 * Metodo que no retorna ni recibe parametros este registra una venta de un
	 * automovil
	 */
	public void registrarVenta() {
		if (cabeza == null) {// Verifica si la lista de automoviles esta llena
			// View.mostrarMensaje("No hay automóviles disponibles para venta.");
			pedir.mostrarMensaje("No hay automóviles disponibles para venta.");
			return;
		}

		int id = pedir.pedirInt("Ingrese ID:");
		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si el id coincide con algun vehiculo
//			View.mostrarMensaje("Automóvil no encontrado con ID: " + id);
			ventas.mostrarMensaje("Automóvil no encontrado con ID:" + id);
			return;
		}

//		View.mostrarMensaje("El vehículo a vender es: " + actual.getAutomovil().toString());
//		View.mostrarMensaje("Ingrese la forma de pago: ");
		ventas.mostrarMensaje("El vehículo a vender es: " + actual.getAutomovil().toString());
		int forma = ventas
				.pedirInt("ingrese la forma de pago (ingrese 1 para pagar al contado o 2 para pago a credito):");

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
		registro.add(actual.getAutomovil().toString());
		
		eliminarAutomovilDeVenta(id);
//		View.mostrarMensaje("Venta Exitosa.");
		ventas.mostrarMensaje("Venta Exitosa.");
		
	}

	/**
	 * Metodo que no recibe ni retorna parametros, aqui se elimina un automovil de
	 * la lista de automoviles
	 */
	public void eliminarAutomovil() {
		if (cabeza == null) {// Verifica si la lista esta vacia
//			View.mostrarMensaje("No hay automoviles");
			pedir.mostrarMensaje("No hay automoviles en la lista");
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
			pedir.mostrarMensaje("No se encontro ningun automovil con ID" + idd);
			return;
		}
		actual.setNext(actual.next.next);// Apunta el nodo al siguiente objeto de la lista para eliminarlo
//		View.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito");
		pedir.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito");

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
			pedir.mostrarMensaje("No hay automóviles para eliminar.");
			return;
		}
//           int ventaId = ventas.pedirInt("Ingrese el ID del Vehiculo:");
		if (cabeza.getAutomovil().getId() == ventaId) {
			cabeza = cabeza.getNext();// Elimina el automovil apuntando la cabeza del nodo al siguiente elemento
//			View.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado exitosamente.");
			pedir.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado exitosamente.");
			return;
		}

		Nodo actual = cabeza;
		while (actual.getNext() != null && actual.getNext().getAutomovil().getId() != ventaId) {
			actual = actual.getNext();
		}

		if (actual.getNext() == null) {
//			View.mostrarMensaje("No se encontró ningún automóvil con ID " + ventaId);
			pedir.mostrarMensaje("No se encontró ningún automóvil con ID " + ventaId);
		} else {
			actual.setNext(actual.getNext().getNext());
//			View.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado después de la venta.");
			pedir.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado después de la venta.");
		}
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el id
	 * del automovil a modificar
	 * 
	 * @param id
	 */

	public void modificarAutomovil() {
		if (cabeza == null) {// Verifica si la lista de automoviles esta vacia
			pedir.mostrarMensaje("No hay automoviles en la lista");
			return;
		}
		int id = pedir.pedirInt("Ingrese El ID del vehiculo");
		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si existe un automovil con ese id
//			View.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
			pedir.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
			return;
		}
		Automovil automod = actual.getAutomovil();
//		View.mostrarMensaje("Automovil encontrado, digite los nuevos valores");
//		View.mostrarMensaje("Introduzca nuevo id");
		int nuevoId = pedir.pedirInt("Ingrese ID:");
//		View.mostrarMensaje("Introduzca nuevo modelo");
		String nuevoModelo = pedir.pedirString("Ingrese Modelo");
//		View.mostrarMensaje("Introduzca nueva marca");
		String nuevaMarca = pedir.pedirString("Ingrese Marca");
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
		pedir.mostrarMensaje("Automovil modificado");
//		View.mostrarMensaje("Automóvil modificado exitosamente.");
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el
	 * año para buscar los automoviles por año
	 * 
	 * @param anio
	 */
	public void buscarAutomovilAnio() {

		if (cabeza == null) {// Verficia si la lista esta vacia
//			View.mostrarMensaje("No hay automóviles.");
			pedir.mostrarMensaje("No hay automóviles.");
			return;
		}
		int anio = pedir.pedirInt("Ingrese el año del vehiculo");
		boolean encontrado = false;
		Nodo actual = cabeza;
		while (actual != null) {
			Automovil automovil = actual.getAutomovil();
			if (automovil.getAnio() == anio) {
//				View.mostrarMensaje(automovil.toString());
				pedir.mostrarMensaje(automovil.toString());
				encontrado = true;
			}
			actual = actual.getNext();
		}
		if (!encontrado) {// Verifica si existen automoviles dentro de la lista que coincidan con el año
							// ingresado
//			View.mostrarMensaje("No se encontró ningún automóvil del año " + anio);
			pedir.mostrarMensaje("No se encontró ningún automóvil del año " + anio);
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
		n = (persona.pedirString("Ingrese el nombre"));
//		View.mostrarMensaje("Ingrese el apellido: ");
		f = persona.pedirString("Ingrese el apellido");
//		View.mostrarMensaje("Ingrese la cedula: ");
		t = persona.pedirInt("Ingrese Cedula");
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
		n = persona.pedirString("Ingrese Nombre");
//		View.mostrarMensaje("Ingrese el apellido: ");
		f = persona.pedirString("Ingrese Apellido");
//		View.mostrarMensaje("Ingrese la cedula: ");
		t = persona.pedirInt("Ingrese cedula");
//		View.mostrarMensaje("Ingrese el codigo");
		l = persona.pedirInt("Ingrese Codigo");
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

	public void mostrarVentas() {
		
		if(registro.isEmpty()) {
			
			pedir.mostrarMensaje("Lista Vacia");
			
		}else {
			
			pedir.mostrarLista(registro, "Lista de ventas");
			
			
		}
		
		
	}
		
		
		
			
			

	

	public void eliminarCliente() {

		if (!objLista.getLista().isEmpty()) {

			int cedula = persona.pedirInt("Ingrese la cédula del cliente a eliminar");

			Cliente eliminar = null;

			for (Persona cliente : objLista.getLista()) {
				if (cliente instanceof Cliente) {
					Cliente clienteCast = (Cliente) cliente;
					if (clienteCast.getCedula() == cedula) {
						eliminar = clienteCast;
						break;
					}
				}
			}

			if (eliminar != null) {

				persona.mostrarMensaje("Datos del cliente a eliminar: " + " Nombre: " + eliminar.getNombre()
						+ " Apellidos " + eliminar.getApellidos() + " C.c: " + eliminar.getCedula());
				objLista.getLista().remove(eliminar);
				persona.mostrarMensaje("Cliente eliminado.");
			} else {
				persona.mostrarMensaje("Cliente no encontrado.");
			}
		} else {
			persona.mostrarMensaje("La lista está vacía.");
		}
	}

	public void eliminarEmpleado() {
		if (!objLista.getLista().isEmpty()) {

			int cedula = persona.pedirInt("Ingrese la cédula del Empleado a eliminar");

			Empleado eliminar = null;

			for (Persona empleado : objLista.getLista()) {
				if (empleado instanceof Empleado) {
					Empleado cast = (Empleado) empleado;
					if (empleado.getCedula() == cedula) {
						eliminar = cast;
						break;
					}
				}
			}

			if (eliminar != null) {

				persona.mostrarMensaje("Datos del empleado a eliminar: " + " Nombre: " + eliminar.getNombre()
						+ " Apellidos " + eliminar.getApellidos() + " C.c: " + eliminar.getCedula() + " Codigo: "
						+ eliminar.getCodigo());
				objLista.getLista().remove(eliminar);
				persona.mostrarMensaje("Empleado eliminado.");
			} else {
				persona.mostrarMensaje("Empleado no encontrado.");
			}
		} else {
			persona.mostrarMensaje("La lista está vacía.");
		}
	}

	public void agregarEmpleado(String id, String nombre) {
		String n, f;
		int t, l;
		n = (pedir.pedirString("Ingrese nombre"));
		f = (pedir.pedirString("Ingrese apellido"));
		t = pedir.pedirInt("Ingrese la cedula");
		l = pedir.pedirInt("Ingrese el código");
		objLista.setListaPersona(new Empleado(n, f, t, l));

	}

	public void mostrarClientes() {
		if (!objLista.getLista().isEmpty()) {
			persona.mostrarMensaje("Clientes registrados:");
			for (Object obj : objLista.getLista()) {
				if (obj instanceof Cliente) {
					Cliente cliente = (Cliente) obj;
					persona.mostrarMensaje(cliente.toString());
				}
			}
		} else {
			persona.mostrarMensaje("No hay clientes registrados.");
		}

	}

	public void agregarCliente(String id, String nombre) {
		String n, f;
		int t;
		n = (persona.pedirString("Ingrese nombre"));
		f = (persona.pedirString("Ingrese apellido"));
		t = persona.pedirInt("Ingrese la cedula");
		objLista.setListaPersona(new Cliente(n, f, t));

	}

	public int calcularIngresosTotales() {

		if (total == 0) { 
	        persona.mostrarMensaje("No se han registrado ventas.");
	        return 0;
	    }

	    
	    persona.mostrarMensaje("El ingreso total acumulado es: $" + total);

	    return (int) total;

	}

}