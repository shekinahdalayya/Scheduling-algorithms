package main;
import java.util.Scanner;

import main.FCFS;
import main.Priority;
import main.Round_Robin;
import main.SJF;

public class Process {
	private FCFS fcfs;
	private Priority pri;
	private Round_Robin rr;
	private SJF sjf;
	
	public static void main(String args[]) {
			//n is number of processes
			//at is arrival time
			//bt is burst time
			//wt is waiting time
			//tat is turn around time
			//awt is average waiting time
			//atat is average turn around time
			//p is process
			//pp is process priority
	Scanner s = new Scanner(System.in);
	int x,n,p[],pp[],bt[],wt[],t[], at[],i;
	float awt=0; 
	float atat=0;
	
	System.out.print("Enter the number of process:");
	n = s.nextInt();
	p = new int[n];
	pp = new int[n];
	bt = new int[n];
	wt = new int[n];
	t = new int[n];
	at = new int[n];
	
	System.out.print("\n\t Enter burst time\n");

	for(i=0;i<n;i++)
	{
		System.out.print("\nProcess["+(i+1)+"]:");
		bt[i] = s.nextInt();
		p[i]=i+1;
	}
	
	System.out.println("\n\nEnter Arrival Time"); 
	for(int j=0;j<n;j++) 
	{ 
		System.out.println("Process["+j+"]"); 
		at[j]=s.nextInt(); 
	} 
	System.out.println("\n"); 
	wt[0]=0; 
	
	}
	
	System.out.println("The results for First In First Out");
	FCFS()
	;
	
}
