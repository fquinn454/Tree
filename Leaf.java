public class Leaf implements Tree {
    private Tree left;
    private int value;
    private Tree right;

    public Leaf(int value){
        this.left = null;
        this.value = value;
        this.right = null;
    }

    @Override
    public Tree getLeft() {
        return null;
    }

    @Override
    public int getElement() {
        return value;
    }

    @Override
    public Tree getRight() {
        return null;
    }
}
