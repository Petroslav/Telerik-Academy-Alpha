import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class GreedyDwarf {

	public static void main(String[] args) {
		InputReader read = new InputReader();
		
		//n
		int rows = read.readInt();
		//m
		int cols = read.readInt();
		
		int startingRow = 0;
		int startingCol = 0;
		
		int[][] matrix = new int[rows][cols];
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				matrix[row][col] = read.readInt();
				if(matrix[row][col] == 0) {
					startingRow = row;
					startingCol = col;
				}
			}
		}
		
		int coinsCollected = 0;
		
		int[] dRow = {0, 0, -1, 1};
		int[] dCol = {-1, 1, 0, 0};
		
		int rowPos = startingRow;
		int colPos = startingCol;

		int nextRow = 0;
		int nextCol = 0;
		int tempCol = colPos;
		int tempRow = rowPos;
		
		while(true) {
			int max = 0;
			for(int pos = 0; pos < dRow.length; pos++) {
				tempCol = colPos + dCol[pos];
				tempRow = rowPos + dRow[pos];
				if(!validCell(tempRow, tempCol, rows, cols)) {
					continue;
				}
				if(matrix[tempRow][tempCol] > 0 && matrix[tempRow][tempCol] > max ) {
					max = matrix[tempRow][tempCol];
					nextRow = tempRow;
					nextCol = tempCol;
				}
				
			}
			if(max == 0) {
				break;
			}
			colPos = nextCol;
			rowPos = nextRow;
			matrix[rowPos][colPos]--;
			coinsCollected++;
		}
		
		System.out.println(coinsCollected);
		
	}
	
	public static boolean validCell(int row, int col, int rows, int cols) {
		if(row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		return true;
	}
	
	static class InputReader {
	       private InputStream stream;
	       private byte[] buf = new byte[1024];
	       private int curChar;
	       private int numChars;

	       InputReader() {
	           this.stream = System.in;
	       }

	       int read() {
	           if (numChars == -1)
	               throw new InputMismatchException();
	           if (curChar >= numChars) {
	               curChar = 0;
	               try {
	                   numChars = stream.read(buf);
	               } catch (IOException e) {
	                   throw new InputMismatchException();
	               }
	               if (numChars <= 0)
	                   return -1;
	           }
	           return buf[curChar++];
	       }

	       int readInt() {
	           int c = read();
	           while (isSpaceChar(c)) {
	               c = read();
	           }
	           int sgn = 1;
	           if (c == '-') {
	               sgn = -1;
	               c = read();
	           }
	           int res = 0;
	           do {
	               if (c < '0' || c > '9') {
	                   throw new InputMismatchException();
	               }
	               res *= 10;
	               res += c - '0';
	               c = read();
	           } while (!isSpaceChar(c));
	           return res * sgn;
	       }

	       boolean isSpaceChar(int c) {
	           return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	       }
	   }
}
