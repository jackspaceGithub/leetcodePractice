/**
 * 242. Valid Anagram
 * 相同字母异序词
 * 有效的字母移位词
 */
public class P242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram") ? "true" : "false");
    }


    public static boolean isAnagram(String s, String t) {
        int word[] = new int[30];
        int word2[] = new int[30];
        char[] charlistS = s.toCharArray();
        char[] charlistT = t.toCharArray();
        for(int i = 0; i < charlistS.length; i++) {
            word[charlistS[i] - 'a']++;
        }

        for(int i = 0; i < charlistT.length; i++) {
            word2[charlistT[i] - 'a']++;
        }

        for(int i = 0; i < 30; i++) {
            if(word[i] != word2[i]) {
                return false;
            }
        }
        return true;
    }

}
