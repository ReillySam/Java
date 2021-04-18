import java.math.BigInteger;

// hard q. taken from zalando challenge codility
// a lot of added code and poor efficiency

public class MaxPathFromTopLeftCorner {

    public String solution(int[][] A) {
        // write your code in Java SE 8

        String st = "";

        int v = A.length - 1;
        int h = A[0].length - 1;
        if (h == 0) {
            for (int i = 0; i <= v; i++) {
                st = st.concat(String.valueOf(A[i][0]));
            }
        } else if (v == 0) {
            for (int i = 0; i <= h; i++) {
                st = st.concat(String.valueOf(A[0][i]));
            }

        } else {

            st = st.concat(String.valueOf(A[0][0]));

            int m = 0; //vertical
            int n = 0; // horizontal
            while(m<v && n<h) {
                if(A[m+1][n]>=A[m][n+1]){
                    st = st.concat(String.valueOf(A[m+1][n]));
                    m++;
                }else {
                    st = st.concat(String.valueOf(A[m][n+1]));
                    n++;
                }

            }

            st = st.concat(String.valueOf(A[v][h]));
        }


        return st;
    }

    public static void main(String[] args){
        MaxPathFromTopLeftCorner mpftlc = new MaxPathFromTopLeftCorner();
        System.out.println(mpftlc.solution(new int[][] {{ 9,9,7 }, { 9,7,2 }, { 6,9,5 }, { 9,1,2 }}));
    }
}
