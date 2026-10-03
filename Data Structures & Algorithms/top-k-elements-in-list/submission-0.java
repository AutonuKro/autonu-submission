class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer a : nums) {
            if(map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else {
                map.put(a, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int zero = Integer.compare(a.getValue(), b.getValue());
                return zero == 0 ? 0 : (-1 * zero);
            });
        for(var entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        int i = 0;
        int [] ans = new int[k];
        while( i < k && !maxHeap.isEmpty()) {
            var a = maxHeap.poll();
            ans[i] = a.getKey();
            i++;
        }
        return ans;
    }
}
