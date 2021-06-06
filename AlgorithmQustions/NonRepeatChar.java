import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class NonRepeatChar{


    public static void main(String []args){

        System.out.println(nonRepeat("aababzbabnkrkk".toCharArray()));
        System.out.println(nonRepeat("k".toCharArray()));
        System.out.println(nonRepeat("rrthhjkknt".toCharArray()));
        System.out.println(nonRepeat("".toCharArray()));
        System.out.println(nonRepeat("dddccdbba".toCharArray()));


    }



    public static Character nonRepeat(char [] arr){


        Map<Character, Integer> charMap = new LinkedHashMap<>();


        for(int i =0; i< arr.length; i++){

            if(charMap.containsKey(arr[i])){
                int count = charMap.get(arr[i]);
                charMap.put(arr[i],++count);

            }else{
                charMap.put(arr[i],1);
            }

        }


        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){

            if(entry.getValue()==1){
               return entry.getKey().charValue();
          }

        }

        return null;

    }


}