Karan likes even numbers very much. He has a very long list of numbers. You just need to print the even numbers from the list. The list ends when -1 is encountered.

Input: The list.
Output: Print even numbers from the list, one per line.

Constraints: -1 <= i <= 10^9

Sample Input (Plaintext Link)
1
4
-1
Sample Output (Plaintext Link)
4
Time Limit 1 sec(s) 


import java.util.Scanner;
class KaranEven {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n != -1)
		{
			if(n%2 == 0)
				System.out.println(n);
			n= in.nextInt();
		}
	}
}