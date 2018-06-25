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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import controller.Controller;

public class Window_Top_Score extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton salir;
	private JLabel lpersonal;
	private JLabel lConectado;
	private JList<String> personal, conectado;
	private PanelBackground imagel;
	private JTextField bar1, bar;

	public Window_Top_Score(Controller con) {
		setTitle("Top Score");
		setSize(550, 400);
		setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
		setResizable(false);
		Image image = Toolkit.getDefaultToolkit().getImage("img/score.png");
		setIconImage(image);
		setLocationRelativeTo(null);

		imagel = new PanelBackground(this.getWidth(), this.getHeight(), "fondo.jpg");
		imagel.setLayout(new GridBagLayout());

		String[] nombre = { "David" };
		String[] line = { "Juan", "David" };

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;

		lpersonal = new JLabel("Top Personal ");
		lpersonal.setForeground(Color.WHITE);
		lpersonal.setFont(new Font("Comic Sans Ms", 10, 22));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(lpersonal, c);

		lConectado = new JLabel("Top Score World");
		lConectado.setFont(new Font("Comic Sans Ms", 10, 22));
		lConectado.setForeground(Color.WHITE);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(lConectado, c);

		personal = new JList<>(nombre);
		personal.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		personal.setForeground(Color.WHITE);
		personal.setFont(new Font("Comic Sans Ms", 10, 18));
		personal.setBackground(Color.BLACK);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(personal, c);

		conectado = new JList<>(line);
		conectado.setFont(new Font("Comic Sans Ms", 10, 18));
		conectado.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		conectado.setForeground(Color.WHITE);
		conectado.setBackground(Color.BLACK);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(conectado, c);

		JScrollPane barraDesplazamiento = new JScrollPane(conectado);
		imagel.add(barraDesplazamiento, c);

		bar = new JTextField();
		bar.setText("2000" + " " + "Puntos");
		bar.setEditable(false);
		bar.setFont(new Font("Comic Sans Ms", 10, 18));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(bar, c);

		bar1 = new JTextField();
		bar1.setText("2000" + " " + "Puntos");
		bar1.setEditable(false);
		bar1.setFont(new Font("Comic Sans Ms", 10, 18));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(bar1, c);

		salir = new JButton("Salir");
		salir.setIcon(new ImageIcon("img/exit.png"));
		salir.setFont(new Font("Comic Sans Ms", 10, 18));
		salir.setActionCommand(Controller.C_EXIT_CONNECT);
		salir.addActionListener(con);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(salir, c);

		this.add(imagel);
	}
}
