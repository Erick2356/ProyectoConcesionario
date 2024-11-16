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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton btnGestionAutomoviles = new JButton("Gestionar Automóviles");
        JButton btnVentas = new JButton("Ventas");
        JButton btnClientesEmpleados = new JButton("Gestionar Clientes y Empleados");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnGestionAutomoviles);
        panel.add(btnVentas);
        panel.add(btnClientesEmpleados);
        panel.add(btnSalir);

        btnGestionAutomoviles.addActionListener(e -> openAutomovilesMenu());
        btnVentas.addActionListener(e -> openVentasMenu());
        btnClientesEmpleados.addActionListener(e -> openClientesEmpleadosMenu());
        btnSalir.addActionListener(e -> System.exit(0));

        add(panel);
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