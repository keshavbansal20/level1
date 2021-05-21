public void resize(){
    size = 0;
    LinkedList<HMNode>[] ob = buckets;
    buckets = new LinkedList[2 * ob.length];
    for(int i = 0 ; i < buckets.length; i++){
        buckets[i] = new LinkedList<>();
    }
    for(int i = 0 ; i < ob.length; i++){
        LinkedList<HMNode> ll = ob[i];
        for(int j = 0 ; j < ll.size(); j++){
            put(ll.get(j).key, ll.get(j).value);
        }
    }
    
}