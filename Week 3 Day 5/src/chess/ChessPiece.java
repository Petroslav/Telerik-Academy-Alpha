 package chess;

public class ChessPiece {

	private int rowPos;
	private int colPos;
	
	private Player owner;
	
	public ChessPiece(int row, int col) {
		rowPos = row;
		colPos = col;
	}
	
	public void move(int rowPos, int colPos) {
		this.rowPos = rowPos;
		this.colPos = colPos;
	}

	public int getRowPos() {
		return rowPos;
	}

	public int getColPos() {
		return colPos;
	}
	
	
	
	
}
