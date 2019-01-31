package heapimplementation;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int size){
        this.maxSize=size;
        currentSize=0;
        heapArray=new Node[size];
    }

    public int getSize(){
        return currentSize;
    }

    public boolean isEmpty(){
        return (currentSize==0);
    }

    public boolean insert(int key){
        if(currentSize==maxSize){
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize]=newNode;
        trickleUp(currentSize);
        currentSize++;

        return true;
    }

    public void trickleUp(int idx){
        int parentIdx = (idx-1)/2;
        Node nodeToInsert = heapArray[idx];

        //loop as long as we haven;t reached the root and key of nodeToInsert's parent is less than new
        while(idx>0&&heapArray[parentIdx].getKey()<nodeToInsert.getKey()){
            heapArray[idx]=heapArray[parentIdx];//move parent down
            idx=parentIdx;
            parentIdx=(parentIdx-1)/2;
        }
    }

    public Node remove(){
        Node root = heapArray[0];
        currentSize--;
        heapArray[0]= heapArray[currentSize];

        trickleDown(0);
        return root;
    }

    public void trickleDown(int idx){
        int largeChildIdx;
        Node top = heapArray[idx];//save last node into top variable

        //will run as long as index is not on the bottom row(at least 1 child)
        while(idx<currentSize/2){
            int leftChildIdx = 2*idx+1;
            int rightChildIdx = leftChildIdx+1;

            if(rightChildIdx<currentSize&&
                heapArray[leftChildIdx].getKey()<heapArray[rightChildIdx].getKey()){
                largeChildIdx=rightChildIdx;
            }else{
                largeChildIdx=leftChildIdx;
            }

            if(top.getKey()>=heapArray[largeChildIdx].getKey()){
                break;
            }
            heapArray[idx]=heapArray[largeChildIdx];
            idx=largeChildIdx;
        }
        heapArray[idx]=top;
    }
}
