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
	public static final String C_TOP_SCORE = "score";
	public static final String C_HELP = "ayuda";
	public static final String C_SALIR_TOP = "cerrar top";
	public static final String C_SALIR_HELP = "Salir Help";
	private Window_Game game;
	public Windows_Principal wp;
	private Window_Top_Score score;
	private Window_Help help;

	public Controller() {

		wp = new Windows_Principal(this);
		score = new Window_Top_Score(this);
		help = new Window_Help(this);
		game = new Window_Game(this, wp);
		wp.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case C_VIEW_CLIENTE:
			game.correr();
			this.terminando();
			if (game.getUsu() != "") {
				wp.setVisible(false);

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
			wp.dispose();
			game.cerrar();
			game.dispose();
			break;
		case C_TOP_SCORE:
			score.setVisible(true);
			wp.setVisible(false);
			break;
		case C_SALIR_TOP:
			score.setVisible(false);
			wp.setVisible(true);
			break;
		case C_SALIR_HELP:
			help.setVisible(false);
			wp.setVisible(true);
			break;
		case C_HELP:
			help.setVisible(true);
			wp.setVisible(false);
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
