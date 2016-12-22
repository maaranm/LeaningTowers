package game;

import java.util.Scanner;

public class MineSweeperPanel {
	boolean [][] clicked;
	boolean quit;
	int xMove, yMove;
	char moveType;
	MineSweeper gameInfo;
	Game game;
	Scanner userIn;
	boolean displayed;
	public MineSweeperPanel(){
		quit = false;
		game = (MineSweeper)game; //downcast!!!!!
		clicked = new boolean[20][20];
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				clicked[i][j] = false;
			}
		}
		displayed = false;
		System.out.println("Please note that the top right corner of the grid is 0 x 0 and the grid is 19 x 19");
		System.out.println("There are 25 bombs on the field");
		System.out.println("E stands for empty");
		gameInfo = new MineSweeper();
		userIn = new Scanner(System.in);
	}
	
	public void run(){
		if(!gameInfo.dead){
			drawPlayerBoard();
			getMove();
			clicked[xMove][yMove] = true;
			int typeOfMove = (moveType == 'F')? 0:1;
			gameInfo.newMove(xMove, yMove, typeOfMove);
		}
		else if(!displayed){
			drawPlayerBoard();
			System.out.println("Waa Waa You Lost... You're bad");
			displayed = true;
			System.out.println("Taking you back to the main menu now!");
			quit = true;
		}
	}
	
	public void drawPlayerBoard(){
		char[][] playerMoves = gameInfo.getPlayerMove();
		for(int i = 0; i<20; i++){
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
