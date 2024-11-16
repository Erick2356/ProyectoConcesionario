package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import co.edu.konradlorenz.controller.Controller;

public class ClientesEmpleadosWindow extends JFrame {
	private final Controller controller;

	public ClientesEmpleadosWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		setTitle("Gestión de Clientes y Empleados");
		setSize(400, 300);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));

		JButton btnAgregarCliente = new JButton("Agregar Cliente");
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		JButton btnMostrarClientes = new JButton("Mostrar Clientes");
		JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
		JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
		JButton btnSalir = new JButton("Salir");

		panel.add(btnAgregarCliente);
		panel.add(btnEliminarCliente);
		panel.add(btnMostrarClientes);
		panel.add(btnAgregarEmpleado);
		panel.add(btnEliminarEmpleado);
		panel.add(btnSalir);

		btnAgregarCliente.addActionListener(e -> agregarCliente());
		btnEliminarCliente.addActionListener(e -> eliminarCliente());
		btnMostrarClientes.addActionListener(e -> mostrarClientes());
		btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());
		btnEliminarEmpleado.addActionListener(e -> eliminarEmpleado());
		btnSalir.addActionListener(e -> dispose());

		add(panel);
	}

	private void agregarCliente() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
		if (nombre != null && id != null) {
			controller.agregarCliente(id, nombre);
		}
	}

	private void eliminarCliente() {
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente a eliminar:");
		if (id != null) {
			controller.eliminarCliente(id);
		}
	}

	private void mostrarClientes() {
		String clientes = controller.mostrarClientes();
		JOptionPane.showMessageDialog(this, clientes, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
	}

	private void agregarEmpleado() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del empleado:");
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado:");
		if (nombre != null && id != null) {
			controller.agregarEmpleado(id, nombre);
		}
	}

	private void eliminarEmpleado() {
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:");
		if (id != null) {
			controller.eliminarEmpleado(id);
		}
	}
}
