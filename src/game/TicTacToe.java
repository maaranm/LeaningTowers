package game;

public class TicTacToe implements Grid{
	int [][] moves = new int[3][3];
	boolean twoPlayer;
	boolean cpuMove;
	int moveCounter;
	public TicTacToe(boolean twoPlayer){
		moveCounter = 0;
		cpuMove = false;
		this.twoPlayer = twoPlayer;
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				moves[i][j] = 0;
			}
		}
	}
	
	public boolean isPlayerOne(){
		if(twoPlayer){
			if((moveCounter%2) != 0)
				return true;
			else
				return false;
		}
		else{
			if(cpuMove)
				return false;
			else
				return true;
		}
	}
	@Override
	public boolean newMove(int x, int y, int playerNum){
		if(playerNum == 0)
			moves[x][y] = 2;
		else if(playerNum == 1)
			moves[x][y] = 1;
		else
			moves[x][y] = 2;
		moveCounter++;
		if((x > 0 && x < 3) && (y > 0 && y < 3))
			return true;
		else
			return false;
	}
	@Override
	public boolean check(int playerNum){
		for(int i = 0; i < 3; i++){
			if(moves[i][0] == moves[i][1] && moves[i][2] == moves[i][0] && moves[i][0] == playerNum) //checks for vertical wins
				return true;
		}
		for(int i = 0; i < 3; i++){
			if(moves[0][i] == moves[1][i] && moves[2][i] == moves[0][i] && moves[0][i] == playerNum) //checks for horizontal wins
				return true;
		}
		
		if(moves[0][0] == moves[1][1] && moves[2][2] == moves[0][0] && moves[0][0] == playerNum) //checks for one diagonal win
			return true;
		
		if(moves[0][2] == moves[1][1] && moves[0][2] == moves[2][0] && moves[0][2] == playerNum) //checks for other diagonal win
			return true;
		
		return false;
	}

	@Override
	public char[][] getGameBoard() {
		char[][] game = new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(moves[i][j] == 0)
					game[i][j] = 'N';
				else if(moves[i][j] == 1)
					game[i][j] = 'X';
				else
					game[i][j] = 'O';
			}
		}
		return game;
	}
}
