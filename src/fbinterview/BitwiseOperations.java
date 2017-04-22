package fbinterview;

/**
 * Created by swetha on 4/16/17.
 */
public class BitwiseOperations {
    public static void main(String[] args) {
        BitwiseOperations codeLab = new BitwiseOperations();

        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
        System.out.println(codeLab.numSetBits(42));
    }

        public int numSetBits(long a) {
            //32 16 8 4 2 1
            //1 0 1 0 1 0
            int count = 0;
            while (a != 0){
                count += a & 1;
                a >>= 1;
            }

            return count;
        }


}
