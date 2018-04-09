import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Combinatinos {

	public static void main(String[] args) {
		InputReader sc = new InputReader();
		
		int n = sc.readInt();		
		int k = sc.readInt();		
		
		findCombos(n, 1, 0, new int[k]);
	}

	public static void findCombos(int maxNum, int start, int index, int[] arr) {
		
		if(index == arr.length) {
			for(int f : arr) {
				System.out.print(f + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < maxNum+1; i++) {
			arr[index] = i;
			findCombos(maxNum, i+1, index+1, arr);
		}
		
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