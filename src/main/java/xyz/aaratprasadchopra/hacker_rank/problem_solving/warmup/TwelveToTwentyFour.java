package xyz.aaratprasadchopra.hacker_rank.problem_solving.warmup;

public class TwelveToTwentyFour {
    public static String timeConversion(String s) {
        String amOrPm = s.substring(8).toUpperCase();
        String twelve = s.substring(0, 2);
        if (amOrPm.equals("AM") && twelve.equals("12")) {
            s = s.substring(2, 8);
            System.out.println("00" + s);
            return "00" + s;
        } else if (amOrPm.equals("PM") && twelve.equals("12")) {
            System.out.println(s.substring(0, 8));
            return s.substring(0, 8);
        } else if (amOrPm.equals("AM")) {
            System.out.println(s.substring(0, 8));
            return s.substring(0, 8);
        } else {
            String backupS = s.substring(2, 8);
            s = s.substring(0, 2);
            int twentyFourHour = 12 + Integer.parseInt(s);
            String finalS = String.valueOf(twentyFourHour) + backupS;
            System.out.println(finalS);
            return finalS;
        }
    }
}
