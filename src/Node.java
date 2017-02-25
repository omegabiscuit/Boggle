import java.util.ArrayList;

/**
 * Created by Brigham on 2/25/2017.
 */

public class Node {


    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void addChild(Node node) {
        children.add(node);
        node.setParent(this);

    }

    public Node getParent() {
        return parent;
    }

    protected void setParent(Node node) {
        parent = node;
    }

    private int value = 0;
    private ArrayList<Node> children = new ArrayList<>();
    private Node parent = null;

}
