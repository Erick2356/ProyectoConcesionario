package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import co.edu.konradlorenz.controller.Controller;

/**
 * Clase del menu de gestion de ventas y todo lo relacionado.. esta hereda de la
 * clase JFrame y se crea un objeto de tipo controller
 */
public class VentasWindow extends JFrame {
	private final Controller controller;

	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public VentasWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	// Se inicializan los componentes relacionados con la interfaz grafica
	private void initComponents() {
		setTitle("Gestión de Ventas");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Header Panel
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(34, 139, 34)); // Verde bosque
		JLabel titulo = new JLabel("Gestión de Ventas", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		titulo.setForeground(Color.WHITE);
		panelHeader.add(titulo);

		// Buttons Panel
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(3, 2, 20, 20));
		panelButtons.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panelButtons.setBackground(Color.WHITE);

		JButton btnRegistrarVenta = createStyledButton("Registrar Venta");
		JButton btnMostrarVentas = createStyledButton("Mostrar Todas las Ventas");
		JButton btnIngresosTotales = createStyledButton("Calcular Ingresos Totales");
		JButton btnSalir = createStyledButton("Salir");

		panelButtons.add(btnRegistrarVenta);
		panelButtons.add(btnMostrarVentas);
		panelButtons.add(btnIngresosTotales);
		panelButtons.add(btnSalir);

		btnRegistrarVenta.addActionListener(e -> controller.registrarVenta());
		btnMostrarVentas.addActionListener(e -> controller.mostrarVentas());
		btnIngresosTotales.addActionListener(e -> controller.calcularIngresosTotales());
		btnSalir.addActionListener(e -> dispose());

		add(panelHeader, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
	}

	// Estilo de los botones
	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setFont(new Font("SansSerif", Font.BOLD, 14));
		button.setBackground(new Color(255, 69, 0)); // Rojo tomate
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		return button;
	}

	// Metodos pedir entero, String, Double y mostrar mensaje.
	public int pedirInt(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public String pedirString(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

	public double pedirDouble(String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}

}