package co.edu.konradlorenz.view;

import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner (System.in);

    public static int  mostrarMenu(){
        System.out.println("\n1 Agregar automovil \n2 Eliminar Automovil \n3 Actualizar automovil \n4 Mostrar automoviles \n5 Buscar automoviles por año \n6 Registrar venta \n7 Ingreso total ventas \n8 Salir");
        int opcion= sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    
    public static int pedirForma(){
        System.out.println("\n1 De Contado \n2 A Credito");
        return sc.nextInt();
       }

    public static int pedirTipoAutomovil(){
        System.out.println("\n1 Camioneta \n2 Electrico \n3 Motocicleta");
        int tipo= sc.nextInt();
        sc.nextLine();
        return tipo;

    }

    public static void  mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public static String pedirString(){
        return sc.nextLine();

    }

    public static int pedirEntero(){
        int ent = sc.nextInt();
        sc.nextLine();
        return ent;
    }

    public static double pedirDouble(){
        double dou = sc.nextDouble();
        sc.nextLine();
        return dou;
    }


}
