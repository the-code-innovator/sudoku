package org.thecodeinnovator.sudoku.console;

import java.io.PrintStream;

public class InfoPrinter {
	private static final String infoPrefix = new String(
		(char)27 + "[32m" +
		"[INFO]" +
		(char)27 + "[m" +
		" :> "
	);
	public PrintStream infoStream;
	public String infoString;
	/**
	 * Constructor for console Output.
	 * Default PrintStream : System.out
	 * Default String : "NULL"
	 */
	public InfoPrinter() {
		this.infoStream = System.out;
		this.infoString = new String(infoPrefix + "NULL");
	}
	/**
	 * Constructor for console Output.
	 * Default PrintStream : System.out
	 * @param string String the information to print to the default PrintStream
	 */
	public InfoPrinter(String string) {
		this.infoStream = System.out;
		this.infoString = new String(infoPrefix + string);
	}
	/**
	 * Constructor for console Output.
	 * @param stream PrintStream the Stream to set for the InfoPrinter
	 */
	public InfoPrinter(PrintStream stream) {
		this.infoStream = stream;
		this.infoString = new String(infoPrefix + "NULL");
	}
	/**
	 * Constructor for console Output.
	 * @param string String the information to print to the PrintStream
	 * @param stream PrintStream the stream to print the infoString to
	 */
	public InfoPrinter(String string, PrintStream stream) {
		this.infoStream = stream;
		this.infoString = new String(infoPrefix + string);
	}
	/**
	 * getStream to get the PrintStream for info.
	 * @return PrintStream the printstream of the InfoPrinter
	 */
	public PrintStream getStream() {
		return this.infoStream;
	}
	/**
	 * setStream to set the stream for information.
	 * @param stream PrintStream the Stream to which set the Info Stream printing task to
	 */
	public void setStream(PrintStream stream) {
		this.infoStream = stream;
	}
	/**
	 * getInformation to get the information string.
	 * @return String the information which is to be printed onto the information stream
	 */
	public String getInformation() {
		return this.infoString;
	}
	/**
	 * setInformation to set the information string.
	 * @param string the String to set for the information string
	 */
	public void setInformation(String string) {
		this.infoString = new String(infoPrefix + string);
	}
	/**
	 * putInformation to print the information string in the PrintStream.
	 */
	public void putInformation() {
		this.infoStream.println(this.infoString);
	}
	/**
	 * setPair to set the infoString and infoStream
	 * @param string the infoString
	 * @param stream the infoStream
	 * @return InfoPrinter with the string and stream set
	 */
	public InfoPrinter setPair(String string, PrintStream stream) {
		return new InfoPrinter(string, stream);
	}
}
