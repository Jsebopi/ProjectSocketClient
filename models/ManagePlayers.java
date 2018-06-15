package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import constant.Constant;

public class ManagePlayers {
	private Player player;
	private ArrayList<Obstacule> obstacule;
	public ArrayList<FitEat> fitFat;
	public ArrayList<FitEat> obstaculeFitEat;
	public ArrayList<Vegetables> vegetable;
	private Enemy enemy;
	private ArrayList<Enemy> listEnemy;
	private Timer timer;
	private int golpes = 0;
	private int batallon = 1;

	public ManagePlayers() {
		obstacule = new ArrayList<>();
		fitFat = new ArrayList<>();
		vegetable = new ArrayList<>();
		listEnemy = new ArrayList<>();
		obstaculeFitEat = new ArrayList<>();
		player = new Player("jugador 1", 80, Constant.FARMER.getImage(), 1200, 590, "STOP", 3, 0);
		enemy = new Enemy("OVNI", Constant.UFO.getImage(), -900, -900, "RIGTH");
		createVegetable();
		moveCow();
		createVillain();
	}

	public void createVegetable() {
		;
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 80, 540));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 350, 540));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 580, 540));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 750, 540));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 60, 440));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 380, 440));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 580, 440));
		vegetable.add(new Vegetables("", Constant.COW.getImage(), 750, 440));
	}

	public void moveCow() {
		vegetable.get(5).start();
		vegetable.get(5).pause();
	}

	public void changes() {
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (enemy.getY() > 310) {
					vegetable.get(5).resume();
				}
				checkCollision();
				checkCollision2();
				checkCollisionHero();
			}
		});
		timer.start();

	}

	public void createVillain() {
		Obstacule villain = new Obstacule("BATALLON " + batallon, 80, Constant.MARCIANO.getImage(), -randomY(),
				randomY(), "RIGTH");
		obstacule.add(villain);
		Obstacule villain2 = new Obstacule("BATALLON " + batallon, 80, Constant.MARCIANO.getImage(), -randomY(),
				randomY(), "RIGTH");
		obstacule.add(villain2);
		Obstacule villain3 = new Obstacule("BATALLON " + batallon, 80, Constant.MARCIANO.getImage(), -randomY(),
				randomY(), "RIGTH");
		obstacule.add(villain3);
		Enemy ufo = new Enemy("BATALLON " + batallon, Constant.UFO.getImage(), -randomY(), randomY(), "RIGTH");
		listEnemy.add(ufo);
		batallon++;
	}

	public ArrayList<Enemy> getUfos() {
		return listEnemy;
	}

	public void setUfos(ArrayList<Enemy> ufos) {
		this.listEnemy = ufos;
	}

	public void create() {
		timer = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createVillain();
			}
		});
		timer.start();

	}

	public int randomX() {
		int numero = (int) (Math.random() * 1200) + 1;
		return numero;
	}

	public int randomY() {
		int numero = (int) (Math.random() * 500) + 1;
		return numero;
	}

	public int random() {
		int numero = (int) (Math.random() * 500) + 1;
		return numero;
	}

	public ArrayList<Obstacule> getVillains() {
		return obstacule;
	}

	public void checkCollision() {
		for (int i = 0; i < fitFat.size(); i++) {
			for (int j = 0; j < obstacule.size(); j++) {
				if (fitFat.get(i).getRect().intersects(obstacule.get(j).getRect())) {
					fitFat.get(i).stop();
					fitFat.remove(i);
					obstacule.get(j).stop();
					obstacule.remove(j);
				}
			}
		}
	}

	public void checkCollision2() {
		for (int i = 0; i < listEnemy.size(); i++) {
			if (listEnemy.get(i).getRect().intersects(player.getRect())) {
				listEnemy.get(i).stop();
				listEnemy.remove(i);
				player.setVidas(player.getVidas() - 1);

				break;

			}
		}
		for (int i = 0; i < fitFat.size(); i++) {
			for (int j = 0; j < listEnemy.size(); j++) {
				if (fitFat.get(i).getRect().intersects(listEnemy.get(j).getRect())) {
					fitFat.get(i).stop();
					fitFat.remove(i);
					listEnemy.get(j).stop();
					listEnemy.remove(j);
				}
			}
		}
	}

	public void checkCollisionHero() {
		for (int i = 0; i < obstaculeFitEat.size(); i++) {
			if (obstaculeFitEat.get(i).getRect().intersects(player.getRect())) {
				obstaculeFitEat.get(i).stop();
				obstaculeFitEat.remove(i);
				golpes++;
				if (golpes == 5) {
					player.setVidas(player.getVidas() - 1);
					golpes = 0;
				}
			}
		}
	}

	public void addVillain(Obstacule villain) {
		obstacule.add(villain);
	}

	public void addShoot(FitEat shoot) {
		fitFat.add(shoot);
	}

	public ArrayList<Vegetables> getCows() {
		return vegetable;
	}

	public void setCows(ArrayList<Vegetables> cows) {
		this.vegetable = cows;
	}

	public void addShootVillains(FitEat shoot) {
		obstaculeFitEat.add(shoot);
	}

	public Enemy getUfo() {
		return enemy;
	}

	public void setUfo(Enemy ufo) {
		this.enemy = ufo;
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<FitEat> getShootsVillains() {
		return obstaculeFitEat;
	}

	public ArrayList<FitEat> getShoots() {
		return fitFat;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void changeDirection(String aux) {
		player.setDireccion(aux);
	}

}
