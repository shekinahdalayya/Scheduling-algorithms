//http://campuscoke.blogspot.my/2015/01/shortest-remaining-time-first-srtf-cpu.html
//This code has been modified
package main;
import java.io.*;

class SJF{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//number of processes
		int n;
		
		System.out.println("Please enter the number of Processes: ");
		n = Integer.parseInt(br.readLine());
		
		int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
		
		System.out.println("Please enter the Burst Time");
		for(int i = 1; i <= n; i++)
		{
			System.out.println("Process " + i + ": ");
			proc[i][1] = Integer.parseInt(br.readLine());
		}
		
		System.out.println("Please enter the Arrival Time");
		for(int i = 1; i <= n; i++)
		{
			System.out.println("Process " + i + " with burst time " + proc[i][1]+": ");
			proc[i][0] = Integer.parseInt(br.readLine());
		}
		System.out.println();

		//Calculation of Total Time
		int total_time = 0;
		for(int i = 1; i <= n; i++)
		{
			total_time += proc[i][1];
		}

		for(int i = 0; i < total_time; i++)
		{
			//Selection of shortest process which has arrived
			int sel_proc = 0;
			int min = 99999;
			for(int j = 1; j <= n; j++)
			{
				if(proc[j][0] <= i)//Condition to check if Process has arrived
				{
					if(proc[j][1] < min && proc[j][1] != 0)
					{
						min = proc[j][1];
						sel_proc = j;
					}
				}
			}


			//Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
			proc[sel_proc][1]--;

			//WT and TT Calculation
			for(int j = 1; j <= n; j++)
			{
				if(proc[j][0] <= i)
				{
					if(proc[j][1] != 0)
					{
						proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
						if(j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
							proc[j][2]++;
					}
					else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
						proc[j][3]++;
				}
			}


		}
		System.out.println();
		System.out.println();

		//Printing the WT and TT for each Process
		System.out.println("Process\t Arrival Time \t Waiting Time \t Turnaround Time ");
		for(int i = 1; i <= n; i++)
		{
			System.out.printf(i+ "\t\t"+ proc[i][0]+ "\t\t" + proc[i][2] + "\t\t" + proc[i][3]);
			System.out.println();
		}

		System.out.println();

		//Printing the average WT & TT
		float WT = 0,TT = 0;
		for(int i = 1; i <= n; i++)
		{
			WT += proc[i][2];
			TT += proc[i][3];
		}
		WT /= n;
		TT /= n;
		System.out.println("The Average Waiting Time is: " + WT);
		System.out.println("The Average Turnaround Time is: " + TT);
	}

}