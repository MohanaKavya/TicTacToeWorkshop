package com.capgemini.workshop.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {	
	// Constants
	private final static int TAIL = 0;
	private final static int HEAD = 1;
	// Variables
	private static char computer;
	private static char[] board;
	private static char userChoice;

	public static void main(String[] args) {	
		board = createBoard();
		userChoice = chooseUserLetter();	
		// Assigning Letter to Computer
		if(userChoice == 'X')
			computer = 'O';
		else
			computer = 'X';
		
		int gameToss = toss();
		chooseFirstPlayer(gameToss);
	}
	// Choose The First Player
	private static void chooseFirstPlayer(int gameToss) {
		if(gameToss == HEAD) {
			System.out.println("User Plays First");
			gameVerdict(gameToss);
		}
		if(gameToss == TAIL) {
			System.out.println("Computer Plays First");
			gameVerdict(gameToss);
		}
	}
	// Game Verdict Winner, Tie, Next Move
	private static void gameVerdict(int gameToss) {
		
		if(gameToss == HEAD) {
			makeMove(board, userChoice);
		}
		else if(gameToss == TAIL) {
			makeMove(board, computer);
		}
		
		if((board[1]==board[2] && board[2]==board[3] && board[1]!=' ') || (board[4]==board[5] && board[5]==board[6] && board[6]!=' ') || (board[7]==board[8] && board[8]==board[9] && board[9]!=' ') 
				|| (board[1]==board[4] && board[4]==board[7] && board[7]!=' ') || (board[2]==board[5] && board[5]==board[8] && board[8]!=' ') || (board[3]==board[6] && board[6]==board[9] && board[9]!=' ') ||
				(board[1]==board[5] && board[5]==board[9] && board[9]!=' ') || (board[3]==board[5] && board[5]==board[7] && board[7]!=' ')) {
			if(gameToss==HEAD)
				System.out.println("Winner is User");
			if(gameToss==TAIL)
				System.out.println("Winner is Computer");
			System.exit(0);
		}
		else { if(board[1]!=' ' && board[2]!=' ' && board[3]!=' ' && board[4]!=' ' &&
				board[5]!=' ' && board[6]!=' ' && board[7]!=' ' && board[8]!=' ' && board[9]!=' ') {
			System.out.println("Tie");
			System.exit(0);
		}
		else {
			if(gameToss == HEAD) {
				gameToss--;
				gameVerdict(gameToss);
			}
			else if(gameToss == TAIL) {
				gameToss++;
				gameVerdict(gameToss);
			}
		}
		}
	}
	// Toss of Head & Tail. Head - User, Tail - Computer
	private static int toss() {
		int gameToss = (int)(Math.floor(Math.random()*10)%2);
		return gameToss;		
	}
	//Make Move on Board
	private static void makeMove(char[] board, char Choice) {
		boolean empty = false;
		if(Choice==userChoice) {
		int position = userSelectIndex(board);
		board[position] = Choice;
		}
		else {
		do {
		int position = (int)(Math.floor((Math.random()*10)%9)+1);
		empty = isSpaceFree(board, position);
		if(empty)
			board[position] = Choice;	
		}while(empty==false);
		}
		showBoard(board);
	}
	// Select Index for Player
	private static int userSelectIndex(char[] board) {
		Scanner sc = new Scanner(System.in);
		boolean available = false;
		int position = 0;
		Integer [] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		do {
		System.out.println("Choose a Desired Location on Board from 1 to 9 :");
		position = sc.nextInt();
		if(isSpaceFree(board, position) && Arrays.asList(validCells).contains(position)) 
			available = true;
		else
			System.out.println("Invalid Location. Choose from 1 to 9");
		}while(available==false);	
		return position;
	}
	
	public static boolean isSpaceFree(char[] board, int position) {
		return board[position]==' ';
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
		System.out.println("Choose Your User Letter X or O");
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
