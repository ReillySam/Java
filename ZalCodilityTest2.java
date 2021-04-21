import java.util.HashMap;
import java.util.Locale;

public class ZalCodilityTest2 {

    // phone dial, will do the corner cases another time

    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8
        // base cases
        // 0 < name string < 10
        // lowercase English letters
        // P is only digits
        // phone number only digits

        // validate P
        if(!P.chars().allMatch(Character::isDigit) || P.length() == 0) {
            return "No Contact";
        }

        HashMap<String, String> phoneBook = new HashMap();
        // populate phone book (name, number) + lowercase english letters. Chosen to add 
        for (int i = 0; i < A.length; i++)  {
            phoneBook.put(A[i], B[i]);
        }

        // if entry contains an illegal character remove it
        for (int i = 0; i < A.length; i++) {
            // length of name string, skip if it's false
            if (A[i].length() <= 0 || A[i].length() >= 10) {
                phoneBook.remove(A[i]);
            }
            // lowercase English letters and digits
            else if (!A[i].matches("^[a-z]+$") || !A[i].matches("[a-zA-Z]+") || A[i].matches(".*\\d.*")) {
                phoneBook.remove(A[i]);
            }
            // phone number only digits 1.. 9
            else if (!B[i].chars().allMatch(Character::isDigit)) {
                phoneBook.remove(A[i]);
            }
        }
        
        // check for substring        
        String result = "";
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
        ZalCodilityTest2 zct2 = new ZalCodilityTest2();
        System.out.println(zct2.solution(new String[] {"pim", "pom"}, new String[]{"9999999199", "777888999"}, "8899")); //pom
        System.out.println(zct2.solution(new String[] {"tom", "jerry"}, new String[]{"012345678", "777888999"}, "345")); //tom
        System.out.println(zct2.solution(new String[] {"ed", "frank"}, new String[]{"999999999", "777888999"}, "")); // No contact
        System.out.println(zct2.solution(new String[] {"eddie", "frank99"}, new String[]{"999999999", "777888999"}, "8899")); // No contact
        System.out.println(zct2.solution(new String[] {"jerry", "Frank"}, new String[]{"999999999", "777888999"}, "8899")); // No contact
    }
}
