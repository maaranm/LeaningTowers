package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Boxes extends JButton{
	boolean pressed;
	char value;
	JButton button;
	public Boxes(int num){
		pressed = false;
		value = 'N';
		button = new JButton("Button" + num);
		button.setBackground(Color.CYAN);
		repaint();
	}
	
	public void setValue(char val){
		value = val;
		repaint();
	}
	
	public char getValue(){
		return value;
	}
	
}
