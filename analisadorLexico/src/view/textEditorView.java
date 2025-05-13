package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.AnaliseLexicaController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class textEditorView extends JPanel implements ActionListener{
	private JMenu runMenu;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JButton abrirButton;
	private JButton novoButton;
	private JButton analiseLexicaButton;
	private JButton analiseSemanticaButton;
	private JTextArea textArea;
	private JButton salvarButton;
	private JButton salvarComoButton;
	private JScrollPane scrollPane;
	
	public textEditorView() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 36);
		menuBar.setBackground(new Color(0, 100, 0));
		menuBar.setForeground(Color.WHITE);
		menuBar.setBorder(BorderFactory.createCompoundBorder());
		add(menuBar);
		
		fileMenu = new JMenu("File");
		fileMenu.setBackground(new Color(0, 100, 0));
		fileMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		fileMenu.setForeground(new Color(255, 255, 255));
		fileMenu.setBorder(BorderFactory.createCompoundBorder());
		fileMenu.setLayout(null);
		menuBar.add(fileMenu);
		
		novoButton = new JButton("Novo                       ");
		novoButton.setForeground(new Color(255, 255, 255));
		novoButton.setBackground(new Color(0, 100, 0));
		novoButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		novoButton.setBorder(BorderFactory.createCompoundBorder());
		novoButton.addActionListener(this);
		fileMenu.add(novoButton);
		
		abrirButton = new JButton("Abrir Ficheiro         ");
		abrirButton.setForeground(new Color(255, 255, 255));
		abrirButton.setBackground(new Color(0, 100, 0));
		abrirButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		abrirButton.setBorder(BorderFactory.createCompoundBorder());
		abrirButton.addActionListener(this);
		fileMenu.add(abrirButton);
		
		salvarButton = new JButton("Salvar                      ");
		salvarButton.setForeground(new Color(255, 255, 255));
		salvarButton.setBackground(new Color(0, 100, 0));
		salvarButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		salvarButton.setBorder(BorderFactory.createCompoundBorder());
		salvarButton.addActionListener(this);
		fileMenu.add(salvarButton);
		
		salvarComoButton = new JButton("Salvar Como           ");
		salvarComoButton.setForeground(new Color(255, 255, 255));
		salvarComoButton.setBackground(new Color(0, 100, 0));
		salvarComoButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		salvarComoButton.setBorder(BorderFactory.createCompoundBorder());
		salvarComoButton.addActionListener(this);
		fileMenu.add(salvarComoButton);
		
		runMenu = new JMenu("Run");
		runMenu.setBackground(new Color(0, 128, 0));
		runMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		runMenu.setForeground(new Color(255, 255, 255));
		runMenu.setBorder(BorderFactory.createCompoundBorder());
		runMenu.setLayout(null);
		menuBar.add(runMenu);
		
		analiseLexicaButton = new JButton("Analise Lexica");
		analiseLexicaButton.setForeground(new Color(255, 255, 255));
		analiseLexicaButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		analiseLexicaButton.setBackground(new Color(0, 100, 0));
		analiseLexicaButton.setBorder(BorderFactory.createCompoundBorder());
		analiseLexicaButton.addActionListener(this);
		runMenu.add(analiseLexicaButton);
		
		analiseSemanticaButton = new JButton("Analise Semantica");
		analiseSemanticaButton.setForeground(new Color(255, 255, 255));
		analiseSemanticaButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		analiseSemanticaButton.setBackground(new Color(0, 100, 0));
		analiseSemanticaButton.setBorder(BorderFactory.createCompoundBorder());
		analiseSemanticaButton.addActionListener(this);
		runMenu.add(analiseSemanticaButton);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 34, 800, 266);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
		textArea.setBorder(BorderFactory.createCompoundBorder());
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 35, 800, 300);
        this.add(scrollPane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==analiseLexicaButton) {
			String s = textArea.getText();
			String analiseLexica = AnaliseLexicaController.lexicalAnalysis(s);
			consoleView.log(analiseLexica);
		}
	}
	
	public void saveTextToFile(String text) {
        String filePath = "files/";
        
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
            System.out.println("Text successfully saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving text to file: " + e.getMessage());
        }
    }
}
