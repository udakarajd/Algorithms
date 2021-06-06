import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortCharsByFreq {
}


class Solution {

    public String frequencySort(String s) {

        Map<Character, Integer> charMap  = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int size = s.length();

        for(int i=0; i<size; i++) {

            if(charMap.containsKey(s.charAt(i)) ){
                int count = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i), ++count);
            }else{
                charMap.put(s.charAt(i), 1);
            }

        }
        Comparator<Map.Entry<Character, Integer>> cmp = Map.Entry.comparingByValue();

        charMap.entrySet().stream().sorted(cmp);

        return sb.toString();

    }


}
