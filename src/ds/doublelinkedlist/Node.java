package ds.doublelinkedlist;

public class Node {
    public int data;
    public Node next;
    public Node previous;

    public void displayNode(){
        System.out.println("{"+data+"}");
    }
}
