import java.util.Scanner;

public class HorsePath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int[][] board = new int[n][n];
		int jumps = n*n;
		int jump = 1;
		int row = 0;
		int col = 0;
		board[row][col] = jump++;
		jumps--;
		
		while(jumps >0) {
			if(row-2 > -1 && col-1 > -1 ) {
				if(board[row-2][col-1] == 0) {
					board[row-2][col-1] = jump++;
					row -= 2;
					col -= 1;
					jumps--;
					continue;
				}
			}
			if(row-2 > -1 && col+1 < n) {
				if(board[row-2][col+1] == 0) {
					board[row-2][col+1] = jump++;
					row -= 2;
					col += 1;
					jumps--;
					continue;
				}
			}
			if(row-1 > -1 && col-2 > -1) {
				if(board[row-1][col-2] == 0) {
					board[row-1][col-2] = jump++;
					row -= 1;
					col -= 2;
					jumps--;
					continue;
				}
			}
			if(row-1 > -1 && col+2 < n) {
				if(board[row-1][col+2] == 0) {
					board[row-1][col+2] = jump++;
					row -= 1;
					col += 2;
					jumps--;
					continue;
				}
			}
			if(row+1 < n && col-2 > -1) {
				if(board[row+1][col-2] == 0) {
					board[row+1][col-2] = jump++;
					row += 1;
					col -= 2;
					jumps--;
					continue;					
				}
			}
			if(row+1 < n && col+2 < n) {
				if(board[row+1][col+2] == 0) {
					board[row+1][col+2] = jump++;
					row += 1;
					col += 2;
					jumps--;
					continue;
				}
			}
			if(row+2 < n && col-1 > -1) {
				if(board[row+2][col-1] == 0) {
					board[row+2][col-1] = jump++;
					row += 2;
					col -= 1;
					jumps--;
					continue;
				}
			}
			if(row+2 < n && col+1 < n) {
				if(board[row+2][col+1] == 0) {
					board[row+2][col+1] = jump++;
					row += 2;
					col += 1;
					jumps--;
					continue;
				}
			}
			boolean found = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == 0) {
						row = i;
						col = j;
						found = true;
						break;
					}
					
				}
				if(found) {
					board[row][col] = jump++;
					jumps--;
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
