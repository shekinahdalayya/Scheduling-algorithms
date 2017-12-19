//http://tutorialheap.com/java-program-for-first-come-first-serve-fcfs-scheduling-algorithm/
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
		//tat is turn around time
		//awt is average waiting time
		//atat


		int n,at[],bt[],wt[],tat[], total=0; 
		float awt=0; 
		float atat=0;
		InputStreamReader isr=new InputStreamReader(System.in); 
		BufferedReader br=new BufferedReader(isr); 
		System.out.println("Enter the number of process:");
		n=Integer.parseInt(br.readLine()); 

		wt=new int[n]; 
		tat=new int[n]; 
		bt=new int[n];
		at=new int[n];

		System.out.println("Enter Burst time for each process\n"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.println("Process["+i+"]"); 
			bt[i]=Integer.parseInt(br.readLine()); 
		} 
		System.out.println("\n\nEnter Around Time"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.println("Process["+i+"]"); 
			at[i]=Integer.parseInt(br.readLine()); 
		} 
		System.out.println("\n"); 
		wt[0]=0; 
		for(int i=1;i<n;i++) 
		{ 
			wt[i]=wt[i-1]+bt[i-1]; 
			wt[i]=wt[i]-at[i]; 
		} 
		for(int i=0;i<n;i++) 
		{ 
			tat[i]=wt[i]+bt[i]; 
			awt=awt+wt[i]; 
		} 
		System.out.println(" PROCESS\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("   "+ i + "\t\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		} 
		for(int j=0;j<n;j++)
		{
			total+=tat[j];
		}
		awt=awt/n; 
		atat=(float)total/n;
		System.out.println("\n"); 
		System.out.println("Avg waiting time="+awt+"\n"); 
		System.out.println("Avg turn around time="+atat+"\n");
	} 
} 
