import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MDg2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
//		int[][] matrix = new int[n][n];		
		BigInteger[][] matrix = new BigInteger[n][n];
		
		for(int i = 0; i < matrix.length; i++) {
			if(i == 0) matrix[i][0] = BigInteger.ONE;
			else matrix[i][0] = matrix[i-1][0].multiply(BigInteger.valueOf(2));
			for(int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][j-1].multiply(BigInteger.valueOf(2));
			}
		}
		
		BigInteger sum = BigInteger.ZERO;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix[i].length; j++) {
				sum = sum.add(matrix[i][j]);
			}
		}
		
		System.out.println(sum);		
	}
}
