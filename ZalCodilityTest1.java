public class ZalandoCodeTest1 {

    // Sum of all two digit numbers

    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int sum = 0;
        for (int i: A) {
            // positive digits
            if (i > 9 && i < 100) {
                sum += i;
            }
            // negative digits
            else if (i < -9 && i > -100){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        ZalandoCodeTest1 zct1 = new ZalandoCodeTest1();
        System.out.println(zct1.solution(new int[] { 1,1000,80,-91 } )); // -11
//        System.out.println(zct1.solution(new int[] { 47,1900,1,90,45 } )); // 182
    }
}
