package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//[5 marks] Read the input one line at a time and output the
// current line if and only if it is not a suffix of some previous line.
// For example, if the some line is "0xdeadbeef" and some subsequent line
// is "beef", then the subsequent line should not be output.

public class Part6 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		List<String> fastList = new ArrayList<String>();
		List<String> fastList2 = new ArrayList<>();
		HashSet<String> finalList = new HashSet<>();
		Boolean isSuffix = false;
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			fastList.add(line);
			fastList2.add(line);
		}
		for (String t : fastList){				//loop List1
			for(String s: fastList2){			//loop List2
				if((t.endsWith(s))&& (t!=s)){	//if a word form L1 ends with word from L2 and their not the same word
					isSuffix = true;
				}
			}
			if(!isSuffix){
				finalList.add(t);
			}else{
				isSuffix = false;
			}
		}

//		for (String m: fastList){
//			if(!(finalList.contains(m))){
//				w.println(m);
//			}
//		}

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
