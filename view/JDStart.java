package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class JDStart extends JDialog {
	private static final long serialVersionUID = 1L;
	private PanelStart panelStart;
	private JPanel panelInfo;
	private JTextField txIp, txPort, txName;

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

		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(1, 2));
		panelInfo.setBorder(BorderFactory.createTitledBorder("Conexion"));
		panelInfo.add(txIp);
		panelInfo.add(txPort);

		panelStart = new PanelStart(controller);
		panelStart.setBorder(BorderFactory.createTitledBorder("Configuracion"));

		add(panelInfo, BorderLayout.PAGE_END);
		add(panelStart, BorderLayout.CENTER);
		add(txName, BorderLayout.PAGE_START);
	}

}
