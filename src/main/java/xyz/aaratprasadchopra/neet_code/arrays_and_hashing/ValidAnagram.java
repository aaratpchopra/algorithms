package xyz.aaratprasadchopra.neet_code.arrays_and_hashing;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var hashMapS = new HashMap<Character, Integer>();
        var hashMapT = new HashMap<Character, Integer>();

        var charS = s.toCharArray();
        var charT = t.toCharArray();

        for (char c : charS) {
            if (Character.isAlphabetic(c)) {
                var getVal = hashMapS.get(c);
                if (getVal != null) {
                    hashMapS.put(c, ++getVal);
                } else {
                    hashMapS.put(c, 1);
                }
            }
        }

        for (char c : charT) {
            if (Character.isAlphabetic(c) && s.contains(Character.toString(c))) {
                var getVal = hashMapT.get(c);
                if (getVal != null) {
                    hashMapT.put(c, ++getVal);
                } else {
                    hashMapT.put(c, 1);
                }
            }
        }

        if (hashMapS.equals(hashMapT))
            return true;
        return false;
    }
}
