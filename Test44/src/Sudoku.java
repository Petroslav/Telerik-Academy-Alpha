import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sudoku {

	private static ArrayList<ArrayList<Integer>> sudoku = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		InputReader sc = new InputReader();
		var s = 3;
		System.out.println(s);
		for(int i = 0; i < 9; i++) {
			sudoku.add(new ArrayList<Integer>());
			for(int j = 0; j < 9; j++) {
				int num = sc.readInt();
				sudoku.get(i).add(num);				
			}
		}

		solveSudoku(0, 0);

		for(ArrayList<Integer> list : sudoku) {
			for(int n : list) {
				System.out.print(n);
			}
			System.out.println();
		}
	}
	
	public static boolean solveSudoku(int startingRow, int startingCell) {
		if(startingRow == 9) {
			return true;
		}
		if(startingCell == 9) {
			return solveSudoku(startingRow + 1, 0);
		}
		ArrayList<Integer> row = sudoku.get(startingRow);
		int num = row.get(startingCell);
		if(num != 0) {
			return solveSudoku(startingRow, startingCell + 1);
		}
		boolean[] possibleNumbers = findPossibleNumbers(startingRow, startingCell);
		
		for(int i = 0; i < 9; i++) {
			if(possibleNumbers[i]) {
				continue;
			}
			
			row.set(startingCell, i+1);
			possibleNumbers[i] = true;
			if(solveSudoku(startingRow, startingCell+1)) {
				return true;
			}
		}
		row.set(startingCell, 0);
		return false;
	}
	
	public static boolean containedInMatrix(int row, int col, int num) {
		if(row < 3) row = 0;
		if(row > 2 && row < 6) row = 3;
		if(row > 5) row = 6;

		if(col < 3) col = 0;
		if(col > 2 && col < 6) col = 3;
		if(col > 5) col = 6;
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if(sudoku.get(i).get(j) == num) return true;
			}
		}
		return false;
	}
	
	public static boolean containedInCol(int num, int col) {
		for(int i = 0; i < 9; i++) {
			if(sudoku.get(i).get(col) == num) return true;
		}
		
		return false;
	}
	
	public static boolean containedInRow(int num, int row) {
		for(int i = 0; i < 9; i++) {
			if(sudoku.get(row).get(i) == num) return true;
		}
		
		return false;
	}
	
	public static boolean[] findPossibleNumbers(int row, int col) {
		boolean[] nums = new boolean[9];
		for(int i = 0; i < 9; i++) {
			if(containedInRow(i+1, row) || containedInCol(i+1, col) || containedInMatrix(row, col, i+1)) {
				nums[i] = true;
			}
		}
		return nums;
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
	           if (c == '-') {
	               return 0;
	           }else {
	        	   return c - '0';
	           }
	       }

	       boolean isSpaceChar(int c) {
	           return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	       }
	   }
}