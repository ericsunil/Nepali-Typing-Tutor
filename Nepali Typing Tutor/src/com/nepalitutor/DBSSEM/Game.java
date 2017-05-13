package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private int speed;
	private int x = 0;
	private int y = (int) screen.getHeight();

	private int score;
	private Image image;
	private int imageHeight;
	private int imageWidth;
	private String[] path = { "game/loveballoon.png", "game/redballoon.png" };
	private File file;
	private StringBuilder temp;
	private Thread t = new Thread(this);
	private String lessons[] = { "बुबा", "दिदी", "दाई", "कालो", "रातो", "निलो",
			"हरियो", "पेन्सिल", "मोबाइल", "टि भी", "क्षति", "कलम" };
	private String answer;
	private UnicodeConverter convert = new UnicodeConverter();
	private JTextField text = new JTextField(10);
	private JLabel score_label = new JLabel(score + "");
	private JButton start = new JButton("Start");
	private Random random = new Random();
	private String input;

	public Game() {
		setBackground(Color.white);
		input = "";
		text.setEditable(false);
		text.getCaret().setVisible(true);
		reset();
		score = 0;
		add(start);
		add(text);
		add(score_label);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.start();
				text.requestFocus(true);
				start.setEnabled(false);
			}
		});
		text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent kp) {
				if (kp.getKeyCode() == 10 && text.getText().equals(answer)) {
					score += 10;
					score_label.setText(score + "");
					reset();
				} else if (kp.getKeyCode() == 10 || kp.getKeyCode() == 29
						|| kp.isShiftDown()) {
					text.setText(input);
					// Do nothing
				} else if (kp.getKeyCode() == 8) {
					if (input.length() != 0) {
						temp = new StringBuilder(input);
						temp = temp.deleteCharAt(input.length() - 1);
						input = temp.toString();
						text.setText(input);
					} else
						text.setText("");
				} else {
					input += convert.toRoman(Character.toString(kp.getKeyChar()));
					text.setText(input);
				}
			}
		});
		setPreferredSize(screen);
	}

	public void levelUp() {
		if (score < 50)
			speed = 150;
		else if (score >= 50 && score < 100)
			speed = 100;
		else if (score >= 200 && score < 500)
			speed = 75;
		else if (score >= 500 && score < 1000)
			speed = 50;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (y < 20) {
			reset();
		}
		try {
			image = ImageIO.read(file);
			imageHeight = image.getHeight(null);
			imageWidth = image.getWidth(null);
		} catch (IOException io) {
			io.printStackTrace();
		}
		g.drawImage(image, x, y, null);
		g.setColor(Color.BLUE);
		g.drawString(answer, x + imageWidth / 2 - 25, imageHeight / 2 + y - 30);
	}

	public void reset() {
		x = random.nextInt(600);
		y = (int) screen.getHeight();
		answer = lessons[random.nextInt(lessons.length)];
		file = new File(path[(random.nextInt(path.length))]);
		input = "";
		text.setText(input);
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(speed);
				y -= 10;
				repaint();
				levelUp();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
