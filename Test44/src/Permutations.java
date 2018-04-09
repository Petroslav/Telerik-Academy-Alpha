import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int n = 6;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i < n+1; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
		permutations(n, 0, new HashSet<Integer>(), list, perms);
		System.out.println();
		for(ArrayList<Integer> perm : perms) {
			System.out.println(perm);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permutations(int n, int index, HashSet<Integer> used, ArrayList<Integer> permutation,  ArrayList<ArrayList<Integer>> allPerms){
		if(index == n) {
			allPerms.add(new ArrayList<Integer>(permutation));
			return allPerms;
		}
		
		for(int i = 0; i < n; i++) {
			if(used.contains(i)) {
				continue;
			}
			used.add(i);
			permutation.set(index, i+1);
			permutations(n, index+1, used, permutation, allPerms);
			used.remove(i);
		}
		
		return allPerms;
	}
	
//	public static void allCombinations(ArrayList<Integer> nums, int index, ArrayList<Integer> combo) {
//		if(index == )
//	}
	   
}
