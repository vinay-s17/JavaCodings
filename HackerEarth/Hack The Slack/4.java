Karan's mathematics professor has given him a lots of homework. Since he is busy preparing for September Easy Challenge, he needs your help.

Given two numbers, find the sum of prime numbers between them, both inclusive.

Input:

The first line contains the number of test cases T. Each test case contains two space separated integers.

Output:

Print the answer on a new line for each case.

Constraints:

1 <= T <= 100

1 <= a,b < 10^6

Sample Input (Plaintext Link)
1
1 5
Sample Output (Plaintext Link)
10


import java.io.DataInputStream;
import java.io.InputStream;
class KaranPrime1
{ 
		static Parser obj = new Parser(System.in);
		boolean primes[] = new boolean[2];
        int upper;
        int lower;
        public KaranPrime1() throws Exception
        {
        	getBoundaries();
        	primes = new boolean [upper+1];
        	primes[0] = false;
            primes[1] = false;
            for (int i = 2; i < primes.length; i++) {
                primes[i] = true;
            }
            
            processSieve();
            showPrimes();
        }
        
        public void processSieve()
        { 
        	for(int i = 2; (i * i) <= upper; i++ ){
                for (int j = (i * i); j <= upper; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        public void getBoundaries () throws Exception 
        {
        	lower = obj.nextInt();
            upper = obj.nextInt();
        }
 
        public void showPrimes ()
        { 
        	int sum=0;
        	for (int i = lower; i <= upper; i++) {
            if (primes[i] == true) {
                sum +=i;
            }
          }
          System.out.println(sum);
        }
        public static void main(String args[]) throws Exception 
        {
        	//Scanner in = new Scanner(System.in);
        	int testCase = obj.nextInt();
        	
        	KaranPrime1[] objj = new KaranPrime1[testCase];
        	for(int i =0;i<testCase;i++)
        	{
        		objj[i] = new KaranPrime1();
        		objj[i] = null;
        	}
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