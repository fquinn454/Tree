import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {

    public static ArrayList postOrder(Tree myTree){
        ArrayList postOrderList = new ArrayList();
        if (myTree.getLeft() instanceof Node) {
            postOrderList.add(postOrder(myTree.getLeft()));
        }
        if(myTree.getLeft() instanceof Leaf) {
            postOrderList.add(myTree.getLeft().getElement());
        }
        if(myTree.getRight() instanceof Node) {
            postOrderList.add(postOrder(myTree.getRight()));
        }
        if(myTree.getRight() instanceof Leaf){
            postOrderList.add(myTree.getRight().getElement());
        }
        postOrderList.add(myTree.getElement());
        return postOrderList;
    }

    public static ArrayList inOrder(Tree myTree){
        ArrayList inOrderList = new ArrayList();
        if (myTree.getLeft() instanceof Node) {
            inOrderList.add(inOrder(myTree.getLeft()));
        }
        if(myTree.getLeft() instanceof Leaf) {
            inOrderList.add(myTree.getLeft().getElement());
        }
        inOrderList.add(myTree.getElement());
        if(myTree.getRight() instanceof Node) {
            inOrderList.add(inOrder(myTree.getRight()));
        }
        if(myTree.getRight() instanceof Leaf){
            inOrderList.add(myTree.getRight().getElement());
        }
        return inOrderList;
    }

    public static ArrayList preOrder(Tree myTree){
        ArrayList preOrderList = new ArrayList();

        preOrderList.add(myTree.getElement());
        if (myTree.getLeft() instanceof Node) {
            preOrderList.add(preOrder(myTree.getLeft()));
        }
        if(myTree.getLeft() instanceof Leaf) {
            preOrderList.add(myTree.getLeft().getElement());
        }
        if(myTree.getRight() instanceof Node) {
            preOrderList.add(preOrder(myTree.getRight()));
        }
        if(myTree.getRight() instanceof Leaf){
            preOrderList.add(myTree.getRight().getElement());
        }
        return preOrderList;
    }

    public static void prettyPrint(List<?> treeAsList){
        ArrayList<?> a = (ArrayList) flatten(treeAsList);
        for (Object item:a){
            System.out.print(item+" ");
        }
        System.out.println();
    }


    public static Stream<?> flattenToStream(List<?> list) {
        return list.stream().flatMap(item -> item instanceof List<?> ?
                flattenToStream((List<?>)item) : Stream.of(item));
    }

    public static List<?> flatten(List<?> list) {
        return flattenToStream(list).collect(Collectors.toList());
    }

    public static boolean search(List<?> list, int x){
        return flatten(list).contains(x);
    }

    public static int max(List<?> list){
        ArrayList<Integer> a = (ArrayList) flatten(list);
        int max = Collections.max(a);
        return max;
    }

    public static int min(List<?> list){
        ArrayList<Integer> a = (ArrayList) flatten(list);
        int min = Collections.min(a);
        return min;
    }

    public static Pair minMax(List<?> list){
        Pair minMax = new Pair(min(list), max(list));
        return minMax;
    }

    public static void main(String[] args) {
        Leaf  leaf2 = new Leaf(25);
        Leaf  leaf3 = new Leaf(75);
        Leaf  leaf4 = new Leaf(9);
        Leaf  leaf5 = new Leaf(16);
        Leaf leaf6 = new Leaf(32);
        Node node3 = new Node(leaf5, -5, leaf6);
        Node node1 = new Node(node3, 3, leaf2);
        Node node2 = new Node(leaf3, 1, leaf4);
        Node myTree = new Node(node1, 11, node2);

        prettyPrint(inOrder(myTree));
        prettyPrint(preOrder(myTree));
        prettyPrint(postOrder(myTree));
        System.out.println();
        System.out.println(search(inOrder(myTree), 7));
        System.out.println(search(inOrder(myTree), 1));
        System.out.println(search(inOrder(myTree), 36));
        System.out.println(minMax(inOrder(myTree)));

    }
}
