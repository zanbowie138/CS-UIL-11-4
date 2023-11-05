import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Bank {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("bank.dat"));
        int sets = Integer.parseInt(s.nextLine());
        for (int S = 0; S < sets; S++) {
            String op =  s.nextLine();

            int c = Integer.parseInt(s.nextLine());
            for (int l = 0; l < c; l++) {
                String debug = s.nextLine();
                String[] line = debug.split(" ");
                switch (line[0]) {
                    case "SEARCH":
                        System.out.println(op.indexOf(line[2], Integer.parseInt(line[1])-1)+1);
                        break;
                    case "REPLACE":
                        int a = Integer.parseInt(line[1])-1;
                        System.out.println(op.substring(0, a) + line[2] + op.substring(a+1, op.length()));
                        break;
                    case "DELETE":
                        int aa = Integer.parseInt(line[1])-1;
                        int bb = Integer.parseInt(line[2]);
                        System.out.println(op.substring(0, aa) + op.substring(aa+bb, op.length()));
                        break;
                    case "INSERT":
                        int aaa = Integer.parseInt(line[1]);
                        String str1 = combine(line, 2);
                        System.out.println(op.substring(0, aaa-1) + str1 + " " + op.substring(aaa-1, op.length()));
                        break;
                }
            }
        }
    }

    private static String combine(String[] arr, int start) {
        String output = "";
        for (int i = start; i < arr.length; i++) {
            output+=arr[i] + " ";
        }
        return output.substring(0, output.length()-1);
    }
}