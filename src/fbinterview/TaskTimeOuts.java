package fbinterview;

import java.util.*;

/**
 * Created by swetha on 4/25/17.
 *
 * Facebook interview
 Cooldown: 2
 Input: 1 1 2 3 2
 Output: 1 - - 1 2 3 2
 // if(map key has same task, check for cooldown)
 // if timeslot == cooldown
 // timeslott++
 // Add to map --> 1 -->> timeSlot = 1
 //
 // Add to map --> 1 -->> 1
 Output: 1 _ _ 1 2 3 _ 2 ===> 8
 */


// 1
public class TaskTimeOuts {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,4};//1 2 3 1 2 4 1 2
        int k =2;
        System.out.println(getTimeOuts(nums, k));
    }
    public static int getTimeOuts(int[] nums, int coolDown) {
        Arrays.sort(nums);

        StringBuilder slots = new StringBuilder();
        slots.append(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int lastPos = slots.lastIndexOf(nums[i]+"");
            if(lastPos == -1) {
                int slotsPos = slots.indexOf("_");
                if(slotsPos == -1)
                    slots.append(nums[i]);
                else {
                    slots.deleteCharAt(slotsPos);
                    slots.insert(slotsPos,nums[i]);
                }
            } else {
                int slotsPos = lastPos + coolDown;
                if(slots.length() <= slotsPos) {
                    for (int j = 0; j < coolDown; j++) {
                        slots.append("_");
                    }
                    slots.append(nums[i]);
                } else {
                    if(slots.charAt(slotsPos) == '_') {
                        slots.deleteCharAt(slotsPos);
                        slots.insert(slotsPos,nums[i]);
                    } else {
                        while(slotsPos < slots.length() && slots.charAt(slotsPos) != '_') {
                            slotsPos ++;
                        }
                        if(slots.length() <= slotsPos) {
                            slots.append(nums[i]);
                        } else {
                            slots.deleteCharAt(slotsPos);
                            slots.insert(slotsPos,nums[i]);
                        }
                    }
                }
            }
        }
        System.out.println("Slots: "+slots);
        return slots.length();
    }
}
