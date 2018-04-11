import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Bounce {

    public static void main(String[] args) {
        InputReader sc = new InputReader();

        int rows = sc.readInt();
        int cols = sc.readInt();

        int dRow = +1;
        int dCol = +1;

        int row = 0;
        int col = 0;

        if(rows == 1 || cols == 1){
            System.out.println(1);
            return;
        }
        BigInteger result = BigInteger.ZERO;

        while(true){
            BigInteger value = getCellValue(row, col);
            result = result.add(value);

            col += dCol;
            row += dRow;
            if(row >= rows-1 || row == 0) {
                dRow *= -1;
            }

            if(col >= cols-1 || col == 0) {
                dCol *= -1;
            }

            if((col == 0 && row == 0) || (row == 0 && col == cols -1) || (row == rows-1 && col == 0) || (row == rows-1 && col == cols-1)){
                break;
            }
        }

        result = result.add(getCellValue(row,col));

        System.out.println(result);
    }

    public static BigInteger getCellValue(int row, int col){
        BigInteger two = BigInteger.valueOf(2);
        int power = row + col;
        return two.pow(power);
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
