package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class consoleView extends JPanel {
	private static JTextArea textArea;
	private JPanel consolePanel;
	private JLabel consoleLabel;
	private JScrollPane scrollPane;
	
	public consoleView() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBounds(0, 37, 800, 263);
		textArea.setEnabled(false);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 35, 800, 300);
        this.add(scrollPane);
		
		consolePanel = new JPanel();
		consolePanel.setBounds(0, 0, 800, 35);
		consolePanel.setBackground(new Color(0, 100, 0));
		consolePanel.setForeground(new Color(255, 255, 255));
		add(consolePanel);
		consolePanel.setLayout(null);
		
		consoleLabel = new JLabel("Console");
		consoleLabel.setForeground(new Color(255, 255, 255));
		consoleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		consoleLabel.setBounds(10, 11, 117, 14);
		consolePanel.add(consoleLabel);
	}
	
	public static void log(String s) {
		textArea.setText("");
		textArea.setText(s);
	}
}
