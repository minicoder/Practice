package fbinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by swetha on 4/22/17.
 */
public class PerformOps {
    public static void main(String[] args){
        PerformOps performOps = new PerformOps();
        List<Integer> integers = Arrays.asList(5, 10, 2, 1);
        ArrayList<Integer> B = performOps.performOps(integers);
        for (Integer aB : B) {
            System.out.print(aB + " ");
        }
    }

    ArrayList<Integer> performOps(List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }
}
