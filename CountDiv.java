public class CountDiv {

    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        // to find start = a / k (round up)
        int base = (int)Math.ceil((double)A / K);

        // start = base x k
        base *= K;

        // subtract base div from end range
        B -= base;

        //( remainder / k )( round down)
        int result = (int)Math.floor((double)B / K);

        // add divisors
        result++;

        // return result
        return result;
    }


    public static void main(String[] args){
        CountDiv cd = new CountDiv();
        System.out.println(cd.solution( 2,11,2 )); // 3
//        System.out.println(cd.solution( 0,11,2 )); // 6
//        System.out.println(cd.solution( 2,21,2 )); // 10
    }
}
