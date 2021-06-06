import java.util.HashSet;
import java.util.Set;

public class KMinusPair {


    public static void main(String [] args){
        Solution sol = new Solution();
        sol.findPairs(new int[]{3,1,4,1,5},2);

    }

    static class Solution {
        public int findPairs(int[] nums, int k) {

            int result=0;


            Set<Pair> memo = new HashSet<>();

            Pair pair;

            for(int i = 0; i< nums.length; i++){

                for(int j = i+1; j < nums.length; j++ ){
                    pair = new Pair(nums[i],nums[j]);
                    if(!memo.contains(pair) && Math.abs(nums[i] - nums[j])==k){
                        result++;
                        memo.add(pair);
                        System.out.println(pair.toString());
                    }
                }

            }

            return result;


        }
    }

    static class Pair{

        public int a;
        public int b;
        public Pair(int a , int b){
            this.a = a;
            this.b = b;
        }


        @Override
        public boolean equals(Object ob1){
            if(ob1==null)
                return false;

            if(!(ob1 instanceof Pair)){
                return false;
            }
            Pair ob = (Pair) ob1;
            if(this.a == ob.a && this.b == ob.b) {
                return true;

            }if(this.b == ob.a && this.a == ob.b){
                return true;
            }

            return false;
        }

        @Override
        public int hashCode(){
            final int prime = 31;
            return prime*(a+b);
    }
        @Override
        public String toString(){
            return "Pair ("+a+", "+b+")";
        }


    }



}
