import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {

	public static void getAllPermutations(int index, int n, 
																	HashSet<Integer> used, 
																	ArrayList<Integer> currentPermutation){
		if(index == n) {
			//TODO fix
			return;
		}
		
		for(int value = 1; value < n; value++) {
			if(used.contains(value)) {
				continue;
			}
			
			used.add(value);
			currentPermutation.set(index, value);
			getAllPermutations(index++, n, used, currentPermutation);
			used.remove(value);
		}
	}
}
