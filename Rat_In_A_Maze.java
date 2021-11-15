import java.util.*;

public class Rat_In_A_Maze {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int a[][]=new int[n][n];
		
		//This solution matrix displays the path if it exists
		int sol[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		
		//calling function and checking whether it is a valid path or not.
		
		if(solveMaze(a,0,0,n,sol)==false)
		{
			System.out.println("No valid path");
		}
		else
		{
			System.out.println("The rat can move from source to destination successfully .Hence the path is ");
			//System.out.println();
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(sol[i][j]!=0)
					{
					System.out.print(sol[i][j]+" ");
					}
					else
					{
						System.out.print(" "+" ");
					}
				}
				System.out.println();
			}
		}
		
		
		
	}
	
	//This function helps us to find the valid path from source to destination.
	
	public static boolean solveMaze(int a[][],int i,int j,int n,int sol[][])
	{
		if(i==n-1 && j==n-1 && a[i][j]==1)
		{
			sol[i][j]=1;
			return true;
		}
		if(safePath(a,i,j,n))
		{
			sol[i][j]=1;
			if(solveMaze(a,i+1,j,n,sol)==true)
				return true;
			else if(solveMaze(a,i,j+1,n,sol)==true)
				return true;
			
			sol[i][j]=0;
		}
		return false;
	}
	
	//This function ensures that each step is valid if the value is 1 and does not exceeds the size of matrix.
	
	public static boolean safePath(int a[][],int i,int j,int n)
	{
		return (i<n && j<n && a[i][j]==1);
	}
}


