class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(Integer a : map.keySet()) {
            heap.add(a);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        int [] top = new int[k];
        int i = 0;
        while(i < k) {
            top[i++] = heap.poll();
        }
        return top;
    }
}
