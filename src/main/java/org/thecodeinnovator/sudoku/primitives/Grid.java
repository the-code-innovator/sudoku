package org.thecodeinnovator.sudoku.primitives;

import java.io.IOException;
import java.util.ArrayList;

import org.thecodeinnovator.sudoku.console.ErrorPrinter;
import org.thecodeinnovator.sudoku.console.InfoPrinter;
import org.thecodeinnovator.sudoku.reader.GridReader;

public class Grid {
	public Integer order;
	public ArrayList<ArrayList<Character>> matrix;
	public Integer dimension;
	public InfoPrinter info;
	public ErrorPrinter err;
	public Grid(String filePath) throws IOException {
		this.info = new InfoPrinter(System.out);
		this.err = new ErrorPrinter(System.out);
		GridReader reader = new GridReader(filePath);
		this.dimension = reader.getDimension();
		this.order = reader.getOrder();
		this.matrix = reader.getMatrix();
	}
	public String gridString() {
		String grid = "";
		for (ArrayList<Character> list : this.matrix) {
			grid = new String(grid + "\n");
			for (Character item : list) {
				grid = new String(grid + item + "\t");
			}
		}
		return grid;
	}
	public void printGrid() {
		this.info.setInformation("PUZZLE -> " + this.gridString());
		this.info.putInformation();
	}
	public void printOrder() {
		this.info.setInformation("ORDER -> " + this.order);
		this.info.putInformation();
	}
	public void printDimension() {
		this.info.setInformation("DIMENSION -> " + this.dimension);
		this.info.putInformation();
	}
}
