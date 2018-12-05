package org.thecodeinnovator.sudoku.charset;

import java.util.ArrayList;

import org.thecodeinnovator.sudoku.console.ErrorPrinter;
import org.thecodeinnovator.sudoku.console.InfoPrinter;

public class CharSet {
	public ArrayList<Character> symbols;
	public Integer order;
	public ErrorPrinter err;
	public InfoPrinter info;
	public CharSet() {
		this.order = 3;
		this.symbols = this.getCharSet(this.order);
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		this.info.setInformation(new String("CharSet -> " + this.stringifyCharSet(this.symbols)));
		this.info.putInformation();
	}
	public CharSet(Integer order) {
		this.order = order;
		this.err = new ErrorPrinter(System.out);
		this.info = new InfoPrinter(System.out);
		if (this.order >= 1 && this.order <= 6) {
			this.symbols = this.getCharSet(this.order);
			this.info.setInformation(new String("CharSet -> " + this.stringifyCharSet(this.symbols)));
			this.info.putInformation();
		}
		else {
			this.err.setError(new String("the order is invalid !"));
			this.err.putError();
		}
	}
	public ArrayList<Character> getCharSet(Integer inputOrder) {
		ArrayList<Character> constructedCharSet = new ArrayList<Character>();
		constructedCharSet.add(new Character('-'));
		switch (inputOrder) {
			case 3:
			for (Character iterator = '1'; iterator <= '9'; iterator++) {
				constructedCharSet.add(iterator);
			}
			break;
		}
		return constructedCharSet;
	}
	public String stringifyCharSet(ArrayList<Character> inputCharSet) {
		String stringifiedCharSet = new String();
		StringBuilder builder = new StringBuilder();
		Integer charSetLength = inputCharSet.size() - 1;
		builder.append("[");
		for (Character charInList : inputCharSet) {
			builder.append((char)charInList);
			if (charSetLength > 0) {
				builder.append(",");
				charSetLength--;
			}
		}
		builder.append("]");
		stringifiedCharSet = builder.toString();
		return stringifiedCharSet;
	}
	public ArrayList<Character> getInputCharSet(ArrayList<Character> inputCharSet) {
		ArrayList<Character> entryCharSet = inputCharSet;
		Character index0 = entryCharSet.remove(0);
		this.info.setInformation(new String("Removed -> " + index0));
		this.info.putInformation();
		return entryCharSet;
	}
}
