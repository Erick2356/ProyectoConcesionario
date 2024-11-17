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
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(70, 130, 180)); // Azul acero
        JLabel titulo = new JLabel("Gestión de Clientes y Empleados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        panelHeader.add(titulo);

        // Buttons Panel
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(3, 2, 20, 20));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelButtons.setBackground(Color.WHITE);

        JButton btnAgregarCliente = createStyledButton("Agregar Cliente");
        JButton btnEliminarCliente = createStyledButton("Eliminar Cliente");
        JButton btnMostrarClientes = createStyledButton("Mostrar Clientes");
        JButton btnAgregarEmpleado = createStyledButton("Agregar Empleado");
        JButton btnEliminarEmpleado = createStyledButton("Eliminar Empleado");
        JButton btnSalir = createStyledButton("Salir");

<<<<<<< Updated upstream
        panelButtons.add(btnAgregarCliente);
        panelButtons.add(btnEliminarCliente);
        panelButtons.add(btnMostrarClientes);
        panelButtons.add(btnAgregarEmpleado);
        panelButtons.add(btnEliminarEmpleado);
        panelButtons.add(btnSalir);

        btnAgregarCliente.addActionListener(e -> agregarCliente());
        btnEliminarCliente.addActionListener(e -> eliminarCliente());
        btnMostrarClientes.addActionListener(e -> mostrarClientes());
        btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());
        btnEliminarEmpleado.addActionListener(e -> eliminarEmpleado());
        btnSalir.addActionListener(e -> dispose());

        add(panelHeader, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
    }
=======
		btnAgregarCliente.addActionListener(e -> controller.agregarCliente());
		btnEliminarCliente.addActionListener(e -> controller.eliminarCliente());
		btnMostrarClientes.addActionListener(e -> controller.mostrarClientes());
		btnAgregarEmpleado.addActionListener(e -> controller.agregarEmpleado());
		btnEliminarEmpleado.addActionListener(e -> controller.eliminarEmpleado());
		btnSalir.addActionListener(e -> dispose());
		panel.setBackground(Color.black);

		add(panel);
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
	
/**
	private void agregarCliente() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
		if (nombre != null && id != null) {
			controller.agregarCliente(id, nombre);
		}
	}
>>>>>>> Stashed changes

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(100, 149, 237)); // Azul cielo
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
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

<<<<<<< Updated upstream
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
=======
	private void eliminarEmpleado() {
		String id = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:");
		if (id != null) {
			controller.eliminarEmpleado(id);
		}
	}
	*/
}
>>>>>>> Stashed changes
