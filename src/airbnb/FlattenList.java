package airbnb;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by swetha on 2/1/18.
 */
public class FlattenList {
    public  List<Object> flattenIterative(List<Object> list) {
        List<Object> result = new ArrayList<>();
        LinkedList stack = new LinkedList<>(list);
        while(!stack.isEmpty()) {
            Object e = stack.pop();
            if(e instanceof List<?>) {
                stack.addAll(0, (Collection) e);
            } else
                result.add(e);
        }
        return result;
    }

    public static List<Object> list(Object... args) {
        return Arrays.asList(args);
    }

    public Object flattenRecursive(Object object) {
        List<Object> result = new ArrayList<>();

        if(object.getClass().isArray()) {
            for(int i = 0 ; i < Array.getLength(object); i++) {
                result.addAll(flattenIterative((List<Object>) Array.get(object, i)));
            }
        }else if (object instanceof List) {
            for(Object el : (List<?>)object) {
                result.addAll(flattenIterative((List<Object>) el));
            }
        } else {
            result.add(object);
        }
        return result;
    }

    public static void main(String[] args) {
        FlattenList flattenList = new FlattenList();
        List<Object> list = list(1, 3, 5, list(6, 7), 8, 9, 10, list(11, 13, 15, list(16, 17, list(18, 19))), 20);
        System.out.println("flatten=" + flattenList.flattenIterative(list));
    }
}
