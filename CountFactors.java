public class CountFactors {

    public int solution(int N) {
        // write your code in Java SE 8
        // use the square root of a number to check factors of N
        int factors = 0;

        for (int i = 1; i <= Math.sqrt(N); i++){
            if(N%i == 0){
                if (N / i == i){
                    factors++;
                }
                else {
                    factors += 2;
                }
            }
        }
        return factors;
    }


    public static void main(String[] args){
        CountFactors cf = new CountFactors();
        System.out.println(cf.solution(24));
//        System.out.println(cf.solution(100)); // 9
//        System.out.println(cf.solution(0)); // 0
//        System.out.println(cf.solution(1)); // 1
    }
}
