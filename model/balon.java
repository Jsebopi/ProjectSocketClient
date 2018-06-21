package model;

import javax.swing.ImageIcon;

public class balon extends Sprite implements comun {

	private int xdir;
	private int ydir;

	public balon() {

		xdir = 10;
		ydir = -10;

		ImageIcon ii = new ImageIcon("img/shot.png");
		image = ii.getImage();

		width = image.getWidth(null);
		heigth = image.getHeight(null);

		resetState();
	}

	public void move() {
		x += xdir;
		y += ydir;

		if (x <= 70) {
			setXDir(1);
		}

		if (x >= BALL_RIGHT) {
			setXDir(-1);
		}

		if (y <= 60) {
			setYDir(1);
		}
		if (y >= 580) {
			setYDir(-1);
		}
	}

	public void resetState() {

		x = 230;
		y = 280;
	}

	public void setXDir(int x) {
		xdir = x;
	}

	public void setYDir(int y) {
		ydir = y;
	}

	public int getYDir() {
		return ydir;
	}
}