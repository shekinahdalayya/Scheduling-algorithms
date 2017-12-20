//http://tutorialheap.com/java-program-for-first-come-first-serve-fcfs-scheduling-algorithm/
//This code has been modified
package main;
import java.io.*; 

class FCFS 
{ 

	public static void main(String args[]) throws Exception 
	{ 
		//n is number of processes
		//at is arrival time
		//bt is burst time
		//wt is waiting time
		//tat is turn around/arrival time
		//awt is average waiting time
		//atat is average turnaround time
		//ct is complete time


		int n,at[],bt[],wt[],tat[],ct=0,total=0; 
		float awt=0; 
		float atat=0;

		//in order to read input from keyboard
		InputStreamReader isr=new InputStreamReader(System.in); 
		BufferedReader br=new BufferedReader(isr); 
		System.out.println("Enter the number of process:");
		n=Integer.parseInt(br.readLine()); 

		wt=new int[n]; 
		tat=new int[n]; 
		bt=new int[n];
		at=new int[n];

		
		//Each burst time is stored in bt[]
		System.out.println("Enter Burst time for each process\n"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.println("Process["+i+"]"); 
			bt[i]=Integer.parseInt(br.readLine()); 
		} 
		
		//Each around time is stored in at[]
		System.out.println("\n\nEnter Around Time"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.println("Process["+i+"]"); 
			at[i]=Integer.parseInt(br.readLine()); 
		} 
		
		System.out.println("\n"); 
		
		//Waiting time for the first process is 0
		wt[0]=0;
		
		//Calculation of turnaround time
		for(int i=0;i<n;i++) 
		{ 	
			ct+=bt[i];
			tat[i]=ct-at[i];
		} 
		
		//Calculation of waiting time and total waiting time
		for(int i=1;i<n;i++) 
		{ 
			wt[i]=tat[i]-bt[i];
			awt=awt+wt[i]; 
		} 

		System.out.println(" PROCESS\tARRIVAL TIME\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("   "+ i + "\t\t"+ at[i] + "\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		} 
		
		//calculation of total turnaround time
		for(int j=0;j<n;j++)
		{
			total+=tat[j];
		}
		
		//average of total waiting time and total turnaround time
		awt=awt/n; 
		atat=(float)total/n;
		System.out.println("\n"); 
		System.out.println("Avg waiting time="+awt+"\n"); 
		System.out.println("Avg turn around time="+atat+"\n");
	} 
} 
