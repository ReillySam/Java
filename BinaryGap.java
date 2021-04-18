public class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        // convert N to binary string
        String bString = Integer.toString(N, 2);

        // boolean to start and end count
        boolean started = false;
        int counter = 0;
        int maxCount = 0;

        // loop string
        for (int i = 0; i<bString.length(); i++){
            String ch = bString.substring(i, i+1);

            // check for 1 and initialise count
            if (ch.equals("1")){
                // if started before
                if (started){
                    // set max count when bg start
                    if (counter > maxCount){
                        maxCount = counter;
                    }
                }
                // reset
                counter = 0;
                started = true;

            }
            // count zeros
            if (ch.equals("0")){
                counter++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args){
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.solution(9));
        System.out.println(bg.solution(529)); // 4
        System.out.println(bg.solution(32)); // 0

    }
}
