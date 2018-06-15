package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constant.Constant;
import view.JDStart;

public class Controller implements ActionListener {
	private JDStart start;

	public Controller() {
		start = new JDStart(this);
		start.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case Constant.EXIT:
			start.dispose();
			break;
		}
	}

}
