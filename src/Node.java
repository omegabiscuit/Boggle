import java.util.ArrayList;

/**
 * Created by Brigham on 2/25/2017.
 */

public class Node {


    public Node(int value) { //Node constructor
        this.value = value;
    }

    public int getValue() { //return node value
        return value;
    }

    public void addChild(Node node) { //add onto solution path
        if(parent == node){ //prevents backtracking
            return;
        }
        children.add(node);
        node.setParent(this);

    }

    public boolean isAncestorOf(Node node){ //checks if node is already in solution path.
        Node tmp = this;
        while(tmp.getValue() != 0){
            if(tmp.parent == node){
                return true;
            }
            tmp = tmp.getParent();
        }
        return false;
    }

    public Node getParent() { //get previous value in solution path
        return parent;
    }

    protected void setParent(Node node) { //set previous value in solution path
        parent = node;
    }

    private int value = 0;
    private ArrayList<Node> children = new ArrayList<>(); //list of possible next values in solution path
    private Node parent = null;

}
