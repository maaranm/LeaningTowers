package game;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuScreen extends JPanel implements ActionListener{
	boolean playMineSweeper, playTicTac;
	public MenuScreen(){
		playMineSweeper = false;
		playTicTac = false;
		GridLayout layout = new GridLayout(3, 3);
		setLayout(layout);
		JButton mineSweeper = new JButton();
		mineSweeper.addActionListener(this);
		mineSweeper.setActionCommand("mineSweeper");
		mineSweeper.setFont(new Font("Maaran", Font.BOLD, 80));
		mineSweeper.setText("Mine Sweeper");

		JButton ticTacToe = new JButton();
		ticTacToe.addActionListener(this);
		ticTacToe.setActionCommand("ticTac");
		ticTacToe.setFont(new Font("Maaran", Font.BOLD, 80));
		ticTacToe.setText("Tic Tac Toe");
		add(mineSweeper);
		add(ticTacToe);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Mine Sweeper")){
			playMineSweeper = true;
		}
		else{
			playTicTac = true;
			System.out.println("Play Tic");
		}
	}
}