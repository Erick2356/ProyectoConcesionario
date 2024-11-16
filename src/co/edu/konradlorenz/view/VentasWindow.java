package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import co.edu.konradlorenz.controller.Controller;

public class VentasWindow extends JFrame {
	private final Controller controller;

	public VentasWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		setTitle("Gestión de Ventas");
		setSize(400, 300);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));

		JButton btnRegistrarVenta = new JButton("Registrar Venta");
		JButton btnEliminarVenta = new JButton("Eliminar Venta");
		JButton btnMostrarVentas = new JButton("Mostrar Todas las Ventas");
		JButton btnIngresosTotales = new JButton("Calcular Ingresos Totales");
		JButton btnSalir = new JButton("Salir");

		panel.add(btnRegistrarVenta);
		panel.add(btnEliminarVenta);
		panel.add(btnMostrarVentas);
		panel.add(btnIngresosTotales);
		panel.add(btnSalir);

		btnRegistrarVenta.addActionListener(e -> registrarVenta());
		btnEliminarVenta.addActionListener(e -> eliminarVenta());
		btnMostrarVentas.addActionListener(e -> mostrarVentas());
		btnIngresosTotales.addActionListener(e -> calcularIngresosTotales());
		btnSalir.addActionListener(e -> dispose());

		add(panel);
	}

	private void registrarVenta() {
		// Capturar información y registrar una venta
		String clienteId = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
		String automovilId = JOptionPane.showInputDialog(this, "Ingrese el ID del automóvil:");
		if (clienteId != null && automovilId != null) {
			controller.registrarVenta(clienteId, automovilId);
		}
	}

	private void eliminarVenta() {
		String ventaId = JOptionPane.showInputDialog(this, "Ingrese el ID de la venta a eliminar:");
		if (ventaId != null) {
			controller.eliminarAutomovilDeVenta(ventaId);
		}
	}

	private void mostrarVentas() {
		// Mostrar todas las ventas en un JOptionPane o nueva ventana
		String ventas = controller.mostrarVentas();
		JOptionPane.showMessageDialog(this, ventas, "Ventas Registradas", JOptionPane.INFORMATION_MESSAGE);
	}

	private void calcularIngresosTotales() {
		double ingresos = controller.calcularIngresosTotales();
		JOptionPane.showMessageDialog(this, "Ingresos Totales: $" + ingresos, "Ingresos Totales",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
