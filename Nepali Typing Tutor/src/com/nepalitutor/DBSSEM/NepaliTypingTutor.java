package com.nepalitutor.DBSSEM;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class NepaliTypingTutor extends JFrame {

	/**
	 * This is our main program All the objects are initialize here
	 */

	private static final long serialVersionUID = 1L;

	private Data data;
	private Keyboard keyboard;
	private TypingPractice typingPractice;
	private StatusViewer status;
	private Home home;
	private Help help;
	private TypingPanel typingPanel;
	private Mistake mistake;
	private Accuracy accuracy;
	private WoPS wopm;
	private DisplayPanel displayPanel;
	private Time time;
	private Game game;
	JTabbedPane tab;

	public NepaliTypingTutor() {
		super("Nepali Typing Tutor");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		tab = new JTabbedPane();
		data = new Data();
		displayPanel = new DisplayPanel();
		typingPanel = new TypingPanel(data);
		mistake = new Mistake(data);
		accuracy = new Accuracy(data);
		time = new Time();
		wopm = new WoPS(data, typingPanel, time);
		keyboard = new Keyboard(data, typingPanel, displayPanel);
		status = new StatusViewer(mistake, time, accuracy, wopm, keyboard);
		typingPractice = new TypingPractice(data, displayPanel, typingPanel,
				status, keyboard, this);
		home = new Home(this, keyboard);
		help = new Help();
		game = new Game();

		Container contentPane = getContentPane();
		tab.addTab("Home", home);
		tab.addTab("Typing Practice", typingPractice);
		tab.addTab("Game", game);
		tab.addTab("Help", help);
		contentPane.add(tab);

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pack();
	}
}
