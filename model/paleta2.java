package model;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class paleta2 extends Sprite implements comun {

	String paddle = "src/img/shot.png";

	public String getPaddle() {
		return paddle;
	}

	public void setPaddle(String paddle) {
		this.paddle = paddle;
	}

	int dx = 0;
	private int dy = 0;

	public paleta2() {

		ImageIcon ii = new ImageIcon(paddle);
		image = ii.getImage();

		width = image.getWidth(null);
		heigth = image.getHeight(null);

		resetState();
	}

	public void move() {
		x += dx;
		y += dy;
		if (x <= 380) {
			x = 380;
		}
		if (x >= 690) {
			x = 690;
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

		if (key == KeyEvent.VK_J) {
			dx = -15;
		}

		if (key == KeyEvent.VK_L) {
			dx = 15;
		}
		if (key == KeyEvent.VK_K) {
			dy = 15;
		}

		if (key == KeyEvent.VK_I) {
			dy = -15;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_J) {
			dx = 0;
		}

		if (key == KeyEvent.VK_L) {
			dx = 0;
		}

		if (key == KeyEvent.VK_I) {
			dy = 0;
		}

		if (key == KeyEvent.VK_K) {
			dy = 0;
		}
	}

	public void resetState() {
		x = 610;
		y = 280;
	}
}
