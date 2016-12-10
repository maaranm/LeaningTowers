package game;

import java.awt.Point;

public abstract class Pieces {
	int curPosX, curPosY, curRotation;
	Point[] corners;
	public static boolean finished;
	public Pieces(){
		curPosX = 200;
		curPosY = 0;
		curRotation = 0;
		finished = false;
	}
	public Pieces(int x, int y){
		curPosX = x;
		curPosY = y;
		curRotation = 0;
		finished = false;
	}
	public void updatePos(int x){
		curPosX+=x;
		if(curPosY<500 && !finished){
			curPosY++;
		}
		else{
			finished = true;
		}
	}
	
	public int getX(){
		return curPosX;
	}
	
	public int getY(){
		return curPosY;
	}
	
	public abstract int updateRotation();
	
	public abstract Point[] boundaries();
	
	public int getRotation(){
		return curRotation;
	}
}
