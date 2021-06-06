import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FequencyAccending {

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int val :nums){

            int count = freqMap.getOrDefault(val,0);

            freqMap.put(val, ++count);
        }


        Comparator<Map.Entry<Integer, Integer>> cmp = (a, b)->{

            if(a.getValue()==b.getValue()){
                return b.getKey()-a.getKey();
            }
            return a.getValue()-b.getValue();
        };

        ArrayList<Integer> list = new ArrayList<>();

        freqMap.entrySet().stream().sorted(cmp).forEach((entry)->{

            for(int i =0; i<entry.getValue(); i++){
                list.add(entry.getKey());
            }

        });

        return list.stream().mapToInt(i->i).toArray();


    }
}
