package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//used in TicTacToePanel
public class Boxes extends JButton{ //adds onto the properties of a JButton
	boolean pressed; 
	char value;
	JButton button;
	public Boxes(int num){
		//creates a JButton
		pressed = false;
		value = 'N';
		button = new JButton("Button" + num);
		button.setBackground(Color.CYAN);
		repaint();
	}
	
	public void setValue(char val){ //Also stores a char (either X, O or N)
		value = val;
		repaint();
	}
	
	public char getValue(){ //getter method for value
		return value;
	}
	
}
