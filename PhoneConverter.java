import java.util.Scanner;

public class PhoneConverter {

    public static String getNumber() {
        String num = null;
        while (num == null) {
            System.out.println("Please Input 11 Digit Phone Number");
            Scanner scnr = new Scanner(System.in);
            String tmp = scnr.next();
            if (tmp.length() != 11) {
                System.out.println("Invalid Number, Please Try Again");
            }
            else {
                num = tmp;
                scnr.close();
            }
        }
        return num;
    }

    public static int convertToNum(String grossNum) {
        for (int i = 0; i < 11; i++) {
            char val = grossNum.charAt(i);
            if (Character.isDigit(val)) {
                continue;
            }
            else if(Character.isLetter(val)) {
                String newStr = grossNum.substring(0, i - 1) + 'i' + grossNum.substring(i + 1, grossNum.length());
                grossNum = newStr;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String num = getNumber();
        

    }


}