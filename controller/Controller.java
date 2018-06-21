package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import constant.Constant;
import models.FitEat;
import models.ManagePlayers;
import view.JDStart;
import view.WindowsGame;

public class Controller implements ActionListener {
	private JDStart start;
	private ManagePlayers manage;
	private WindowsGame game;
	private Timer timer;

	public Controller() {
		manage = new ManagePlayers();
		game = new WindowsGame(manage.getPlayer(), this, manage.getVillains(), manage.getShoots(),
				manage.getShootsVillains(), manage.getCows(), manage.getUfo(), manage.getEnemy());
		start = new JDStart(this);
		start.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case Constant.EXIT:
			start.dispose();
			break;
		case Constant.CONN:
			if (start.getText() == true) {
				start.dislBtn();
			} else {
				JOptionPane.showMessageDialog(null, "Diligencia todos los recuadros de texto!");
			}
			break;
		case Constant.START:
			start.setVisible(false);
			game.setLife(String.valueOf(100));
			game.setPunt(String.valueOf(0));
			game.setUser(start.getName());
			game.history(this);
			ShootVillains();
			playGame();

			break;

		}

	}

	public FitEat Shoot() {
		FitEat shoot = new FitEat(40, Constant.SHOOT.getImage(), manage.getPlayer().getX() + 22,
				manage.getPlayer().getY() + 22, "UP");
		manage.addShoot(shoot);
		return shoot;
	}

	public void moveDown() {

		manage.changeDirection("UP");
		manage.getPlayer().move();
	}

	public void moveUp() {

		manage.changeDirection("DOWN");
		manage.getPlayer().move();
	}

	public void moveLeft() {
		manage.changeDirection("LEFT");
		manage.getPlayer().move();
	}

	public void moveRigth() {
		manage.changeDirection("RIGTH");
		manage.getPlayer().move();
	}

	public void playGame() {
		game.play(this);
		actualizar();
		game.start();
		manage.create();
		manage.changes();
		game.repaint();
	}

	private void actualizar() {
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				game.getPanelGame().setVillain(manage.getVillains());
				game.getPanelGame().setShoots(manage.getShoots());
				game.getPanelGame().setPlayer(manage.getPlayer());
				game.getPanelGame().setShootsVillains(manage.getShootsVillains());
				game.getPanelGame().setUfos(manage.getEnemy());
				game.setLife(""+manage.getPlayer().getPuntos());
				if (manage.getPlayer().getVidas() == 0) {
					timer.stop();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					game.dispose();
					newGame();
				}
			}
		});
		timer.start();

	}

	public void newGame() {
		manage = new ManagePlayers();
		game = new WindowsGame(manage.getPlayer(), this, manage.getVillains(), manage.getShoots(),
				manage.getShootsVillains(), manage.getCows(), manage.getUfo(), manage.getEnemy());
	}

	public void ShootVillains() {

		Thread shoots = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < manage.getVillains().size(); i++) {
						FitEat shoot = new FitEat(40, Constant.SHOOT2.getImage(),
								manage.getVillains().get(i).getX() + 80, manage.getVillains().get(i).getY() + 160,
								"DOWN");
						manage.addShootVillains(shoot);
						game.getPanelGame().setShootsVillains(manage.getShootsVillains());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			}
		});
		shoots.start();
	}

}
