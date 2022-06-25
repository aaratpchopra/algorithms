package xyz.aaratprasadchopra.hacker_rank.problem_solving.strings;

public class CamelCase {
    public static int camelCase(String s) {
        int totalWords = 0;
        if (s == "") {
            System.out.println(totalWords);
            return totalWords;
        }

        char[] charS = s.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (i == 0 || Character.isUpperCase(charS[i])) {
                totalWords++;
            }
        }
        System.out.println(totalWords);
        return totalWords;
    }
}
