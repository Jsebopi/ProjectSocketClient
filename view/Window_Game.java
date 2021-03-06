package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import view.VentanaC;

public class Window_Game extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	public String usu = "";
	private VentanaC ventana;
	private Windows_Principal wp;
	private boolean timer;

	public Window_Game(Controller c, Windows_Principal wp, String[] user) {
		setTitle("Soccer Hot dog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		Image image = Toolkit.getDefaultToolkit().getImage("src/img/icon.png");
		setIconImage(image);
		setIgnoreRepaint(true);
		setResizable(false);
		ventana = new VentanaC(c, user);
		add(ventana);
		timer = true;
		this.wp = wp;
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}

			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.cerrar();
	}

	public void cerrar() {
		ventana.confirmardesconexion();
	}

	public void correr() {
		Thread hilo = new Thread(ventana);
		hilo.start();
	}

	public void empezar() {
		ventana.initCont();
	}

	public String getUsu() {
		return usu;
	}

	public void setUsu(String user) {
		this.usu = user;
		ventana.setUsuario(usu);
	}

	@Override
	public void run() {
		while (timer) {
			if (ventana.getTime() == 0 && ventana.getPoint() > ventana.getPoint2()) {
				JOptionPane.showMessageDialog(null, "Fin del Juego , Gano HamburguerFc");
				this.dispose();
				timer = false;
				wp.setVisible(true);
			} else if (ventana.getTime() == 0 && ventana.getPoint2() > ventana.getPoint()) {
				JOptionPane.showMessageDialog(null, "Fin del Juego, Gano Jugador 2");
				timer = false;
				this.dispose();
				wp.setVisible(true);
			} else if (ventana.getTime() == 0 && ventana.getPoint2() == ventana.getPoint()) {
				JOptionPane.showMessageDialog(null, "El juego a terminado, EMPATE");
				this.dispose();
				timer = false;
				wp.setVisible(true);
			}

		}

	}
}