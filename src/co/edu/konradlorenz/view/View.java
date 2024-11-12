package co.edu.konradlorenz.view;

import java.util.Scanner;

/**
 * Clase publica View, en donde se imprimen todos los mensajes en consola, y se
 * reciben los parametros del usuario por teclado
 */
public class View {
	static Scanner sc = new Scanner(System.in);

	/**
	 * MostrarMenu principal, retorna un byte y no recibe ningun parametro
	 * 
	 * @return
	 */
	public static byte mostrarMenu() {
		System.out.println(
				"\n1 Gestionar Automoviles " + "\n2 Ventas " + "\n3 Gestionar clientes y empleados" + "\n4.Salir");
		byte opcion = sc.nextByte();
		sc.nextLine();
		return opcion;
	}

	/**
	 * Mostrar el menu para la gestion de automoviles, no pide ningun parametro pero
	 * retorna un byte que es la opcion del usuario
	 * 
	 * @return
	 */
	public static byte mostrarMenuGestionAutomoviles() {
		System.out.println("\n1 Agregar automovil " + "\n2 Eliminar Automovil " + "\n3 Modificar automovil "
				+ "\n4 Mostrar automoviles " + "\n5 Buscar automoviles por año " + "\n6 Salir");
		byte opcion2 = sc.nextByte();
		return opcion2;
	}

	/**
	 * Mostrar menu para la parte de las ventas, no retorna y recibe la opcion del
	 * usuario
	 * 
	 * @return
	 */
	public static byte mostrarMenuVentas() {
		System.out.println("\n1 Registrar venta " + "\n2 Ingreso total ventas ");
		byte opcion3 = sc.nextByte();
		return opcion3;
	}

	/**
	 * Mostrar menu para la gestion de empleados y clientes, no recibe pero si
	 * retorna la opcion del usuario
	 * 
	 * @return
	 */
	public static byte mostrarMenuClientesEmpleados() {
		System.out.println(
				"\n1 Agregar Empleado " + "\n2 Agregar Cliente " + "\n3 Mostrar Clientes " + "\n4 Mostrar Empleados ");
		byte opcion4 = sc.nextByte();
		return opcion4;
	}

	/**
	 * Metodo que pide la forma de pago, ya sea de contado o a credito, retorna la
	 * opcion del usuario como tipo entero
	 * 
	 * @return
	 */
	public static int pedirForma() {
		System.out.println("\n1 De Contado \n2 A Credito");
		return sc.nextInt();
	}

	/**
	 * Pedir tipo de automovil ya sea Camioneta, electrico o motociclaeta, retorna
	 * la opcion del usuario como entero
	 * 
	 * @return
	 */
	public static int pedirTipoAutomovil() {
		System.out.println("\n1 Camioneta \n2 Electrico \n3 Motocicleta");
		int tipo = sc.nextInt();
		sc.nextLine();
		return tipo;

	}

	/**
	 * Metodo mostrar mensaje, este metodo no retorna pero si recibe un String que
	 * es el mensaje que va a ser imprimido dentro del cuerpo del metodo
	 * 
	 * @param mensaje
	 */
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * Metodo que retorna un String, y no recibe nada
	 * 
	 * @return
	 */
	public static String pedirString() {
		return sc.next();

	}

	/**
	 * Metodo que retorna un entero pero no recibe nada
	 * 
	 * @return
	 */
	public static int pedirEntero() {
		int ent = sc.nextInt();
		sc.nextLine();
		return ent;
	}

	/**
	 * Metodo que retorna un double y no recibe nada
	 * 
	 * @return
	 */
	public static double pedirDouble() {
		double dou = sc.nextDouble();
		sc.nextLine();
		return dou;
	}

}
