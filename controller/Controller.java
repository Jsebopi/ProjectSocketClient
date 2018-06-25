package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Window_Game;
import view.Window_Help;
import view.Window_Top_Score;
import view.Windows_Principal;

public class Controller implements ActionListener {
	public static final String C_enviar_mensaje = "view";
	public static final String C_VIEW_CLIENTE = "ver";
	public static final String C_BORRAR = "borrar";
	public static final String C_SALIR = "Salir";
	public static final String C_TOP_CONNEC = "score";
	public static final String C_HELP = "ayuda";
	public static final String C_EXIT_CONNECT = "cerrar top";
	public static final String C_SALIR_HELP = "Salir Help";
	private Window_Game game;
	public Windows_Principal windowPrincipal;
	private Window_Top_Score connect;
	private Window_Help help;

	public Controller() {

		windowPrincipal = new Windows_Principal(this);
		connect = new Window_Top_Score(this);
		help = new Window_Help(this);
		game = new Window_Game(this, windowPrincipal);
		windowPrincipal.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case C_VIEW_CLIENTE:
			game.correr();
			this.terminando();
			if (game.getUsu() != "") {
				windowPrincipal.setVisible(false);

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						game.setVisible(true);

					}
				});

			}
			game.empezar();
			;

			break;
		case C_SALIR:
			windowPrincipal.dispose();
			game.cerrar();
			game.dispose();
			break;
		case C_TOP_CONNEC:
			connect.setVisible(true);
			windowPrincipal.setVisible(false);
			break;
		case C_EXIT_CONNECT:
			connect.setVisible(false);
			windowPrincipal.setVisible(true);
			break;
		case C_SALIR_HELP:
			help.setVisible(false);
			windowPrincipal.setVisible(true);
			break;
		case C_HELP:
			help.setVisible(true);
			windowPrincipal.setVisible(false);
			break;
		default:
			break;
		}
	}

	public void terminando() {
		Thread h = new Thread(game);
		h.start();
	}
}
