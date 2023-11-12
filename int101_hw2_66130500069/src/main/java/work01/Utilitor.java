package work01;

public class Utilitor {
    public static String testString(String value) {
        if (value == null)
            throw new NullPointerException("This value null");
        if (value.isEmpty())
            throw new IllegalArgumentException("This value blank string");
        return value;
    }

    public static double testPositive(double value) {
        if (value < 0)
            throw new IllegalArgumentException("The value negative");
        return value;
    }

    public static long computeIsbn10(long isbn10) {

        if (String.valueOf(isbn10).length() != 9) {
            throw new IllegalArgumentException("should 9 digit number.");
        }

        String stringIsbn = String.valueOf(isbn10);
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(stringIsbn.charAt(i));
            sum += (i + 1) * digit;
        }

        int remain = sum % 11;
        if (remain == 0) {
            return 0;
        } else {
            return 11 - remain;
        }

    }
}
