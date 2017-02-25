//import javax.xml.soap.Node;

import java.util.*;

/**
 * Created by Brigham on 2/21/2017.
 */
public class Boggle{

    private ArrayList<List<Integer>> Grid = new ArrayList<>();
    private LinkedList<Integer> solution_path = new LinkedList<>();


    public void createTable(int heightWidth) { //Creates a 2d array of randomly generated numbers


        //Grid = new int[heightWidth][heightWidth];
        Random rn = new Random();
        for (int i = 0; i < (heightWidth); i++) {
            Grid.add(i, new ArrayList<>());
            for (int j = 0; j < heightWidth; j++) {
                Grid.get(i).add(j, rn.nextInt(9 - 2) + 1);
            }
        }
        //System.out.println(Arrays.deepToString(Grid));
    }

    private Node Calculator(int i, int j, int value, Node current) {
        if (Grid.get(i).get(j) == null) {//stop if index is out of bounds
            return null;
        }
        int newvalue = Grid.get(i).get(j) - value;
        if (newvalue > 0) {
            Node newcurrent = new Node(Grid.get(i).get(j));
            current.addChild(Calculator(i, j - 1, newvalue, newcurrent));//left
            /*
            Calculator(i, j + 1, newvalue, current);//right
            Calculator(i - 1, j, newvalue, current);//top
            Calculator(i + 1, j, newvalue, current);//bottom
            Calculator(i - 1, j + 1, newvalue, current);//top right
            Calculator(i - 1, j - 1, newvalue, current);//top left
            Calculator(i + 1, j + 1, newvalue, current);//bottom right
            Calculator(i + 1, j - 1, newvalue, current);//bottom left
            */
            return newcurrent;

        }
        return null;


    }


    public void solveTable() {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < Grid.size(); i++) {
            for (int j = 0; j < Grid.get(0).size(); j++) {
                Calculator(i,j,9,new Node)
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Boggle myboggle = new Boggle();
        myboggle.createTable(3);
        myboggle.solveTable();

    }
}



