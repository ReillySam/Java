import java.util.ArrayList;
import java.util.Arrays;

public class ZalandoCodeTest3 {

    // dice roll, return missing results
    public int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8

        // base case
        if(F < 0 || M < 1 || M > 6) {
            return new int[]{0};
        }

        int[] res = new int[F];
        int totalRolls = A.length + F;
        int sum = 0;

        for (int el : A) {
            sum += el;
        }

        int remainderF = (M * totalRolls) - sum;

        //not possible 0 median
        if(F > remainderF || remainderF / F > 6) {
            return new int[] {0};
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = remainderF/F--;
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