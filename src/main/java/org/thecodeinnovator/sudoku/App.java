package org.thecodeinnovator.sudoku;

import java.io.IOException;

import org.thecodeinnovator.sudoku.console.ErrorPrinter;
import org.thecodeinnovator.sudoku.console.InfoPrinter;
import org.thecodeinnovator.sudoku.primitives.Grid;
import org.thecodeinnovator.sudoku.solver.Solver;

public class App {
    public static ErrorPrinter err;
    public static InfoPrinter info;
    public static void main(String[] args) throws IOException {
        Grid fileGrid;
        err = new ErrorPrinter(System.out);
        info = new InfoPrinter(System.out);
        fileGrid = new Grid(args[0]);
        info.setInformation(
            new String(
                "FILE PATH -> " +
                args[0]
            )
        );
        info.putInformation();        
        if (fileGrid.validExtension == true && fileGrid.getOrder() == 3) {
            info.setInformation(
                new String(
                    "ORDER -> " +
                    fileGrid.getOrder()
                )
            );
            info.putInformation();
            info.setInformation(
                new String(
                    "DIMENSION -> " +
                    fileGrid.getDimension()
                )
            );
            info.putInformation();
            info.setInformation(
                new String(
                    "PARSED GRID ->\n" +
                    fileGrid.getGridString()
                )
            );
            info.putInformation();
            Solver solver = new Solver(fileGrid);
            if (solver.isSolvable()) {
                fileGrid = solver.getSolvedGrid();
                info.setInformation(
                    new String(
                        "SOVED GRID ->\n" +
                        fileGrid.getGridString()
                    )
                );
                info.putInformation();
            }
            else {
                err.setError(
                    new String(
                        "the sudoku is not solvable !"
                    )
                );
                err.putError();
            }
        }
        else {
            err.setError(
                new String(
                    "the extension doesn't match any of the approved extensions !"
                )
            );
            err.putError();
        }
    }
}
