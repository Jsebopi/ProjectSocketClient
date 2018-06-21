package model;

import java.awt.Color;
import java.util.Random;
public class PaletteColor extends CircleSimpleList<Color> {

	private static final int MAX_GENERATE = 15;
	private Random random;
	private static PaletteColor paletteColor = null;

	// con patron singleton se debe tener un constructor privado
	public PaletteColor() {
		random = new Random();
	}

	public static PaletteColor getInstancePalett() {
		if (paletteColor == null) {
			paletteColor = new PaletteColor();
		}
		return paletteColor;
	}


	public Color randomColor() {
		return this.getPosition(random.nextInt(MAX_GENERATE)).getInfo();
	}

}
