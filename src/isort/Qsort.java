package isort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.omg.CORBA.portable.OutputStream;
public class Qsort {
	static int [] buffer ;
	static long exe_time = System.currentTimeMillis();
	static int total_time;
	static String time;
	public static void main(String[] args) { // Main function: Just calls different functions to perform different operations. 
		String inputfl=args[0];
		int arr[] =loadFile(inputfl);
		int result[]=quicksort(arr, 0, arr.length-1);
		long end_time = System.currentTimeMillis();
		total_time = (int)(end_time - exe_time);
		time = Integer.toString(total_time);	
		printfile(result);
	}// END of Main function

	public static void printfile(int x[] ) // Prints the sorted output to a file named "answer.txt".
	{
		try
		{
			String length_1 = Integer.toString(x.length);
			BufferedWriter fileout = null;
			fileout = new BufferedWriter(new FileWriter("answer.txt"));

			for(int i =0;i<x.length;i++){
				if(i==x.length-1)
					fileout.write(x[i]+" ");
				else
					fileout.write(x[i]+";");
			}


			fileout.newLine();
			fileout.write("performance analysis:");
			fileout.newLine();
			fileout.write("Size      ");
			fileout.write("Sorting time(in milliseconds)");
			fileout.newLine();
			fileout.write(length_1);	
			fileout.write("         ");
			fileout.write(time);
			fileout.close();
		}
		catch(Exception e)
		{
			System.err.println("ERROR:" + e.getMessage() );
			System.exit(1);
		}
	} // END of printfile function
	/* --------------------------------------------------------------------------------*/
	public static int[] quicksort(int[] arr, int low, int high) // This function performs the basic insertion sort
	{
		int i = low;
		int j = high;
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quicksort(arr, low, j);

		if (high > i)
			quicksort(arr, i, high);
		return arr;	
	} // END of quicksort function
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



