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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import constants.Constants;
import controller.Controller;

public class Window_Help extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton salir;
	private JLabel linformation, lintegrante;
	private JTextArea instruccion;
	private JTextField autor;
	private PanelBackground imagel;

	public Window_Help(Controller con) {
		setTitle("Ayuda");
		setSize(550, 500);
		setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
		setResizable(false);
		Image image = Toolkit.getDefaultToolkit().getImage("src/img/information.png");
		setIconImage(image);
		setLocationRelativeTo(null);

		imagel = new PanelBackground(this.getWidth(), this.getHeight(), "fondo.jpg");
		imagel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;

		linformation = new JLabel("Acerca de... ");
		linformation.setFont(new Font("Comic Sans Ms", 10, 22));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(linformation, c);

		lintegrante = new JLabel("Integrantes:");
		lintegrante.setFont(new Font("Comic Sans Ms", 10, 22));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(lintegrante, c);

		instruccion = new JTextArea();
		instruccion.setText("Socket Hockey 1.0.." +

				"\nEsta desarrollado con la finalidad de que \npor medio de dos computadores"
				+ "\nconectadas a un servidor local o LAN, \ninteractuen de manera que su contrincante"
				+ "\nevite que le realicen puntuaciones. de alguna\n manera su rival y usted "
				+ "\ndeben evitar que el tiempo termine con menor\n puntos que el otro. "
				+ "\nEl aplicativo permite visualizar su puntaje y el \nde aquellos conectados al juego." + "   ");
		instruccion.setEditable(false);
		instruccion.setFont(new Font("Comic Sans Ms", 10, 18));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(instruccion, c);

		autor = new JTextField();
		autor.setText("Juan Sebastian Bocachica Pinzon");
		autor.setEditable(false);
		autor.setFont(new Font("Comic Sans Ms", 10, 16));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(autor, c);

		salir = new JButton("Salir");
		salir.setIcon(new ImageIcon("src/img/exit.png"));
		salir.setFont(new Font("Comic Sans Ms", 10, 18));
		salir.setActionCommand(Constants.C_SALIR_HELP);
		salir.addActionListener(con);
		salir.setBackground(Color.decode("#FAEB9E"));
		salir.setForeground(Color.decode("#504117"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(salir, c);

		this.add(imagel);

	}

}
