class MinStack {
    Stack<Integer> minIdx = new Stack();
    int topIdx = -1;
    List<Integer> array = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        array.add(val);
        topIdx = array.size() - 1;
        if(minIdx.isEmpty()) {
            minIdx.push(topIdx);
        } else {
            int currMinId = minIdx.peek();
            if(array.get(currMinId) >= val) {
                minIdx.push(topIdx);
            }
        }
    }
    
    public void pop() {
        if(topIdx < 0) {
            return;
        }
        int currMinId = minIdx.peek();
        int min = array.get(currMinId);
        int removed = array.remove(topIdx);
        topIdx = array.size() - 1;
        if(removed == min){
            minIdx.pop();
        }
    }
    
    public int top() {
        return array.get(topIdx);
    }
    
    public int getMin() {
        return array.get(minIdx.peek());
    }
}
