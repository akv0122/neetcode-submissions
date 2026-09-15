class LRUCache {

    class DLLNode{
        DLLNode next; 
        DLLNode prev; 
        int key; 
        int value; 

        DLLNode(int key, int value){
            this.key = key; 
            this.value = value; 
        }
    }

    private DLLNode head; 
    private DLLNode tail;
    private int size; 
    private int capacity;
    private HashMap<Integer, DLLNode> map; 

    public LRUCache(int capacity) {
        head = null; 
        tail = null; 
        size = 0; 
        this.capacity = capacity;
        map = new HashMap<>(); 
    }
    
    public int get(int key) {
        //look for this key in the list
        DLLNode node = findKey(key);
        if(node != null){
        //if key found, make it most recently used and move it to the tail
            moveNodeToEnd(node);
        //return the corresponding value
            return node.value; 
        } else return -1; //node not found
    }

    private void moveNodeToEnd( DLLNode node){
        //

        DLLNode currNext = node.next; 
        DLLNode currPrev = node.prev; 

        if( node.key == tail.key){ //already at the tail
            return;
        }

        if(currNext == null && currPrev == null){ //single node case
            return; 
        }

        //disconnect this node
        node.next = null; 
        node.prev = null; 

        if(currNext == null){ // this is tail node- already taken care
            //do nothing
        } else if(currPrev == null){ //means this is head node and should be move to end
            currNext.prev = null; 
            head = currNext; 
        }else{ //currNext and currPrev both are not null
            currPrev.next = currNext; 
            currNext.prev = currPrev; 
        }

        //put this node at the tail
        tail.next = node; 
        node.prev = tail; 
        tail = node; 

    }



    private DLLNode findKey(int key){
        return map.get(key); 
    }

    private void addAtEnd(int key, int value){

        if(head == null){
            head = new DLLNode(key, value); 
            tail = head; 
        } else{
            DLLNode newNode = new DLLNode(key, value); 
            tail.next = newNode; 
            newNode.prev = tail;
            tail = newNode; 
        }

    }

    private void removeHead(){
        if(head == null){
            return; 
        }
        
        head = head.next; 
        if(head == null){ //after doing head = head.next if the head becomes null
            tail = null; //means only single node so tail is also null
        }else{
            head.prev = null;
        }
    }
    
    public void put(int key, int value) {
         //look for this key in the list
        DLLNode node = findKey(key);
        if(node != null){ 
            node.value = value; //update the value
            //move the node at the tail as it is going to be most recently used
            moveNodeToEnd(node); 
        } else{
            //if emtpy slot available
            if(size < capacity){
                //add new node at the tail with this key-value pair
                addAtEnd(key, value);
                map.put(key, tail); //also adding the key and node to the map for getFuntion 
                
                //increment the size
                size++; 
            } else { // if empty slot not available 
            //remove the LRU node from head...basically remove head node
            int removedKey = head.key; 
            removeHead();
            map.remove(removedKey); //while remvoing node we need to update our map


            //then add the new node at the tail
            addAtEnd(key, value);
            map.put(key, tail); //also adding the key and node to the map for getFuntion 

            }
        }
        
    }
}