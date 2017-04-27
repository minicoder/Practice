package fbinterview;

/**
 * Created by swetha on 4/22/17.
 * //Not working
 */
public class Arrange {
    public static void main(String[] args) {
        Arrange arrange = new Arrange();
        arrange.arrange("WWBWBB",3);
    }

    public int arrange(String a, int b) {
        //"WWBWBB", 3
        //{W,WB,}
        String[] split = a.split("");

        int whiteHorses = 0,blackHorses = 0;
        String[] choice = new String[b];
        for(int i = 0; i < split.length ; i++) {
           choice[i] = split[i]+split[i+1]; //[WW]
            i++;
        }
        for(String s : choice){
            System.out.println("Choice:"+s);
        }

        int product = whiteHorses*blackHorses;



        return -1;
    }
}
