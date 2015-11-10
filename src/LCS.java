
// Author: Evan Glazer

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LCS {
	static Scanner sc;
	static StringBuffer lcs = new StringBuffer();
	
	public static String lcs(String x, String y) 
	{
		// var for check
		int c1 = 0, c2=0;
				
	 	// Simple base case...
	 	if (x.length() == 0 || y.length() == 0) 
	 		return "LCS Legnth: " + lcs.length() + "\tLCS: " + lcs.toString(); 
	 	
	 	// Make Graph
	 	int[][] lcsGraph = new int[x.length()+1][y.length()+1];
	 	
	 	for(int i = x.length()-1; i>=0; i--)
	 	{
	 		for(int j = y.length() -1; j >=0; j--)
	 		{
	 			// if the char are equal then add one to current max
	 			if(x.charAt(i) == y.charAt(j))
	 				lcsGraph[i][j]= lcsGraph[i+1][j+1]+1;
	 			else
	 				// get max from diagonal
	 				lcsGraph[i][j] = Math.max(lcsGraph[i+1][j], lcsGraph[i][j+1]);
 		}
	 	}
	 	
	 	// now we go through characters to get string that match so we can output
	 	while(c1<x.length() && c2<y.length())
	 	{
	 		// if char are the same then append
	 		if(x.charAt(c1) == y.charAt(c2))
	 		{
	 			lcs.append(x.charAt(c1));
	 			c1++; c2++;
	 		}
	 		// else check if left side is greater than right increment sides
	 		else if(lcsGraph[c1+1][c2] >= lcsGraph[c1][c2+1])
	 			c1++;
	 		else
	 			c2++;
	 	}
	 	// return lcs
	    return "LCS Legnth: " + stringCount(lcs.toString()) + "\tLCS: " + lcs.toString(); 
	}

	public static int stringCount(String s)
	{
		int word = 0;
		for(int i=0; i< s.length(); i++)
		{
			if(s.charAt(i) == ' ')
				word++;
		}
		return word;
	}

	public static void main(String [] args) 
	{
		sc = new Scanner(System.in);
		int numTimes = sc.nextInt();
		// run through depending on input of num times
		for(int i=0; i<numTimes; i++)
		{
			lcs(sc.next(), sc.next());
		}
	}
}
	