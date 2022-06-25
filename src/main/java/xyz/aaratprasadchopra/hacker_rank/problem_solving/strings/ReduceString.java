package xyz.aaratprasadchopra.hacker_rank.problem_solving.strings;

public class ReduceString {
    public static String superReducedString(String s) {
        String[] splitS = s.split("");
        StringBuilder finalS = new StringBuilder();
        boolean notRepeating = false;
        boolean isRepeating = false;
        int j = 0;

        for (j = 0; j < s.length(); j++) {
            if (notRepeating) {
                System.out.println(j);
                System.out.println(finalS);
                return finalS.toString();
            }
            for (int i = 0; i < splitS.length; i++) {
                if (i < splitS.length - 1 && splitS[i].equals(splitS[i + 1])) {
                    splitS[i] = "";
                    splitS[i + 1] = "";
                    i++;
                    continue;
                }
                finalS.append(splitS[i]);
            }

            if (finalS.toString().equals(""))
                break;

            String[] checkArr = finalS.toString().split("");

            for (int i = 0; i < checkArr.length - 1; i++) {
                if (checkArr[i].equals(checkArr[i + 1])) {
                    isRepeating = true;
                    splitS = checkArr;
                    finalS = new StringBuilder();
                    break;
                }
            }
            if (!isRepeating)
                notRepeating = true;
            isRepeating = false;
        }

        System.out.println(j);
        System.out.println("Empty String");
        return "Empty String";
    }
}
