package org.thecodeinnovator.sudoku.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.thecodeinnovator.sudoku.charset.CharParse;
import org.thecodeinnovator.sudoku.charset.CharSet;
import org.thecodeinnovator.sudoku.console.ErrorPrinter;
import org.thecodeinnovator.sudoku.console.InfoPrinter;

public class GridReader {
	public Integer order;
	public Integer dimension;
	public ArrayList<ArrayList<Character>> matrix;
	public InfoPrinter info;
	public ErrorPrinter err;
	public String filePath;
	private static final String separator = new String(",");
	public GridReader(String filePath) throws IOException {
		this.filePath = new String(filePath);
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		this.matrix = this.parseMatrix(filePath);
	}
	public ArrayList<Character> parseFile(String filePath) throws IOException {
		String extension = this.getFileExtension(filePath);
		ArrayList<Character> list = new ArrayList<Character>();
		if (extension.equals(new String("txt"))) {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
			String line;
			ArrayList<String> strings = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] lineContent = line.split(separator);
				for (int i = 0; i < lineContent.length; i++) {
					strings.add(lineContent[i]);
				}
			}
			for (String i : strings) {
				list.add(CharParse.parseSegment(i));
			}
			reader.close();
		}
		else {
			this.err.setError("INVALID EXTENSION !");
			this.err.putError();
			System.exit(-1);
		}
		boolean validCharacter = true;
		CharSet input = new CharSet();
		ArrayList<Character> validCharacterList = input.getCharSet();
		for (Character listChar : list) {
			if (validCharacterList.contains(listChar) == false) {
				validCharacter = false;
				break;
			}
		}
		if (validCharacter == false) {
			this.err.setError("Invalid Character in File !");
			this.err.putError();
			System.exit(-1);
		}
		return list;
	}
	public Integer parseDimension(String filePath) throws IOException {
		String extension = this.getFileExtension(filePath);
		Integer dimension = new Integer(0);
		if (extension.equals(new String("txt"))) {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
			String line;
			ArrayList<String> strings = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				strings.add(line);
			}
			Integer dimensionX = strings.size();
			Integer dimensionY = new Integer(0);
			for (String i : strings) {
				String[] lineContent = i.split(separator);
				if (new Integer(lineContent.length).equals(dimensionX)) {
					dimensionY += 1;
				}
			}
			dimension = (dimensionX.equals(dimensionY)) ? dimensionX : new Integer(0);
			reader.close();
		}
		else {
			this.err.setError("INVALID EXTENSION !");
			this.err.putError();
			System.exit(-1);
		}
		if (dimension.equals(new Integer(0))) {
			this.err.setError("ZERO DIMENSION !");
			this.err.putError();
			System.exit(-1);
		}
		return dimension;
	}
	public Integer parseOrder(String filePath) throws IOException {
		this.dimension = this.parseDimension(filePath);
		return Integer.parseInt(String.format("%.0f", Math.sqrt(new Double(this.dimension))));
	}
	public ArrayList<ArrayList<Character>> parseMatrix(String filePath) throws IOException {
		ArrayList<Character> input = this.parseFile(filePath);
		ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();
		this.order = parseOrder(filePath);
		for (int i = 0; i < this.dimension; i++) {
			List<Character> listCharacter = input.subList(i * this.dimension, i * this.dimension + 9);
			ArrayList<Character> subList = new ArrayList<Character>();
			for (Character j : listCharacter) {
				subList.add(j);
			}
			matrix.add(subList);
		}
		return matrix;
	}
	public ArrayList<ArrayList<Character>> getMatrix() {
		return this.matrix;
	}
	public Integer getDimension() {
		return this.dimension;
	}
	public Integer getOrder() {
		return this.order;
	}
	public String getFileExtension(String filePath) {
		String[] filePart = filePath.split("\\.");
		return new String(filePart[filePart.length - 1]);
	}
}
