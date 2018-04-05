import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		ArrayList<Integer> list = new ArrayList<Integer>(n);
		for(int i = 1; i < n+1; i++) {
			list.add(i+1);
		}
		
		permutations(list, new HashSet<Integer>(), n, 0);
	}

	public static void permutations(ArrayList<Integer> list, HashSet<Integer> used, int n, int index) {
		if(index == n) {
			for(int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i < n+1; i++) {
			if(used.contains(i)) {
				continue;
			}
			used.add(i);
			list.set(index, i);
			permutations(list, used, n, index+1);
			used.remove(i);
		}
	}
}
