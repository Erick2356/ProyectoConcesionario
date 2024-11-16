package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		btnEliminarAutomovil.addActionListener(e -> eliminarAutomovil());
		btnModificarAutomovil.addActionListener(e -> modificarAutomovil());
		btnMostrarAutomoviles.addActionListener(e -> mostrarAutomoviles());
		btnBuscarAutomoviles.addActionListener(e -> buscarAutomoviles());
		btnSalir.addActionListener(e -> dispose());

		add(panel);
	}

	private void agregarAutomovil() {
		// Lógica para agregar automóvil en GUI (puedes invocar el método en Controller)
	}

	private void eliminarAutomovil() {
		// Lógica para eliminar automóvil en GUI
	}

	private void modificarAutomovil() {
		// Lógica para modificar automóvil en GUI
	}

	private void mostrarAutomoviles() {
		controller.mostrarAutomovil();
	}

	private void buscarAutomoviles() {
		// Lógica para buscar automóvil en GUI
	}
}