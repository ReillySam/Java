import java.util.HashMap;

public class DemoTest {

    public int solution(int[] A) {
        // write your code in Java SE 8

        // base cases
        if (A.length == 0) {
            return 1;
        }

        // add smallest present int to map
        int smallPosInt = 1;
        HashMap<Integer, Boolean> currSPI = new HashMap<>();

        for (int i = 0; i <A.length; i++) {
            if (A[i] > 0 && !currSPI.containsKey(A[i])) {
                currSPI.put(A[i], true);
            }
        }

        // check for missing int
        while (currSPI.containsKey(smallPosInt)){
            smallPosInt++;
        }
        return smallPosInt;
    }

    public static void main(String[] args){
        DemoTest dt = new DemoTest();
        System.out.println(dt.solution(new int[] { 1,3,6,4,1,2 })); // 5
//        System.out.println(dt.solution(new int[] { -1, -3 })); // 1
//        System.out.println(dt.solution(new int[] { 1,2,3 })); // 4
    }
}
