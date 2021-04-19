import java.util.HashMap;

public class ZalandoCodeTest2 {

    // phone dial, will do the corner cases another time

    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8
        // base cases
        // 0 < name string < 10
        // lowercase English letters
        // P is only digits
        // phone number only digits

        String result = "";

        // populate phone book (name, number)
        HashMap<String, String> phoneBook = new HashMap();
        for (int i = 0; i < A.length; i++) {
            phoneBook.put(A[i], B[i]);
        }

        // check for substring
        for (String a: phoneBook.values()) {
            if (a.contains(P)) {
                result = a;
            }
        }

        // return the contact
        String contact = "";
        for (String b: phoneBook.keySet()) {
            // assign the key to name
            if (phoneBook.containsValue(result)) {
                contact = b;
            }
        }
        return contact;
    }

    public static void main(String[] args){
        ZalandoCodeTest2 zct2 = new ZalandoCodeTest2();
        System.out.println(zct2.solution(new String[] {"pim", "pom"}, new String[]{"999999999", "777888999"}, "88999"));
    }
}
