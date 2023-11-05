import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class BridgePoints {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("bridge.dat"));
        int lines = Integer.parseInt(s.nextLine());
        for (int l = 0; l < lines; l++) {
            String hand = s.nextLine();
            int totalAces = 0;
            int totalPoints = 0;
            int[] suitCounts = new int[4]; // S, D, C, H
            for (int i = 0; i < hand.length(); i += 2){
                String value = hand.substring(i, i+1);
                String suit = hand.substring(i+1, i+2);
                if (value.equals("A")){
                    totalAces++;
                    totalPoints += 4;
                } else if (value.equals("K")){
                    totalPoints += 3;
                } else if (value.equals("Q")){
                    totalPoints += 2;
                } else if (value.equals("J")){
                    totalPoints += 1;
                }
                if (totalAces == 4){ totalPoints += 1; }

                if (suit.equals("S")){
                    suitCounts[0]++;
                } else if (suit.equals("D")){
                    suitCounts[1]++;
                } else if (suit.equals("C")){
                    suitCounts[2]++;
                } else if (suit.equals("H")){
                    suitCounts[3]++;
                }

                for (int k = 0; k < 4; k++){
                    if (suitCounts[k] == 0){
                        totalPoints += 3;
                    } else if (suitCounts[k] == 1){
                        totalPoints += 2;
                    } else if (suitCounts[k] == 2){
                        totalPoints += 1;
                    }
                }
                System.out.println(totalPoints);
            }
            System.out.println("BRIDGE POINTS = " + totalPoints);
        }
        
    }
}