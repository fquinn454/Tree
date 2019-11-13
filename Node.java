import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Node implements Tree {
    Tree leftTree;
    Tree rightTree;
    int value;

    public Node(Tree left, int value, Tree right) {
        this.leftTree = left;
        this.value = value;
        this.rightTree = right;
    }

    @Override
    public Tree getLeft() {
        return leftTree;
    }

    @Override
    public int getElement() {
        return value;
    }

    @Override
    public Tree getRight() {
        return rightTree;
    }


}



