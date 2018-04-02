import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Scanner;

public class LongesSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = reader.read();
		ArrayList<Integer> nums = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++) {
			nums.add(reader.read());
		}
		reader.close();
		
		short tempSeq = 1;
		short maxSeq = 1;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n-1; j++) {
				if(nums.get(j) < nums.get(j+1)) {
					tempSeq++;
				}else {
					break;
				}
			}
			if(tempSeq > maxSeq) {
				maxSeq = tempSeq;
			}
			tempSeq = 1;
		}
		
		System.out.println(maxSeq);
	}
}
