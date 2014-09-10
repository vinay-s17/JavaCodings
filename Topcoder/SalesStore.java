import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 8/30/2014
 * <br />Time: 9:57 PM
 */

public class SalesStore implements Serializable
{
	private List<String> input = new ArrayList<>();
	
	// Main Process of application as required
	public void process()
	{
		double[] p = new double[]{0,0,0,0,0};
		double[] d = new double[]{0,0,0,0,0};
		double[] g = new double[]{0,0,0,0,0};
		double[] s = new double[]{0,0,0,0,0};
		int counter = 0;		
		
		while(counter < input.size())
		{
			String[] elem = input.get(counter++).split(" ");
			if(elem[0].equals("P"))
			{
				p[(Integer.parseInt(elem[1])-1)] =p[2] + Double.parseDouble(elem[2]);
			}
			else if(elem[0].equals("D"))
			{
				d[(Integer.parseInt(elem[1])-1)] =d[2] + Double.parseDouble(elem[2]);
			}
			else if(elem[0].equals("G"))
			{
				g[(Integer.parseInt(elem[1])-1)] =g[2] + Double.parseDouble(elem[2]);
			}
			else 
			{
				s[(Integer.parseInt(elem[1])-1)] =s[2] + Double.parseDouble(elem[2]);
			}
			counter++;
		}
		System.out.println("\t"+ " P" + "" + "\t" +" D" +"\t" + " G" +"\t" + " S" +"\t" + "Product Total");
		
		double[] tot = new double[]{0,0,0,0};
		tot[0] = p[0]+p[1]+p[2]+p[3]+p[4];
		tot[1] = d[0]+d[1]+d[2]+d[3]+d[4];
		tot[2] = g[0]+g[1]+g[2]+g[3]+g[4];
		tot[3] = s[0]+s[1]+s[2]+s[3]+s[4];
	
		double totalAmunt = 0;
		for(int i=0;i<5;i++)
		{
			double total = p[i]+d[i]+g[i]+s[i];
			totalAmunt +=total;
			System.out.println((i+1) + "\t"+ p[i]+ "\t"+d[i] + "\t" + g[i] + "\t" + s[i] + "\t" + total);
		}
		 DecimalFormat df = new DecimalFormat(".00");
		System.out.println("Totals" +"\t" + df.format(tot[0]) + "\t" +df.format(tot[1]) +"\t" +df.format(tot[2]) +"\t" + df.format(tot[3]) +"\t" + df.format(totalAmunt));
		
		if(tot[0] > tot[1] && tot[0] > tot[2] && tot[0] > tot[3])
			System.out.println("\nSales Person of the Month: " +"P with total of $" +df.format(tot[0]) );
		else if(tot[1] > tot[0] && tot[1] > tot[2] && tot[1] > tot[3])
			System.out.println("\nSales Person of the Month: " +"D with total of $" +df.format(tot[1] ));
		else if(tot[2] > tot[1] && tot[2] > tot[1] && tot[2] > tot[3])
			System.out.println("\nSales Person of the Month: " +"G with total of $" +df.format(tot[0]) );
		else
			System.out.println("\nSales Person of the Month: " +"S with total of sales of $" +df.format(tot[0]) );
		
	}
	
	// ******** Set the path and file name in u Sys correctly and encode here ! ! !
	// Read from a file at a single instance and
	// Store it to a List of String.
	// For better processing from local variable.
	public void ReadFromFile() throws IOException 
	{
		BufferedReader br = null;
		try 
		{
			System.out.println("Catherine StringFellow" +"\n" + "Program 1\n");
			br = new BufferedReader(new FileReader("D:\\CS2prog1.txt"));
			for(String line; (line = br.readLine()) != null; )
				input.add(line);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
				br.close();
		}
	}

	public static void main(String args[]) 
	{
		SalesStore obj=new SalesStore();
		try 
		{
			obj.ReadFromFile();
			obj.process();			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}