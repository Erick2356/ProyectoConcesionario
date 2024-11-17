package co.edu.konradlorenz.controller;

/**
 * Clase main, contiene el metodo main en donde se inicializa el objeto
 * controller, el objeto mainWindow y se llama al metodo setVisible para comenzar la interfaz grafica
 */
import co.edu.konradlorenz.view.ViewGUI;

public class AplMain {
	public static void main(String[] args) {
		Controller controller = new Controller();
		ViewGUI mainWindow = new ViewGUI(controller);
		mainWindow.setVisible(true);
	}
}