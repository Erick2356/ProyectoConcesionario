package co.edu.konradlorenz.controller;

import java.util.ArrayList;
import java.util.Iterator;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.View;

public class Controller {
	private ArrayList<Persona> lista = new ArrayList<>();
	private Cliente objCliente = new Cliente();
	private Empleado objEmpleado = new Empleado();
	private Lista objLista = new Lista();
	private Nodo cabeza;

	public void run() {
		boolean running = true;
		while (running) {

			switch (View.mostrarMenu()) {
			case 1:
				switch (View.mostrarMenuGestionAutomoviles()) {
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

				default:
					View.mostrarMensaje("Opcion no valida");
					break;
				}
			case 2:
				switch (View.mostrarMenuVentas()) {
				case 1:
					registrarVenta();
					break;
				case 2:
					double entada = totalIngresos(0);
					View.mostrarMensaje("El ingreso total de ventas es de: " + entada);
					break;

				default:
					View.mostrarMensaje("Opcion no valida");
					break;
				}
			case 3:
				switch (View.mostrarMenuClientesEmpleados()) {
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

				default:
					View.mostrarMensaje("Opcion no valida");
					break;
				}

			case 4:
				View.mostrarMensaje("Saliendo del programa...");
				running = false;
				break;
			default:
				View.mostrarMensaje("Opción no válida");
				break;

			}
		}
	}

	public Controller() {
		this.cabeza = null;
	}

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
		case 1:
			View.mostrarMensaje("Ingrese capacidad de carga");
			int capacidad = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de camioneta(tracción)");
			String tipo = View.pedirString();
			nAutomovil = new Camioneta(id, modelo, marca, motor, color, puertas, anio, precio, capacidad, tipo);
			break;
		case 2:
			View.mostrarMensaje("Ingrese autonomia");
			int autonomia = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de bateria");
			String tipoBateria = View.pedirString();
			View.mostrarMensaje("Ingrese tiempo de carga");
			int tiempoCarga = View.pedirEntero();
			nAutomovil = new Electrico(id, modelo, marca, motor, color, puertas, anio, precio, autonomia, tipoBateria,
					tiempoCarga);
			break;
		case 3:
			View.mostrarMensaje("Ingrese cilindraje");
			int cilindraje = View.pedirEntero();
			View.mostrarMensaje("Ingrese tipo de motocicleta");
			String tipoMotocicleta = View.pedirString();
			nAutomovil = new Motocicleta(id, modelo, marca, motor, color, puertas, anio, precio, cilindraje,
					tipoMotocicleta);
			break;

