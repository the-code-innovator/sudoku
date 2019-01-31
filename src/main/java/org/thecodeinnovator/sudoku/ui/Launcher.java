package org.thecodeinnovator.sudoku.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class Launcher extends JApplet implements ActionListener {
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
		} catch (InvocationTargetException ite) {
			System.out.print(ite.getMessage());
		}
		catch (InterruptedException ie) {
			System.out.print(ie.getMessage());
		}
	}
	public void createGUI() {
		this.setLayout(this.layout);
		setSize(800, 800);
		this.add(this.launcherFrame);
	}
	public void actionPerformed(ActionEvent ae) {
	}
}
