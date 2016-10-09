package isort;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
public class Isort {
static int [] buffer ;

	public static void main(String[] args) { // Main function: Just calls different functions to perform different operations. 
		String inputfl= args[0];
		int arr[] =loadFile(inputfl);
		int result[]=insertionsort(arr);
		printfile(result);
	}// END of Main function

	public static void printfile(int x[] ) // Prints the sorted output to a file named "answer.txt".
	{
		try
		{
			//Writing data to output file
			FileOutputStream fileout = new FileOutputStream("answer.txt");
			PrintStream result = new PrintStream(fileout);	
			if (x.length >= 1)
			{
				result.print(x[0]);
			}

			//  i starts at 1, as we have already printed the element at index x=0
			for (int i = 1; i < x.length; i++)
			{ 
				result.print("; " + x[i]);
			}
			result.close();
		}
		catch(Exception e)
		{
			System.err.println("ERROR:" + e.getMessage() );
			System.exit(1);
		}
	} // END of printfile function
	/* --------------------------------------------------------------------------------*/
	public static int[] insertionsort(int[] arr) // This function performs the basic insertion sort
	{
		for (int i = 1; i < arr.length; i++)
		{
			int j = i; 
			while (j > 0 && arr[j] < arr[j - 1]) // Setting conditions for swapping.
			{
				int temp = arr[j - 1]; // Swapping values using a temp variable.
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		return arr;
	} // END of insertionsort function
	/* --------------------------------------------------------------------------------*/

	public static int [] loadFile( String t) // This function take the data from the input file 
	//stores it in an integer array and returns it for next function 
	{
		try
		{
			//Reading the data from input text file
			FileInputStream filestream =
					new FileInputStream(t);
			DataInputStream input = new DataInputStream(filestream);
			BufferedReader bf = 
					new BufferedReader( new InputStreamReader (input) );
			String s = bf.readLine();
			String[] val2 = s.split(";");
			int count=	val2.length;
			buffer = new int[count];
			
			//Storing the values in an integer array.
			for(int p =0;p<count;p++)
			{
				int  buf1 = Integer.parseInt(val2[p]);
				buffer[p] = buf1;
			}
			input.close();
		}

		catch(Exception e)
		{
			System.err.println("ERROR:" + e.getMessage() );
		}
		return buffer;
	} //END of loadFile function
}
/* --------------------------------------------------------------------------------*/



