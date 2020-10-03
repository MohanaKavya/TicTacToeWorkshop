package com.capgemini.workshop.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {		

	public static void main(String[] args) {
		//variables
		char computer = ' ';
		
		TicTacToeGame game = new TicTacToeGame();
		char [] board = game.createBoard();
		char userChoice = game.chooseUserLetter();
		
		// Assigning Letter to Computer
		if(userChoice == 'X')
			computer = 'O';
		else
			computer = 'X';
	}

	// Create Board and Assign Empty Spaces
	private char[] createBoard() {
		char [] board = new char[10];
		for(int i=1; i<10; i++)
			board[i] = ' ';
		return board;
	}
	// Selection of Letter by User 
	private char chooseUserLetter()
	{	Scanner sc = new Scanner(System.in);
		System.out.println("Choose Your Letter X or O");
		char userChoice = sc.next().charAt(0);
		return userChoice;
	}
}
