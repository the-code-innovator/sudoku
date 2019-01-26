#!/bin/bash

# compiling the project
mvn compile

# packaging the project
mvn package

# executing the project by passing a file in as command line argument
# java -jar target/SudokuSolver-1.0.jar misc/sudoku-comma.txt

# executing the jar as an app
java -jar target/SudokuSolver-1.0.jar
echo ""
echo "-------- EOF --------"
