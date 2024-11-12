package co.edu.konradlorenz.view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Display extends JFrame {
	JFrame d;

	public Display() {
		d = new JFrame();
		d.setVisible(true);
		d.setBounds(0, 0, 400, 400);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setTitle("Concesionario");

		d.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Foco activo");

			}

			@Override
			public void focusLost(FocusEvent e) {
				d.requestFocus();

			}
		});
		d.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Se movio el mouse");

			}
		});
	}

}
