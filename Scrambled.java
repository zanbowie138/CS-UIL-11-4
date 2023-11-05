import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Scrambled {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("scrambled.dat"));
        while (s.hasNextLine()) {
            String[] str = s.nextLine().split(" ");
            int i = 0;
            while (!isInt(str[i])) {
                i++;
            }
            int pivot = i;
            int sum = Integer.parseInt(str[pivot]);
            for (int h = pivot+1; h < str.length; h++) {
                String fk = str[pivot-(h-pivot)];
                if (fk.equals("+")) {
                    sum += Integer.parseInt(str[h]);
                } else {
                    sum -= Integer.parseInt(str[h]);
                }
            }
            System.out.println(sum);
        }
    }

    private static boolean isInt(String a) {
        return a.matches("[0-9]+$");
    }
}