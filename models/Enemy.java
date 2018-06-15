package models;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public class Enemy extends MyThread {

	private int x;
	private int y;
	private Color color;
	private int size;
	private Image image;
	private String direccion;
	private String name;

	public Enemy(String name, Image image, int x, int y, String direccion) {
		super(name);
		this.name = name;
		this.x = x;
		this.y = y;
		this.size = 80;
		this.image = image;
		this.direccion = direccion;
		start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return new Rectangle(x, y, 256, 256);
	}

	public void move() {
		if (direccion == "RIGTH") {
			x += 2;
			y += 2;
		}
		if(y>320) {
			direccion="LEfT";
		}
		if (direccion == "LEfT") {
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
