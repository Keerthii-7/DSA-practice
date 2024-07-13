class Triplet{
    int index;
    int pos;
    int h;
    char d;
    Triplet(int i,int p,int h,char c){
        this.index=i;
        this.pos=p;
        this.h=h;
        this.d=c;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Triplet[] a=new Triplet[positions.length];
        for(int i=0;i<positions.length;i++){
            a[i]=new Triplet(i,positions[i],healths[i],directions.charAt(i));
        }
        Arrays.sort(a,(a1,a2)->a1.pos-a2.pos);
        List<Integer> ans=new ArrayList<>();
        Stack<Triplet> st=new Stack<>();
        for(int i=0;i<positions.length;i++){
            if(a[i].d=='R'){
                 st.push(a[i]);
            }else {
                while (!st.isEmpty() && st.peek().d == 'R') {
                    Triplet curr = st.pop();
                    if (curr.h > a[i].h) {
                        curr.h--;
                        a[i].h = 0; // The left robot is destroyed
                        healths[a[i].index]=0;
                        healths[curr.index]--;
                        st.push(curr);
                        break;
                    } else if (curr.h < a[i].h) {
                        healths[a[i].index]--;
                        healths[curr.index]=0;
                        a[i].h--;
                    } else {
                        healths[a[i].index]=0;
                        healths[curr.index]=0;
                        a[i].h = 0; // Both robots destroy each other
                        break;
                    }
                }
                if (a[i].h > 0) {
                    st.push(a[i]);
                }
            }
        }
        for(int h:healths){
            if(h!=0)
            ans.add(h);
        }
        return ans;
    }
}