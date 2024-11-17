package co.edu.konradlorenz.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import co.edu.konradlorenz.controller.Controller;

/**
 * Clase que muestra la ventana en cuanto al menu de Automoviles, esta hereda de
 * JFrame, Implementando todas sus clases, Tiene el objeto controller
 */
public class AutomovilesWindow extends JFrame {
	private final Controller controller;

	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public AutomovilesWindow(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	/**
	 * metodo que no recibe ni retorna, este inicializa los componentes de la
	 * interfaz grafica
	 */
	private void initComponents() {
		// TITULO
		setTitle("Gestión de Automóviles");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		// PANELES
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(70, 130, 180)); // Azul acero
		JLabel titulo = new JLabel("Gestión de Automóviles", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		titulo.setForeground(Color.WHITE);
		panelHeader.add(titulo);

		// Logo
		JLabel l1 = new JLabel();
		l1.setSize(200, 100);
		ImageIcon logo = new ImageIcon("C:\\yo\\TECNICAS II\\LOGO.png");
		l1.setIcon(new ImageIcon(logo.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH)));
		panelHeader.add(l1, BorderLayout.WEST);
		// BOTONES
		PanelConFondo panelButtons = new PanelConFondo("/co/edu/konradlorenz/view/IMAGENES/IMAGEN FONDO AUTOMOVILES.jpg");
		panelButtons.setLayout(new GridLayout(3, 2, 20, 20));
		panelButtons.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panelButtons.setBackground(Color.WHITE);

		JButton btnAgregarAutomovil = createStyledButton("Agregar Automóvil");
		JButton btnEliminarAutomovil = createStyledButton("Eliminar Automóvil");
		JButton btnModificarAutomovil = createStyledButton("Modificar Automóvil");
		JButton btnMostrarAutomoviles = createStyledButton("Mostrar Automóviles");
		JButton btnBuscarAutomoviles = createStyledButton("Buscar Automóviles por Año");
		JButton btnSalir = createStyledButton("Salir");

		panelButtons.add(btnAgregarAutomovil);
		panelButtons.add(btnEliminarAutomovil);
		panelButtons.add(btnModificarAutomovil);
		panelButtons.add(btnMostrarAutomoviles);
		panelButtons.add(btnBuscarAutomoviles);
		panelButtons.add(btnSalir);

		btnAgregarAutomovil.addActionListener(e -> agregarAutomovil());
		btnEliminarAutomovil.addActionListener(e -> controller.eliminarAutomovil());
		btnModificarAutomovil.addActionListener(e -> controller.modificarAutomovil());
		btnMostrarAutomoviles.addActionListener(e -> controller.mostrarAutomovil());
		btnBuscarAutomoviles.addActionListener(e -> controller.buscarAutomovilAnio());
		btnSalir.addActionListener(e -> dispose());

		add(panelHeader, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
	}

	/**
	 * metodo que recibe y retorna, este se utiliza para el etilo de los botones
	 * 
	 * @param text
	 * @return
	 */
	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setFont(new Font("SansSerif", Font.BOLD, 14));
		button.setBackground(new Color(255, 215, 0)); // Oro
		button.setForeground(Color.DARK_GRAY);
		button.setFocusPainted(false);
		return button;
	}

	/**
	 * Este metodo no recibe ni retorna, se encarga de toda la parte visual en
	 * cuanto a agregar un automovil, sin embargo la logica esta en el controller
	 */
	private void agregarAutomovil() {
		JPanel tipoVehiculoPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // Tres botones en columna con espacio
		tipoVehiculoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JButton btnCamioneta = createStyledButton("Camioneta");
		JButton btnElectrico = createStyledButton("Eléctrico");
		JButton btnMotocicleta = createStyledButton("Moto");

		btnCamioneta.addActionListener(e -> controller.agregarAutomovil(1)); // Camioneta
		btnElectrico.addActionListener(e -> controller.agregarAutomovil(2)); // Vehículo Eléctrico
		btnMotocicleta.addActionListener(e -> controller.agregarAutomovil(3)); // Motocicleta

		tipoVehiculoPanel.add(btnCamioneta);
		tipoVehiculoPanel.add(btnElectrico);
		tipoVehiculoPanel.add(btnMotocicleta);

		JOptionPane.showMessageDialog(this, tipoVehiculoPanel, "Selecciona el tipo de automóvil",
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Metodo que se encargan de pedir diferentes variables, String, enteros,
	 * doubles y mostrar mensajes
	 * 
	 * @param mensaje
	 * @return
	 */
	public int pedirInt(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}

	public String pedirString(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

	public double pedirDouble(String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/**
	 * Metodo que no retorna pero si recibe dos parametros, estos son la lista de
	 * automoviles dentro de una estructura de datos ArrayList y un String
	 * 
	 * @param listaAutomoviles
	 * @param mensaje
	 */
	public void mostrarLista(ArrayList<String> listaAutomoviles, String mensaje) {
		JFrame frame = new JFrame(mensaje);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(this);

		String[] datos = listaAutomoviles.toArray(new String[0]);

		JList<String> lista = new JList<>(datos);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(lista);
		frame.add(scrollPane, BorderLayout.CENTER);

		frame.setVisible(true);
	}
}
