package org.thecodeinnovator.sudoku;

import java.io.IOException;

import org.thecodeinnovator.sudoku.console.InfoPrinter;
import org.thecodeinnovator.sudoku.primitives.Grid;

public class App {
	public static InfoPrinter info;
	public static Grid puzzle;
    public static void main(String[] args) throws IOException {
		info = new InfoPrinter(System.out);
		puzzle = new Grid(args[0]);
		info.setInformation("PATH -> " + args[0]);
		info.putInformation();
		puzzle.printOrder();
		puzzle.printDimension();
		puzzle.printGrid();
    }
}
