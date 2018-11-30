package org.thecodeinnovator.sudoku.primitives;

import java.io.IOException;

import org.thecodeinnovator.sudoku.console.ErrorPrinter;
import org.thecodeinnovator.sudoku.console.InfoPrinter;
import org.thecodeinnovator.sudoku.reader.GridReader;

public class Grid {
	public Integer[][] grid;
	public Integer dimension;
	public boolean validExtension;
	public ErrorPrinter err;
	public InfoPrinter info;
	public Integer order;
	public Grid(Integer inputDimension) {
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		this.grid = new Integer[inputDimension][inputDimension];
		this.dimension = inputDimension;
		this.parseOrder();
	}
	public Grid(Integer[][] inputMatrix) {
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		this.grid = inputMatrix;
		this.dimension = inputMatrix.length;
		this.parseOrder();
	}
	public Grid(String filePath) throws IOException {
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		String fileExtension = filePath.split("\\.")[1];
		if (fileExtension.equals(new String("txt"))) {
			textParser(filePath);
			this.validExtension = true;
			this.parseOrder();
		}
		else if (fileExtension.equals(new String("json"))) {
			jsonParser(filePath);
			this.validExtension = true;
		}
		else {
			this.validExtension = false;
		}
	}
	public void textParser(String filePath) throws IOException {
		// info.setInformation(
		// 	new String(
		// 		"PROBLEM TEXT FILE PATH -> " + filePath
		// 	)
		// );
		// info.putInformation();
		GridReader reader;
		reader = new GridReader(filePath);
		this.setGrid(reader.getIntegerMatrix());
		this.dimension = reader.getIntegerDimension();
	}
	public void jsonParser(String filePath) throws IOException {
		info.setInformation(
			new String(
				"the file is a format which will be supported in future releases."
			)
		);
		info.putInformation();
	}
	public int[][] getPrimitiveMatrix() {
		int[][] gridArray = new int[this.grid.length][this.grid.length];
		for (int rowIterator = 0; rowIterator < this.grid.length; rowIterator++) {
			for (int columnIterator = 0; columnIterator < this.grid.length; columnIterator++) {
				gridArray[rowIterator][columnIterator] = this.grid[rowIterator][columnIterator];
			}
		}
		return gridArray;
	}
	public String getGridString() {
		String resultString = new String("");
		for (int rowIterator = 0; rowIterator < this.grid.length; rowIterator++) {
			for (int columnIterator = 0; columnIterator < this.grid.length; columnIterator++) {
				resultString += this.grid[rowIterator][columnIterator] + "";
				resultString += "\t";
			}
			resultString += "\n";
		}
		return resultString;
	}
	public Integer getDimension() {
		return this.dimension;
	}
	public void setDimension(Integer inputDimension) {
		this.dimension = inputDimension;
	}
	public Integer[][] getGrid() {
		return this.grid;
	}
	public void setGrid(Integer[][] inputGrid) {
		this.grid = inputGrid;
	}
	public Integer getOrder() {
		return this.order;
	}
	public void setOrder(Integer inputOrder) {
		this.order = inputOrder;
	}
	public void parseOrder() {
		this.order = Integer.parseInt(
            String.format(
                "%.0f",
                Math.sqrt(
                    Double.parseDouble(
                        this.dimension +
                        ""
                    )
                )
            )
        );
	}
}
