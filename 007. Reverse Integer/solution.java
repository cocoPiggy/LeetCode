
class Solution {
    public int reverse(int x) {
        int res =0;
        while(x!=0){
            int temp=res*10+x%10;
            x=x/10;
            if(res!=temp/10){
                return 0;
            }
            res=temp;
        }
        return res;
    }
}
