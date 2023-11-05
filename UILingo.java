import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class UILingo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("uilingo.dat"));
        int boards = Integer.parseInt(s.nextLine());
        for (int b = 0; b < boards; b++){
            boolean[][] called = new boolean[4][4];
            int[][] card = new int[4][4];
            for (int r = 0; r < 4; r++){
                for (int c = 0; c < 4; c++){
                    card[r][c] = s.nextInt();
                }
            }
            s.nextLine();
            int games = Integer.parseInt(s.nextLine());
            for (int g = 0; g < games; g++){
                int numFlats = 0;
                int fourCorners = 0;
                int numPlumbs = 0;
                int leftSlant = 0;
                int rightSlant = 0;
                int[] instructions = new int[10];
                String[] Sinstructions = s.nextLine().split(" ");
                int u = 0;
                for (String lkk : Sinstructions){
                    instructions[u] = Integer.parseInt(lkk);
                    u++;
                }

                for (int k = 0; k < 10; k++){
                    int instruction = instructions[k];
                    numFlats = 0;
                    fourCorners = 0;
                    numPlumbs = 0;
                    leftSlant = 0;
                    rightSlant = 0;
                
                    for (int r = 0; r < 4; r++){
                        for (int c = 0; c < 4; c++){
                            if (card[r][c] == instruction){
                                called[r][c] = true;

                            }
                            // System.out.print(called[r][c] + " ");
                            // System.out.println();
                        }
                    }

                    
                    System.out.println(Arrays.deepToString(called));


                    // CHECK FOR FLATS 
                    for (int r = 0; r < 4; r++){
                        boolean isFlat = true;
                        for (int c = 0; c < 4; c++){
                            if (called[r][c] == false){
                                isFlat = false;
                            }
                        }
                        if (isFlat == true){
                            numFlats++;
                        }
                    }

                    // CHECK FOR PLUMBS
                    for (int c = 0; c < 4; c++){
                        boolean isPlumb = true;
                        for (int r = 0; r < 4; r++){
                            if (called[r][c] == false){
                                isPlumb = false;
                            }
                        }
                        if (isPlumb == true){
                            numPlumbs++;
                        }
                    }

                    // FOUR CORNERS
                    if (called[0][3] && called[3][0] && called[0][0] && called[3][3]){
                        fourCorners = 1;
                    }

                    // SLANT
                    if (called[0][0] && called[1][1] && called[2][2] && called[3][3]){
                        leftSlant = 1;
                    }
                    if (called[3][0] && called[2][1] && called[1][2] && called[0][3]){
                        rightSlant = 1;
                    }

                    if(leftSlant == 1 || rightSlant == 1 || fourCorners == 1 || numPlumbs > 0 || numFlats > 0){
                        break;
                    }


                }
                int earnings = numFlats * 10 + numPlumbs * 15 + fourCorners * 5 + leftSlant * 20 + rightSlant * 20;
                System.out.println(earnings);


            }
        }
    }
}