import java.util.Scanner;

// This program demonstrates prime factorization in a nutshell.

public class Factors 
{
	public static void main(String[] args) 
	{
		// Define the input number and the scope number.
		int n, s = 0;
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Assign the input number to i.
		n = keyboard.nextInt();
		
		// Find the scope of the prime factor.
		while ( s * s < n )
			s++;
		
		// Define the array of prime factors.
		int[] pf = new int[s];
		
		// Define the two loop parameters.
		int lp1 = 0, lp2 = 2;
		
		// Execute the factorization.
		for ( lp1 = 2; lp1 <= s; lp1++)
		{
			// Initialize the times of prime factors.
			pf[ lp1 - 2 ] = 0;
			
			// Judge if the loop parameter is prime.
			while ( lp1 / lp2 * lp2 != lp1 && lp2 * lp2 < lp1)
				lp2++;
			
			if ( lp2 * lp2 > lp1 )
			{
				// Assign the number n to the second loop parameter.
				lp2 = n;
				
				// Count the times of the specific prime factor.
				while ( lp2 / lp1 * lp1 == lp2 )
				{
					pf[ lp1 - 2 ]++;
					lp2 = lp2 / lp1;
				}
			}			
			
			lp2 = 2;
		}
		
		lp2 = 0;
		
		// Calculate the number of prime factors.
		for ( lp1 = 2; lp1 <= s; lp1++)
		{
			if ( pf[ lp1 - 2 ] != 0 )
				lp2++;
		}
		
		// The input number is prime.
		if ( lp2 == 0 )
			System.out.print( n );
		// The input number is not prime.
		else
		{
			// Initial the second loop parameter for printing.
			lp2 = 0;
			
			for ( lp1 = 2; lp1 <= s; lp1++)
			{
				if ( pf[ lp1 - 2 ] != 0 )
				{
					if ( lp2 == 0 )
					{
						if ( pf[ lp1 - 2 ] == 1 )
							System.out.print( lp1 );
						else
							System.out.print( lp1 + "(" + pf[ lp1 - 2 ] + ")" );
						
						lp2++;
					}
					else if ( pf[ lp1 - 2 ] == 1 )
						System.out.print( "," + lp1 );
					else
						System.out.print( "," + lp1 + "(" + pf[ lp1 - 2 ] + ")" );
				}
			}
		}
		
		System.out.print("\n");
	}
}
