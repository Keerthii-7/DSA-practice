class Pair{
    String name;
    int height;
    Pair(String n,int h){
        this.name=n;
        this.height=h;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] arr=new Pair[names.length];
        for(int i=0;i<names.length;i++){
            arr[i]=new Pair(names[i],heights[i]);
        }
        Arrays.sort(arr,(e1,e2)->e2.height-e1.height);
        String[] ans=new String[names.length];
        for(int i=0;i<names.length;i++){
            ans[i]=arr[i].name;
        }
        return ans;
    }
}