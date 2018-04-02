import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MainDiagonal2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[][] matrix = new int[n][n];
		
		for(int i = 0; i < matrix.length; i++) {
			if(i == 0) matrix[i][0] = 1;
			else matrix[i][0] = matrix[i-1][0]*2;
			for(int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][j-1]*2;
			}
		}
		
		int sum = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			if(i == matrix.length-1) break;
			for(int j = i+1; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		
		System.out.println(sum);
		for(int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		
	}
}
