package game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{
	public static boolean playTic, playMine; //static variables for which game will be played
	public static void main(String[] args){
		int gameChoice = 0; //game type
		JFrame frame = new JFrame("Maaran's kool games"); //JFrame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //default close
		frame.setLayout(new BorderLayout()); //simplest frame layout
		Scanner sc = new Scanner(System.in); //scanner object for user input
		while(true){
			try { //thread.sleep requires a try catch or a throws statement
				Thread.sleep(1000); //use to delay slightly between the game and coming back to the main menu
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.setVisible(false); //when coming back from a game set the frame to not visible
			System.out.println("Hello there, welcome to Maaran's awesome game machine!");
			System.out.println("You have two options for games 1: Tic Tac Toe or 2: Mine Sweeper");
			System.out.println("Which would you like to play?");
			do{ //prompts user for valid input of a game choice
				System.out.println("Please enter 1 or 2");
				gameChoice = sc.nextInt();
			}while((gameChoice > 2 || gameChoice <1));
		
			if(gameChoice == 1){//if it's tictactoe
				TicTacToePanel ticTacGamePanel= new TicTacToePanel(true); //create a gamePanel object
				frame.add(ticTacGamePanel, BorderLayout.CENTER); //add the panel to the frame
		
				frame.setSize(600, 600); //set the frame size to 600,600
				frame.setVisible(true); //display the frame
				while(!ticTacGamePanel.quit){ //while the variable quit is not true
					ticTacGamePanel.run(); //run the game
				}
			}
			else{ //if it's minesweeper
				MineSweeperPanel mineSweeperGame = new MineSweeperPanel(); //create minesweeper object
			
				while(!mineSweeperGame.quit){ //while the variable quit is not true
					mineSweeperGame.run(); //run the game
				}
			}
		}
	}
}
