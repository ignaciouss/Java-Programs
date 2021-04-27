package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//[5 marks] Read the input one line at a time until you have read all n
// lines and imagine these lines are numbered 0,...,n-1.  Next output
// lines floor(n/2),...,n-1 followed by lines 0,..,.floor(n/2)-1.

public class Part1 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		List<String>  fastList = new ArrayList<String>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			fastList.add(line);
		}
		int halfWay = (int) Math.floor(fastList.size() / 2);
		int totalSize = fastList.size();


		for (int i= halfWay; i<totalSize; i++ ){
			w.println(fastList.get(i));
		}
		for(int j = 0; j<halfWay; j++){
			w.println(fastList.get(j));
		}

	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
