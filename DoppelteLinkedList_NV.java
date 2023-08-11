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
}
