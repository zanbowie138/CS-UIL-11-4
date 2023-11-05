import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Curve {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("curve.dat"));
        while(s.hasNext()) {
            String[] line = s.nextLine().split(" ");
            int T = Integer.parseInt(line[0]);
            int L = Integer.parseInt(line[1]);
            for (int i = 0; i < T; i++) {
                int j = L;
                while (j > 0) {
                    printStars(j);
                    j/=2;
                }
                L-=5;
            }
            if (s.hasNext())
                System.out.print("\n");
        }
    }

    private static void printStars(int a) {
        String l = "";
        for (int j = 0; j < a; j++) {
            l+="*";
        }
        System.out.println(l);
    }
}