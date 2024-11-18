package co.edu.konradlorenz.controller;

import java.util.ArrayList;
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
	private Nodo cabeza;// Estructura de datos listas enlazadas
	private double total = 0;
	private AutomovilesWindow pedir = new AutomovilesWindow(null); // pedir alguna variable, utilizar todos los metodos
																	// de AutomovilesWindow
	private VentasWindow ventas = new VentasWindow(null);
	private ClientesEmpleadosWindow persona = new ClientesEmpleadosWindow(null);

	/**
	 * Estructura de datos lista, por nodos
	 */
	public Controller() {
		this.cabeza = null;
	}

	/**
	 * Metodo que no retorna pero si pide una variable de tipo entera
	 */
	public void agregarAutomovil(int opcion) {

		int id = pedirInt("Ingrese ID:");
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

	}

	/**
	 * Metodo que no retorna ni recibe parametros, este muestra la lista de todos
	 * los automoviles añadidos al consesionario
	 */
	public void mostrarAutomovil() {
		if (cabeza == null) {// Verifica si existen automoviles en la lista enlazada
			pedir.mostrarMensaje("No hay Auntomoviles");
		} else {
			ArrayList<String> listaAutomoviles = new ArrayList<>();
			Nodo aux = cabeza;
			while (aux != null) {
				Automovil automovil = aux.getAutomovil();
				if (automovil != null) {
					listaAutomoviles.add(automovil.toString());
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
			pedir.mostrarMensaje("No hay automóviles disponibles para venta.");
			return;
		}

		int id = pedir.pedirInt("Ingrese ID:");
		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();
		}

		if (actual == null) {// Verifica si el id coincide con algun vehiculo
			ventas.mostrarMensaje("Automóvil no encontrado con ID:" + id);
			return;
		}

		ventas.mostrarMensaje("El vehículo a vender es: " + actual.getAutomovil().toString());
		int forma = ventas
				.pedirInt("ingrese la forma de pago (ingrese 1 para pagar al contado o 2 para pago a credito):");

		double precio = actual.getAutomovil().getPrecio();
		if (forma == 1) {// Si es al contado

		} else if (forma == 2) {// si es a credito

			double cuotas = pedir.pedirDouble("Ingrese El Numero de Cuotas");
			double interes = pedir.pedirDouble("Ingrese Intereses");
			double montoTotal = actual.getAutomovil().montoTotal(precio, interes);
			precio = montoTotal;
		}

		totalIngresos(precio);
		registro.add(actual.getAutomovil().toString());

		eliminarAutomovilDeVenta(id);
		ventas.mostrarMensaje("Venta Exitosa.");

	}

	/**
	 * Metodo que no recibe ni retorna parametros, aqui se elimina un automovil de
	 * la lista de automoviles
	 */
	public void eliminarAutomovil() {
		if (cabeza == null) {// Verifica si la lista esta vacia
			pedir.mostrarMensaje("No hay automoviles en la lista");
			return;
		}
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
			pedir.mostrarMensaje("No se encontro ningun automovil con ID" + idd);
			return;
		}
		actual.setNext(actual.next.next);// Apunta el nodo al siguiente objeto de la lista para eliminarlo
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
			pedir.mostrarMensaje("No hay automóviles para eliminar.");
			return;
		}
		if (cabeza.getAutomovil().getId() == ventaId) {
			cabeza = cabeza.getNext();// Elimina el automovil apuntando la cabeza del nodo al siguiente elemento
			pedir.mostrarMensaje("Automóvil con ID " + ventaId + " eliminado exitosamente.");
			return;
		}

		Nodo actual = cabeza;
		while (actual.getNext() != null && actual.getNext().getAutomovil().getId() != ventaId) {
			actual = actual.getNext();
		}

		if (actual.getNext() == null) {
			pedir.mostrarMensaje("No se encontró ningún automóvil con ID " + ventaId);
		} else {
			actual.setNext(actual.getNext().getNext());
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
			pedir.mostrarMensaje("No se encontró ningún automóvil con ID " + id);
			return;
		}
		Automovil automod = actual.getAutomovil();
		int nuevoId = pedir.pedirInt("Ingrese ID:");
		String nuevoModelo = pedir.pedirString("Ingrese Modelo");
		String nuevaMarca = pedir.pedirString("Ingrese Marca");
		String nuevoMotor = pedir.pedirString("Ingrese Motor");
		String nuevoColor = pedir.pedirString("Ingrese Color");
		int nuevaPuertas = pedir.pedirInt("Ingrese Numero de Puertas");
		int nuevoAnio = pedir.pedirInt("Ingrese Año");
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
			camioneta.setCapacidadCarga(pedir.pedirInt("Ingrese Capacidad"));// Cambia la capacidad de carga
			camioneta.setTipo(pedir.pedirString("Ingrese tipo de Traccion"));// Cambia el tipo de traccion

		} else if (automod instanceof Electrico) {// SI es un automovil electrico
			Electrico electrico = (Electrico) automod;
			electrico.setAutonomia(pedir.pedirInt("Ingrese Autonomia"));// Cambia la autonomia
			electrico.setTipoBateria(pedir.pedirString("Ingrese Tipo de bateria"));// Cambia el tipo de bateria
			electrico.setTiempoCarga(Integer.parseInt("Ingrese Tiempo de Carga"));// Cambia el tiempo de carga

		} else if (automod instanceof Motocicleta) {// Si es una motocicleta
			Motocicleta motocicleta = (Motocicleta) automod;
			motocicleta.setCilindraje(pedir.pedirInt("Ingrese Cilindraje"));// Cambia el cilindraje
			motocicleta.setTipoMoto(pedir.pedirString("Ingrese tipo de moto"));// Cambia el tipo de motocicleta
		}
		pedir.mostrarMensaje("Automovil modificado");
	}

	/**
	 * Metodo que no retorna pero si recibe un parametro de tipo entero que es el
	 * año para buscar los automoviles por año
	 * 
	 * @param anio
	 */
	public void buscarAutomovilAnio() {

		if (cabeza == null) {// Verficia si la lista esta vacia
			pedir.mostrarMensaje("No hay automóviles.");
			return;
		}
		int anio = pedir.pedirInt("Ingrese el año del vehiculo");
		boolean encontrado = false;
		Nodo actual = cabeza;
		while (actual != null) {
			Automovil automovil = actual.getAutomovil();
			if (automovil.getAnio() == anio) {
				pedir.mostrarMensaje(automovil.toString());
				encontrado = true;
			}
			actual = actual.getNext();
		}
		if (!encontrado) {// Verifica si existen automoviles dentro de la lista que coincidan con el año
							// ingresado
			pedir.mostrarMensaje("No se encontró ningún automóvil del año " + anio);
		}
	}

	/**
	 * Metodo que no recibe ni retorna parametros, este agrega un objeto de tipo
	 * cliente a una lista
	 */
	public void agregarCliente() {
		String n, f;
		int t;
		n = (persona.pedirString("Ingrese el nombre"));
		f = persona.pedirString("Ingrese el apellido");
		t = persona.pedirInt("Ingrese Cedula");
		objLista.setListaPersona(new Cliente(n, f, t));// Se crea el objeto cliente con las variables recibidas por
														// teclado anteriormente
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, agrega un empleado
	 */
	public void agregarEmpleado() {
		String n, f;
		int t, l;
		n = persona.pedirString("Ingrese Nombre");
		f = persona.pedirString("Ingrese Apellido");
		t = persona.pedirInt("Ingrese cedula");
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
				pedir.mostrarMensaje(cliente.toString());
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
				pedir.mostrarMensaje(empleado.toString());

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

	/**
	 * Metodo que no recibe ni retorna ninguna variable, este muestra la lista de
	 * ventas
	 */
	public void mostrarVentas() {

		if (registro.isEmpty()) {
			pedir.mostrarMensaje("Lista Vacia");
		} else {
			pedir.mostrarLista(registro, "Lista de ventas");// LLama al metodo mostrarLista en GUI
		}
	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, este elimina un cliente
	 */
	public void eliminarCliente() {

		if (!objLista.getLista().isEmpty()) {// Verifica si la lista de clientes esta llena

			int cedula = persona.pedirInt("Ingrese la cédula del cliente a eliminar");

			Cliente eliminar = null;

			for (Persona cliente : objLista.getLista()) {// Por cada objeto de tipo cliente en la lista, entonces..
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

	/**
	 * Metodo que no recibe ni retorna, este elimina un empleado teniendo la misma
	 * logica que el de elminar cliente
	 */
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

	/**
	 * Netodo que no retorna pero si recibe dos variables de tipo String, estas son
	 * el id y el nombre para agregar un Empleado
	 * 
	 * @param id
	 * @param nombre
	 */
	public void agregarEmpleado(String id, String nombre) {
		String n, f;
		int t, l;
		n = (pedir.pedirString("Ingrese nombre"));
		f = (pedir.pedirString("Ingrese apellido"));
		t = pedir.pedirInt("Ingrese la cedula");
		l = pedir.pedirInt("Ingrese el código");
		objLista.setListaPersona(new Empleado(n, f, t, l));// Se utilizan los setters para añadir al objeto de tipo
															// empleado a la lista

	}

	/**
	 * Metodo que no recibe ni retorna ninguna variable, este muestra la lista de
	 * objetos de tipo clientes, llamando al metodo toString de cada uno
	 * 
	 */
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

	/**
	 * Metodo que no retorna pero si recibe dos variables de tipo String, estas son
	 * el id y el nombre, utiliza la misma logica que agregarEmpleado pero en este
	 * caso se añaden objetos de tipo cliente a la lista de clientes
	 * 
	 * @param id
	 * @param nombre
	 */
	public void agregarCliente(String id, String nombre) {
		String n, f;
		int t;
		n = (persona.pedirString("Ingrese nombre"));
		f = (persona.pedirString("Ingrese apellido"));
		t = persona.pedirInt("Ingrese la cedula");
		objLista.setListaPersona(new Cliente(n, f, t));

	}

	/**
	 * Metodo que no recibe pero si retorna una variable de tipo entero, esta es el
	 * ingreso total que tiene el concesionario, sumando todas las ventas
	 * 
	 * @return
	 */
	public int calcularIngresosTotales() {

		if (total == 0) {
			persona.mostrarMensaje("No se han registrado ventas.");
			return 0;
		}

		persona.mostrarMensaje("El ingreso total acumulado es: $" + total);

		return (int) total;

	}
	
	public int pedirInt(String mensaje) {
        while (true) { 
            try {
                String input = pedir.pedirInput(mensaje); 
                if (input == null) { 
                   pedir.mostrarMensaje("Se cancelo la operacion.");
                    return -1;
                }
                return Integer.parseInt(input); 
            } catch (NumberFormatException e) {
                pedir.mostrarMensaje("Por favor, ingresar un dato invalido.");
            }
        }
    }

}