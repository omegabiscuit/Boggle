import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Brigham on 2/21/2017.
 */
public class Boggle {
    public void createTable(int height, int width) {

        int Grid[][] = new int[height][width];
        Random rn = new Random();

        for (int i = 0; i < (height); i++) {
            for (int j = 0; j < width; j++) {
                Grid[i][j] = rn.nextInt(9 - 2) + 1;
            }
        }
        System.out.print(Arrays.deepToString(Grid));
    }


    public void solveTable() {
        int
        while
    }

    public static void main(String args[]) {
        Boggle myboggle = new Boggle();
        myboggle.createTable(3, 3);

    }
}



