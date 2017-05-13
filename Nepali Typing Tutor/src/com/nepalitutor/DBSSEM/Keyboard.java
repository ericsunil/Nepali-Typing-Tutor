package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Keyboard extends JPanel implements KeyListener, Runnable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// global declarations
	private Data data;
	private TypingPanel typingPanel;
	private DisplayPanel displayPanel;
	private UnicodeConverter conv = new UnicodeConverter();
	private final int CAPS = 29;
	private int lessonNo = 0;
	private int textIndex = 0;

	int x[], y[];
	boolean isRoman = true;
	private Thread t;
	private String converted;
	public JButton[] button = new JButton[61];
	private Dimension buttonSize = new Dimension(47, 26);
	private Dimension finalButtons = new Dimension(80, 26);

	// String array for button caption
	private String keys[] = { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"0", "-", "=", "\\", "", "Tab", "q", "w", "e", "r", "t", "y", "u",
			"i", "o", "p", "[", "]", "Tab", "Caps Lock", "a", "s", "d", "f",
			"g", "h", "j", "k", "l", ";", "\'", " Enter", "Shift", "z", "x",
			"c", "v", "b", "n", "m", ",", ".", "/", " Shift", "Ctrl", "Win",
			"Alt", "Space", "Alt", "Win", "Ctrl" };

	private String caps[] = { "~", "!", "@", "#", "$", "%", "^", "&", "*", "(",
			")", "_", "+", "|", "", "Tab", "Q", "W", "E", "R", "T", "Y", "U",
			"I", "O", "P", "{", "}", "Tab", "Caps Lock", "A", "S", "D", "F",
			"G", "H", "J", "K", "L", ":", "\"", "Enter", "Shift", "Z", "X",
			"C", "V", "B", "N", "M", "<", ">", "?", " Shift", "Ctrl", "Win",
			"Alt", "Space", "Alt", "Win", "Ctrl" };

	private String indexing1 = "`1234567890-=\\||qwertyuiop[]||asdfghjkl;'||zxcvbnm,./|||| |||";
	private String indexing2 = "`1234567890-=\\||QWERTYUIOP{}||ASDFGHJKL:\"||ZXCVBNM<>/|||| |||";
	private String romanCaps[] = conv.toRoman(caps);
	private String traditionalCaps[] = conv.toTraditional(caps);

	private String roman[] = conv.toRoman(keys);
	private String traditional[] = conv.toTraditional(keys);
	private String kType[] = new String[keys.length];
	private ImageIcon backspace = new ImageIcon("icon/backspace.png");

	private boolean capsIsOn = Toolkit.getDefaultToolkit().getLockingKeyState(
			KeyEvent.VK_CAPS_LOCK);

	public Keyboard(Data data, TypingPanel typingPanel,
			DisplayPanel displayPanel) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.typingPanel = typingPanel;
		this.displayPanel = displayPanel;
		this.data = data;
		t = new Thread(this);
		t.start();
		x = new int[5];
		y = new int[5];
		conv = new UnicodeConverter();
		setKeyboardType();
		setKeyboard();

		if (capsIsOn)
			button[29].setBackground(Color.ORANGE);
	}

	public void reset() {
		typingPanel.text.setText("");
		typingPanel.convertedText = "";
		displayPanel.text.setText(displayPanel.lesson[lessonNo]);
		textIndex = 0;
	}

	public int getIndex() {
		return textIndex;
	}

	public void setKeyboardType() {
		if (isRoman && !capsIsOn)
			kType = roman;
		else if (isRoman && capsIsOn)
			kType = romanCaps;
		else if (!isRoman && !capsIsOn)
			kType = traditional;
		else if (!isRoman && capsIsOn)
			kType = traditionalCaps;
	}

	public void setCapsState() {
		if (capsIsOn) {
			capsIsOn = false;
			button[CAPS].setBackground(Color.ORANGE);
			if (isRoman)
				for (int i = 0; i < keys.length; i++)
					button[i].setText(roman[i]);
			else
				for (int i = 0; i < keys.length; i++)
					button[i].setText(traditional[i]);
		} else {
			capsIsOn = true;
			button[CAPS].setBackground(Color.ORANGE);
			if (isRoman)
				for (int i = 0; i < keys.length; i++)
					button[i].setText(romanCaps[i]);
			else
				for (int i = 0; i < keys.length; i++)
					button[i].setText(traditionalCaps[i]);
		}
	}

	public boolean getCapsState() {
		return capsIsOn;
	}

	public String[] getRoman() {
		return roman;
	}

	public String[] getTraditional() {
		return traditional;
	}

	public void setKeyboard() {
		// Panels for each buttons rowss
		JPanel k1 = new JPanel();
		k1.setBackground(Color.white);
		JPanel k2 = new JPanel();
		k2.setBackground(Color.white);
		JPanel k3 = new JPanel();
		k3.setBackground(Color.white);
		JPanel k4 = new JPanel();
		k4.setBackground(Color.white);
		JPanel k5 = new JPanel();
		k5.setBackground(Color.white);

		// 1st row buttons
		for (int j = 0; j < 15; j++) {
			JButton newB = new JButton();
			newB.setText(kType[j]);
			button[j] = newB;

			// backspace button
			if (j == 14) {
				button[14].setIcon(backspace);
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(buttonSize);
				k1.add(button[j]);
			} else {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(buttonSize);
				k1.add(button[j]);
			}
			button[j].addKeyListener(this);
			button[j].setFocusable(false);
		}

		// 2nd row buttons
		for (int j = 15; j < 29; j++) {
			JButton newB = new JButton();
			newB.setText(kType[j]);
			button[j] = newB;

			// tab button
			if (j == 15) {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(new Dimension(71, 26));
				k2.add(button[j]);

			} else if (j == 28) {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(new Dimension(70, 26));
				k2.add(button[j]);

			} else {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(buttonSize);
				k2.add(button[j]);
			}
			button[j].addKeyListener(this);
			button[j].setFocusable(false);
		}

		// 3rd row buttons
		for (int j = 29; j < 42; j++) {
			JButton newB = new JButton();
			newB.setText(kType[j]);
			button[j] = newB;
			// caps button
			if (j == 29) {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(new Dimension(94, 26));
				k3.add(button[j]);
			}

			// enter button
			else if (j == 41) {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(new Dimension(94, 26));
				k3.add(button[j]);
			} else {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(buttonSize);
				k3.add(button[j]);
			}
			button[j].addKeyListener(this);
			button[j].setFocusable(false);
		}

		// 4th row buttons
		for (int j = 42; j < 54; j++) {
			JButton newB = new JButton();
			newB.setText(kType[j]);
			button[j] = newB;
			// left shift
			if (j == 42) {
				button[j].setPreferredSize(new Dimension(118, 26));
				button[j].setBackground(Color.YELLOW);
				k4.add(button[j]);
			}
			// right shift
			else if (j == 53) {
				button[j].setPreferredSize(new Dimension(118, 26));
				button[j].setBackground(Color.YELLOW);
				k4.add(button[j]);
			}

			else {
				button[j].setPreferredSize(buttonSize);
				button[j].setBackground(Color.YELLOW);
				k4.add(button[j]);
			}
			button[j].addKeyListener(this);
			button[j].setFocusable(false);
		}

		// 5th row buttons
		for (int j = 54; j < 61; j++) {
			JButton newB = new JButton();
			newB.setText(kType[j]);
			button[j] = newB;
			// space
			if (j == 57) {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(new Dimension(250, 26));
				k5.add(button[j]);

			} else {
				button[j].setBackground(Color.YELLOW);
				button[j].setPreferredSize(finalButtons);
				k5.add(button[j]);
			}
			button[j].addKeyListener(this);
			button[j].setFocusable(false);
		}

		button[54].setEnabled(false);
		button[55].setEnabled(false);
		button[56].setEnabled(false);
		button[58].setEnabled(false);
		button[59].setEnabled(false);
		button[60].setEnabled(false);

		add(k1);
		add(k2);
		add(k3); // adding all the sub panels to main panel
		add(k4);
		add(k5);
	}

	public void checkMistake() {

		if (converted.equals(Character.toString(displayPanel.lesson[lessonNo]
				.charAt(textIndex)))) {
			typingPanel.convertedText += converted;
			textIndex++;
		} else
			data.Mistakes++;

		data.isTyped(true);
	}

	public void checkEnding() {
		if (textIndex == displayPanel.lesson[lessonNo].length()) {
			x = WoPS.x;
			y = WoPS.y;
			lessonNo++;
			reset();
			new Graph(x, y);
		}
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		int index = 0;

		if (kp.getKeyCode() == 20) // caps key
			setCapsState();

		// indexing button pressed
		if (kp.getKeyCode() != 16 && kp.getKeyCode() != 20) {

			if (getCapsState() || kp.isShiftDown()) {
				index = indexing2.indexOf(kp.getKeyChar());
				button[index].setBackground(Color.ORANGE);
			} else {
				index = indexing1.indexOf(kp.getKeyChar());
				button[index].setBackground(Color.ORANGE);
			}

			// convert pressed button label to roman or traditional
			try {
				if (isRoman)
					converted = conv
							.toRoman(Character.toString(kp.getKeyChar()));
				else
					converted = conv.toTraditional(Character.toString(kp
							.getKeyChar()));
				checkMistake();
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}

		if (kp.isShiftDown()) {
			if (capsIsOn) {
				if (isRoman)
					for (int i = 0; i < keys.length; i++)
						button[i].setText(roman[i]);
				else
					for (int i = 0; i < keys.length; i++)
						button[i].setText(traditional[i]);
			} else {
				if (isRoman)
					for (int i = 0; i < keys.length; i++)
						button[i].setText(romanCaps[i]);
				else
					for (int i = 0; i < keys.length; i++)
						button[i].setText(traditionalCaps[i]);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent kr) {
		checkEnding();
		for (int i = 0; i < keys.length; i++)
			button[i].setBackground(Color.yellow);

		if (capsIsOn)
			button[CAPS].setBackground(Color.ORANGE);

		if (kr.getKeyCode() == 16) {
			if (!capsIsOn) {
				if (isRoman)
					for (int i = 0; i < keys.length; i++)
						button[i].setText(roman[i]);
				else
					for (int i = 0; i < keys.length; i++)
						button[i].setText(traditional[i]);
			} else {
				if (isRoman)
					for (int i = 0; i < keys.length; i++)
						button[i].setText(romanCaps[i]);
				else
					for (int i = 0; i < keys.length; i++)
						button[i].setText(traditionalCaps[i]);
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent kt) {

	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				String romanIndex = conv.toRoman(indexing1)
						+ conv.toRoman(indexing2);
				String traditionalIndex = conv.toTraditional(indexing1)
						+ conv.toTraditional(indexing2);
				if (isRoman) {
					int x = romanIndex.indexOf(displayPanel.lesson[lessonNo]
							.charAt(textIndex));
					if (x > indexing1.length()) {
						x -= indexing1.length();
						button[42].setBackground(Color.green);
						button[53].setBackground(Color.green);
					}
					button[x].setBackground(Color.green);
				} else {
					int x = traditionalIndex
							.indexOf(displayPanel.lesson[lessonNo]
									.charAt(textIndex));
					if (x > indexing1.length()) {
						x -= indexing1.length();
						button[42].setBackground(Color.green);
						button[53].setBackground(Color.green);
					}
					button[x].setBackground(Color.green);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
