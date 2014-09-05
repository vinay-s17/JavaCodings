package codechef.june2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] s)
	{
		try
		{
			InputStream inputStream = System.in;
			InputReader in = new InputReader(inputStream);
			PrintWriter writer = new PrintWriter(System.out);

			TaskA solution = new TaskA();
			solution.solve(in,writer);

			writer.close();
			inputStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}

class TaskA
{
	public void solve(InputReader in, PrintWriter out) throws IOException
	{
		int sizeOfString = in.nextInt();
		int tests = in.nextInt();
		char[] input = in.next().toCharArray();

		for (int i=0;i<tests;i++)
		{
			int index = in.nextInt();
			int indexValue = Character.getNumericValue(input[index-1]);
			int result = 0;
			for(int j=0; j<index; j++)
			{

				result += Math.abs(indexValue - Character.getNumericValue(input[j]));
			}
			out.println(result);
		}
	}
}

class InputReader
{
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream)
	{
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next()
	{
		while (tokenizer == null || !tokenizer.hasMoreTokens())
		{
			try
			{
				tokenizer = new StringTokenizer(reader.readLine());
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt()
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}

	public double nextDouble()
	{
		return Double.parseDouble(next());
	}
}
