package fbinterview;

import java.util.*;

/**
 * Created by swetha on 4/16/17.
 */
public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
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
