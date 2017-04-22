package fbinterview;

import java.util.*;

/**
 * Created by swetha on 4/16/17.
 */
public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        List<Integer> integerList = new ArrayList<>();
//        Integer[] a = new Integer[] {723, 256, 668, 723, 140, 360, 597, 233, 128, 845, 737, 804, 986, 701, 906, 512, 845, 510, 510, 227, 430, 701, 366, 946, 464, 619, 946, 627, 209, 771, 424, 555, 959, 711, 530, 937, 716, 261, 505, 658, 706, 140, 511, 277, 396, 233, 819, 196, 475, 906, 583, 261, 147, 658, 517, 197, 196, 702, 944, 711, 128, 555, 149, 483, 530, 291, 716, 258, 430, 464, 601, 749, 149, 415, 802, 573, 627, 771, 660, 601, 360, 986, 291, 51, 415, 51, 227, 258, 937, 366, 923, 669, 33, 517, 417, 702, 475, 706, 110, 417, 275, 804, 500, 473, 746, 973, 669, 275, 973, 147, 817, 657, 277, 923, 144, 660, 197, 511, 793, 893, 944, 505, 322, 817, 586, 512, 322, 668, 33, 424, 962, 597, 144, 746, 345, 753, 345, 269, 819, 483, 368, 802, 573, 962, 583, 615, 208, 209, 269, 749, 256, 657, 619, 893, 959, 473, 753, 299, 396, 299, 500, 368, 586, 110, 793, 737, 615};
//        gcd.singleNumber(Arrays.asList(a));
        //gcd.singleNumber();
        gcd.isInterleave("eZCHXr0CgsB4O3TCDlitYI7kH38rEElI","UhSQsB6CWAHE6zzphz5BIAHqSWIY24D","eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D");
    }

    public int gcd(int a, int b) {
        while(a!=0 && b!=0) // until either one of them is 0
        {
            int c = b;
            b = a%b;
            a = c;
        }
        return a+b; // either one is 0, so return the non-zero value
    }

    public int singleNumber(final List<Integer> a) {
        int result = 0;
        for (int element : a)
            result ^= element;
        System.out.println(result);
        return result;
    }

    public int isInterleave(String a, String b, String c) {
        String res = a + b;
        String[] arrofS = res.split("");
        String [] ResC = c.split("");
        Arrays.sort(arrofS);
        Arrays.sort(ResC);
        if(arrofS.length != ResC.length){
            return 0;
        }else
        {
            for (int i=0; i<arrofS.length;i++){
                if( !ResC[i].equalsIgnoreCase(arrofS[i])){
                    return 0;
                }
            }
        }
        return 1;
    }
}
