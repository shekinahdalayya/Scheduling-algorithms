//http://tutorialheap.com/java-program-perform-priority-scheduling-algorithm/
package main;
import java.util.Scanner;

public class Priority {

	public static void main(String args[]) {
		//n is number of process
		//p is process
		//pp is process priority
		//bt is process burst time
		//w is wait time
		// t is turnaround time
		//awt is average waiting time
		//atat is average turnaround time

		Scanner s = new Scanner(System.in);

		int x,n,p[],pp[],bt[],w[],t[], i;
		float awt=0; 
		float atat=0;
		System.out.print("Enter the number of process:");
		n = s.nextInt();
		
		p = new int[n];
		pp = new int[n];
		bt = new int[n];
		w = new int[n];
		t = new int[n];


		System.out.print("\nEnter burst time\n");

		for(i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"]:");
			bt[i] = s.nextInt();
			p[i]=i+1;
		}
		
		System.out.print("\nEnter time priorities\n");

		for(i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"] with burst time-"+ bt[i] +":");
			pp[i] = s.nextInt();
			p[i]=i+1;
		}

		//sorting on the basis of priority
		for(i=0;i<n-1;i++)
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
		w[0]=0;
		awt=0;
		t[0]=bt[0];
		atat=t[0];
		for(i=1;i<n;i++)
		{
			w[i]=t[i-1];
			awt+=w[i];
			t[i]=w[i]+bt[i];
			atat+=t[i];
		}

		//Displaying the process

		System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
		for(i=0;i<n;i++)
			System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
		awt/=n;
		atat/=n;
		System.out.print("\n Average Wait Time : "+awt);
		System.out.print("\n Average Turn Around Time : "+atat);

	}
}