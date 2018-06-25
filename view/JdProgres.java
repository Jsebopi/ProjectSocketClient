package view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JdProgres extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private JProgressBar bar;
	private int aux = 120;

	public int getAux() {
		return aux;
	}

	public void setAux(int aux) {
		this.aux = aux;
	}

	public JdProgres() {
		bar = new JProgressBar(0, 120);
		bar.setForeground(Color.green);
		this.add(bar);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 120; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bar.setValue(aux);
			aux = aux - 1;
			System.out.println(aux);
		}
	}

}
