package org.thecodeinnovator.sudoku.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GridReader {
	public String filePath;
	public ArrayList<String> stringsArrayList;
	public Integer dimension;
	public Integer[][] gridIntegerMatrix;
	public GridReader(String inputFilePathString) throws IOException {
		this.filePath = inputFilePathString;
		this.dimension = this.findDimension();
		this.populateIntegerMatrix();
	}
	public Integer findDimension() throws IOException {
		this.populateStringsArrayList();
		ArrayList<Integer> lengthArrayList = new ArrayList<Integer>();
		for (String stringElement : this.stringsArrayList) {
			int elementLength = stringElement.split(",").length;
			if (elementLength == this.stringsArrayList.size()) {
				lengthArrayList.add(elementLength);
			}
		}
		return (this.stringsArrayList.size() == lengthArrayList.size()) ? this.stringsArrayList.size() : 0;
	}
	public int[][] getPrimitiveMatrix() {
		int[][] gridArray = new int[this.dimension][this.dimension];
		for (int rowIterator = 0; rowIterator < this.dimension; rowIterator++) {
			for (int columnIterator = 0; columnIterator < this.dimension; columnIterator++) {
				gridArray[rowIterator][columnIterator] = this.gridIntegerMatrix[rowIterator][columnIterator];
			}
		}
		return gridArray;
	}
	public void populateIntegerMatrix() {
		this.gridIntegerMatrix = new Integer[this.dimension][this.dimension];
		for (int lineIndex = 0; lineIndex < this.dimension; lineIndex++) {
			String[] elementArray = this.stringsArrayList.get(lineIndex).split(",");
			for (int lineContentIndex = 0; lineContentIndex < this.dimension; lineContentIndex++) {
				this.gridIntegerMatrix[lineIndex][lineContentIndex] = Integer.parseInt(elementArray[lineContentIndex]);
			}
		}
	}
	public void populateStringsArrayList() throws IOException {
		this.stringsArrayList = new ArrayList<String>();
		File inputFile = new File(this.filePath);
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader contentReader = new BufferedReader(fileReader);
		String line = new String("");
		while ((line = contentReader.readLine()) != null) {
			stringsArrayList.add(line);
		}
		contentReader.close();
	}
	public Integer[][] getIntegerMatrix() {
		return this.gridIntegerMatrix;
	}
	public Integer getIntegerDimension() {
		return this.dimension;
	}
}
