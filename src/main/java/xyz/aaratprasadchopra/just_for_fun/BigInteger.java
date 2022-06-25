package xyz.aaratprasadchopra.just_for_fun;

public class BigInteger implements Comparable<BigInteger> {
    private String value;

    public BigInteger() {
        this.value = "0";
    }

    public BigInteger(int value) {
        if (value < 0)
            System.out.println("NEGATIVE NUMBERS NOT IMPLEMENTED!");
        this.value = Integer.toString(value);
    }

    public BigInteger(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public char[] chars() {
        return this.value.toCharArray();
    }

    public int length() {
        return this.value.length();
    }

    @Override
    public int compareTo(BigInteger otherBI) {

        if (this.length() > otherBI.length())
            return 1;
        else if (this.length() < otherBI.length())
            return 0;

        char[] thisChars = this.chars();
        char[] otherBIChars = otherBI.chars();

        for (int i = 0; i < this.length(); i++) {
            int thisCharDigit = Character.getNumericValue(thisChars[i]);
            int otherBICharDigit = Character.getNumericValue(otherBIChars[i]);

            if (thisCharDigit > otherBICharDigit)
                return 1;
            else if (thisCharDigit < otherBICharDigit)
                return -1;
        }

        return 0;
    }

    private static String[] equalLengths(BigInteger bI1, BigInteger bI2) {
        String bI1Value;
        String bI2Value;

        if (bI1.length() == bI2.length()) {
            bI1Value = bI1.getValue();
            bI2Value = bI2.getValue();
        } else if (bI1.length() > bI2.length()) {
            bI1Value = bI1.getValue();
            bI2Value = "0".repeat(bI1.length() - bI2.length()) + bI2.getValue();
        } else {
            bI1Value = "0".repeat(bI2.length() - bI1.length()) + bI1.getValue();
            bI2Value = bI2.getValue();
        }

        return new String[] { bI1Value, bI2Value };
    }

    public void add(int value) {
        add(new BigInteger(value));
    }

    public void add(BigInteger otherBI) {
        String[] bI1_2 = equalLengths(this, otherBI);

        char[] bI1Char = bI1_2[0].toCharArray();
        char[] bI2Char = bI1_2[1].toCharArray();

        int overflow = 0;

        var result = new StringBuilder();

        for (int i = bI1Char.length - 1; i >= 0; i--) {
            int bI1Digit = Character.getNumericValue(bI1Char[i]);
            int bI2Digit = Character.getNumericValue(bI2Char[i]);
            int digitSum = bI1Digit + bI2Digit + overflow;
            result.append(digitSum % 10);
            overflow = digitSum / 10;
        }

        this.value = (overflow == 0 ? "" : "1") + result.reverse().toString();
    }

}
