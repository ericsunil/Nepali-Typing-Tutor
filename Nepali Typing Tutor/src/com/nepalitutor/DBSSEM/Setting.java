package com.nepalitutor.DBSSEM;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Setting extends JDialog implements ActionListener {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton roman;
	private JRadioButton traditional;
	private ButtonGroup group;
	private Keyboard keyboard;
	private String[] romanKeys;
	private String[] traditionalKeys;

	public Setting(JFrame frame, String title, Keyboard keyboard) {
		super(frame, title);
		setResizable(false);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.keyboard = keyboard;
		romanKeys = keyboard.getRoman();
		traditionalKeys = keyboard.getTraditional();

		roman = new JRadioButton("Roman");
		roman.addActionListener(this);
		traditional = new JRadioButton("Traditional");
		traditional.addActionListener(this);

		group = new ButtonGroup();
		group.add(roman);
		group.add(traditional);

		JPanel typePanel = new JPanel();
		typePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Keyboard types"));
		typePanel.add(roman);
		typePanel.add(traditional);

		add(typePanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton ok = new JButton("Ok");
		ok.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		add(buttonPanel);

		if (keyboard.isRoman)
			roman.setSelected(true);
		else if (!keyboard.isRoman)
			traditional.setSelected(true);

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		switch (ae.getActionCommand()) {
		case "Roman":
			keyboard.isRoman = true;
			break;
		case "Traditional":
			keyboard.isRoman = false;
			break;
		case "Ok":
			if (keyboard.isRoman)
				for (int i = 0; i < 61; i++)
					keyboard.button[i].setText(romanKeys[i]);
			else
				for (int i = 0; i < 61; i++)
					keyboard.button[i].setText(traditionalKeys[i]);
			dispose();
			break;

		case "Cancel":
			dispose();
			break;
		}
	}

}
