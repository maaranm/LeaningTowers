package game;

import java.util.Scanner;
//used to actually run the minesweeper game
public class MineSweeperPanel {
	//Declare variables for class wide use
	boolean [][] clicked; //to keep track of what to display 
	boolean quit; //constantly checked by Main to see whether it should exit or not
	int xMove, yMove;
	char moveType;
	MineSweeper gameInfo;
	Game game;
	Scanner userIn;
	boolean displayed;
	public MineSweeperPanel(){
		quit = false;
		game = (MineSweeper)game; //downcast!!!!!
		clicked = new boolean[20][20]; //20 by 20 because that is the size of the mine sweeper panel
		for(int i = 0; i<20; i++){ //iterate through elements
			for(int j = 0; j<20; j++){
				clicked[i][j] = false;
			}
		}
		displayed = false;
		System.out.println("Please note that the top right corner of the grid is 0 x 0 and the grid is 19 x 19");
		System.out.println("There are 25 bombs on the field");
		System.out.println("E stands for empty");
		gameInfo = new MineSweeper(); //minesweeper object
		userIn = new Scanner(System.in); //scanner object
	}
	
	public void run(){ //constantly called by Main class
		if(!gameInfo.dead && !gameInfo.check(0)){ //if the game is still in regular state
			//calls a variety of game functions
			drawPlayerBoard(); 
			getMove();
			clicked[xMove][yMove] = true; //set the current tile to clicked
			int typeOfMove = (moveType == 'F')? 0:1; //use ternary operator to determine what kind of move it is
			gameInfo.newMove(xMove, yMove, typeOfMove); //set new move
		}
		else if(!displayed && gameInfo.dead){ //if you clicked a bomb draw the game board one last time
			drawPlayerBoard();
			System.out.println("Waa Waa You Lost... You're bad");
			displayed = true;
			System.out.println("Taking you back to the main menu now!");
			quit = true;
		}
		else if(!displayed){ //if you won (Very unlikely) draws the game board one last time
			drawPlayerBoard();
			System.out.println("YAYYYY! You Won!");
			displayed = true;
			System.out.println("Taking you back to the main menu now!");
			quit = true;
		}
	}
	
	public void drawPlayerBoard(){ //used to draw the gameBoard which contains the players moves
		char[][] playerMoves = gameInfo.getPlayerMove(); //local char array
		for(int i = 0; i<20; i++){//iterate through the array elements
			for(int j = 0; j<20; j++){
				if(!clicked[i][j])
					System.out.print(" _ ");
				else
					System.out.print(" "+gameInfo.playerMoves[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}
	//simple function for prompting users for proper inputs
	public void getMove(){
		System.out.println("What is your move?");
		do{
			System.out.println("Please enter a valid x coordinate:");
			xMove = userIn.nextInt();
		}while(xMove > 19 || xMove < 0);
		
		do{
			System.out.println("Please enter a valid y coordinate:");
			yMove = userIn.nextInt();
		}while(yMove > 19 || yMove < 0);
		
		do{
			System.out.println("Please enter a valid move type (either flag [F] or uncover [U])");
			moveType = userIn.next().charAt(0);
		}while(moveType != 'F' && moveType != 'U');
	}
}
