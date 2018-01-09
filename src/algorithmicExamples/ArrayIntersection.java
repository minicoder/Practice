package algorithmicExamples;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by swetha on 5/2/17.
 * Given two integer arrays, find the intersection of the two.
 eg: arr1 = {1,3,6,10}, arr2 = {2,3,5,6} , the function should return {3,6}.

 */
public class ArrayIntersection {
    public static void main(String[] args) {
        Integer[] arr1 = { 10, 9, 8, 2, 7, 6, 5, 4, 3, 2, 1 };
        Integer[] arr2 = { 2, 2, 3, 5, 6, 9 };
        Integer[] intersection = new Integer[0];

        arrayIntersectionUnsorted(arr1, arr2, intersection);
        PrintArray( intersection );
    }

    static void arrayIntersectionUnsorted(Integer[] arr1, Integer[] arr2, Integer[] intersection) {
        Integer[] smallerArray = (arr1.length <= arr2.length) ? arr1 : arr2;
        Integer[] largerArray = (arr1.length <= arr2.length) ? arr2 : arr1;

        HashSet<Integer> table = new HashSet<>(Arrays.asList(smallerArray) );
        HashSet<Integer> result = new HashSet<>();
        for (Integer aLargerArray : largerArray) {
            if (table.contains(aLargerArray) && !result.contains(aLargerArray)) {
                result.add(aLargerArray);
            }
        }
        intersection = new Integer[result.size()];
        System.arraycopy(result.toArray(), 0, intersection, 0, result.size());
    }

    static void PrintArray( Integer[] array )
    {
        if ( array.length > 0 )
        {
            for ( int i = 0; i < array.length - 1; ++i )
            {
                System.out.println(array[i] + ",");
            }
            System.out.println(array[array.length - 1]);
        }
        else
        {
            System.out.println( "Empty array." );
        }
    }
}
