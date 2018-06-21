package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private String url;

	public PanelBackground(int w, int h, String url) {
		this.url = url;
		this.setSize(w, h);
	}

	public void paint(Graphics grafico) {
		Dimension height = getSize();
		ImageIcon Img = new ImageIcon(getClass().getResource(url));
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		setOpaque(false);
		super.paintComponents(grafico);
	}
}
