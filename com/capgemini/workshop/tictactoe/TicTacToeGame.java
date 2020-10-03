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
		
		game.showBoard(board);
	}

	// Create Board and Assign Empty Spaces
	private char[] createBoard() {
		char [] board = new char[10];
		for(int i=1; i<board.length; i++)
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
	// Show Board
	private void showBoard(char[] board) {
		int k = 1;
		for(int i=0; i<=2;i++) {
			System.out.println("\n_______\n");
			System.out.print("|");
			for(int j=0; j<=2; j++) {
				System.out.print(board[k]+"|");
				k++;
			}
		}
		System.out.println("\n_______");
	}
}
