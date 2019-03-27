
Project Description: In this project, I've implemented the minimax algorithm to play the classic game, TicTacToe against a human opponent. The project consists of a Board.java class, a Move.java class and a driver class called TicTacToe.java where the actual program execution begins. 

Dependencies: The following commands can be used to compile these programs on a Linux OS. 

Compilation: a) Board.java - This is a class that is used to represent each configuration of the TicTacToe Board. To compile this class, run the following terminal command: "javac Board.java"
	     
	     b) Move.java - This is a class that is used to represent a move(and associated score) on the TicTacToe board. To compile this class, run the following terminal command: "javac Move.java"

	     c) TicTacToe.java - This is a driver program that represents the actual TicTacToe game. One can ignore all the above commands by running the following terminal commands: "javac   					 TicTacToe.java" followed by "java TicTacToe" 

Note: All the files can be compiled together (on the condition that they're stored in the same directory). Simply run the following two commands in terminal: "javac *.java" followed by "java TicTacToe"

Input format: The user will be prompted to enter his/her move on the board(the human always gets the "X" symbol) in row major order where the top left of the board is position 1 and the bottom right is 	      position 9. 

Output format: Once the user has made his/her move, the program will print the new board. After the minimax algorithm finds and makes a move, the new board will be printed again at which point the user is 	       expected to enter his/her next move. This will continue until the game is over. 



