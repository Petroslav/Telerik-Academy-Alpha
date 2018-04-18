package chess;

public class Pawn extends ChessPiece {

	public Pawn(int row, int col) {
		super(row, col);
	}

	@Override
	public void move(int rowPos, int colPos) {
		if(moveIsValid(rowPos, colPos)) {
			super.move(rowPos, colPos);
		}
	}

	private boolean moveIsValid(int rowPos, int colPos) {
		if(rowPos != this.getRowPos() && colPos != this.getColPos()) {
			return false;
		}
		if(rowPos > this.getRowPos() + 1 || rowPos < this.getRowPos() - 1 || colPos > this.getColPos() + 1 || colPos < this.getColPos() - 1) {
			return false;
		}
		return true;
	}

}
