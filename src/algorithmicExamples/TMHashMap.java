package algorithmicExamples;

import quicktime.QTException;
import quicktime.std.clocks.Clock;

public class TMHashMap {
    // for simplicity size is taken as 2^4
    private static final int SIZE = 512;
    private Entry table[] = new Entry[SIZE];
    
 
    /**
     * User defined simple Map data structure
     * with key and value.
     * This is also used as linked list in case multiple
     * key-value pairs lead to the same bucket with same
     * hashcodes and different keys (collisions) using
     * pointer 'next'.
     *
     * @author ntallapa
     */
    class Entry {
        final String key;
        String value;
        Entry next;
 
        Entry(String k, String v) {
            key = k;
            value = v;
        }
 
        public String getValue() {
            return value;
        }
 
        public void setValue(String value) {
            this.value = value;
        }
 
        public String getKey() {
            return key;
        }
    }
 
    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    public Entry get(String k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
 
        // if bucket is found then traverse through the linked list and
        // see if element is present
        while(e != null) {
            if(e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }
 
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    @SuppressWarnings("deprecation")
	public void put(String k, String v) {
    	try {
			Clock c = new Clock(0);
		} catch (QTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Size: "+SIZE);
    	System.out.println("Hashcode1: "+k.hashCode());
        int hash = k.hashCode() % SIZE;
        System.out.println("Hashcode: "+k.hashCode()+" ,Hash: "+hash);
        Entry e = table[hash];
        if(e != null) {
            // it means we are trying to insert duplicate
            // key-value pair, hence overwrite the current
            // pair with the old pair
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                // traverse to the end of the list and insert new element 
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // new element in the map, hence creating new bucket
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }
 
    // for testing our own map
    public static void main(String[] args) {
        TMHashMap tmhm = new TMHashMap();
 
        tmhm.put("Swetha", "SMTS");
        tmhm.put("Pramod", "SSE");
        tmhm.put("Swetha", "SMTS1");
        //tmhm.put("Padma", "SSE");
 
        Entry e = tmhm.get("Swetha");
        System.out.println(""+e.getValue());
    }
}
