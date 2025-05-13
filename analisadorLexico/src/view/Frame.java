package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public static textEditorView textEditorPanel;
	public static consoleView consolePanel;
	
	public Frame() {
		getContentPane().setLayout(null);
		this.setSize(800, 605);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		textEditorPanel = new textEditorView();
		textEditorPanel.setBounds(0, 0, 800, 300);
		textEditorPanel.setVisible(true);
		textEditorPanel.setEnabled(true);
		getContentPane().add(textEditorPanel);
		
		consolePanel = new consoleView();
		consolePanel.setBounds(0, 305, 800, 300);
		consolePanel.setVisible(true);
		consolePanel.setEnabled(true);
		getContentPane().add(consolePanel);
	}
}
