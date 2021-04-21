import java.util.ArrayList;
import java.util.Arrays;

public class ZalandoCodeTest3 {

    // dice roll, return potential missing rolls
    public int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8

        // base case
        if(F < 0 || M < 1 || M > 6) {
            return new int[]{0};
        }

        int[] res = new int[F];
        int totalRolls = A.length + F;
        int sum = 0;

        // summ all know rolls 
        for (int el : A) {
            sum += el;
        }
        
        // remainder is the sum of potential dice rolls
        int remainderF = (M * totalRolls) - sum;

        // not possible if the potential roll is greater than the remainder or if the remainder is greater than 6 (max roll)
        if (F > remainderF || remainderF / F > 6) {
            return new int[] {0};
        }

        // loop for potential rolls
        for (int i = 0; i < res.length; i++) {
            // result is the potential roll, then decrement F for roll taken i.e. future rolls
            res[i] = remainderF/F--;
            // new remainder
            remainderF -= res[i];
        }
        return res;
    }

    public static void main(String[] args){
        ZalandoCodeTest3 zct3 = new ZalandoCodeTest3();
        System.out.println(Arrays.toString(zct3.solution(new int[]{3, 2, 4, 3}, 2, 4))); // [6,6]
        System.out.println(Arrays.toString(zct3.solution(new int[]{1, 5, 6}, 4, 3))); // [2,1,2,4] or [6,1,1,1]
    }
}
