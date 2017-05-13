package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NepaliTypingTutor nepaliTypingTutor;
	private Keyboard keyboard;

	GridBagConstraints c = new GridBagConstraints();
	JPanel control = new JPanel();
	ImageIcon homeIcon = new ImageIcon("icon/home.jpg");
	ImageIcon settingIcon = new ImageIcon("icon/setting.jpg");
	ImageIcon aboutIcon = new ImageIcon("icon/about.jpg");
	ImageIcon helpIcon = new ImageIcon("icon/help.jpg");
	ImageIcon welcome = new ImageIcon("icon/welcome.png");
	ImageIcon usericon = new ImageIcon("icon/user.jpg");
	ImageIcon nepali = new ImageIcon("icon/nepali.png");
	private String about = "Nepali Typing Tutor\nDesigner: Sunil Hyagumekha\nGUI Builder: Sudean Manandhar"
			+ "\nUnicode Converter: Bhupesh Shrestha\nDocumetation: Mahesh Adhikari\nOverAll Coding: Dipesh Manandhar\n"
			+ "Contact @ typingtutor@ku.edu.com\n+977 9849796420\n@Copyright";

	public Home(NepaliTypingTutor nepaliTypingTutor, Keyboard keyboard) {
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

		JLabel nepl = new JLabel(nepali);

		JButton help = new JButton("Help");
		help.setIcon(helpIcon);
		help.setBackground(Color.WHITE);
		help.addActionListener(this);

		JButton about = new JButton("About");
		about.addActionListener(this);
		about.setBackground(Color.WHITE);
		about.setIcon(aboutIcon);

		JButton user = new JButton("User");
		user.setIcon(usericon);
		user.setBackground(Color.WHITE);
		user.addActionListener(this);

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

		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 2;
		// c.weighty=1;
		add(nepl, c);

		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 2;
		JButton button = new JButton("Typing Lesson");
		button.setPreferredSize(new Dimension(200, 40));
		add(button, c);

		c.gridx = 2;
		c.gridy = 4;
		JButton typingPractice = new JButton("Typing Practice");
		typingPractice.setPreferredSize(new Dimension(200, 40));
		typingPractice.addActionListener(this);

		add(typingPractice, c);

		c.gridx = 3;
		c.gridy = 4;
		JButton gameZone = new JButton("Game Zone");
		gameZone.addActionListener(this);
		gameZone.setPreferredSize(new Dimension(200, 40));
		add(gameZone, c);
		

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
			new UserStatistics(new JFrame(), "User Login");
			break;
		case "Game Zone":
			nepaliTypingTutor.tab.setSelectedIndex(3);
			break;
		}
	}

}
