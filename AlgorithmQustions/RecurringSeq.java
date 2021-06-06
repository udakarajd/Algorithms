import java.util.ArrayList;

public class RecurringSeq {

    public static void main(String [] args){

        System.out.println(getRecurring(50,22));


    }


    static int getRecurring(int num, int deno){

        int remainder = num%deno;

        if(remainder == 0){
            return -1;
        }

        ArrayList<Integer> remainders = new ArrayList<>();
        remainders.add(remainder);

        int result =0;

        while (true){

            remainder = remainder*10;
            result = (result * 10) + (remainder/deno);
            int newRemainder = remainder % deno;

            if(remainder ==0)
                break;
            if(remainders.contains(newRemainder)){
                return result;
            }

            remainder = newRemainder;

        }


        return -1;

    }

}
