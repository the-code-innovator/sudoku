package org.thecodeinnovator.sudoku.solver;

import java.util.ArrayList;

import org.thecodeinnovator.sudoku.console.InfoPrinter;

public class Solver {
	public Character[][] inputGrid;
	public ArrayList<ArrayList<Character>> arrayGrid;
	public ArrayList<Character> validCharacters;
	public InfoPrinter info;
	public Integer length;
	public Solver(ArrayList<ArrayList<Character>> inputGrid) {
		this.arrayGrid = inputGrid;
		this.info = new InfoPrinter(System.out);
		this.length = inputGrid.size();
		this.inputGrid = new Character[this.length][this.length];
		for (int i = 0; i < this.length; i++) {
			ArrayList<Character> row = inputGrid.get(i);
			for (int j = 0; j < this.length; j++) {
				Character atIJ = row.get(j);
				this.inputGrid[i][j] = new Character(atIJ);
			}
		}
		// CharSet set = new CharSet();
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
	public void solve() {
		// for (int i = 0; i < this.)
	}
	public void printSolvedGrid() {
		this.info.setInformation("SOLUTION -> " + this.gridString());
		this.info.putInformation();
	}
}
