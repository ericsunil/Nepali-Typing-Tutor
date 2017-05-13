package com.nepalitutor.DBSSEM;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UserStatistics extends JDialog implements ActionListener,
		ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> UserArrayList;
	private String[] userArray;
	private String user = "";
	private String newUser;
	private String SelectedUser;
	private final String PATH = "database/user.txt";
	private JList<String> list;

	public UserStatistics(JFrame parent, String title) {
		super(parent, title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		UserArrayList = new ArrayList<String>();
		try {
			readUser();
			userArray = UserArrayList.toArray(new String[UserArrayList.size()]);
			setDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectedUser() {
		JOptionPane.showMessageDialog(null, SelectedUser + "Selected");
	}

	public void selectedUser(String add) {
		JOptionPane.showMessageDialog(null, add + "Selected");
	}

	public void setDialog() {
		setSize(225, 200);
		setLocation(400, 500);
		setVisible(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		list = new JList<String>(userArray);
		list.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(list);
		add(scroll);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JButton bAdd = new JButton("Add");
		JButton select = new JButton("Select");
		select.addActionListener(this);
		panel.add(bAdd);
		panel.add(select);
		bAdd.addActionListener(this);
		add(panel);
	}

	public void readUser() throws Exception {
		try {
			FileReader fileReader = new FileReader(PATH);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			while (line != null) {
				user += line + "\n";
				UserArrayList.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeUser() {
		try {
			FileWriter fileWriter = new FileWriter(PATH);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(user + newUser);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		switch (action.getActionCommand()) {
		case "Add":
			newUser = JOptionPane.showInputDialog(null, "Enter new User Name");
			writeUser();
			selectedUser(newUser);
			dispose();
			break;
		case "Select":
			selectedUser();
			dispose();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent l) {
		SelectedUser = list.getSelectedValue();
	}

}
