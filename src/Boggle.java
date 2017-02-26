//import javax.xml.soap.Node;

import java.util.*;
/**
 * Created by Brigham on 2/21/2017.
 */
public class Boggle {
    private ArrayList<List<Node>> Grid = new ArrayList<>();//Grid for Boggle
    private ArrayList<ArrayList<Node>> all_solutions = new ArrayList<>();//list of solutions


    public void createTable(int heightWidth) { //Creates a 2d array of nodes with randomly generated values
        Random rn = new Random();
        int x = 1;
        System.out.println("Grid:");
        for (int i = 0; i < (heightWidth); i++) {
            Grid.add(i, new ArrayList<>());
            for (int j = 0; j < heightWidth; j++) {
                Grid.get(i).add(j, new Node(rn.nextInt(9 - 2) + 1));
                //Grid.get(i).add(j, new Node(x));
                x += 1;
                System.out.print(Grid.get(i).get(j).getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    private ArrayList<Node> solutionSort(ArrayList<Node> solution){ //simple bubble sort to organize solutions. Used to avoid repeats
        for(int j = 0; j < solution.size(); j++) {
            for (int i = 1; i < solution.size() - j; i++) {
                if (solution.get(i - 1).getValue() > solution.get(i).getValue()) {
                    Collections.swap(solution, solution.indexOf(solution.get(i - 1)), solution.indexOf(solution.get(i)));
                }
            }
        }
        return solution;
    }

    private void Calculator(int i, int j, int value, Node current, Node parent) { //Finds the paths that equal area of grid
        if (current == null || parent.isAncestorOf(current)) {//stop if index is out of bounds or if current value is already in solution path
            return;
        }
        int newvalue = value - current.getValue();
        if (newvalue > 0) {
            current.setParent(parent);
            parent.addChild(current);
            if (j - 1 >= 0 && j - 1 < Grid.get(i).size()) {                                 //left
                Calculator(i, j - 1, newvalue, Grid.get(i).get(j - 1), current);
            }
            if (j + 1 >= 0 && j + 1 < Grid.get(i).size()) {                                 //right
                Calculator(i, j + 1, newvalue, Grid.get(i).get(j + 1), current);
            }
            if (i - 1 >= 0 && i - 1 < Grid.size()) {                                        //top
                Calculator(i - 1, j, newvalue, Grid.get(i - 1).get(j), current);
            }
            if (i + 1 >= 0 && i + 1 < Grid.size()) {                                        //bottom
                Calculator(i + 1, j, newvalue, Grid.get(i + 1).get(j), current);
            }
            if (i - 1 >= 0 && i - 1 < Grid.size() && j + 1 >= 0 && j + 1 < Grid.get(i).size()) {//top right
                Calculator(i - 1, j + 1, newvalue, Grid.get(i - 1).get(j + 1), current);
            }
            if (i - 1 >= 0 && i - 1 < Grid.size() && j - 1 >= 0 && j - 1 < Grid.get(i).size()) {//top left
                Calculator(i - 1, j - 1, newvalue, Grid.get(i - 1).get(j - 1), current);
            }
            if (i + 1 >= 0 && i + 1 < Grid.size() && j + 1 >= 0 && j + 1 < Grid.get(i).size()) {//bottom right
                Calculator(i + 1, j + 1, newvalue, Grid.get(i + 1).get(j + 1), current);
            }
            if (i + 1 >= 0 && i + 1 < Grid.size() && j - 1 >= 0 && j - 1 < Grid.get(i).size()) {//bottom left
                Calculator(i + 1, j - 1, newvalue, Grid.get(i + 1).get(j - 1), current);
            }
        }
        if (newvalue == 0) {
            current.setParent(parent);
            parent.addChild(current);
            ArrayList<Node> solution = new ArrayList<>();
            Node iter = current;
            while (iter.getParent() != null) {
                solution.add(iter);
                iter = iter.getParent();
            }
            solution = solutionSort(solution);
            if(!(all_solutions.contains(solution)) && solution.size() >= Grid.get(0).size()-1) {
                all_solutions.add(solution);
            }
        }
    }

    public void solveTable() { //Finds all possible solutions, then eliminates repeats
        System.out.println("Answers:");
        for (int i = 0; i < Grid.size(); i++) {
            for (int j = 0; j < Grid.get(0).size(); j++) {
                Node root = new Node(0);
                Calculator(i, j, Grid.get(i).size()*Grid.get(j).size(), Grid.get(i).get(j), root);
            }
        }
        for (int i = 0; i < all_solutions.size(); i++){
            for (int j = 0; j < all_solutions.get(i).size()-1; j++){
                System.out.print(all_solutions.get(i).get(j).getValue() + " + ");
            }
            System.out.print(all_solutions.get(i).get(all_solutions.get(i).size()-1).getValue() + " = 9");
            System.out.println();
        }
        System.out.print(all_solutions.size() + " Answers found!");
    }


    public static void main(String args[]) {
        Boggle myboggle = new Boggle();
        myboggle.createTable(3);
        myboggle.solveTable();
    }
}



