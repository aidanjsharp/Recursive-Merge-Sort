import java.util.Random;
import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		String userSize; int int_random; 										//create some variables
		
		Scanner scannerObj = new Scanner(System.in);							//initialize scanning object
		System.out.println("Enter array size:");
		userSize = scannerObj.nextLine();
		scannerObj.close();														//close scanning object
		
		int[] Array = new int[Integer.parseInt(userSize)];						//create Array
		
		
		System.out.printf("Your randomly generated array: { ");
		Random rand = new Random();
		for(int i = 0; i< Integer.parseInt(userSize); i++) {
			int_random = rand.nextInt(100) + 1;									//create random number
			Array[i] = int_random;												//assign random number to spot in array
			
			if (i == Integer.parseInt(userSize)-1) {
				System.out.println(int_random + " }");
			}
			else {
				System.out.printf(int_random + ", ");
			}
			
		}
				
		
		arraySum((Integer.parseInt(userSize) - 1), Array, 0);
		sort(Array, Integer.parseInt(userSize));

		System.out.printf("Your sorted array: { ");
		for (int j = 0; j < Integer.parseInt(userSize); j++) {
			
			if (j == Integer.parseInt(userSize)-1) {
				System.out.println(Array[j] +" }");
			}
			else {
				System.out.printf(Array[j] +", ");
			}
		}
	}
	
	public static void arraySum(int x, int Array[], int sum) {
		if ( x == -1 ) {
			System.out.println("The sum of the array is " +  sum);
		} else {
			sum = sum + Array[x];
			//System.out.println(Array[x]);
			x --;
			arraySum(x, Array, sum);
		}
		
	}
	
	public static void sort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    sort(l, mid);
	    sort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
		
	}
	
	
	
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {
			 
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
	}


	


}
