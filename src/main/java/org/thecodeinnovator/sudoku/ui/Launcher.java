package org.thecodeinnovator.sudoku.ui;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class Launcher extends JApplet {
	private static final long serialVersionUID = 7598364342364722277L;
	public BorderLayout layout;
	public LauncherFrame launcherFrame;
	public Launcher() {
		this.layout = new BorderLayout();
		this.launcherFrame = new LauncherFrame();
	}
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					createGUI();
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			System.out.print(e);
		}
	}
	public void createGUI() {
		this.setLayout(this.layout);
		setSize(800, 800);
		this.add(this.launcherFrame);
	}
}
