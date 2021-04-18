import java.util.*;

public class Dominator{

    public int solution(int[] A) {
        // write your code in Java SE 8
        // base case
        if (A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return A[0];
        }

        // store ints in map or checking, key is num value is 0
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            map.put(j, 0);
        }

        int counter = 0;
        int domValue = 0, domKey = 0;

        // add one to kvp for each time it appears in the array
        for (int j : A) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
                counter = map.get(j);
            }
            // assign dominator value
            if (domValue < counter) {
                domValue = counter;
            }
        }

        // assign dominator int (key)
        for( int key: map.keySet() ){
            int currentCount = map.get(key);
            if (domValue == currentCount) {
                domKey = key;
            }
        }

        // check if dominator passes and print the index location of each
        if (domValue > A.length / 2) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == domKey) {
                    return i;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args){
        Dominator d = new Dominator();
        System.out.println(d.solution(new int[] { 3,4,3,2,3,-1,3,3 })); // 0,2,4,6,7
//        System.out.println(d.solution(new int[] { })); // -1
//        System.out.println(d.solution(new int[] { 50 })); // 0

    }
}