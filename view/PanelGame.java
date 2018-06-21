package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import constant.Constant;
import controller.Controller;
import models.Player;
import models.Enemy;
import models.FitEat;
import models.Obstacule;

public class PanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player;
	private ArrayList<Obstacule> listObstacule;
	private int img;
	private int ancho = 80;
	private int anchoVillain = 200;
	private int alto = 90;
	private int altoVillain = 270;
	private ArrayList<FitEat> shoots;
	private ArrayList<FitEat> shootsVillains;
	private ArrayList<Enemy> listEnemy;

	public PanelGame(Player player, ArrayList<Obstacule> obstaculeList, ArrayList<FitEat> shoots, Controller controller,
			ArrayList<FitEat> shootsVillains, ArrayList<Enemy> enemyList) {
		this.player = player;
		this.listObstacule = obstaculeList;
		img = 5;
		this.listEnemy = enemyList;
		this.shootsVillains = shootsVillains;
		this.shoots = shoots;
		setDoubleBuffered(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent a) {
				controller.Shoot();

			}
		});
		addKeys(controller);

	}

	@SuppressWarnings("serial")
	public void addKeys(Controller controller) {
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		getInputMap().put(KeyStroke.getKeyStroke("D"), "RIGTH");
		getActionMap().put("RIGTH", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent a) {
				controller.moveRigth();
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke("S"), "DOWN");
		getActionMap().put("DOWN", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent a) {
				controller.moveUp();
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke("W"), "UP");
		getActionMap().put("UP", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent a) {
				controller.moveDown();
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke("A"), "LEFT");
		getActionMap().put("LEFT", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent a) {
				controller.moveLeft();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Constant.FONDO.getImage(), 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player.getVidas() > 0) {
			g.setFont(new Font("Tahoma", Font.BOLD, 46));
			g.setColor(new Color(20, 80, 200));
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);

			for (int i = 0; i < shoots.size(); i++) {
				g.drawImage(shoots.get(i).getImage(), shoots.get(i).getX(), shoots.get(i).getY(), this);
			}

			for (int i = 0; i < listObstacule.size(); i++) {

				g.drawImage(listObstacule.get(i).getImage(), listObstacule.get(i).getX(), listObstacule.get(i).getY(),
						this);
			}
			for (int i = 0; i < shootsVillains.size(); i++) {
				g.drawImage(shootsVillains.get(i).getImage(), shootsVillains.get(i).getX(),
						shootsVillains.get(i).getY(), this);
			}
			for (int i = 0; i < listEnemy.size(); i++) {
				g.drawImage(listEnemy.get(i).getImage(), listEnemy.get(i).getX(), listEnemy.get(i).getY(), this);
			}
		} else {
			g.setColor(new Color(200, 0, 0));
			g.fillRect(0, 0, 1400, 700);
			g.setFont(new Font("Tahoma", Font.BOLD, 52));
			g.setColor(new Color(255, 255, 255));
			g.drawString(" GAME OVER ", 490, 350);
		}

	}

	public int getImg() {
		return img;
	}

	public ArrayList<FitEat> getShoots() {
		return shoots;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setShoots(ArrayList<FitEat> shoots) {
		this.shoots = shoots;
	}

	public ArrayList<Obstacule> getVillain() {
		return listObstacule;
	}

	public ArrayList<Enemy> getUfos() {
		return listEnemy;
	}

	public void setUfos(ArrayList<Enemy> ufos) {
		this.listEnemy = ufos;
	}

	public ArrayList<FitEat> getShootsVillains() {
		return shootsVillains;
	}

	public void setShootsVillains(ArrayList<FitEat> shootsVillains) {
		this.shootsVillains = shootsVillains;
	}

	public void setVillain(ArrayList<Obstacule> villain) {
		this.listObstacule = villain;
	}

	public void setImg(int img) {
		this.img = img;
	}

}
