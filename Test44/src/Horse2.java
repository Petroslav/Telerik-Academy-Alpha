import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Horse2 {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		int n = reader.readInt();
		int m = reader.readInt();
		
		int[][] field = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < field[0].length; j++) {
				field[i][j] = reader.readInt();
			}
		}
		int max = firstMax(field);
		if(n == 3 && m == 3) System.out.println(max);
		else {
			for(int i = 0; i < field.length-2; i++) {
				int s = 0;
				if(i == 0) s = 1;
				for(int j = s; j < field[i].length-2; j++) {
					int temp = field[i][j] + field[i][j+1] + field[i][j+2];
					temp += field[i+1][j] + field[i+1][j+1] + field[i+1][j+2];
					temp += field[i+2][j] + field[i+2][j+1] + field[i+2][j+2];
					if(temp > max) max = temp;
				}
			}
			System.out.println(max);
		}
	}
	
	public static int firstMax(int[][] field) {
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += field[i][0] + field[i][1] + field[i][2];
		}
		
		return sum;
	}
	
	static class InputReader {
	       private InputStream stream;
	       private byte[] buf = new byte[1024];
	       private int curChar;
	       private int numChars;

	       InputReader() {
	           this.stream = System.in;
	       }

	       int read() {
	           if (numChars == -1)
	               throw new InputMismatchException();
	           if (curChar >= numChars) {
	               curChar = 0;
	               try {
	                   numChars = stream.read(buf);
	               } catch (IOException e) {
	                   throw new InputMismatchException();
	               }
	               if (numChars <= 0)
	                   return -1;
	           }
	           return buf[curChar++];
	       }

	       int readInt() {
	           int c = read();
	           while (isSpaceChar(c)) {
	               c = read();
	           }
	           int sgn = 1;
	           if (c == '-') {
	               sgn = -1;
	               c = read();
	           }
	           int res = 0;
	           do {
	               if (c < '0' || c > '9') {
	                   throw new InputMismatchException();
	               }
	               res *= 10;
	               res += c - '0';
	               c = read();
	           } while (!isSpaceChar(c));
	           return res * sgn;
	       }

	       boolean isSpaceChar(int c) {
	           return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	       }
	   }
}