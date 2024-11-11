package co.edu.konradlorenz.view;

import java.util.Scanner;

public class View {
	static Scanner sc = new Scanner(System.in);

	public static byte mostrarMenu() {
		System.out.println(
				"\n1 Gestionar Automoviles " + "\n2 Ventas " + "\n3 Gestionar clientes y empleados" + "\n4.Salir");
		byte opcion = sc.nextByte();
		sc.nextLine();
		return opcion;
	}

	public static byte mostrarMenuGestionAutomoviles() {
		System.out.println("\n1 Agregar automovil " + "\n2 Eliminar Automovil " + "\n3 Modificar automovil "
				+ "\n4 Mostrar automoviles " + "\n5 Buscar automoviles por año ");
		byte opcion2 = sc.nextByte();
		return opcion2;
	}

	public static byte mostrarMenuVentas() {
		System.out.println("\n1 Registrar venta " + "\n2 Ingreso total ventas ");
		byte opcion3 = sc.nextByte();
		return opcion3;
	}

	public static byte mostrarMenuClientesEmpleados() {
		System.out.println(
				"\n1 Agregar Empleado " + "\n2 Agregar Cliente " + "\n3 Mostrar Clientes " + "\n4 Mostrar Empleados ");
		byte opcion4 = sc.nextByte();
		return opcion4;
	}

	public static int pedirForma() {
		System.out.println("\n1 De Contado \n2 A Credito");
		return sc.nextInt();
	}

	public static int pedirTipoAutomovil() {
		System.out.println("\n1 Camioneta \n2 Electrico \n3 Motocicleta");
		int tipo = sc.nextInt();
		sc.nextLine();
		return tipo;

	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static String pedirString() {
		return sc.nextLine();

	}

	public static int pedirEntero() {
		int ent = sc.nextInt();
		sc.nextLine();
		return ent;
	}

	public static double pedirDouble() {
		double dou = sc.nextDouble();
		sc.nextLine();
		return dou;
	}

}
