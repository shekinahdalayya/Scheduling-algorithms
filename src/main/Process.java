package main;
import java.util.Scanner;

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
		int n,bt[],btt[],p[],wt[],t[],i;

		System.out.print("Enter the number of process:");
		n = s.nextInt();
		bt = new int[n];
		btt = new int[n];
		wt = new int[n];
		t = new int[n];
		p = new int[n];

		System.out.print("\nEnter burst time:\n");

		for(i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"]:");
			bt[i] = s.nextInt();
			p[i]=i+1;
		}

		wt[0]=0; 
		btt = bt.clone();

		System.out.println("\nThe results for Priority");
		Priority(n, bt, wt, t);

		bt=btt.clone();
		System.out.println("\n\nThe results for Round Robin");
		RoundRobin(n, bt, wt, t);

		bt=btt.clone();
		System.out.println("\n\nThe results for First In First Out");
		FCFS(n, bt, wt, t);

		bt=btt.clone();
		System.out.println("\n\nThe results for Short Job First");
		SJF(n, bt, wt, t, p);



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
		System.out.print("\n\nAverage Waiting Time: "+awt/n);
		System.out.print("\n\nAverage Turn Around Time: "+atat/n);
	}

	public static void RoundRobin(int n,int bt[], int wt[], int t[]){
		int q, sum=0;
		float atat=0;
		float awt=0;
		int a[]=new int[n];
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter time quantum: ");
		q=s.nextInt();
		for(int i=0;i<n;i++)
			a[i]=bt[i];
		for(int i=0;i<n;i++)
			wt[i]=0;
		do
		{
			for(int i=0;i<n;i++)
			{
				if(bt[i]>q)
				{
					bt[i]-=q;
					for(int j=0;j<n;j++)
					{
						if((j!=i)&&(bt[j]!=0))
							wt[j]+=q; 
					}
				}
				else
				{
					for(int j=0;j<n;j++)
					{
						if((j!=i)&&(bt[j]!=0))
							wt[j]+=bt[i];
					}
					bt[i]=0;
				}
			}
			sum=0;
			for(int k=0;k<n;k++)
				sum=sum+bt[k];
		}
		while(sum!=0);
		for(int i=0;i<n;i++)
			t[i]=wt[i]+a[i];
		System.out.print("\n\nProcess \t Burst Time \t Waiting Time \t Turn Around Time\n");
		for(int i=0;i<n;i++){
			System.out.print("\n   "+(i+1)+"\t\t   "+a[i]+"\t\t     "+wt[i]+"\t\t     "+t[i]+"\n");
		}
		for(int j=0;j<n;j++)
		{
			awt+=wt[j];
		}
		for(int j=0;j<n;j++)
		{
			atat+=t[j];
		}
		System.out.println("\n\nAverage Waiting Time: "+(awt/n));
		System.out.println("\nAverage Turn Around Time: "+(atat/n));
	}
	public static void FCFS(int n, int bt[], int wt[], int t[]){
		float awt = 0;
		float atat =0;
		for(int i=0;i<n;i++){
			wt[i]=0;
			t[i]=0;
		}
		for(int i=1;i<n;i++) 
		{ 
			wt[i]=wt[i-1]+bt[i-1];  
		} 
		for(int i=0;i<n;i++) 
		{ 
			t[i]=wt[i]+bt[i]; 
			awt=awt+wt[i]; 

		} 
		
		System.out.print("\n\nProcess \t Burst Time \t Waiting Time \t Turn Around Time\n");
		for(int i=0;i<n;i++){
		System.out.print("\n   "+(i+1)+"\t\t   "+bt[i]+"\t\t     "+wt[i]+"\t\t     "+t[i]+"\n");
		}
		for(int j=0;j<n;j++)
		{
			atat+=t[j];
		}
		System.out.println("\n\nAverage Waiting Time: "+(awt/n));
		System.out.println("\nAverage Turn Around Time: "+(atat/n));


	}
	public static void SJF(int n, int bt[], int wt[], int t[], int p[]){
		float awt = 0;
		float atat =0;
		int total=0,pos,temp;
		for(int i=0;i<n;i++){
			t[i]=0;
		}
		for(int i=0;i<n;i++)
		{
			pos=i;
			for(int j=i+1;j<n;j++)
			{
				if(bt[j]<bt[pos])
					pos=j;
			}

			temp=bt[i];
			bt[i]=bt[pos];
			bt[pos]=temp;

			temp=p[i];
			p[i]=p[pos];
			p[pos]=temp;
		}



		//First process has 0 waiting time
		wt[0]=0;
		//calculate waiting time
		for(int i=1;i<n;i++)
		{
			wt[i]=0; 
			for(int j=0;j<i;j++)
				wt[i]+=bt[j];

			total+=wt[i];
		}


		//Calculating Average waiting time
		awt=(float)total/n;
		total=0;
		atat=t[0];
	
		
		System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time\n");
		for(int i=0;i<n;i++)
		{			t[i]=bt[i]+wt[i]; //Calculating Turnaround Time
		total+=t[i];
		System.out.println("\n   "+p[i]+"\t\t "+bt[i]+"\t\t "+wt[i]+"\t\t "+t[i]);
		}

		//Calculation of Average Turnaround Time
		atat=(float)total/n;
		System.out.println("\n\nAverage Waiting Time: "+awt);
		System.out.println("\nAverage Turn Around Time: "+atat);



	}


}
