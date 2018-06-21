package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import constant.Constant;
import controller.Controller;

public class PanelStart extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton start;
	private JButton options;
	private JButton exit;

	public PanelStart(Controller controller) {
		setLayout(new GridLayout(3, 1));

		start = new JButton("Play");
		start.setBackground(Constant.AZUL_CLARO);
		start.setForeground(Constant.BLANCO);
		start.setFont(new Font("Comic Sans", Font.BOLD, 30));
		start.setIcon(new ImageIcon("src/img/start.png"));
		start.setActionCommand(Constant.START);
		start.addActionListener(controller);
		start.setEnabled(false);

		options = new JButton("Options");
		options.setBackground(Constant.AZUL_CLARO);
		options.setForeground(Constant.BLANCO);
		options.setFont(new Font("Comic Sans", Font.BOLD, 30));
		options.setIcon(new ImageIcon("src/img/options.png"));
		options.setActionCommand(Constant.EXIT);
		options.addActionListener(controller);
		options.setEnabled(false);

		exit = new JButton("Exit");
		exit.setBackground(Constant.AZUL_CLARO);
		exit.setForeground(Constant.BLANCO);
		exit.setActionCommand(Constant.EXIT);
		exit.setIcon(new ImageIcon("src/img/exit.png"));
		exit.addActionListener(controller);
		exit.setFont(new Font("Comic Sans", Font.BOLD, 30));

		add(start);
		add(options);
		add(exit);
	}

	public void dislBtn() {
		start.setEnabled(true);
		options.setEnabled(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(Constant.FONDO2.getImage(), 0, 0, null);
	}
}
