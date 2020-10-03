package com.capgemini.workshop.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {		

	public static void main(String[] args) {
		//variables
		char computer = ' ';
	
		char [] board = createBoard();
		char userChoice = chooseUserLetter();
		
		// Assigning Letter to Computer
		if(userChoice == 'X')
			computer = 'O';
		else
			computer = 'X';
		
		showBoard(board);
		userSelectIndex(board, userChoice);
	}
	// Select Index for Player
	private static void userSelectIndex(char[] board, char userChoice) {
		Scanner sc = new Scanner(System.in);
		boolean available = false;
		do {
		System.out.println("Choose a Desired Location on Board from 1 to 9 :");
		int position = sc.nextInt();
		if(board[position]==' ') {
			board[position] = userChoice;
			available = true;
		}
		else 
			System.out.println("Invalid Position or Position Occupied. Try Again");
		}while(available==false);
		
		showBoard(board);	
	}
		

	// Create Board and Assign Empty Spaces
	private static char[] createBoard() {
		char [] board = new char[10];
		for(int i=1; i<board.length; i++)
			board[i] = ' ';
		return board;
	}
	// Selection of Letter by User 
	private static char chooseUserLetter()
	{	Scanner sc = new Scanner(System.in);
		System.out.println("Choose Your Letter X or O");
		char userChoice = sc.next().charAt(0);
		return userChoice;
	}
	// Show Board
	private static void showBoard(char[] board) {
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
