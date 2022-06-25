package xyz.aaratprasadchopra.FCC_10_common;

import java.util.ArrayList;
import java.util.HashMap;

public class Anagram {
    public static void anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println(false);
            return;
        }
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        var patternStr1 = new ArrayList<Integer>();
        var patternStr2 = new ArrayList<Integer>();

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphaArr = alphabets.toCharArray();

        var str1HM = new HashMap<Character, Integer>();
        var str2HM = new HashMap<Character, Integer>();

        for (int i = 0; i < alphaArr.length; i++) {
            str1HM.put(alphaArr[i], 0);
        }

        for (int i = 0; i < alphaArr.length; i++) {
            str2HM.put(alphaArr[i], 0);
        }

        var str1Arr = str1.toCharArray();
        var str2Arr = str2.toCharArray();

        for (int i = 0; i < str1Arr.length; i++) {
            if (Character.isAlphabetic(str1Arr[i])) {
                int val = str1HM.get(str1Arr[i]);
                val++;
                str1HM.replace(str1Arr[i], val);
            }
        }

        for (int i = 0; i < str2Arr.length; i++) {
            if (Character.isAlphabetic(str2Arr[i])) {
                int val = str2HM.get(str2Arr[i]);
                val++;
                str2HM.replace(str2Arr[i], val);
            }
        }

        str1HM.entrySet().forEach(entry -> patternStr1.add(entry.getValue()));
        str2HM.entrySet().forEach(entry -> patternStr2.add(entry.getValue()));

        if (patternStr1.equals(patternStr2))
            System.out.println(true);
        else
            System.out.println(false);
    }
}
