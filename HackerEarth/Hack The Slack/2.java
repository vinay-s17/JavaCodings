The purpose of this problem is to verify whether the method you are using to read input data is sufficiently fast to handle problems branded with the enormous Input/Output warning. You are expected to be able to process at least 2.5MB of input data per second at runtime.

Karan likes stickers. All his stickers are rectangular in shape. Since he has less space on his laptop, he likes to stick only the stickers whose length is less than 3*10^8 nm. Since he is running short of time, he asks you the number of stickers he will be able to put on his laptop.

Input: The input begins with a positive integer N (N<=10^9). The next line of input contains N space-separated, positive integers, not greater than 10^10 each. Ti is the length of ith sticker in nanometres.

Output: Print the answer.

Note: There is no partial marking in this question. Chances are that you get 0 even when you have passed all the test cases.

Sample Input (Plaintext Link)
2
18 400000000
Sample Output (Plaintext Link)
1


/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 8/25/2014
 * <br />Time: 8:01 PM
 */
import java.io.DataInputStream;
import java.io.InputStream;

class Main {

	Parser parser = new Parser(System.in);

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}

	public void solve() throws Exception
	{
		int n = parser.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (parser.nextInt() < 300000000) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

class Parser {

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Parser(InputStream in) {
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String nextString() throws Exception {
		StringBuffer sb = new StringBuffer("");
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		do {
			sb.append((char) c);
			c = read();
		} while (c > ' ');
		return sb.toString();
	}

	public char nextChar() throws Exception {
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		return (char) c;
	}

	public int nextInt() throws Exception {
		int ret = 0;
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		return ret;
	}

	private void fillBuffer() throws Exception {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1) {
			buffer[0] = -1;
		}
	}

	private byte read() throws Exception {
		if (bufferPointer == bytesRead) {
			fillBuffer();
		}
		return buffer[bufferPointer++];
	}
}