package co.edu.konradlorenz.view;

import javax.swing.*;

import co.edu.konradlorenz.controller.Controller;

import java.awt.*;
import javax.swing.*;

public class ViewGUI extends JFrame {
	private final Controller controller;

	public ViewGUI(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		setTitle("Concesionario - Menú Principal");
		setSize(800, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Header Panel
		JPanel panelHeader = new JPanel(new BorderLayout());
		panelHeader.setBackground(new Color(30, 144, 255)); // Azul brillante
		JLabel titulo = new JLabel("Proyecto Técnicas II", SwingConstants.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
		titulo.setForeground(Color.WHITE);
		panelHeader.add(titulo, BorderLayout.CENTER);

		// Logo
		JLabel l1 = new JLabel();
		l1.setSize(200, 100);
		ImageIcon logo = new ImageIcon("Media/Trabajador.png");
		l1.setIcon(new ImageIcon(logo.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH)));
		panelHeader.add(l1, BorderLayout.WEST);

		// Main Menu Panel
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
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

	private void customizeButton(JButton button) {
		button.setFont(new Font("SansSerif", Font.PLAIN, 16));
		button.setBackground(new Color(255, 165, 0)); // Naranja
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(new Color(255, 140, 0), 2));
	}

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
