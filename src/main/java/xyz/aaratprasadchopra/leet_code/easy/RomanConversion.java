package xyz.aaratprasadchopra.leet_code.easy;

import java.util.ArrayList;
import java.util.List;

public class RomanConversion {
    public static int romanToInt(String s) {
        String[] splitS = s.split("");
        List<String> pairs = new ArrayList<>();
        int total = 0;

        // III --> 3
        if (s.length() % 2 == 0) {
            for (int i = 0; i < splitS.length; i += 2) {
                pairs.add(splitS[i] + splitS[i + 1]);
            }
        } else {
            for (int i = 0; i < splitS.length; i += 2) {
                if (i == 0) {
                    pairs.add(splitS[i]);
                    i--;
                    continue;
                }
                pairs.add(splitS[i] + splitS[i + 1]);
            }
        }

        for (String pair : pairs) {
            String[] pairSplit = pair.split("");
            String storePrev = "";
            int tempCounter = 0;

            if (pairSplit.length == 1) {
                switch (pairSplit[0]) {
                    case "M":
                        total = 1000;
                        break;
                    case "D":
                        total = 500;
                        break;
                    case "C":
                        total = 100;
                        break;
                    case "L":
                        total = 50;
                        break;
                    case "X":
                        total = 10;
                        break;
                    case "V":
                        total = 5;
                        break;
                    case "I":
                        total = 1;
                        break;
                }
                continue;
            }

            for (int i = 0; i < pairSplit.length; i++) {
                switch (pairSplit[i]) {
                    case "M":
                        if (storePrev == "I" || storePrev == "V" || storePrev == "X" || storePrev == "L"
                                || storePrev == "C" || storePrev == "D") {
                            tempCounter = 1000 - tempCounter;
                        } else {
                            tempCounter += 1000;
                        }

                        break;
                    case "D":
                        if (storePrev == "I" || storePrev == "V" || storePrev == "X" || storePrev == "L"
                                || storePrev == "C") {
                            tempCounter = 500 - tempCounter;
                        } else {
                            storePrev = "D";
                            tempCounter += 500;
                        }

                        break;
                    case "C":
                        if (storePrev == "I" || storePrev == "V" || storePrev == "X" || storePrev == "L") {
                            tempCounter = 100 - tempCounter;
                        } else {
                            storePrev = "C";
                            tempCounter += 100;
                        }

                        break;
                    case "L":
                        if (storePrev == "I" || storePrev == "V" || storePrev == "X") {
                            tempCounter = 50 - tempCounter;
                        } else {
                            storePrev = "L";
                            tempCounter += 50;
                        }

                        break;
                    case "X":
                        if (storePrev == "I" || storePrev == "V") {
                            tempCounter = 10 - tempCounter;
                        } else {
                            storePrev = "X";
                            tempCounter += 10;
                        }

                        break;
                    case "V":
                        if (storePrev == "I") {
                            tempCounter = 5 - tempCounter;
                        } else {
                            storePrev = "V";
                            tempCounter += 5;
                        }

                        break;
                    case "I":
                        storePrev = "I";
                        tempCounter += 1;
                        break;
                }
            }
            total += tempCounter;
        }
        System.out.println(total);
        return total;
    }

    public static int intConversion() {

        

        return 1;
    }
}
