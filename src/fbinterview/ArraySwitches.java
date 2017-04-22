package fbinterview;

import java.util.Arrays;
import java.util.List;

/**
 * Created by swetha on 4/16/17.
 */
public class ArraySwitches {
    public static void main(String[] args) {
    ArraySwitches arraySwitches = new ArraySwitches();
        List<Integer> integers = Arrays.asList(1,0,1,1,1,0);
        System.out.println(arraySwitches.bulbs(integers));
    }

    public int bulbs(List<Integer> a) {
        int state = 0;
        int switches = 0;
        if(a != null && !a.isEmpty()) {
            for (Integer anA : a) {
                if (state == anA) {
                    state = 1 - state;
                    switches++;
                }
            }

        }
        return switches;
    }
}
