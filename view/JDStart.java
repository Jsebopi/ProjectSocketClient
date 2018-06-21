package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constant.Constant;
import controller.Controller;

public class JDStart extends JDialog {
	private static final long serialVersionUID = 1L;
	private PanelStart panelStart;
	private JPanel panelInfo;
	private JTextField txIp, txPort, txName;
	private JButton btnconect;

	public JDStart(Controller controller) {
		setTitle("Menú Principal");
		setSize(300, 300);
		setLocationRelativeTo(null);

		txIp = new JTextField();
		txIp.setBorder(BorderFactory.createTitledBorder("Ip: "));

		txPort = new JTextField();
		txPort.setBorder(BorderFactory.createTitledBorder("Puerto: "));

		txName = new JTextField();
		txName.setBorder(BorderFactory.createTitledBorder("Nombre: "));

		btnconect = new JButton("Conectar");
		btnconect.addActionListener(controller);
		btnconect.setActionCommand(Constant.CONN);
		btnconect.setBackground(Constant.AZUL_CLARO);
		btnconect.setForeground(Constant.BLANCO);
		btnconect.setFont(new Font("Comic Sans", Font.BOLD, 13));
		btnconect.setIcon(new ImageIcon("src/img/start.png"));

		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(2, 2));
		panelInfo.setBorder(BorderFactory.createTitledBorder("Conexion"));
		panelInfo.add(txIp);
		panelInfo.add(txPort);
		panelInfo.add(txName);
		panelInfo.add(btnconect);

		panelStart = new PanelStart(controller);
		panelStart.setBorder(BorderFactory.createTitledBorder("Configuracion"));

		add(panelInfo, BorderLayout.PAGE_START);
		add(panelStart, BorderLayout.CENTER);
	}

	public void dislBtn() {
		panelStart.dislBtn();
	}

	public boolean getText() {
		if (txName.getText() == "" || txPort.getText() == "" || txIp.getText() == "") {
			return false;
		} else {
			return true;
		}
	}

	public String getName() {
		return txName.getText();
	}

}
