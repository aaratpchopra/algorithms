package xyz.aaratprasadchopra.hacker_rank.problem_solving.strings;

public class StrongPsw {
    public static int minimumNumber(int n, String password) {
        int strongRatio = 0;
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_char = "!@#$%^&*()-+";

        if (!includes(password, numbers))
            strongRatio++;
        if (!includes(password, lowerCase))
            strongRatio++;
        if (!includes(password, upperCase))
            strongRatio++;
        if (!includes(password, special_char))
            strongRatio++;

        strongRatio = Math.max(strongRatio, 6 - n);

        System.out.println(strongRatio);
        return strongRatio;
    }

    private static boolean includes(String password, String field) {
        char[] charPsw = password.toCharArray();

        for (int i = 0; i < charPsw.length; i++) {
            switch (field) {
                case "0123456789":
                    if (Character.isDigit(charPsw[i]))
                        return true;
                    break;
                case "abcdefghijklmnopqrstuvwxyz":
                    if (Character.isLowerCase(charPsw[i]))
                        return true;
                    break;
                case "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
                    if (Character.isUpperCase(charPsw[i]))
                        return true;
                    break;
                case "!@#$%^&*()-+":
                    if (charPsw[i] == '!' || charPsw[i] == '@' || charPsw[i] == '#' || charPsw[i] == '$'
                            || charPsw[i] == '%' || charPsw[i] == '^' || charPsw[i] == '&' || charPsw[i] == '*'
                            || charPsw[i] == '(' || charPsw[i] == ')' || charPsw[i] == '-' || charPsw[i] == '+')
                        return true;
                    break;
            }
        }
        return false;
    }
}
