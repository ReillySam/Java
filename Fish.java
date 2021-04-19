import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        // base case, zero fish
        if(A.length == 0){
            return 0;
        }

        // all elements are distinct, use set or stack and counter
        int aliveFish = A.length;
        Stack<Integer> river = new Stack<>();


        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1){
                // push downstream fish to stack
                river.push(A[i]);
            }
            // downstream vs upstream
            if (B[i] == 0) {
                // while there is fish still in the river
                while (!river.isEmpty()){
                    // push if the fish in the stack is > than current fish
                    if (river.peek() > A[i]){
                        aliveFish--;
                        break;
                    }
                    // otherwise remove it
                    else if (river.peek() < A[i]) {
                        aliveFish--;
                        river.pop();
                    }
                }
            }
        }
        return aliveFish;
    }

    public static void main(String[] args){
        Fish f = new Fish();
        System.out.println(f.solution(new int[]{ 4,3,2,1,5 }, new int[] { 0,1,0,0,0 })); // 1

    }
}
