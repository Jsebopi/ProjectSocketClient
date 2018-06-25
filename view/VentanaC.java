package view;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import controller.Controller;
import model.Court;
import model.Cliente;
import model.Ball;
import model.paleta;
import model.paleta2;

public class VentanaC extends JPanel implements KeyListener, Runnable {
	private static final long serialVersionUID = 1L;
	private Point point;
	private String userName;
	private int x, y;
	private JLabel fondo;
	private JdProgres barra;
	private Ball ball;
	private paleta paddle;
	private final Cliente cliente;
	private Court arco1, arco2;
	private paleta2 paddle2;
	private JPanel panel;
	private int Point;
	private JLabel count;
	private JLabel count2;
	private int point2;
	public boolean moviendo = true;
	public boolean cont = true;

	public VentanaC(Controller controller, String[] user) {
		initComponents();
		String ip_puerto_nombre[] = user;
		String ip = ip_puerto_nombre[0];
		String puerto = ip_puerto_nombre[1];
		String nombre = ip_puerto_nombre[2];
		cliente = new Cliente(this, ip, Integer.valueOf(puerto), nombre);

	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
			paddle2.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
			paddle2.keyPressed(e);
		}
	}

	public Point getCmbContactos() {
		return point;
	}

	public void setCmbContactos(Point point) {
		this.point = point;
	}

	private void initComponents() {

		this.setSize(800, 600);
		setDoubleBuffered(true);
		setFocusable(true);
		x = 0;
		y = 0;

		barra = new JdProgres();
		barra.setBorder(BorderFactory.createTitledBorder("Tiempo: "));

		point = new Point(x, y);
		ball = new Ball();
		this.addKeyListener(new TAdapter());
		Point = 0;
		point2 = 0;
		arco1 = new Court(70, 260, 40, 100);
		arco2 = new Court(680, 260, 40, 100);

		panel = new JPanel();
		panel.setSize(getSize());
		panel.setBorder(BorderFactory.createTitledBorder("Jugadores en Linea: "));
		panel.setLayout(new GridLayout(1, 3));
		setOpaque(true);

		count = new JLabel(String.valueOf(Point));
		count.setFont(new Font("Comic Sans", Font.BOLD, 17));
		count.setBorder(BorderFactory.createTitledBorder("Puntos SoccerHotFc"));
		count.setIcon(new ImageIcon("src/img/player1.png"));

		count2 = new JLabel(String.valueOf(point2));
		count2.setFont(new Font("Comic Sans", Font.BOLD, 17));
		count2.setBorder(BorderFactory.createTitledBorder("Puntos HamburguerFC"));
		count2.setIcon(new ImageIcon("src/img/player2.png"));

		panel.add(count2);
		panel.add(count);
		panel.add(barra);

		add(panel, BorderLayout.PAGE_START);
		fondo = new JLabel();
		paddle = new paleta();
		paddle2 = new paleta2();

		ImageIcon imagen = new ImageIcon("src/img/tablero.png");
		fondo.setIcon(imagen);
		add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		add(fondo, BorderLayout.CENTER);

	}

	public void initCont() {
		Thread hilo = new Thread(barra);
		hilo.start();
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public void pintando() {
		while (true) {
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this);

		g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), this);

		g.drawImage(paddle2.getImage(), paddle2.getX(), paddle2.getY(), paddle2.getWidth(), paddle2.getHeight(), this);
		arco1.pintarArco(g);
		arco2.pintarArco(g);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void confirmardesconexion() {
		cliente.confirmarDesconexion();
	}

	public void setUsuario(String usuario) {
		this.userName = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void addContacto(String contacto) {
		userName = contacto;
	}

	private void panelActionPerformed(KeyEvent evt) {
		switch (evt.getKeyCode()) {
		case KeyEvent.VK_W:
			cliente.sendPlayer(userName, paddle.getX(), paddle.getY());
			break;
		case KeyEvent.VK_D:
			cliente.sendPlayer(userName, paddle.getX(), paddle.getY());
			break;
		case KeyEvent.VK_A:
			cliente.sendPlayer(userName, paddle.getX(), paddle.getY());
			break;
		case KeyEvent.VK_S:
			cliente.sendPlayer(userName, paddle.getX(), paddle.getY());
			break;
		case KeyEvent.VK_I:
			cliente.sendPlayer2(userName, paddle2.getX(), paddle2.getY());
			break;
		case KeyEvent.VK_L:
			cliente.sendPlayer2(userName, paddle2.getX(), paddle2.getY());
			break;
		case KeyEvent.VK_J:
			cliente.sendPlayer2(userName, paddle2.getX(), paddle2.getY());
			break;
		case KeyEvent.VK_K:
			cliente.sendPlayer2(userName, paddle2.getX(), paddle2.getY());
			repaint();
			break;
		default:
			break;
		}
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public int getPoint2() {
		return point2;
	}

	public void setPoint2(int points2) {
		point2 = points2;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		panelActionPerformed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mover();

		}

	}

	private void mover() {

		if (moviendo) {
			ball.move();
		}
		checkPuntaje();
		checkCollision(ball);
		paddle.move();
		paddle2.move();
		if (moviendo) {
			cliente.sendBall(userName, ball.getX(), ball.getY());
		}
		cliente.sendPlayer(userName, paddle.getX(), paddle.getY());
		cliente.sendPlayer2(userName, paddle2.getX(), paddle2.getY());
		repaint();
	}

	public void checkPuntaje() {
		if ((ball.getRect()).intersects(arco1.getRect())) {
			Point = Point + 60;
			if (point2 > 0) {
				point2 = point2 - 5;
			} else {
				point2 = 0;
			}
			count.setText(String.valueOf(Point));
			count2.setText(String.valueOf(point2));
			ball.setX(570);
			ball.setY(280);
			cliente.enviarPuntaje1(userName, Point);
			moviendo = false;
			cliente.sendSaque(userName, "False");
			ball.setXDir(-10);
			repaint();
		} else if ((ball.getRect()).intersects(arco2.getRect())) {
			point2 = point2 + 60;
			if (Point > 0) {
				Point = Point - 5;
			} else {
				Point = 0;
			}
			count2.setText(String.valueOf(point2));
			count.setText(String.valueOf(Point));
			ball.resetState();
			cliente.enviarPuntaje2(userName, point2);
			moviendo = false;
			cliente.sendSaque(userName, "False");
			ball.setXDir(10);
			repaint();
		}
	}

	public void checkCollision(Ball ballX) {

		if (ballX.getRect().getMinY() <= 60) {

			ballX.setYDir(10);
		}
		if (ballX.getRect().getMaxY() >= 580) {

			ballX.setYDir(-10);
		}

		if (ballX.getRect().getMaxX() >= 720) {

			ballX.setXDir(-10);

		}
		if (ballX.getRect().getMinX() <= 70) {

			ballX.setXDir(10);

		}

		if (ballX != null) {

			if ((ballX.getRect()).intersects(paddle.getRect())) {
				cliente.sendSaque(userName, "True");
				int paddleLPos = (int) paddle.getRect().getMinX();
				int ballLPos = (int) ballX.getRect().getMinX();

				int first = paddleLPos + 16;
				int second = paddleLPos + 32;
				int third = paddleLPos + 48;
				int fourth = paddleLPos + 62;

				if (ballLPos < first) {
					ballX.setXDir(-10);
					ballX.setYDir(-10);
				}

				if (ballLPos >= first && ballLPos < second) {
					ballX.setXDir(-10);
					ballX.setYDir(-1 * ballX.getYDir());
				}

				if (ballLPos >= second && ballLPos < third) {
					ballX.setXDir(10);
					ballX.setYDir(-10);
				}

				if (ballLPos >= third && ballLPos < fourth) {
					ballX.setXDir(10);
					ballX.setYDir(-1 * ballX.getYDir());
				}

				if (ballLPos > fourth) {
					ballX.setXDir(10);
					ballX.setYDir(-10);
				}
			}
			if ((ballX.getRect()).intersects(paddle2.getRect())) {
				moviendo = true;
				cliente.sendSaque(userName, "True");
				int paddleLPos = (int) paddle2.getRect().getMinX();
				int ballLPos = (int) ballX.getRect().getMinX();

				int first = paddleLPos + 16;
				int second = paddleLPos + 32;
				int third = paddleLPos + 48;
				int fourth = paddleLPos + 62;

				if (ballLPos < first) {
					ballX.setXDir(-10);
					ballX.setYDir(-10);
				}

				if (ballLPos >= first && ballLPos < second) {
					ballX.setXDir(-10);
					ballX.setYDir(-1 * ballX.getYDir());
				}

				if (ballLPos >= second && ballLPos < third) {
					ballX.setXDir(10);
					ballX.setYDir(-10);
				}

				if (ballLPos >= third && ballLPos < fourth) {
					ballX.setXDir(10);
					ballX.setYDir(-1 * ballX.getYDir());
				}

				if (ballLPos > fourth) {
					ballX.setXDir(10);
					ballX.setYDir(-10);
				}
			}
		}
	}

	public void addjugador2(int x, int y) {
		paddle2.setX(x);
		paddle2.setY(y);
		repaint();
	}

	public void addPuntaje1(int p) {
		Point = p;
		count.setText(String.valueOf(Point));
		ball.setX(570);
		ball.setY(280);
		repaint();
	}

	public void addBola(int x, int y) {

		ball.setX(x - 1);
		ball.setY(y - 1);
		repaint();
	}

	public void addjugador(int x, int y) {
		paddle.setX(x);
		paddle.setY(y);
		repaint();
	}

	public void addPuntaje2(int p) {
		point2 = p;
		count2.setText(String.valueOf(point2));
		ball.resetState();
		repaint();
	}

	public int getTime() {
		return barra.getAux();
	}

	public void addSaque(String string) {
		// TODO Auto-generated method stub
		if (string.equals("True")) {
			moviendo = true;
		} else {
			moviendo = false;
		}
	}
}
