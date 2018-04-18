package chess;

public class Knight extends ChessPiece {

	public Knight(int row, int col) {
		super(row, col);
	}
	
	public void move(int row, int col) {
		if(moveIsValid(row,col)) {
			super.move(row, col);
		}
	}
	
	public boolean moveIsValid(int row, int col) {
		
		if(row < 0 || row > 8) {
			return false;
		}
		
		if(col < 0 || col > 8) {
			return false;
		}
		
		int[] dRow = {2, 2, -2, -2, 1, 1, -1, -1};
		int[] dCol = {1, -1, 1, -1, 2, -2, 2, -2};
		
		for(int i = 0; i < 8; i++) {
			int testRow = this.getRowPos() + dRow[i];
			int testCol = this.getColPos() + dCol[i];
			if(testRow == row && testCol == col) {
				return true;
			}
		}
		return false;
	}

}
