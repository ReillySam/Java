import java.util.HashSet;

public class PermMissingElement {

    public int solution(int[] A) {
        // write your code in Java SE 8
        // add all values from 0 to n + 1 to a set. Distinct values

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= A.length+1; i++){
            hs.add(i);
        }

        // iterate over array and remove found values hs
        for (int i = 0; i <A.length; i++){
            hs.remove((Integer)A[i]);
        }
        // remaining value is the missing value
        return hs.iterator().next();
    }

    public static void main(String[] args){
        PermMissingElement pme = new PermMissingElement();
        System.out.println(pme.solution(new int[]{ 2,3,1,5 }));
        System.out.println(pme.solution(new int[]{  })); // 1
    }
}
