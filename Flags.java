import java.util.ArrayList;


// Function does not work, need to come back

public class Flags {

    public int solution(int[] A) {
        // write your code in Java SE 8
        //base cases
        if (A.length == 0) {
            return 0;
        }
        // no neighbors so there must be no peak
        if (A.length == 1) {
            return 0;
        }
        // handle first and last elements
        if (A[0] >= A[1]) {
            return 0;
        }
        if (A[A.length - 1] >= A[A.length - 2]) {
            return A.length - 1;
        }

        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            int prev = A[i - 1];
            int curr = A[i];
            int next = A[i + 1];
            if (curr > prev && curr > next) {
                aList.add(curr);
            }
        }

        int sFlag = 1;
        int eFlag = aList.size(); // peak count
        int result = 1;
        // how many flags can fit in the array depending on peaks
        while (sFlag <= eFlag) {
            int K = (sFlag + eFlag) / 2; // flag distance K
            boolean successful = false;
            int used = 0;
            int setFlag = aList.get(0); // first peak
            for (int peak : aList) {
                if (peak >= setFlag) {
                    used++; // distance check
                    setFlag = peak + K;  // set flag at peak
                    if (used == K) {
                        successful = true;
                        break;
                    }
                }

            }
            if (successful) {
                result = K;
                sFlag = K + 1; // move start flag
            } else {
                eFlag = K - 1; // move end flag
            }
        }
        return result;
    }


    public static void main(String[] args){
        Flags f = new Flags();
        System.out.println(f.solution(new int[] { 1,5,3,4,3,4,1,2,3,4,6,2 })); // peaks idx 1,3,5,10
    }
}
