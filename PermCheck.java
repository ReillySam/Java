import java.util.Arrays;
import java.util.HashSet;

public class PermCheck {

    public int solution(int[] A) {
        // write your code in Java SE 8
        // range can only be 1.. 100,000
        boolean[] seen = new boolean[A.length + 1];

        // repeated elements
//        System.out.println(Arrays.toString(seen));

        for (int i = 0; i < A.length; i++) {
            if(A[i] < 1 || A[i] > A.length) {
                return 0;
            }
            if(seen[A[i]]) {
                return 0;
            }
            else {
                seen[A[i]] = true;
            }
        }

        return 1;
    }

    public static void main(String[] args){
        PermCheck pc = new PermCheck();
        System.out.println(pc.solution(new int[]{ 4,1,3,2 })); // 1
//        System.out.println(pc.solution(new int[]{ 4,1,2 })); // 0
//        System.out.println(pc.solution(new int[]{ 1 })); // 1
//        System.out.println(pc.solution(new int[]{  })); // 0
//        System.out.println(pc.solution(new int[] { 1, 1, 3 })); // 0
//        System.out.println(pc.solution(new int[] { 3, 2, 1 })); // 1
//        System.out.println(pc.solution(new int[] { 1000000000 })); // 0
    }
}
