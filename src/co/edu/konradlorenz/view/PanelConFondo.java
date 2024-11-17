package co.edu.konradlorenz.view;

import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {
	private ImageIcon fondo;

	public PanelConFondo(String rutaImagen) {
		fondo = new ImageIcon(rutaImagen);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
}