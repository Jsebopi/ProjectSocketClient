package models;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public class Obstacule extends MyThread {

	private int x;
	private int y;
	private Color color;
	private int size;
	private Image image;
	private String direccion;
	private int sprite;
	private boolean change;

	public Obstacule(String name, int size, Image image, int x, int y, String direc) {
		super(name);
		this.x = x;
		this.y = y;
		this.size = size;
		this.image = image;
		this.direccion = direc;
		sprite = 0;
		start();
	}

	public int getSprite() {
		return sprite;
	}

	public void setSprite(int sprite) {
		this.sprite = sprite;
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

	@Override
	void executeTask() {
		move();
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

	public void move() {

		if (change) {
			if (direccion == "RIGTH") {
				x++;
			}
			if (direccion == "UP") {
				y--;
			}
			if (Calculate.calculo(x, 10)) {
				sprite++;
			}
		} else {
			if (direccion == "RIGTH") {
				x++;
			}
			if (direccion == "UP") {
				y--;
			}
			if (Calculate.calculo(x, 10)) {
				sprite--;
			}
		}
		if (sprite == 11) {
			change = false;
			sprite--;
		} else if (sprite == 0) {
			change = true;
		}

	}

	public int getY() {
		return y;
	}

	public String getDireccion() {
		return direccion;
	}

	public Rectangle getRect() {
		System.out.println();
		return new Rectangle(x, y, 80, 240);
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
