class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                map.put(5,map.get(5)+1);
            }else if(bills[i]==10){
                if(map.get(5)==0){
                    return false;
                }
                else{
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)+1);
                }
            }else{
                if(map.get(10)==0){
                    if(map.get(5)==0){
                        return false;
                    }else{
                        int val=bills[i];
                        while(val>5){
                            if(map.get(5)==0){
                                return false;
                            }
                            map.put(5,map.get(5)-1);
                            val=val-5;
                        }
                    }
                }else{
                     map.put(10,map.get(10)-1);
                     if(map.get(5)==0){
                        return false;
                     }
                     else{
                        map.put(5,map.get(5)-1);
                        map.put(20,map.get(20)+1);
                     }   
                }
            }
        }
        return true;
    }
}