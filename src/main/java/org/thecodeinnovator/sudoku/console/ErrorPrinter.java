package org.thecodeinnovator.sudoku.console;

import java.io.PrintStream;

public class ErrorPrinter {
	private static final String errorPrefix = new String(
		(char)27 + "[33m" +
		"[" +
		(char)27 + "[m" +
		(char)27 + "[31m" +
		"ERROR" +
		(char)27 + "[m" +
		" :> "
	);
	public PrintStream errorStream;
	public String errorString;
	/**
	 * Constructor for console Output.
	 * Default PrintStream : System.out
	 * Default String : "NULL"
	 */
	public ErrorPrinter() {
		this.errorStream = System.out;
		this.errorString = "NULL";
	}
	/**
	 * Constructor for console Output.
	 * Default PrintStream : System.out
	 * @param string String the error to print to the default PrintStream
	 */
	public ErrorPrinter(String string) {
		this.errorStream = System.out;
		this.errorString = new String(errorPrefix + string);
	}
	/**
	 * Console for console Output.
	 * @param stream PrintStream the Stream to set for the ErrorPrinter
	 */
	public ErrorPrinter(PrintStream stream) {
		this.errorStream = stream;
		this.errorString = new String(errorPrefix + "NULL");
	}
	/**
	 * Constructor for console Output.
	 * @param string String the errorString to print to the PrintStream
	 * @param stream PrintStream the stream to print the errorString to
	 */
	public ErrorPrinter(String string, PrintStream stream) {
		this.errorStream = stream;
		this.errorString = new String(errorPrefix + string);
	}
	/**
	 * getStream to get the PrintStream for error.
	 * @return PrintStream the printstream of the ErrorPrinter
	 */
	public PrintStream getStream() {
		return this.errorStream;
	}
	/**
	 * setStream to set the stream for error.
	 * @param stream PrintStream the Stream to which set the Error Stream printing task to
	 */
	public void setStream(PrintStream stream) {
		this.errorStream = stream;
	}
	/**
	 * getError to get the error string.
	 * @return String the error which is to be printed onto the error stream
	 */
	public String getError() {
		return this.errorString;
	}
	/**
	 * setError to set the errro string.
	 * @param string the String to set for the error string
	 */
	public void setError(String string) {
		this.errorString = new String(errorPrefix + string);
	}
	/**
	 * putError to print the error string in the PrintStream.
	 */
	public void putError() {
		this.errorStream.println(this.errorString);
	}
}
