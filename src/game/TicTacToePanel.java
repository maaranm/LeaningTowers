package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//implements the actual running of the tictactoe class
public class TicTacToePanel extends JPanel implements ActionListener{
	Game exampleOfDownCasting = new TicTacToe(true);
	TicTacToe game; //game object
	boolean winner;
	String playerName;
	boolean tie;
	boolean quit;
	Boxes[][] places = new Boxes[3][3]; //array of modified JButtons
	char[][] board; 
	int counter;
	boolean alreadyDisplaying;
	JLabel winLabel;
	GridLayout layout; //layout object for the JPanel
	
	public TicTacToePanel(boolean twoPlayer){
		System.out.println(((TicTacToe)(exampleOfDownCasting)).check(1));
		quit = false;
		winner = false;
		winLabel = new JLabel();
		alreadyDisplaying = false;
		game = new TicTacToe(twoPlayer); //initializes the object
		counter = 0;
		setBackground(Color.white);
		layout = new GridLayout(3,3); //gridLayout's are the best because they do everything for you
		setLayout(layout);
		//iterates through the array of Boxes
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				places[i][j] = new Boxes(i+j); //new box
				places[i][j].addActionListener(this); //to actually make clicking the button return something
				places[i][j].setActionCommand("button" + j + i); //what clicking the button will return
				places[i][j].setBackground(Color.white); //set's the button's colour 
				add(places[i][j]); //adds the box to the JPanel
			}
		}
	}
	//implements all the actual logic
	public void run(){
		repaint(); //repaint the panel everytime this is called
		board = game.getGameBoard();
		if(!alreadyDisplaying){//check if it has already displayed the message
			if(game.check(1)){//if player one wins
				playerName = "Player One";
				winner = true;
				removeAll(); //removes the boxes from the JPanel so that it is empty
				alreadyDisplaying = true;
				//winLabel.setFont(new Font("Maaran", Font.BOLD, 80));
			}
			if(game.check(2)){ //same thing as for player one only difference is that playerName is changed to Player Two
				setLayout(layout);
				playerName = "Player Two";
				winner = true;
				alreadyDisplaying = true;
				removeAll();
			}
		}
		if(counter >= 9 && !winner){ //Tie condition
			tie = true;
			removeAll(); //remove all from JPanel
		}
		
		revalidate(); //without this it was not displaying the text it drew in paintComponent
//		for(int i = 0; i<3; i++){
//			for(int j  = 0; j<3; j++){
//				System.out.print(board[i][j]+"   ");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);//drawing colour is black
		g.setFont(new Font("Maaran", Font.BOLD, 60)); //custom font
		if(winner){//if the game was won it draws a string saying who the winner was...
			g.drawString(playerName + " Wins", 50, 300);
			g.setFont(new Font("Maaran", Font.BOLD, 20));
			g.drawString("Taking you to the Main Menu", 50, 500); //displays taking you back to the main menu before it actually does
			quit = true;
		}
		if(tie){ //if tie condition is true
			g.drawString("You Both Suck", 100, 200); //if you tied you're pretty trash 
			g.setFont(new Font("Maaran", Font.BOLD, 20));
			g.drawString("Taking you to the Main Menu", 50, 500);
			quit = true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { //button action listener
//		System.out.println(e.getActionCommand());
		int y = e.getActionCommand().charAt(6) -48; //converts the action event to a meaningful event (look at ASCII table)
		int x = e.getActionCommand().charAt(7) -48; //same as for y
//		System.out.println(x +" "+ y);
		if(places[x][y].getValue() == 'N') //if the button has not been pressed yet
		{
			//depending on which player pressed the button it becomes either X or O
			if(game.isPlayerOne()){
				places[x][y].setValue('X');
				places[x][y].setFont(new Font("Maaran", Font.BOLD, 80)); //new font
				places[x][y].setForeground(Color.red); //text colour is red
				places[x][y].setText(Character.toString('X'));
				game.newMove(x, y, 2); //Keeps track of the moves in the tictactoe class objects
			}
			else{
				places[x][y].setValue('O');
				places[x][y].setFont(new Font("Maaran", Font.BOLD, 80)); //new font
				places[x][y].setForeground(Color.blue); //text is blue
				places[x][y].setText(Character.toString('O'));
				game.newMove(x, y, 1); //keeps track of the moves in the tictactoe class object
			}
			counter++; //used for tie determination or not
		}
	}
}
