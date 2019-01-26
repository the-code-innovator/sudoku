package org.thecodeinnovator.sudoku.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 6751974838045111028L;
	public JButton newGame;
	public JButton loadGame;
	public JButton howToPlay;
	public JButton settings;
	public JButton exit;
	public MainMenu() {
		setLayout(new GridLayout(5, 1));
		setSize(800, 800);
		setVisible(true);
		this.newGame = new JButton("New Game");
		this.loadGame = new JButton("Load Game");
		this.howToPlay = new JButton("How To Play");
		this.settings = new JButton("Settings");
		this.exit = new JButton("Exit");
		add(this.newGame);
		add(this.loadGame);
		add(this.howToPlay);
		add(this.settings);
		add(this.exit);
	}
}
