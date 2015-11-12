import java.util.*;

// Author: Evan Glazer

public class lcss {
		static Scanner sc;
		static String[] yList;
		static String[] xList;
		static String[] lcss;
		static int len; 
		public lcss(String y, String x)
		{
			this.yList = y.split(" ");
			this.xList = x.split(" ");
			lcs();
		}
		
		public void lcs()
		{
			int yAxis = yList.length + 1;
			int xAxis = xList.length + 1;
			int[][] graph = new int[yAxis][xAxis];
			
			// takes care of lcs graph
			for(int y=1; y<yAxis; y++)
			{
				for(int x=1; x<xAxis; x++)
				{
					if(yList[y-1].equals(xList[x-1]))
					{
						graph[y][x] = graph[y-1][x-1] +1;
					}
					else
					{
						graph[y][x] = Math.max(graph[y-1][x], graph[y][x-1]);
					}
						
				}
			}
			// local variables
			len = graph[yAxis-1][xAxis-1];
			lcss = new String[len];
			
			int tempLen = len-1;
			int tempY = yAxis-1;
			int tempX = xAxis-1;
			
                        // word check
			while(graph[tempY][tempX]!=0)
			{
				if(graph[tempY][tempX] != graph[tempY-1][tempX] && graph[tempY][tempX] != graph[tempY][tempX-1])
				{	
					tempY--;
					tempX--;
					lcss[tempLen--]=yList[tempY];
				}	
				else if(graph[tempY][tempX] == graph[tempY-1][tempX])
				{
					tempY--;
				}	
				else if(graph[tempY][tempX] == graph[tempY][tempX-1])
				{
					tempX--;
			    }
				
			}
			
		}
                
            @Override
            // to string ovverride to print out stuff
            public String toString()
            {  
                String s = "";
                for(int i=0; i<lcss.length; i++)
                {
                   s += lcss[i] + " ";
                }
                return "LCSS Length = " + lcss.length +". " +"LCSS = " + s + ".";
            }
	    public static void main(String [] args) {
	        sc = new Scanner(System.in);
	        
	        int num = Integer.parseInt(sc.nextLine().replaceAll("\\s+", " "));
	        lcss list[] = new lcss[num];
                for(int i=0; i<num; i++)
	        {
		        String y = sc.nextLine();
		        String x = sc.nextLine();
		        lcss temp = new lcss(y,x);
                        list[i] = temp;
	        }
	        for(int i=0; i<list.length; i++)
	        {
	        	System.out.println(list[i].toString());
	        }
	    }
	}

