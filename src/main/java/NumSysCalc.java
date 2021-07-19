import java.util.Scanner;

public class NumSysCalc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String count = "4F1";
        long degreeFrom;
        long degreeTo;

        degreeFrom = 16;
        degreeTo = 2;

        long result;
        String resultString;

        if(degreeTo == 10) {

            System.out.println(changeToDecimal(count, degreeFrom));
        }
        if(degreeFrom==10){

            System.out.println(changeFromDecimal(count, degreeTo));
        }
        else{
            System.out.println(changeFromDecimal((changeToDecimal(count, degreeFrom)), degreeTo));
        }
    }

    private static String changeFromDecimal(String count, long degreeTo) {
        String resultString="";
        int currentNumber = Integer.parseInt(count);

        while(currentNumber>0){
            long modulo = currentNumber% degreeTo;

            if(modulo>9){
                resultString = resultString + (char)(modulo+55);
            }
            else {
                resultString = resultString + modulo;
            }
            currentNumber/= degreeTo;
        }
        String reversedString = new StringBuffer(resultString).reverse().toString();
        return reversedString;
    }

    private static String changeToDecimal(String count, long degreeFrom) {
        int result =0;
        long degree = 0;
        int currentNumber;

        for (int i = count.length() - 1; i >= 0; i--) {
            char currentChar = count.charAt(i);

            if(Character.isLetter(count.charAt(i))){
                currentNumber = currentChar - 55;
            }
            else {
                currentNumber = currentChar - '0';
            }
            result = result + currentNumber * (int) Math.pow(degreeFrom, degree);
            degree++;
        }
        return Integer.toString(result);
    }
}
