package xyz.aaratprasadchopra.leet_code.easy;

public class LongestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefixes = "";

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == "")
                continue;
            String letter = "";
            for (int j = 0; j < strs.length; j++) {
                String[] splitStrs = strs[j].split("");
                if (j == 0 && !splitStrs[i].equals("")) {
                    letter = splitStrs[i];
                    continue;
                }
                if (letter.equals(splitStrs[i]))
                    continue;
                else
                    return prefixes;
            }
            prefixes += letter;
        }
        System.out.println(prefixes);
        return prefixes;
    }
}
