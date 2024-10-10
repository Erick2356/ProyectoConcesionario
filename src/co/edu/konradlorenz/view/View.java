package co.edu.konradlorenz.view;

import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner (System.in);

    public static int  mostrarMenu(){
        System.out.println("\n1 Agregar automovil \n2 Eliminar Automovil \n3 Actualizar automovil \n4 Mostrar automoviles \n5 Buscar automoviles por año \n6 Registrar venta \n7 Ingreso total ventas");
        int opcion= sc.nextInt();
        sc.nextLine();
        return opcion;
    }
}
