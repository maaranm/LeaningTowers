package game;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("LeaningTowers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel game = new GamePanel();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setBackground(Color.gray);
		frame.setContentPane(game);
		
		while(true){
			game.repaint();
		}
	}

}
