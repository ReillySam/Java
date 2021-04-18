import java.util.HashSet;

public class OddOccurrencesInArray {

    HashSet<Integer> hs = new HashSet<Integer>();

    public int solution(int[] A) {
        // write your code in Java SE 8

        // store all values in hs for check

        for (int i = 0; i < A.length; i++) {
            int item = A[i];
            // operation structure here is important
            if (hs.contains(item)) {
                // remove reoccurrences
                hs.remove(item);
            } else {
                hs.add(item);
            }
        }
        // left with the odd occurrence
        return hs.iterator().next();

    }

    public static void main(String[] args) {
        OddOccurrencesInArray ooia = new OddOccurrencesInArray();
        System.out.println(ooia.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
//        System.out.println(ooia.solution(new int[]{42})); //42

    }
}
