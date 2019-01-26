package org.thecodeinnovator.sudoku;

import java.io.IOException;

import org.thecodeinnovator.sudoku.ui.Launcher;

public class App {
	// public static InfoPrinter info;
	// public static Grid puzzle;
	// public static Solver solver;
    public static void main(String[] args) throws IOException {
		// info = new InfoPrinter(System.out);
		// puzzle = new Grid(args[0]);
		// // solver = new Solver(puzzle.matrix);
		// info.setInformation("PATH -> " + args[0]);
		// info.putInformation();
		// puzzle.printOrder();
		// puzzle.printDimension();
		// puzzle.printGrid();
		// // solver.printSolvedGrid();
		Launcher launcher = new Launcher();
		launcher.init();
    }
}
