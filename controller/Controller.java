package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import constants.Constants;
import view.JDConnect;
import view.Window_Game;
import view.Window_Help;
import view.Windows_Principal;

public class Controller implements ActionListener {
	private Window_Game game;
	public Windows_Principal windowPrincipal;
	private Window_Help help;
	private JDConnect connect;

	public Controller() {
		connect = new JDConnect(this);
		windowPrincipal = new Windows_Principal(this);
		help = new Window_Help(this);
		connect.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.C_VIEW_CLIENTE:
			game.correr();
			this.terminando();
			if (game.getUsu() != "") {
				windowPrincipal.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						game.setVisible(true);

					}
				});
				game.empezar();
			}
			break;
		case Constants.C_SALIR:
			windowPrincipal.dispose();
			game.cerrar();
			game.dispose();
			break;
		case Constants.C_SALIR_HELP:
			help.setVisible(false);
			windowPrincipal.setVisible(true);
			break;
		case Constants.C_HELP:
			help.setVisible(true);
			windowPrincipal.setVisible(false);
			break;

		case Constants.C_TOP_CONNEC:
			connect.setVisible(false);
			game = new Window_Game(this, windowPrincipal, connect.getIP_Puerto_Nombre());
			game.setUsu(connect.getUser());
			windowPrincipal.setUser(connect.getUser());
			windowPrincipal.setVisible(true);
			break;

		case Constants.C_EXIT_CONNECT:
			connect.dispose();
			break;

		}
	}

	public void terminando() {
		Thread h = new Thread(game);
		h.start();
	}
}
