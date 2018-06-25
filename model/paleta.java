package model;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class paleta extends Sprite implements comun {

	String paddle = "src/img/obstacule.png";

	public String getPaddle() {
		return paddle;
	}

	public void setPaddle(String paddle) {
		this.paddle = paddle;
	}

	int dx = 0;
	private int dy = 0;

	public paleta() {

		ImageIcon ii = new ImageIcon(paddle);
		image = ii.getImage();

		width = image.getWidth(null);
		heigth = image.getHeight(null);

		resetState();
	}

	public void move() {
		x += dx;
		y += dy;
		if (x <= 70) {
			x = 70;
		}
		if (x >= 350) {
			x = 350;
		}
		if (y <= 50) {
			y = 50;
		}
		if (y >= 525) {
			y = 525;
		}

	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dx = -10;
		}

		if (key == KeyEvent.VK_D) {
			dx = 10;
		}
		if (key == KeyEvent.VK_S) {
			dy = 10;
		}

		if (key == KeyEvent.VK_W) {
			dy = -10;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dx = 0;
		}

		if (key == KeyEvent.VK_D) {
			dx = 0;
		}

		if (key == KeyEvent.VK_W) {
			dy = 0;
		}

		if (key == KeyEvent.VK_S) {
			dy = 0;
		}
	}

	public void resetState() {
		x = 120;
		y = 280;
	}
}
