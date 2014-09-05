You are already aware of Karan's fondness for even numbers. Since you have helped him out in the past, he again reaches out to you for help.

He has a very long list of numbers, but this time, the numbers are in a space separated format. All you need to do is to print the even numbers from the list, one per line. The list ends when -1 is encountered.

Input: The list.

Output: Print even numbers from the list, one per line.

Constraints: -1 <= i <= 10^18

Sample Input (Plaintext Link)
1 3 4 7 9 6 -1
Sample Output (Plaintext Link)
4
6


import java.util.Scanner;
class KaranEven {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		while(n != -1)
		{
			if(n%2 == 0)
				System.out.println(n);
			n = in.nextLong();
		}
	}
}
