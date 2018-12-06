package org.thecodeinnovator.sudoku.solver;

import java.util.ArrayList;

import org.thecodeinnovator.sudoku.console.InfoPrinter;

public class Solver {
	public Character[][] inputGrid;
	public ArrayList<ArrayList<Character>> arrayGrid;
	public InfoPrinter info;
	public Solver(ArrayList<ArrayList<Character>> inputGrid) {
		this.arrayGrid = inputGrid;
		this.info = new InfoPrinter(System.out);
		int length = inputGrid.size();
		this.inputGrid = new Character[length][length];
		for (int i = 0; i < length; i++) {
			ArrayList<Character> row = inputGrid.get(i);
			for (int j = 0; j < length; j++) {
				Character atIJ = row.get(j);
				this.inputGrid[i][j] = new Character(atIJ);
			}
		}
	}
	public String gridString() {
		String grid = "";
		for (ArrayList<Character> list : this.arrayGrid) {
			grid = new String(grid + "\n");
			for (Character item : list) {
				grid = new String(grid + item + "\t");
			}
		}
		return grid;
	}
	public void printSolvedGrid() {
		this.info.setInformation("PUZZLE -> " + this.gridString());
		this.info.putInformation();
	}
}
