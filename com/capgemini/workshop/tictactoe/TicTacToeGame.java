package com.capgemini.workshop.tictactoe;

public class TicTacToeGame {		

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
	}

	// Create Board and Assign Empty Spaces
	private void createBoard() {
		char [] board = new char[10];
		for(int i=1; i<10; i++)
			board[i] = ' ';
	}
}
