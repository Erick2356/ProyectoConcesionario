package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;
import co.edu.konradlorenz.controller.Controller;

/**
 * Clase del menu sobre la gestion de clientes y empleados, esta hereda de la
 * clase JFrame, y se crea el objeto controller
 */
public class ClientesEmpleadosWindow extends JFrame {
	private final Controller controller;

	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public ClientesEmpleadosWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	/**
	 * Se inicializan los componentes relacionados con la interfaz grafica
	 */
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

		// Logo
		JLabel l1 = new JLabel();
		l1.setSize(200, 100);
		ImageIcon logo = new ImageIcon("C:\\yo\\TECNICAS II\\LOGO.png");
		l1.setIcon(new ImageIcon(logo.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH)));
		panelHeader.add(l1, BorderLayout.WEST);

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

		panelButtons.add(btnAgregarCliente);
		panelButtons.add(btnEliminarCliente);
		panelButtons.add(btnMostrarClientes);
		panelButtons.add(btnAgregarEmpleado);
		panelButtons.add(btnEliminarEmpleado);
		panelButtons.add(btnSalir);

		btnAgregarCliente.addActionListener(e -> controller.agregarCliente());
		btnEliminarCliente.addActionListener(e -> controller.eliminarCliente());
		btnMostrarClientes.addActionListener(e -> controller.mostrarClientes());
		btnAgregarEmpleado.addActionListener(e -> controller.agregarEmpleado());
		btnEliminarEmpleado.addActionListener(e -> controller.eliminarEmpleado());
		btnSalir.addActionListener(e -> dispose());

		add(panelHeader, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
	}

	/**
	 * Clase que retorna y recibe variables, esta se encarga del estilo de los
	 * botones
	 * 
	 * @param text
	 * @return
	 */
	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setFont(new Font("SansSerif", Font.BOLD, 14));
		button.setBackground(new Color(100, 149, 237)); // Azul cielo
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		return button;
	}

	/**
	 * aqui los metodos que piden el entero, String, y muestran mensajes creando
	 * ventanas.
	 * 
	 * @param mensaje
	 * @return
	 */
	public int pedirInt(String mensaje) {

		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public String pedirString(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

}
