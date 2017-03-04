//import javax.xml.soap.Node;

import java.util.*;

/**
 * Created by Brigham on 2/21/2017.
 */
public class Boggle {
    private ArrayList<List<Node>> grid = new ArrayList<>();//grid for Boggle
    private ArrayList<ArrayList<Integer>> orderedSolutions = new ArrayList<>(); //list of solutions in order by value
    private ArrayList<ArrayList<Node>> allSolutions = new ArrayList<>();//list of solutions


    public void createTable(int height, int width) { //Creates a 2d array of nodes with randomly generated values
        Random rn = new Random();
        System.out.println("grid:");
        for (int i = 0; i < (height); i++) {
            grid.add(i, new ArrayList<>());
            for (int j = 0; j < width; j++) {
                grid.get(i).add(j, new Node(rn.nextInt(9 - 2)));
                System.out.print(grid.get(i).get(j).getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isUnique(ArrayList<Node> solution) { //simple bubble sort to organize solutions and returns true if solution has not been already found in a different direction
        ArrayList<Node> tmpSolution = new ArrayList<>(solution);
        for (int j = 0; j < tmpSolution.size(); j++) {
            for (int i = 1; i < tmpSolution.size() - j; i++) {
                if (tmpSolution.get(i - 1).getValue() > tmpSolution.get(i).getValue()) {
                    Collections.swap(tmpSolution, tmpSolution.indexOf(tmpSolution.get(i - 1)), tmpSolution.indexOf(tmpSolution.get(i)));
                }
            }
        }
        ArrayList<Integer> solutionArray = new ArrayList<>();
        for (int i = 0; i < tmpSolution.size(); i++) {
            solutionArray.add(tmpSolution.get(i).getValue());
        }
        if(orderedSolutions.contains(solutionArray)){
            return false;
        }
        else{
            orderedSolutions.add(solutionArray);
            return true;
        }
    }

    private void Calculator(int i, int j, int value, Node current, Node parent) { //Finds the paths that equal area of grid
        if (current == null || parent.isAncestorOf(current)) {//stop if index is out of bounds or if current value is already in solution path
            return;
        }
        int newValue = value - current.getValue();
        if (newValue > 0) {
            current.setParent(parent);
            parent.addChild(current);
            if (j - 1 >= 0 && j - 1 < grid.get(i).size()) {                                 //left
                Calculator(i, j - 1, newValue, grid.get(i).get(j - 1), current);
            }
            if (j + 1 >= 0 && j + 1 < grid.get(i).size()) {                                 //right
                Calculator(i, j + 1, newValue, grid.get(i).get(j + 1), current);
            }
            if (i - 1 >= 0 && i - 1 < grid.size()) {                                        //top
                Calculator(i - 1, j, newValue, grid.get(i - 1).get(j), current);
            }
            if (i + 1 >= 0 && i + 1 < grid.size()) {                                        //bottom
                Calculator(i + 1, j, newValue, grid.get(i + 1).get(j), current);
            }
            if (i - 1 >= 0 && i - 1 < grid.size() && j + 1 >= 0 && j + 1 < grid.get(i).size()) {//top right
                Calculator(i - 1, j + 1, newValue, grid.get(i - 1).get(j + 1), current);
            }
            if (i - 1 >= 0 && i - 1 < grid.size() && j - 1 >= 0 && j - 1 < grid.get(i).size()) {//top left
                Calculator(i - 1, j - 1, newValue, grid.get(i - 1).get(j - 1), current);
            }
            if (i + 1 >= 0 && i + 1 < grid.size() && j + 1 >= 0 && j + 1 < grid.get(i).size()) {//bottom right
                Calculator(i + 1, j + 1, newValue, grid.get(i + 1).get(j + 1), current);
            }
            if (i + 1 >= 0 && i + 1 < grid.size() && j - 1 >= 0 && j - 1 < grid.get(i).size()) {//bottom left
                Calculator(i + 1, j - 1, newValue, grid.get(i + 1).get(j - 1), current);
            }
        }
        if (newValue == 0) {
            current.setParent(parent);
            parent.addChild(current);
            ArrayList<Node> solution = new ArrayList<>();
            Node iter = current;
            while (iter.getParent() != null) {
                solution.add(iter);
                iter = iter.getParent();
            }
            if(isUnique(solution)){
                allSolutions.add(solution);
            }
        }
    }

    public void solveTable() { //Finds all possible solutions, then eliminates repeats
        System.out.println("Answers:");
        int gridArea = grid.get(0).size() * grid.get(0).size();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                Node root = new Node(0);
                Calculator(i, j, gridArea, grid.get(i).get(j), root);
            }
        }
        for (int i = 0; i < allSolutions.size(); i++) {
            for (int j = 0; j < allSolutions.get(i).size() - 1; j++) {
                System.out.print(allSolutions.get(i).get(j).getValue() + " + ");
            }
            System.out.print(allSolutions.get(i).get(allSolutions.get(i).size() - 1).getValue() + " = " + gridArea);
            System.out.println();
        }
        System.out.print(allSolutions.size() + " Answers found!");
    }
}



