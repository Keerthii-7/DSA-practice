class RandomizedSet {
        Set<Integer> s;
    public RandomizedSet() {
       s=new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!s.contains(val)){
            s.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(!s.contains(val)){
            return false;
        }
        s.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = s.size();
        int item = new Random().nextInt(size); 
        int i = 0;
        for(Integer obj : s)
        {
            if (i == item)
                return obj;
            i++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */