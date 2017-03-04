import java.util.ArrayList;

/**
 * Created by Brigham on 2/25/2017.
 */

public class Node {


    public Node(int value) { //Node constructor
        this.value = value;
    } //data structure for cell in grid

    public int getValue() { //return node value
        return value;
    } //returns value in cell

    public void addChild(Node node) { //add onto solution path
        if(parent == node){ //prevents backtracking
            return;
        }
        children.add(node);
    }

    public Node getParent() { //get previous value in solution path
        return parent;
    } //returns previous Node in linked list

    protected void setParent(Node node) { //set previous value in solution path
        parent = node;
    } //set previous Node in linked list

    public boolean isAncestorOf(Node node){ //checks if node is already in solution path.
        Node tmp = this;
        while(tmp.getValue() != -1){
            if(tmp.parent == node){
                return true;
            }
            if(tmp.parent == null){
                return false;
            }
            tmp = tmp.getParent();
        }
        return false;
    }

    private int value = -1;
    private ArrayList<Node> children = new ArrayList<>(); //list of possible next values in solution path
    private Node parent = null;

}
