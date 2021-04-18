import java.util.Arrays;

public class Triangle {

    public int solution(int[] A) {
        // write your code in Java SE 8
        // base case
        if (A.length <= 0){
            return 0;
        }
        // sort array in ascending order (0 ≤ P < Q < R < N)
        Arrays.sort(A);

        int tripCount = 0;
        // step through array comparing the elements as explained
        for (int i = 0; i < A.length-2; i++){
            int P = A[i];
            int Q = A[i + 1];
            int R = A[i + 2];
            if (((long)P + (long)Q > (long)R)
                && ((long)Q + (long)R > (long)P)
                    && ((long)P + (long)R > (long)Q)) {
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
    Triangle t = new Triangle();
    System.out.println(t.solution(new int[]{ 10,2,5,1,8,12 }));
//    System.out.println(t.solution(new int[]{ 10,50,5,1 }));
//    System.out.println(t.solution(new int[]{ }));

    }
}