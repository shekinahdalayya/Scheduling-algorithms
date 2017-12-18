package main;
import java.util.Scanner;

import main.FCFS;
import main.Priority;
import main.Round_Robin;
import main.SJF;

public class Process {
	
	public static void main(String args[]) {
			//n is number of processes
			//at is arrival time
			//bt is burst time
			//wt is waiting time
			//t is turn around time
			//awt is average waiting time
			//atat is average turn around time
			//p is process
			//pp is process priority
	Scanner s = new Scanner(System.in);
	int n,p[],pp[],bt[],wt[],t[],i;
	float awt=0; 
	float atat=0;
	
	System.out.print("Enter the number of process:");
	n = s.nextInt();
	bt = new int[n];
	wt = new int[n];
	t = new int[n];
	
	System.out.print("\nEnter burst time:\n");

	for(i=0;i<n;i++)
	{
		System.out.print("\nProcess["+(i+1)+"]:");
		bt[i] = s.nextInt();
	//	p[i]=i+1;
	}
	
	System.out.println("\n"); 
	wt[0]=0; 
	
	System.out.println("\nThe results for Priority");
	Priority(n, bt, wt, t);
	
	System.out.println("The results for First In First Out");
	FCFS(n, bt, wt, t);
	
	

	
	
}
	public static void FCFS(int n, int bt[], int wt[], int t[]){
		float awt = 0;
		float atat =0;
		for(int i=1;i<n;i++) 
		{ 
			wt[i]=wt[i-1]+bt[i-1];  
		} 
		for(int i=0;i<n;i++) 
		{ 
			t[i]=wt[i]+bt[i]; 
			awt=awt+wt[i]; 
			
		} 
		System.out.println("process\t\tBurst Time\tWaiting Time\tTurnaround Time");
		for(int i=0;i<n;i++)
		{
			System.out.println("process"+(i+1)+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+t[i]);
		}
		for(int j=0;j<n;j++)
		{
			atat+=t[j];
		}
		System.out.println("Average waiting time:\t\t "+(awt/n)+"\nAverage turn around time:\t"+(atat/n));
		
		
	}
	
	public static void Priority(int n,int bt[], int wt[], int t[]){
		int x;
		float awt=0;
		float atat=0;
		int pp[], p[]; 
		p = new int[n];
		pp = new int[n];
		Scanner s = new Scanner(System.in);
		System.out.println("Enter priority:");
		for(int i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"]:");
			pp[i] = s.nextInt();
			p[i]=i+1;
		}
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(pp[i]<pp[j])
				{
					x=pp[i];
					pp[i]=pp[j];
					pp[j]=x;
					x=bt[i];
					bt[i]=bt[j];
					bt[j]=x;
					x=p[i];
					p[i]=p[j];
					p[j]=x;
				}
			}
		}
		wt[0]=0;
		awt=0;
		t[0]=bt[0];
		atat=t[0];
		for(int i=1;i<n;i++)
		{
			wt[i]=t[i-1]; 
			awt+=wt[i];
			t[i]=wt[i]+bt[i];
			atat+=t[i];
		}
		System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
		for(int i=0;i<n;i++)
		System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+wt[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
		System.out.print("\n Average Wait Time : "+awt/n);
		System.out.print("\n Average Turn Around Time : "+atat/n);
	}
	
	public void display(){
		
	}
}
