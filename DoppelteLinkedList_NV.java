import java.util.Random;
public class DoppelteLinkedList_NV
{
    private Node_NV head;
    private Node_NV tail;
    
    public DoppelteLinkedList_NV()
    {
        this.head = null;
        this.tail = null;
        
    }

    public void addHead(Nhan_Vien nv)
    {
        Node_NV newNode= new Node_NV(nv);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void addTail(Nhan_Vien nv){
        Node_NV newNode = new Node_NV(nv);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode; 
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void addIndex(int index, Nhan_Vien nv){
        Node_NV newNode = new Node_NV(nv);
        if(head == null){
            if(index != 0){throw new IllegalArgumentException("index khong hop le vi do dai cua list hien tai khong du");}
            head = newNode;
            tail = newNode;
        }
        else{
            if(index == 0){
                addHead(nv);
            }
            else{
                Node_NV cur = head;
                int curposition = 0;
                while(cur!= null && curposition < index){
                    cur = cur.next;
                    curposition++;
                }
                if(cur == null){throw new IllegalArgumentException("Do dai hien tai cua List khong chua index nay ");}
                newNode.next = cur;
                newNode.prev = cur.prev;
                cur.prev.next = newNode;
                cur.prev = newNode;
            }
        }
    }
    
    public void removeHead(){
        if(head == null){throw new IllegalArgumentException("head ko dc phep trong");}
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        else{ 
            tail = null;
        }
    }
    
    public void removeTail(){
        if(tail == null){throw new IllegalArgumentException("tail ko dc phep trong");}
        tail = tail.prev;
        if(tail != null){
            tail.next =null;
        }
        else{
            head = null;
        }
    }
    
    public void removeIndex(int index){
        if(head == null){throw new IllegalArgumentException("head ko dc phep trong");}
        if(index == 0){
            removeHead();
            return;
        }
        Node_NV cur = head;
        int curposition = 0;
        while(cur != null && curposition < index){
            cur = cur.next;
            curposition++;
        }
        if(cur == null){throw new IllegalArgumentException("cur ko dc phep trong");}
        if(cur == tail){
            removeTail();
            return;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    
    public void invertierenList(){
        Node_NV cur = head;
        Node_NV temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            cur = temp;
        }
        temp = head;
        head = tail;
        tail = temp;
    }
    
    /**
     * Size of Doubly_LinkedList
     */
    public int size(){
        int count = 0;
        Node_NV cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    
    /**
     * Get Value von Index
     * @param index ist index von ein Nhan_Vien object in DopplteLinkedList
     */
    public Nhan_Vien getValueAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index ist nicht vernunftig.");
        }

        Node_NV current = head;
        int currentPosition = 0;
        
        while (current != null && currentPosition < index) {
            current = current.next;
            currentPosition++;
        }
        return current._nv;
    }
    /**
     * Set Value bei Index
     */
    public void setValueAtIndex(int index, Nhan_Vien newValue) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index nằm ngoài khoảng cho phép.");
        }

        Node_NV cur = head;
        int currentPosition = 0;

        while (cur != null && currentPosition < index) {
            cur = cur.next;
            currentPosition++;
        }

        cur._nv = newValue;
    }
    /**
     * shuffle List
     */
    public void shuffle(Random random) {
        int size = size();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapValuesAtIndexes(i, j);
        }
    }

    private void swapValuesAtIndexes(int i, int j) {
        Node_NV nodeI = getNodeAtIndex(i);
        Node_NV nodeJ = getNodeAtIndex(j);

        Nhan_Vien temp = nodeI._nv;
        nodeI._nv = nodeJ._nv;
        nodeJ._nv = temp;
    }

    private Node_NV getNodeAtIndex(int index) {
        Node_NV current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < index) {
            current = current.next;
            currentPosition++;
        }
        return current;
    }
    
    /**
     * Loop from Head to Tail
     */
    public void iterateForward() {
        Node_NV current = head;

        System.out.print("Durchsuchen Sie die Liste von Anfang bis Ende: ");
        while (current != null) {
            System.out.print(current._nv + " ");
            current = current.next;
        }
        System.out.println();
    }
    /**
     * Loop from Tail back to Head
     */
    public void iterateBackward() {
        Node_NV current = tail;

        System.out.print("Durchsuchen Sie die Liste von unten nach oben: ");
        while (current != null) {
            System.out.print(current._nv + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
