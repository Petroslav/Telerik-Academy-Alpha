import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JoroTheRabbit {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		
		ArrayList<Integer> terrain = new ArrayList<Integer>();
		String[] test = line.split(", ");
		for(String cell : test) {
			terrain.add(Integer.parseInt(cell));
		}
		
		int maxCount = 0;
		int curCount = 1;
		int step = 1;
		int startPos = 0;
		int pos = startPos;
		int nextPos = 0;
		
		while(true) {
			while(true) {
				int num = terrain.get(pos);
				nextPos = pos + step;
				if(nextPos > terrain.size()-1) {
					nextPos = nextPos - terrain.size();
				}
				pos = nextPos;
				int nextNum = terrain.get(nextPos);
				if(nextNum > num) {
					curCount++;
				}else {
					break;
				}
			}
			if(curCount > maxCount) {
				maxCount = curCount;
			}
			curCount = 1;
			step++;
			if(step == terrain.size()) {
				startPos++;
				step = 1;
				if(startPos == terrain.size()) {
					break;
				}
			}
			
			pos = startPos;
		}
		
		System.out.println(maxCount);
	}
}