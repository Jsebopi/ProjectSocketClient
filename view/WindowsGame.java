package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import constant.Constant;
import controller.Controller;
import models.Vegetables;
import models.Player;
import models.Enemy;
import models.FitEat;
import models.Obstacule;

public class WindowsGame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenu opciones, insert;
	private JMenuItem start, pause, restart, end, playerItem;
	private JMenuBar menuBar;
	private PanelGame panelGame;
	private JPanel panelUser;
	private JLabel lName, lpunt, lLife;

	public WindowsGame(Player player, Controller controller, ArrayList<Obstacule> villain, ArrayList<FitEat> shoots,
			ArrayList<FitEat> shootsVillains, ArrayList<Vegetables> cows, Enemy Ufo, ArrayList<Enemy> ufos) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1300, 800));
		setTitle("Attack Gym");
		Image image = Toolkit.getDefaultToolkit().getImage("src/img/ICONO.png");
		setIconImage(image);

		playerItem = new JMenuItem("Jugador");
		playerItem.setIcon(new ImageIcon("src/img/pacman.png"));
		playerItem.setBackground(Color.white);
		playerItem.setToolTipText("Crea un nuevo jugador");
		playerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		playerItem.setActionCommand(Constant.CREATE_PLAYER);
		playerItem.addActionListener(controller);

		start = new JMenuItem("Iniciar");
		start.setIcon(new ImageIcon("src/img/play.png"));
		start.setBackground(Color.white);
		start.setToolTipText("Inicia el juego");
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		start.setActionCommand(Constant.START);
		start.addActionListener(controller);

		pause = new JMenuItem("Pausar");
		pause.setIcon(new ImageIcon("src/img/pause.png"));
		pause.setBackground(Color.white);
		pause.setToolTipText("Pausa el hilo");
		pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		pause.setActionCommand(Constant.PAUSA);
		pause.addActionListener(controller);

		restart = new JMenuItem("Reiniciar");
		restart.setIcon(new ImageIcon("src/img/restart.png"));
		restart.setBackground(Color.white);
		restart.setToolTipText("Termina el hilo");
		restart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		restart.setActionCommand(Constant.RESTART);
		restart.addActionListener(controller);

		end = new JMenuItem("Terminar");
		end.setIcon(new ImageIcon("src/img/stop.png"));
		end.setBackground(Color.white);
		end.setToolTipText("Termina el hilo");
		end.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
		end.setActionCommand(Constant.END);
		end.addActionListener(controller);
		insert = new JMenu("Insertar");
		opciones = new JMenu("Opciones");
		insert.add(playerItem);
		opciones.add(start);
		opciones.add(pause);
		opciones.add(restart);
		opciones.add(end);
		menuBar = new JMenuBar();
		menuBar.add(opciones);
		this.setJMenuBar(menuBar);

		lName = new JLabel();
		lName.setBorder(BorderFactory.createTitledBorder("Conectado con: "));
		lName.setIcon(new ImageIcon("src/img/user.png"));

		lpunt = new JLabel();
		lpunt.setBorder(BorderFactory.createTitledBorder("Puntos: "));
		lpunt.setIcon(new ImageIcon("src/img/moneda.png"));

		lLife = new JLabel();
		lLife.setBorder(BorderFactory.createTitledBorder("Vidas: "));
		lLife.setIcon(new ImageIcon("src/img/corazon.png"));

		panelUser = new JPanel();
		panelUser.setLayout(new GridLayout(1, 3));
		panelUser.add(lName);
		panelUser.add(lpunt);
		panelUser.add(lLife);

		panelGame = new PanelGame(player, villain, shoots, controller, shootsVillains, ufos);
		add(panelUser, BorderLayout.PAGE_START);
	}

	public void history(Controller controller) {
		panelGame.requestFocus();
		revalidate();
		setVisible(true);

	}

	public void play(Controller controller) {
		getContentPane().setBackground(Color.black);
		add(panelGame, BorderLayout.CENTER);
		panelGame.requestFocus();
		revalidate();

	}

	public void start() {
		SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				while (true) {
					panelGame.repaint();
				}
			}
		};

		swingWorker.execute();
	}

	public void changeImage(int img) {
		panelGame.setImg(img);
	}

	public PanelGame getPanelGame() {
		return panelGame;
	}

	public void setPanelGame(PanelGame panelGame) {
		this.panelGame = panelGame;
	}

	public void setLife(String value) {
		lLife.setText(value);
		this.repaint();
	}

	public void setPunt(String value) {
		lpunt.setText(value);
		this.repaint();
	}

	public void setUser(String value) {
		lName.setText(value);
	}

}
