class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(){}

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    int capacity;
    HashMap<Integer,Node> mp;
    Node left;
    Node right;
    int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
        mp=new HashMap<>();

        left=new Node();
        right=new Node();

        left.next=right;
        right.prev=left;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
            insert(mp.get(key));
            return mp.get(key).val;
        }
        return -1;
    }

    // remove from any point
    void remove(Node n){
        Node prev=n.prev;
        Node next=n.next;

        prev.next=next;
        next.prev=prev;

    }

    // insert at end/right
    void insert(Node n){
        n.prev=right.prev;
        right.prev=n;
        n.next=right;
        n.prev.next=n;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
            mp.get(key).val=value;
            insert(mp.get(key));
        }
        else{ 
            if(size<capacity){
                size++;
            }
            else{
                mp.remove(left.next.key);
                remove(left.next);
            }

            mp.put(key,new Node(key,value));
            insert(mp.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */