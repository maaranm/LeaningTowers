package game;

import java.awt.Point;

import constants.GameConstants;

public class SquarePiece extends Pieces{
	public SquarePiece(){
		super();
		corners = new Point[4];
	}
	
	@Override
	public int updateRotation() {
		return 0;
	}

	@Override
	public Point[] boundaries() {
		return corners;
	}
}
