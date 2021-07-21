import java.util.Scanner;

public class NumSysCalc {

    public static final String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args){

        String count;
        int degreeFrom;
        int degreeTo;

        count = "1MH";
        degreeFrom = 26;
        degreeTo = 10;

        String resultString;

        if(degreeTo == 10) {
            resultString = changeToDecimal(count, degreeFrom);
        }
        else if(degreeFrom==10){

            resultString = changeFromDecimal(count, degreeTo);
        }
        else{
            resultString = changeFromDecimal((changeToDecimal(count, degreeFrom)), degreeTo);
        }
        System.out.println(resultString);
    }

    private static String changeFromDecimal(String count, int degreeTo) {
        String resultString="";
        int currentNumber = Integer.parseInt(count.toUpperCase());

        while(currentNumber>0){

            int remDiv = currentNumber % degreeTo;

            resultString = digits.charAt(remDiv) + resultString;
            currentNumber/= degreeTo;
        }
        return resultString;
    }

    private static String changeToDecimal(String count, long degreeFrom) {
        int result = 0;
        int degree = 0;
        int currentNumber;
        count = count.toUpperCase();

        for (int i = count.length() - 1; i >= 0; i--) {

            char currentChar = count.charAt(i);
            currentNumber = digits.indexOf(currentChar);

            result = result + currentNumber * (int) Math.pow(degreeFrom, degree);
            degree++;
        }
        return Integer.toString(result);
    }
}
