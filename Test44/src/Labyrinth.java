
public class Labyrinth {

	
	public static void main(String[] args) {
		char[][] labyrinth = {
				{'0','x','0','0','0','x','x','x','x','x'},
				{'0','x','0','0','0','0','E','0','0','x'},
				{'0','x','0','x','x','x','x','0','0','x'},
				{'0','0','0','x','0','0','x','0','x','x'},
				{'x','0','0','x','x','0','0','0','0','x'},
				{'x','0','0','0','0','E','x','0','0','x'}
		};
		
		if(foundPath(labyrinth, 0, 0, false)) {
			System.out.println("yes");;
		}else {
			System.out.println("no");
		}
	}
	
	public static boolean foundPath(char[][] labyrinth, int x, int y, boolean found) {
		if(found) {
			return found;
		}
		
		if( x < 0 || y < 0 || x >= labyrinth.length || y >= labyrinth[x].length) {
			found = false;
			return found;
		}
		if(labyrinth[x][y] == 'x') {
			found = false;
			return found;
		}
		
		if(labyrinth[x][y] == 'E') {
			found = true;
			System.out.println("Yes, E is at " + x + ", " + y );
			return found;
		}
		
		if(labyrinth[x][y] == '0') {
			labyrinth[x][y] = 'c';
			found = foundPath(labyrinth, x+1, y, found);
			found = foundPath(labyrinth, x, y+1, found);
			found = foundPath(labyrinth, x, y-1, found);
			found = foundPath(labyrinth, x-1, y, found);
			labyrinth[x][y] = '0';
		}
		
		
		return found;
	}
}
