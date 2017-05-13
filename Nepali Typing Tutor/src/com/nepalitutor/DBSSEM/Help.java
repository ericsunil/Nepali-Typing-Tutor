package com.nepalitutor.DBSSEM;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Help extends JPanel implements HyperlinkListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JEditorPane editorpane;

	public Help() {
		editorpane = new JEditorPane();
		editorpane.setContentType("text/html;charset=UTF-8");
		editorpane.addHyperlinkListener(this);
		JScrollPane editorScrollPane = new JScrollPane(editorpane);
		editorScrollPane.setPreferredSize(Toolkit.getDefaultToolkit()
				.getScreenSize());
		File file = new File("help/help.html");
		try {
			editorpane.setPage(file.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		editorpane.setEditable(false);
		add(editorScrollPane);
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
		HyperlinkEvent.EventType type = hyperlinkEvent.getEventType();
		final URL url = hyperlinkEvent.getURL();
		if (type == HyperlinkEvent.EventType.ENTERED) {
			System.out.println("URL: " + url);
		} else if (type == HyperlinkEvent.EventType.ACTIVATED) {
			System.out.println("Activated");

			try {
				editorpane.setPage(url);
			} catch (IOException ioException) {
				System.out.println("Error following link, Invalid link");
			}
		}
	}
}
