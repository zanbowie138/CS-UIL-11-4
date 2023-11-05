import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Strings {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("strings.dat"));
        int i = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            if (line.equals("")) {break;}
            System.out.println(line);
            System.out.println(line.length());
            System.out.println(line.toUpperCase());
            System.out.println(line.substring(line.length()/2, line.length()));
            System.out.println(line.substring(0, 1).toLowerCase() + line.substring(line.length()-1, line.length()).toLowerCase());
            if (s.hasNextLine())
                System.out.print("\n");
        }
    }
}