import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDiff {

    public static void main(String[] args) {

        int arr1[] = new int[]{3, 5, 2, 7, 4, 2, 7};
        int arr2[] = new int[]{1, 7, 5, 2, 2, 9};

        printArrayDiff(arr1, arr2);

    }


    public static void printArrayDiff(int[] arr1, int[] arr2) {

        ArrayList<Integer> arrList1 = new ArrayList<>(arr1.length);
        for (int in : arr1) {
            arrList1.add(in);
        }

        ArrayList<Integer> arrList2 = new ArrayList<>(arr2.length);
        for (int in : arr2) {
            arrList2.add(in);
        }

        for (int in : arr1) {
            arrList2.remove(new Integer(in));
        }

        for (int in : arr2) {
            arrList1.remove(new Integer(in));
        }

        System.out.println(Arrays.toString(arrList1.toArray()));
        System.out.println(Arrays.toString(arrList2.toArray()));


    }
}
