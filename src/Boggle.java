//import javax.xml.soap.Node;

import java.util.*;

/**
 * Created by Brigham on 2/21/2017.
 */
public class Boggle {

    private ArrayList<List<Node>> Grid = new ArrayList<>();
    private LinkedList<Integer> solution_path = new LinkedList<>();


    public void createTable(int heightWidth) { //Creates a 2d array of nodes with randomly generated values
        Random rn = new Random();
        for (int i = 0; i < (heightWidth); i++) {
            Grid.add(i, new ArrayList<>());
            for (int j = 0; j < heightWidth; j++) {

                Grid.get(i).add(j, new Node(rn.nextInt(9 - 2) + 1));

            }
            System.out.println(Grid.get(i));
        }
        //System.out.println(Arrays.deepToString(Grid.));

    }

    private Node Calculator(int i, int j, int value, Node current, Node parent) { //Finds the paths that equal area of grid
        if (current == null || current.isAncestorOf(parent)) {//stop if index is out of bounds or if current value is already in solution path
            return null;
        }
        int newvalue = current.getValue() - value;
        if (newvalue > 0) {
            Node newparent = current;
            current.addChild(Calculator(i, j-1, newvalue,Grid.get(i).get(j-1), current));//left
            /*
            Calculator(i, j + 1, newvalue, current);//right
            Calculator(i - 1, j, newvalue, current);//top
            Calculator(i + 1, j, newvalue, current);//bottom
            Calculator(i - 1, j + 1, newvalue, current);//top right
            Calculator(i - 1, j - 1, newvalue, current);//top left
            Calculator(i + 1, j + 1, newvalue, current);//bottom right
            Calculator(i + 1, j - 1, newvalue, current);//bottom left
            */
            return current;

        }
        return null;
    }

    public void solveTable() { //solves Boggle puzzle
        ArrayList<Node> solution = new ArrayList<>();
        for (int i = 0; i < Grid.size(); i++) {
            for (int j = 0; j < Grid.get(0).size(); j++) {
                Node root = new Node(0);
                //solution.add(Calculator(9, Grid.get(i).get(j), root));


            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Boggle myboggle = new Boggle();
        myboggle.createTable(3);
        //myboggle.solveTable();

    }
}



