package models;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public class Player {

	private int x;
	private int y;
	private Color color;
	private int size;
	private Image image;
	private String direccion;
	private int vidas;
	private int puntos;

	public Player(String name, int size, Image image, int x, int y, String direc, int vidas, int puntos) {

		this.x = x;
		this.y = y;
		this.size = size;
		this.image = image;
		this.vidas = vidas;
		this.puntos = puntos;
		this.direccion = direc;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
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
		return new Rectangle(x, y, 50, 60);
	}

	public void move() {
		if (direccion == "RIGTH") {
			x += 5;
		}
		if (direccion == "UP") {
			y -= 5;
		}
		if (direccion == "LEFT") {
			x -= 5;
		}
		if (direccion == "DOWN") {
			y += 5;
		}

	}

	public int getY() {
		return y;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
