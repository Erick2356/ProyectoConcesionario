package co.edu.konradlorenz.view;

import javax.swing.*;

import co.edu.konradlorenz.controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		JPanel panel1 = new JPanel();

		panel1.setLayout(null);

		JLabel titulo = new JLabel("Proyecto Tecnicas II", SwingConstants.CENTER);
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 40));
		titulo.setBounds(-80, 40, 500, 150);

		panel1.add(titulo);

		JLabel l1 = new JLabel();
		l1.setSize(300, 200);

		ImageIcon logo = new ImageIcon("Media/Trabajador.png");

		Icon imagen = new ImageIcon(
				logo.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_DEFAULT));

		l1.setIcon(imagen);

		l1.setBounds(350, 10, l1.getWidth(), l1.getHeight());

		panel1.add(l1);

		panel1.setBackground(Color.white);

		panel1.setBounds(50, 10, 700, 200);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		panel2.setBackground(Color.black);

		JButton btnGestionAutomoviles = new JButton("Gestionar Automóviles");

		btnGestionAutomoviles.setBackground(Color.white);
		btnGestionAutomoviles.setBounds(245, 100, 200, 40);

		JButton btnVentas = new JButton("Ventas");

		btnVentas.setBackground(Color.white);
		btnVentas.setBounds(290, 170, 100, 40);
		JButton btnClientesEmpleados = new JButton("Gestionar Clientes y Empleados");

		btnClientesEmpleados.setBackground(Color.white);
		btnClientesEmpleados.setBounds(200, 240, 300, 40);

		JButton btnSalir = new JButton("Salir");

		btnSalir.setBackground(Color.white);

		btnSalir.setBounds(300, 310, 80, 40);

		btnSalir.setToolTipText("Salir del programa");

		panel2.add(btnGestionAutomoviles);
		panel2.add(btnVentas);
		panel2.add(btnClientesEmpleados);
		panel2.add(btnSalir);

		btnGestionAutomoviles.addActionListener(e -> openAutomovilesMenu());
		btnVentas.addActionListener(e -> openVentasMenu());
		btnClientesEmpleados.addActionListener(e -> openClientesEmpleadosMenu());
		btnSalir.addActionListener(e -> System.exit(0));

		panel2.setBounds(50, 250, 700, 500);

		JPanel panel3 = new JPanel();

		panel3.setBackground(Color.white);

		add(panel1);
		add(panel2);
		add(panel3);
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