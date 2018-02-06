package airbnb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swetha on 2/1/18.
 */
public class PatternMatch {
    public boolean isMatch(String str, String pat) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(str, 0, pat, 0, map);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map) {
        System.out.println();
        System.out.println("str: " + str + ", i: " + i + ", j: " + j + ", pattern: " + pat);

        map.forEach((p, n) -> System.out.println("Map: " + p + "->" + n));
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);
        System.out.println("Current char: "+c);

        // if the pattern character exists
        if (map.containsKey(c)) {
            System.out.println("Map contains "+c);
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            System.out.println("i: "+i +" map value: "+s);
            System.out.println("i+s.length: " + i + s.length());
            System.out.println("String length: " + str.length());

            if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
                System.out.println("Either "+i+s.length()+" is > "+str.length()+" OR string substring "+i +" to "+ i+s.length()+
                        " not equal to map value: "+s+". So return false..");
                System.out.println();
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map);
        }

        System.out.println("Pattern Char "+ c +" does not exist in map, so putting it in map.");
        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            // create or update the map
            String substr = str.substring(i, k + 1);
            System.out.println("k: "+k);
            System.out.println("Update the map with key: "+c +" and value: "+substr);
            map.put(c, substr);

            // continue to match the rest
            System.out.println("Continue to match the rest..j: "+j);
            if (isMatch(str, k + 1, pat, j + 1, map)) {
                return true;
            }
        }

        // we've tried our best but still no luck
        map.remove(c);

        return false;
    }

    public static int patternMatchingBruteForce(String string, String pattern) {
        int LS = string.length();
        int LP = pattern.length();

//        int max = LS - LP + 1;
        int max = LS - LP;
        for(int i = 0 ; i < max ; i++) {
            int j;

            for(j = 0 ; j < LP ; j++) {
                if(pattern.charAt(j) != string.charAt(j+i)) {
                    break;
                }
            }
            if(j == LP) return i;
        }
        return LS;
    }

    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();
//        System.out.println(patternMatch.isMatch("catdogdogcat", "abba"));
        System.out.println(patternMatchingBruteForce("the test","test"));
    }
}
