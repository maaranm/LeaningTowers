package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	SquarePiece square = new SquarePiece();
	public GamePanel(){
	}
	
	public void run(){
		repaint();
		square.updatePos(0);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.drawRect(200, square.curPosY, 100, 100);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		if(key == 'a'){
			square.updatePos(-1);
		}
		else if(key == 'd'){
			square.updatePos(1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}