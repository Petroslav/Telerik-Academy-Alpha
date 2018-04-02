import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Subset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int s = sc.nextInt();
		sc.nextLine();
		
		String line = sc.nextLine();
		sc.close();
		String[] numz = line.split(" ");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(String num : numz) {
			int numb = Integer.parseInt(num);
			nums.add(numb);
		}
		
		if(nums.contains(s)) {
			System.out.println("yes");
			System.exit(0);
		}
		HashSet<Integer> contains = new HashSet<>();
		Collections.sort(nums);
		
		int sum = 0;
		int index = 0;
		
		
		for(int i = 0; i < nums.size(); i++) {
			if(i == index || index >= nums.size() || i < 0) continue;
			sum += nums.get(i);
			contains.add(nums.get(i));
			if(sum > s) {
				sum -= nums.get(i);
				sum -= nums.get(i-1);
				contains.remove(nums.get(i));
				contains.remove(nums.get(i-1));
				int test = s - sum;
				if( i > 0 && nums.contains(test) && !contains.contains(test)) {
				    sum += test;
				    break;
				}
				sum = 0;
				contains.clear();
				index++;
				i = -1;
			}
			if(sum == s) {
				break;
			}
		}
		
		if(sum != s) {
			System.out.println("no");
		}else {
			System.out.println("yes");
		}
	}
}