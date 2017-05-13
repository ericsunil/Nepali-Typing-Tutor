package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingPractice extends JPanel implements ActionListener {

	/**
	 * This is our main program
	 */
	ImageIcon homeIcon = new ImageIcon("icon/home.jpg");
	ImageIcon settingIcon = new ImageIcon("icon/setting.jpg");
	ImageIcon aboutIcon = new ImageIcon("icon/about.jpg");
	ImageIcon helpIcon = new ImageIcon("icon/help.jpg");
	ImageIcon welcome = new ImageIcon("icon/welcome.png");
	ImageIcon usericon = new ImageIcon("icon/user.jpg");
	private static final long serialVersionUID = 1L;
	GridBagConstraints c = new GridBagConstraints();
	NepaliTypingTutor nepaliTypingTutor;
	Keyboard keyboard;
	private String about = "Nepali Typing Tutor\nDesigner: Sunil Hyagumekha\nGUI Builder: Sudean Manandhar"
			+ "\nUnicode Converter: Bhupesh Shrestha\nDocumetation: Mahesh Adhikari\nOverAll Coding: Dipesh Manandhar\n"
			+ "Contact @ typingtutor@ku.edu.com\n+977 9849796420\n@Copyright";

	public TypingPractice(Data data, DisplayPanel displayPanel,
			TypingPanel typingPanel, StatusViewer status, Keyboard keyboard,
			NepaliTypingTutor nepaliTypingTutor) {
		setLayout(new GridBagLayout());
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.nepaliTypingTutor = nepaliTypingTutor;
		this.keyboard = keyboard;

		JButton home = new JButton("Home");
		home.setIcon(homeIcon);
		home.setBackground(Color.WHITE);
		home.addActionListener(this);

		JButton setting = new JButton("Setting");
		setting.setIcon(settingIcon);
		setting.setBackground(Color.WHITE);
		setting.addActionListener(this);

		JButton help = new JButton("Help");
		help.setIcon(helpIcon);
		help.setBackground(Color.WHITE);
		help.addActionListener(this);

		JButton about = new JButton("About");

		about.setBackground(Color.WHITE);
		about.setIcon(aboutIcon);
		about.addActionListener(this);

		JButton user = new JButton("User");
		user.addActionListener(this);
		user.setIcon(usericon);
		user.setBackground(Color.WHITE);

		c.gridx = 0;
		c.gridy = 0;
		add(home, c);

		c.gridx = 0;
		c.gridy = 1;
		add(user, c);

		c.gridx = 0;
		c.gridy = 2;
		add(setting, c);

		c.gridx = 0;
		c.gridy = 3;
		add(help, c);

		c.gridx = 0;
		c.gridy = 4;
		add(about, c);

		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 2;
		c.weightx = 1;
		add(displayPanel, c);

		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 2;
		add(typingPanel, c);

		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 2;
		add(keyboard, c);

		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 2;
		;
		add(status, c);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "Typing Practice":
			nepaliTypingTutor.tab.setSelectedIndex(1);
			break;
		case "About":
			JOptionPane.showMessageDialog(null, about);
			break;
		case "Help":
			nepaliTypingTutor.tab.setSelectedIndex(2);
			break;
		case "Setting":
			new Setting(new JFrame(), "Preferences", keyboard);
			break;
		case "User":
			UserStatistics user = new UserStatistics(new JFrame(), "User Login");
			user.setDialog();
			break;
		case "Home":
			nepaliTypingTutor.tab.setSelectedIndex(0);
			break;
		}
	}
}
