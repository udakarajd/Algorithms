public class TrainTickets {

    public static void main(String [] args){
        Solution sol = new Solution();
        System.out.println(sol.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,20}));
    }



    static class Solution {

        static boolean[] travelForDay;

        public int mincostTickets(int[] days, int[] costs) {

            int lastTravelDate = days[days.length-1];

            travelForDay = new boolean[ lastTravelDate + 1 ];

            for(int i = 0; i< days.length; i++){
                travelForDay[days[i]]=true;
            }

            return getMinCost( lastTravelDate , costs);

        }

        private int getMinCost(int day, int[] costs) {

            if(day<=0)
                return 0;

            if(!travelForDay[day])
                return getMinCost(day -1, costs);

            int oneDayCost = getMinCost(day-1, costs) + costs[0];
            int sevenDayCost = getMinCost(day-7, costs) + costs[1];
            int thirtyDayCost = getMinCost(day-30, costs) + costs[2];

            int min =Math.min(oneDayCost,sevenDayCost);

            return Math.min(min, thirtyDayCost);

        }

    }

}
