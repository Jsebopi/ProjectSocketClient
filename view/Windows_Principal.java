package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.Controller;

public class Windows_Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem itemHelp;
	private JButton ingresa, salir, score, help;
	private JLabel participante;
	private JLabel texname;
	private PanelBackground imagel;

	public Windows_Principal(Controller con) {
		setTitle("Menu Principal");
		setSize(550, 400);
		setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
		setResizable(false);
		Image image = Toolkit.getDefaultToolkit().getImage("img/icon.png");
		setIconImage(image);
		setLocationRelativeTo(null);
		imagel = new PanelBackground(this.getWidth(), this.getHeight(), "fondo.jpg");
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuArchivo = new JMenu("Archivo");
		menuArchivo.setFont(new Font("Comic Sans Ms", 10, 15));

		itemHelp = new JMenuItem("Ayuda");
		itemHelp.setIcon(new ImageIcon("img/information.png"));
		itemHelp.setActionCommand(Controller.C_HELP);
		itemHelp.setBackground(Color.WHITE);
		itemHelp.setFont(new Font("Comic Sans Ms", 10, 15));
		itemHelp.addActionListener(con);

		menuArchivo.add(itemHelp);
		menuBar.add(menuArchivo);
		setJMenuBar(menuBar);
		imagel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;

		participante = new JLabel("Bienvenido");
		participante.setForeground(Color.WHITE);
		participante.setFont(new Font("Comic Sans Ms", 10, 22));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(participante, c);

		texname = new JLabel("Soccer HotDog");
		texname.setFont(new Font("Comic Sans Ms", 10, 18));
		texname.setForeground(Color.WHITE);
		texname.setIcon(new ImageIcon("img/shot.png"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(texname, c);

		ingresa = new JButton("Play");
		ingresa.setIcon(new ImageIcon("img/games-control.png"));
		ingresa.setFont(new Font("Comic Sans Ms", 10, 18));
		ingresa.setActionCommand(Controller.C_VIEW_CLIENTE);
		ingresa.addActionListener(con);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(ingresa, c);

		salir = new JButton("Salir");
		salir.setIcon(new ImageIcon("img/exit.png"));
		salir.setFont(new Font("Comic Sans Ms", 10, 18));
		salir.setActionCommand(Controller.C_SALIR);
		salir.addActionListener(con);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(salir, c);

		score = new JButton("Top Score");
		score.setIcon(new ImageIcon("img/score.png"));
		score.setFont(new Font("Comic Sans Ms", 10, 18));
		score.setActionCommand(Controller.C_TOP_SCORE);
		score.addActionListener(con);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(score, c);

		help = new JButton("Ayuda");
		help.setIcon(new ImageIcon("img/information.png"));
		help.setFont(new Font("Comic Sans Ms", 10, 18));
		help.setActionCommand(Controller.C_HELP);
		help.addActionListener(con);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(help, c);

		this.add(imagel);

	}
}
