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

public class TicTacToePanel extends JPanel implements ActionListener{
	TicTacToe game;
	boolean winner;
	boolean gameRetry;
	String playerName;
	boolean tie;
	boolean quit;
	Boxes[][] places = new Boxes[3][3];
	char[][] board;
	int counter;
	boolean alreadyDisplaying;
	JLabel winLabel;
	GridLayout layout;
	
	public TicTacToePanel(boolean twoPlayer){
		quit = false;
		winner = false;
		winLabel = new JLabel();
		alreadyDisplaying = false;
		boolean gameRetry = false;
		game = new TicTacToe(twoPlayer);
		counter = 0;
		setBackground(Color.white);
		layout = new GridLayout(3,3);
		setLayout(layout);
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				places[i][j] = new Boxes(i+j);
				places[i][j].addActionListener(this);
				places[i][j].setActionCommand("button" + j + i);
				places[i][j].setBackground(Color.white);
				add(places[i][j]);
			}
		}
	}
	
	public void run(){
		repaint();
		board = game.getGameBoard();
		if(!alreadyDisplaying){
			if(game.check(1)){
				playerName = "Player One";
				winner = true;
				removeAll();
				alreadyDisplaying = true;
				//winLabel.setFont(new Font("Maaran", Font.BOLD, 80));
			}
			if(game.check(2)){
				setLayout(layout);
				playerName = "Player Two";
				winner = true;
				alreadyDisplaying = true;
				removeAll();
			}
		}
		if(counter >= 9 && !winner){
			tie = true;
			removeAll();
		}
		
		revalidate();
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
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Maaran", Font.BOLD, 60));
		if(winner){
			g.drawString(playerName + " Wins", 50, 300);
			g.setFont(new Font("Maaran", Font.BOLD, 20));
			g.drawString("Taking you to the Main Menu", 50, 500);
			quit = true;
		}
		if(tie){
			g.drawString("You Both Suck", 100, 200);
			g.setFont(new Font("Maaran", Font.BOLD, 20));
			g.drawString("Taking you to the Main Menu", 50, 500);
			quit = true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		int y = e.getActionCommand().charAt(6) -48;
		int x = e.getActionCommand().charAt(7) -48;
//		System.out.println(x +" "+ y);
		if(places[x][y].getValue() == 'N')
		{
			if(game.isPlayerOne()){
				places[x][y].setValue('X');
				places[x][y].setFont(new Font("Maaran", Font.BOLD, 80));
				places[x][y].setForeground(Color.red);
				places[x][y].setText(Character.toString('X'));
				game.newMove(x, y, 2);
			}
			else{
				places[x][y].setValue('O');
				places[x][y].setFont(new Font("Maaran", Font.BOLD, 80));
				places[x][y].setForeground(Color.blue);
				places[x][y].setText(Character.toString('O'));
				game.newMove(x, y, 1);
			}
			counter++;
		}
	}
}