		default:
			View.mostrarMensaje("Tipo de automovil invalido");
			break;
		}
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

	public void registrarVenta() {

		Nodo actual = cabeza;
		if (cabeza == null) {
			View.mostrarMensaje("No hay automoviles");
			return;
		}
		View.mostrarMensaje("Ingrese id del automovil:");
		int idd = View.pedirEntero();
		if (cabeza.getAutomovil().getId() == idd) {
			View.mostrarMensaje("El vehiculo a vender es: " + cabeza.getAutomovil().toString());
			View.mostrarMensaje("Ingrese la forma de pago: ");
			int forma = View.pedirForma();
			switch (forma) {
			case 1:
				View.mostrarMensaje("El precio a pagar: " + cabeza.getAutomovil().getPrecio());
				View.mostrarMensaje("Venta Exitosa.");
				totalIngresos(cabeza.getAutomovil().getPrecio());
				eliminarAutomovilDeVenta(idd);
				break;
			case 2:
				View.mostrarMensaje("Precio del Vehiculo: " + cabeza.getAutomovil().getPrecio());
				View.mostrarMensaje("Ingrese el numero de cuotas:");
				double cant = View.pedirDouble();
				View.mostrarMensaje("Interes total acumulado "
						+ cabeza.getAutomovil().calcularInterecesCredito(cabeza.getAutomovil().getPrecio(), cant));
				View.mostrarMensaje(
						"Valor de cuota mensual " + cabeza.getAutomovil().calcularValorDecuota(
								cabeza.getAutomovil().montoTotal(cabeza.getAutomovil().getPrecio(),
										cabeza.getAutomovil()
												.calcularInterecesCredito(cabeza.getAutomovil().getPrecio(), cant)),
								cant));
				View.mostrarMensaje("Valor total a pagar: " + cabeza.getAutomovil().montoTotal(
						cabeza.getAutomovil().getPrecio(),
						cabeza.getAutomovil().calcularInterecesCredito(cabeza.getAutomovil().getPrecio(), cant)));
				totalIngresos(cabeza.getAutomovil().montoTotal(cabeza.getAutomovil().getPrecio(),
						cabeza.getAutomovil().calcularInterecesCredito(cabeza.getAutomovil().getPrecio(), cant)));
				eliminarAutomovilDeVenta(idd);
				break;

			}

		}

	}

	public void eliminarAutomovil() {
		if (cabeza == null) {
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
		actual.setNext(actual.next.next);
		View.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito");

	}

	public void eliminarAutomovilDeVenta(int ob) {
		if (cabeza == null) {
			View.mostrarMensaje("No hay automoviles");
			return;
		}

		int idd = ob;
		if (cabeza.getAutomovil().getId() == idd) {
			cabeza = cabeza.next;
			return;

		}
		Nodo actual = cabeza;
		while (actual.next != null && actual.next.getAutomovil().getId() != idd) {
			actual = actual.next;
		}
		if (actual.next == null) {

			return;
		}
		actual.setNext(actual.next.next);
		View.mostrarMensaje("Automovil con ID" + idd + " eliminado con exito de la lsita despues de venderse ");

	}

	public void modificarAutomovil(int id) {
		if (cabeza == null) {
			View.mostrarMensaje("No hay automovil");
			return;
		}
		Nodo actual = cabeza;
		while (actual != null && actual.getAutomovil().getId() != id) {
			actual = actual.getNext();

		}
		if (actual == null) {
			View.mostrarMensaje("No se encontro ningun automovil con ID" + id);
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

		automod.setId(nuevoId);
		automod.setModelo(nuevoModelo);
		automod.setMarca(nuevaMarca);
		automod.setMotor(nuevoMotor);
		automod.setColor(nuevoColor);
		automod.setCantidadPuertas(nuevaPuertas);
		automod.setAnio(nuevoAnio);
		automod.setPrecio(nuevoPrecio);

		if (automod instanceof Camioneta) {
			Camioneta camioneta = (Camioneta) automod;
			View.mostrarMensaje("Introduzca nueva capacidad de carga");
			int nuevaCapacidad = View.pedirEntero();
			View.mostrarMensaje("Introduzca nuevo tipo (tracción)");
			String nuevoTipo = View.pedirString();
			camioneta.setCapacidadCarga(nuevaCapacidad);
			camioneta.setTipo(nuevoTipo);

		}

		if (automod instanceof Electrico) {
			Electrico electrico = (Electrico) automod;
			View.mostrarMensaje("Introduzca nueva autonomia");
			int nuevaAutonomia = View.pedirEntero();
			View.mostrarMensaje("Introduzca nuevo tipo de bateria");
			String nuevoTipoBateria = View.pedirString();
			View.mostrarMensaje("Introduzca nuevo tiempo de carga");
			int nuevoTiempoCarga = View.pedirEntero();
			electrico.setAutonomia(nuevaAutonomia);
			electrico.setTipoBateria(nuevoTipoBateria);
			electrico.setTiempoCarga(nuevoTiempoCarga);

		}

		if (automod instanceof Motocicleta) {
			Motocicleta motocicleta = (Motocicleta) automod;
			View.mostrarMensaje("Introduzca nuevo cilindraje");
			int nuevoCilindraje = View.pedirEntero();
			View.mostrarMensaje("Introduzca nuevo tipo de motocicleta");
			String nuevoTipo = View.pedirString();
			motocicleta.setCilindraje(nuevoCilindraje);
			motocicleta.setTipoMoto(nuevoTipo);

		}
		View.mostrarMensaje("Automovil modificato exitosamente");

	}

	public void buscarAutomovilAnio(int anio) {
		if (cabeza == null) {
			View.mostrarMensaje("No hay automoviles");
			return;
		}
		boolean e = false;
		Nodo actual = cabeza;
		while (actual != null) {
			Automovil automovil = actual.getAutomovil();
			if (automovil.getAnio() == anio) {
				View.mostrarMensaje(automovil.toString());
				e = true;

			}
			actual = actual.getNext();

		}
		if (!e) {
			View.mostrarMensaje("No se encontro ningun automovil del año" + anio);

		}
	}

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
		objLista.setListaPersona(new Cliente(n, f, t));
	}

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
		objLista.setListaPersona(new Empleado(n, f, t, l));
	}

	public void obtenerClientes() {
		for (Object cliente : objLista.getLista()) {
			if (cliente instanceof Cliente) {
				View.mostrarMensaje("Cliente: " + cliente.toString());

			}
		}
	}

	public void obtenerEmpleados() {
		for (Object empleado : objLista.getLista()) {
			if ((empleado instanceof Empleado)) {
				View.mostrarMensaje("Empleado: " + empleado.toString());

			}
		}
	}

	public double totalIngresos(double imgreso) {
		double total = 0;
		total += imgreso;
		return total;
	}

}