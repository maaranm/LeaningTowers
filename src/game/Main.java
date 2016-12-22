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
	public static boolean playTic, playMine;
	public static void main(String[] args){
		int gameChoice = 0;
		JFrame frame = new JFrame("Maaran's kool games");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		Scanner sc = new Scanner(System.in);
		while(true){
			try { // used to add temp delay
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.setVisible(false);
			System.out.println("Hello there, welcome to Maaran's awesome game machine!");
			System.out.println("You have two options for games 1: Tic Tac Toe or 2: Mine Sweeper");
			System.out.println("Which would you like to play?");
			do{
				System.out.println("Please enter 1 or 2");
				gameChoice = sc.nextInt();
			}while((gameChoice > 2 || gameChoice <1));
		
			if(gameChoice == 1){
				TicTacToePanel ticTacGamePanel= new TicTacToePanel(true);
				frame.add(ticTacGamePanel, BorderLayout.CENTER);
		
				frame.setSize(600, 600);
				frame.setVisible(true);
				while(!ticTacGamePanel.quit){
					ticTacGamePanel.run();
				}
			}
			else{
				MineSweeperPanel mineSweeperGame = new MineSweeperPanel();
			
				while(!mineSweeperGame.quit){
					mineSweeperGame.run();
				}
			}
		}
	}
}
