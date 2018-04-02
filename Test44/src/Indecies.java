import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Indecies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		String line = sc.nextLine();
		sc.close();
		String[] nums = line.split(" ");

		ArrayList<Integer> numbers = new ArrayList<>();
		HashSet<Integer> check = new HashSet<>();
		int index = 0;
		boolean cycle = false;
		
		while(index >= 0 && index < nums.length) {
			if(check.contains(index)) {
				cycle = true;
				break;
			}
			numbers.add(index);
			check.add(index);
			index = Integer.parseInt(nums[index]);
		}
		
		StringBuilder toPrint = new StringBuilder("");
		
		if(cycle) {
			for(int i = 0; i < numbers.size(); i++) {
				int num = numbers.get(i);
				if(index == num) {
					toPrint.append("(");
				}else {
					toPrint.append(" ");
				}
				toPrint.append(num);
				if(i == numbers.size()-1) {
					toPrint.append(")");
				}
			}
		}else {
			for(Integer num : numbers) {
				toPrint.append(num + " ");
			}
		}
		
		System.out.println(toPrint.toString().trim());
	}
}