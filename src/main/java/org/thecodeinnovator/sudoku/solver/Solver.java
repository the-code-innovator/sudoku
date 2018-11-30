package org.thecodeinnovator.sudoku.solver;

import org.thecodeinnovator.sudoku.primitives.Grid;

public class Solver {
	public Integer[][] solverGrid;
	public Integer dimension;
	public Solver(Grid inputGrid) {
		this.solverGrid = inputGrid.getGrid();
		this.dimension = inputGrid.getDimension();
	}
	public boolean isSolvable() {
		return false;
	}
	public Grid getSolvedGrid() {
		return new Grid(this.solverGrid);
	}
}
