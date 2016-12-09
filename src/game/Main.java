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
		frame.setBackground(Color.gray);
		frame.setContentPane(game);
		frame.addKeyListener(new GamePanel());
		
		while(true){
			game.run();
		}
	}

}
