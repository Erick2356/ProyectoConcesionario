package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.View;

public class Controller {

    private Nodo cabeza;

    public void run() {
        boolean running = true;
        while (running) {
            int opcion = View.mostrarMenu();
            switch (opcion) {
                case 1:
                       agregarAutomovil();
                       break;
                case 2:
                       eliminarAutomovil();
                       break;
                case 3:


                case 4:
                       mostrarAutomovil();
                       break;
                case 5:


                       












            }
        }
    }

    public Controller(){
        this.cabeza = null;
    }

    public void agregarAutomovil(){
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
                   nAutomovil = new Camioneta(id,modelo,marca,motor,color,puertas,anio,precio,capacidad,tipo);
                   break;
            case 2:
                   View.mostrarMensaje("Ingrese autonomia");
                   int autonomia = View.pedirEntero();
                   View.mostrarMensaje("Ingrese tipo de bateria");
                   String tipoBateria = View.pedirString();
                   View.mostrarMensaje("Ingrese tiempo de carga");
                   int tiempoCarga = View.pedirEntero();
                   nAutomovil = new Electrico(id,modelo,marca,motor,color,puertas,anio,precio,autonomia,tipoBateria,tiempoCarga);
                   break;
            case 3:
                   View.mostrarMensaje("Ingrese cilindraje");
                   int cilindraje = View.pedirEntero();
                   View.mostrarMensaje("Ingrese tipo de motocicleta");
                   String tipoMotocicleta = View.pedirString();
                   nAutomovil = new Motocicleta(id,modelo,marca,motor,color,puertas,anio,precio,cilindraje,tipoMotocicleta);
                   break;

            default:
                   View.mostrarMensaje("Tipo de automovil invalido");
                break;
        }
        Nodo nuevoNodo= new Nodo(nAutomovil);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        }else{
            Nodo aux = cabeza;
            while (aux.getNext() != null) {
                aux = aux.getNext();

        }
        aux.setNext(nuevoNodo);
         
    }

    View.mostrarMensaje("Automovil agregado exitosamente");

}

public void mostrarAutomovil(){
    if (cabeza == null) {
        View.mostrarMensaje("No hay automoviles");
        }else{
            Nodo aux = cabeza;
            while (aux != null) {
                Automovil automovil = aux.getAutomovil();
                View.mostrarMensaje(automovil.toString());
                aux = aux.getNext();

            }
}
}

public void eliminarAutomovil(){
    if (cabeza == null) {
        View.mostrarMensaje("No hay automoviles");
        return;
    }
    View.mostrarMensaje("Ingrese id del automovil a eliminar");
    int idd = View.pedirEntero();
    if (cabeza.getAutomovil().getId()== idd) {
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
}