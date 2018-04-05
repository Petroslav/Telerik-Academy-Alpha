
public class PracticeTest {

	public static void main(String[] args) {
		char[][] labyrinth = {
				{'x', ' ', ' ', 'x', 'x', 'x', 'x'},
				{'s', ' ', ' ', ' ', ' ', ' ', 'x'},
				{'x', ' ', 'x', 'x', ' ', 'x', 'x'},
				{'x', ' ', ' ', 'x', ' ', ' ', 'x'},
				{'x', 'x', 'x', 'x', 'x', 'e', 'x'},
		};
		boolean path = pathExists(1, 0, labyrinth);
		if(!path) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		 
		
	}
	
	public static boolean inRange(int cur, int max) {
		return 0 <= cur && cur >= max;
	}
	
	public static boolean pathExists(int row, int col, char[][]labyrinth) {
		int rows = labyrinth.length;
		int cols = labyrinth[row].length;
		
		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = {0, 0, -1, 1};
		
		for(int dir = 0; dir < dRow.length; dir++) {
			int nextRow = row+dRow[dir];
			int nextCol = col + dCol[dir];
		
			if(!inRange(nextRow, rows) || !inRange(nextCol, cols)) {
				continue;
			}
			
			if(labyrinth[nextRow][nextCol] == 'x') {
				continue;
			}
			
			if(labyrinth[nextRow][nextCol] == 'e') {
				return true;
			}
			

			labyrinth[nextRow][nextCol] = 'x';
			boolean hasPath = pathExists(nextRow, nextCol, labyrinth);
			labyrinth[nextRow][nextCol] = ' ';
			
			if(hasPath) {
				return true;
			}
		}		
		
		return false;
	}
}
