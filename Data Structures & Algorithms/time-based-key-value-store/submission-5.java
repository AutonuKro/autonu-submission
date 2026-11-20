class TimeMap {
    private Map<String,String> map;
    private Map<String, List<Integer>> timestamps;
    public TimeMap() {
        map = new HashMap<>();
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String finalKey = key + "_" + timestamp;
        map.put(finalKey, value);
        List<Integer> list = timestamps.getOrDefault(key, new ArrayList<>());
        list.add(timestamp);
        timestamps.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key + "_" + timestamp)) {
            return map.get(key + "_" + timestamp);
        }
        if(!timestamps.containsKey(key)){
            return "";
        }
        List<Integer> list = timestamps.get(key);
        int l = 0, h = list.size() - 1;
        if(timestamp < list.get(l)) {
            return "";
        }
        while(l <= h) {
            int m = (h - l)/2 + l;
            if(list.get(m) > timestamp) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return map.get(key + "_" + list.get(l - 1));
    }
}
