package org.thecodeinnovator.sudoku.ui;

import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class LauncherFrame extends JFrame {
	private static final long serialVersionUID = -1030975280557107294L;
	public JMenuBar menuBar;
	public MainMenu mainMenu;
	public LauncherFrame() {
		setVisible(true);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.menuBar = new JMenuBar();
		menuBar.add(constructFileMenu());
		menuBar.add(constructOpenMenu());
		menuBar.add(constructHelpMenu());
		setJMenuBar(this.menuBar);
		this.mainMenu = new MainMenu();
		setLayout(new GridLayout(3, 3));
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
		add(this.mainMenu);
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
		add(new JPanel().add(new JLabel(" ")));
	}
	public JMenu constructFileMenu() {
		JMenu file;
		JMenuItem newGame;
		JMenuItem loadGame;
		JMenuItem saveGame;
		JMenuItem exit;
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		newGame = new JMenuItem("New Game", KeyEvent.VK_N);
		newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		loadGame = new JMenuItem("Load Game", KeyEvent.VK_L);
		loadGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		saveGame = new JMenuItem("Save Game", KeyEvent.VK_S);
		saveGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		exit = new JMenuItem("Exit", KeyEvent.VK_X);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		file.add(newGame);
		file.add(loadGame);
		file.add(saveGame);
		file.add(exit);
		return file;
	}
	public JMenu constructOpenMenu() {
		JMenu open;
		JMenuItem openJSON;
		JMenuItem openTXT;
		JMenuItem openSQL;
		open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_O);
		openJSON = new JMenuItem("Open JSON", KeyEvent.VK_J);
		openJSON.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		openTXT = new JMenuItem("Open Text", KeyEvent.VK_T);
		openTXT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		openSQL = new JMenuItem("Open SQL", KeyEvent.VK_Q);
		openSQL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		open.add(openJSON);
		open.add(openTXT);
		open.add(openSQL);
		return open;
	}
	public JMenu constructHelpMenu() {
		JMenu help;
		JMenuItem releaseNotes;
		JMenuItem howToPlay;
		JMenuItem about;
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		releaseNotes = new JMenuItem("Release Notes", KeyEvent.VK_N);
		releaseNotes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		howToPlay = new JMenuItem("How To Play", KeyEvent.VK_P);
		howToPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		about = new JMenuItem("About", KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		help.add(releaseNotes);
		help.add(howToPlay);
		help.add(about);
		return help;
	}
}
