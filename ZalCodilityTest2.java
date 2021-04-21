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
        // validate P
        if(!P.chars().allMatch(Character::isDigit) || P.length() == 0) {
            return "No Contact";
        }

        // populate phone book (name, number) + validation
        HashMap<String, String> phoneBook = new HashMap();
        for (int i = 0; i < A.length; i++) {
            // length of name string, skip if it's false
            if (A[i].length() <= 0 || A[i].length() > 9) {
                phoneBook.clear();
            }
            // lowercase english letters (this can be shortened), skip if it's false
            else if (!A[i].matches("^[a-z]+$") || !A[i].matches("[a-zA-Z]+")) {
                phoneBook.clear();
            }
            // phone number are only digits 1.. 9
            else if (!B[i].chars().allMatch(Character::isDigit)) {
                phoneBook.clear();
            }

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
            // assign the key(name) to contact
            if (phoneBook.get(b).equals(result)) {
                contact = b;
            }
        }
        return contact;
    }

    public static void main(String[] args){
        ZalandoCodeTest2 zct2 = new ZalandoCodeTest2();
//        System.out.println(zct2.solution(new String[] {"pim", "pom"}, new String[]{"9999999199", "777888999"}, "9199"));
//        System.out.println(zct2.solution(new String[] {"tom", "jerry"}, new String[]{"012345678", "777888999"}, "345"));
//        System.out.println(zct2.solution(new String[] {"Ed", "frank"}, new String[]{"999999999", "777888999"}, ""));
        System.out.println(zct2.solution(new String[] {"Ed11", "frank99"}, new String[]{"999999999", "777888999"}, "8899"));
    }
}
