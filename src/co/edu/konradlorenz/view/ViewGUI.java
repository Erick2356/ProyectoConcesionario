package co.edu.konradlorenz.view;

import javax.swing.*;

import co.edu.konradlorenz.controller.Controller;

import java.awt.*;
import javax.swing.*;

/**
 * Clase ViewGui, es la clase principal de la parte de vista del programa, aqui
 * esta el menu principal que es con lo primero que tendra relacion el usuario,
 * esta clase hereda de la clase JFrame y tiene un objeto del tipo Controller,
 * para poder llamarlo y que realice toda la logica del programa
 */
public class ViewGUI extends JFrame {
	private final Controller controller;

	/**
	 * Constructor, (Recibe variable de tipo controller)
	 * 
	 * @param controller
	 */
	public ViewGUI(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	// Se inicializan los componentes relacionados con la interfaz grafica
	private void initComponents() {
		setTitle("Concesionario - Menú Principal");
		setSize(800, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Header Panel
		JPanel panelHeader = new JPanel(new BorderLayout());
		panelHeader.setBackground(new Color(30, 144, 255)); // Azul brillante
		JLabel titulo = new JLabel("Concesionaro Rev and Recharge", SwingConstants.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
		titulo.setForeground(Color.WHITE);
		panelHeader.add(titulo, BorderLayout.CENTER);

		// Logo
		JLabel l1 = new JLabel();
		l1.setSize(200, 100);
		ImageIcon logo = new ImageIcon("/ProyectoConcesionario/src/co/edu/konradlorenz/view/IMAGENES/LOGO.png");
		l1.setIcon(new ImageIcon(logo.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH)));
		panelHeader.add(l1, BorderLayout.WEST);

		// Main Menu Panel

		PanelConFondo panelMenu = new PanelConFondo("/co/edu/konradlorenz/view/IMAGENES/IMAGEN FONDO.jpg");
		panelMenu.setBackground(Color.DARK_GRAY);
		panelMenu.setLayout(new GridLayout(5, 1, 20, 20));
		panelMenu.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));

		JButton btnGestionAutomoviles = new JButton("Gestionar Automóviles");
		JButton btnVentas = new JButton("Ventas");
		JButton btnClientesEmpleados = new JButton("Gestionar Clientes y Empleados");
		JButton btnSalir = new JButton("Salir");

		customizeButton(btnGestionAutomoviles);
		customizeButton(btnVentas);
		customizeButton(btnClientesEmpleados);
		customizeButton(btnSalir);

		panelMenu.add(btnGestionAutomoviles);
		panelMenu.add(btnVentas);
		panelMenu.add(btnClientesEmpleados);
		panelMenu.add(btnSalir);

		btnGestionAutomoviles.addActionListener(e -> openAutomovilesMenu());
		btnVentas.addActionListener(e -> openVentasMenu());
		btnClientesEmpleados.addActionListener(e -> openClientesEmpleadosMenu());
		btnSalir.addActionListener(e -> System.exit(0));

		add(panelHeader, BorderLayout.NORTH);
		add(panelMenu, BorderLayout.CENTER);
	}

	// Estilo de los botones
	private void customizeButton(JButton button) {
		button.setFont(new Font("SansSerif", Font.PLAIN, 16));
		button.setBackground(Color.GRAY);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}

	/**
	 * Aqui todos los metodos encargados de llamar a las clases de view que tienen
	 * los otros menus
	 */
	private void openAutomovilesMenu() {
		new AutomovilesWindow(controller).setVisible(true);
	}

	private void openVentasMenu() {
		new VentasWindow(controller).setVisible(true);
	}

	private void openClientesEmpleadosMenu() {
		new ClientesEmpleadosWindow(controller).setVisible(true);
	}
}