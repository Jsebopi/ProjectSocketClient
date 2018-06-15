package models;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public class Vegetables extends MyThread {

	private int x;
	private int y;
	private Color color;
	private int size;
	private Image image;
	private String direccion;

	public Vegetables(String name, Image image, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
		this.size = 80;
		this.image = image;
		this.direccion = "LEFT";
	}

	public Color getColor() {
		return color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}

	public void move() {

		if (direccion == "LEFT") {
			x -= 2;
			y -= 2;
		}
	}

	public int getY() {
		return y;
	}

	@Override
	void executeTask() {
		move();

	}

}
