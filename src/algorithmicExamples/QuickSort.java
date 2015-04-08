package algorithmicExamples;

public class QuickSort {
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] a = {14,12,16,13,11};
		int i = 0;
		int j = 4;
		int[] arr = q.recursiveQuickSort(a, i, j);
		
	}
	
	public int[] recursiveQuickSort(int[] a, int i, int j) {
	    // Handle logic to divide the array
	    int idx = partition(a, i, j);
	    int[] finalArray = new int[a.length];
	    //System.out.println("Index: "+idx); 
	    // Recursively call quick sort with left part of the divided array
	    if(i<idx-1) {
	        finalArray = recursiveQuickSort(a, i, idx-1);
	    }
	     
	    // Recursively call quick sort with right part of the divided array
	    if(j>idx) {	    	   
	        finalArray = recursiveQuickSort(a, idx, j);
	    }
	    
	    System.out.println("Sorted: "+finalArray[j]);
	    return finalArray;
	}
	
	public int partition(int[] a, int left, int right) {
	    // Get the pivot element
	    int pivot = a[left];
	     
	    // Break when left is > right
	    while(left <= right) {
	        //increment the lower bound till you find the element more than the pivot
	        while(a[left]<pivot)
	            left++;
	        //decrement the upper bound till you find the element less than the pivot
	        while(a[right]>pivot)
	            right--;
	         
	        // swap the values which are left by lower and upper bounds 
	        if(left <= right) {
	            int tmp = a[left];
	            a[left] = a[right];
	            a[right] = tmp;
	             
	            //increment left index and decrement right index
	            left++;
	            right--;
	        }
	    }   
	    return left;
	}

}
