package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.konradlorenz.controller.Controller;

public class AutomovilesWindow extends JFrame {
	private final Controller controller;

	public AutomovilesWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		setTitle("Gestión de Automóviles");
		setSize(400, 300);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));

		JButton btnAgregarAutomovil = new JButton("Agregar Automóvil");
		JButton btnEliminarAutomovil = new JButton("Eliminar Automóvil");
		JButton btnModificarAutomovil = new JButton("Modificar Automóvil");
		JButton btnMostrarAutomoviles = new JButton("Mostrar Automóviles");
		JButton btnBuscarAutomoviles = new JButton("Buscar Automóviles por Año");
		JButton btnSalir = new JButton("Salir");

		panel.add(btnAgregarAutomovil);
		panel.add(btnEliminarAutomovil);
		panel.add(btnModificarAutomovil);
		panel.add(btnMostrarAutomoviles);
		panel.add(btnBuscarAutomoviles);
		panel.add(btnSalir);

		btnAgregarAutomovil.addActionListener(e -> agregarAutomovil());
		btnEliminarAutomovil.addActionListener(e -> controller.eliminarAutomovil());
		btnModificarAutomovil.addActionListener(e -> controller.modificarAutomovil());
		btnMostrarAutomoviles.addActionListener(e -> controller.mostrarAutomovil());
		btnBuscarAutomoviles.addActionListener(e -> controller.buscarAutomovilAnio());
		btnSalir.addActionListener(e -> dispose());
		add(panel);
		
		
	}

	private void agregarAutomovil() {
		// Lógica para agregar automóvil en GUI (puedes invocar el método en Controller)
//		controller.agregarAutomovil();
		JPanel tipoVehiculoPanel = new JPanel();
	    tipoVehiculoPanel.setLayout(new GridLayout(3, 1)); // Tres botones en columna
        JButton btnCamioneta = new JButton("Camioneta");
		JButton btnElectrico = new JButton("Electrico");
		JButton btnMotocicleta = new JButton("Moto");
		 btnCamioneta.addActionListener(e -> controller.agregarAutomovil(1)); // Camioneta
	     btnElectrico.addActionListener(e -> controller.agregarAutomovil(2)); // Vehículo Eléctrico
	     btnMotocicleta.addActionListener(e -> controller.agregarAutomovil(3));
	     tipoVehiculoPanel.add(btnCamioneta);
	     tipoVehiculoPanel.add(btnElectrico);
	     tipoVehiculoPanel.add(btnMotocicleta);
	     JOptionPane.showMessageDialog(this, tipoVehiculoPanel, "Selecciona el tipo de automóvil", JOptionPane.PLAIN_MESSAGE);
	}

	public int pedirInt(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	public String pedirString(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public double pedirDouble(String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}
       
	public void mostrarLista(ArrayList<String> listaAutomoviles, String mensaje) {
	    // Crear un nuevo JFrame para la lista
	    JFrame frame = new JFrame(mensaje);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
	    frame.setSize(400, 300);
	    frame.setLocationRelativeTo(this);

	    // Obtener datos desde el controlador
	    String[] datos = listaAutomoviles.toArray(new String[0]);

	    // Crear la lista
	    JList<String> lista = new JList<>(datos);
	    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    // Agregar la lista a un JScrollPane
	    JScrollPane scrollPane = new JScrollPane(lista);

	    // Agregar el JScrollPane al frame
	    frame.add(scrollPane, BorderLayout.CENTER);

	    // Mostrar el frame
	    frame.setVisible(true);
	}
}