package game;

import java.awt.Color;

import javax.swing.JFrame;

import constants.GameConstants;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("LeaningTowers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel game = new GamePanel();
		frame.setSize(GameConstants.width, GameConstants.height);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		frame.setContentPane(game);
		game.addKeyListener(game);
		game.requestFocus();		
		while(true){
			game.run();
		}
	}

}
