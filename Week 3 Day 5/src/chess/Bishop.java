package chess;

public class Bishop extends ChessPiece {

	public Bishop(int row, int col) {
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
		
		if(row == this.getRowPos() || this.getColPos() == col) {
			return false;
		}
		
		int biggerRow = row > this.getRowPos() ? row : this.getRowPos();
		int smallerRow = row < biggerRow ? row : this.getRowPos();
		int biggerCol = col > this.getColPos() ? col : this.getColPos();
		int smallerCol = col < biggerCol ? col : this.getColPos();
		
		if((biggerRow - smallerRow) == (biggerCol - smallerCol)) {
			return true;
		}
		
		return false;
	}
}
