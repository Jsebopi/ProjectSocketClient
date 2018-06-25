package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Court {
	private int x;
	private int y;
	private int width;
	private int heigth;

	public Court(int x, int y, int width, int heigth) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, heigth);
	}

	public void pintarArco(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, heigth);
	}

}
