package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import constants.Constants;
import controller.Controller;

public class JDConnect extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField ip, puerto, usuario;
	private JButton btnConnect, btnCancel;
	private PanelBackground imagel;

	public JDConnect(Controller controller) {
		setSize(650, 200);
		setLocationRelativeTo(null);
		setTitle("Conectar");
		Image image = Toolkit.getDefaultToolkit().getImage("src/img/soccer.png");
		setIconImage(image);

		imagel = new PanelBackground(this.getWidth(), this.getHeight(), "fondo.jpg");
		imagel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;

		ip = new JTextField(20);
		ip.setBorder(BorderFactory.createTitledBorder("Ip Conexión"));
		ip.setFont(new Font("Comic Sans", Font.BOLD, 16));
		ip.setForeground(Color.decode("#504117"));
		ip.setHorizontalAlignment(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(ip, c);

		puerto = new JTextField(20);
		puerto.setBorder(BorderFactory.createTitledBorder("Puerto de la conexión"));
		puerto.setFont(new Font("Comic Sans", Font.BOLD, 16));
		puerto.setForeground(Color.decode("#504117"));
		puerto.setHorizontalAlignment(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(puerto, c);

		usuario = new JTextField(20);
		usuario.setBorder(BorderFactory.createTitledBorder("Nombre Jugador"));
		usuario.setFont(new Font("Comic Sans", Font.BOLD, 16));
		usuario.setForeground(Color.decode("#504117"));
		usuario.setHorizontalAlignment(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(usuario, c);

		ip.setText(Constants.DEFAULT_IP);
		puerto.setText(Constants.DEFAULT_PORT);

		btnConnect = new JButton("Conectar");
		btnConnect.addActionListener(controller);
		btnConnect.setActionCommand(Constants.C_TOP_CONNEC);
		btnConnect.setFont(new Font("Comic Sans", Font.BOLD, 16));
		btnConnect.setBackground(Color.decode("#FAEB9E"));
		btnConnect.setForeground(Color.decode("#504117"));
		btnConnect.setIcon(new ImageIcon("src/img/antena.png"));
		btnConnect.setHorizontalAlignment(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(btnConnect, c);

		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand(Constants.C_EXIT_CONNECT);
		btnCancel.setFont(new Font("Comic Sans", Font.BOLD, 16));
		btnCancel.setBackground(Color.decode("#FAEB9E"));
		btnCancel.setForeground(Color.decode("#504117"));
		btnCancel.setIcon(new ImageIcon("src/img/cancel.png"));
		btnCancel.setHorizontalAlignment(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 40, 0, 60);
		imagel.add(btnCancel, c);

		add(imagel);

	}

	public String[] getIP_Puerto_Nombre() {
		String s[] = new String[3];
		s[0] = ip.getText();
		s[1] = puerto.getText();
		s[2] = usuario.getText();
		return s;
	}

	public String getUser() {
		return usuario.getText();
	}
}
