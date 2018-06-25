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
	private JButton signUp, exit, users, help;
	private JLabel welcom;
	private JLabel nameApp;
	private PanelBackground imagel;

	public Windows_Principal(Controller con) {
		setTitle("Menu Principal");
		setSize(550, 400);
		setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
		setResizable(false);
		Image image = Toolkit.getDefaultToolkit().getImage("src/img/icon.png");
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

		welcom = new JLabel("Bienvenido");
		welcom.setForeground(Color.decode("#504117"));
		welcom.setFont(new Font("Comic Sans Ms", 10, 32));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(welcom, c);

		nameApp = new JLabel("Soccer HotDog");
		nameApp.setFont(new Font("Comic Sans Ms", 10, 18));
		nameApp.setForeground(Color.decode("#504117"));
		nameApp.setIcon(new ImageIcon("src/img/soccer.png"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(nameApp, c);

		signUp = new JButton("Play");
		signUp.setIcon(new ImageIcon("src/img/games-control.png"));
		signUp.setFont(new Font("Comic Sans Ms", 10, 18));
		signUp.setActionCommand(Controller.C_VIEW_CLIENTE);
		signUp.addActionListener(con);
		signUp.setBackground(Color.decode("#FAEB9E"));
		signUp.setForeground(Color.decode("#504117"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(signUp, c);

		exit = new JButton("Salir");
		exit.setIcon(new ImageIcon("src/img/exit.png"));
		exit.setFont(new Font("Comic Sans Ms", 10, 18));
		exit.setActionCommand(Controller.C_SALIR);
		exit.addActionListener(con);
		exit.setBackground(Color.decode("#FAEB9E"));
		exit.setForeground(Color.decode("#504117"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(exit, c);

		users = new JButton("En Linea");
		users.setIcon(new ImageIcon("src/img/antena.png"));
		users.setFont(new Font("Comic Sans Ms", 10, 18));
		users.setActionCommand(Controller.C_TOP_CONNEC);
		users.addActionListener(con);
		users.setBackground(Color.decode("#FAEB9E"));
		users.setForeground(Color.decode("#504117"));

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(users, c);

		help = new JButton("Acerca de");
		help.setIcon(new ImageIcon("src/img/information.png"));
		help.setFont(new Font("Comic Sans Ms", 10, 18));
		help.setActionCommand(Controller.C_HELP);
		help.addActionListener(con);
		help.setBackground(Color.decode("#FAEB9E"));
		help.setForeground(Color.decode("#504117"));

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(help, c);

		this.add(imagel);

	}
}
