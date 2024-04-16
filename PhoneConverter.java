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

    public static int letterToString(char let) {

        let = Character.toLowerCase(let);
        
        switch(let) {
            case 'a','b','c':
                return 2;
            case 'd','e','f':
                return 3;
            case 'g','h','i':
                return 4;
            case 'j','k','l':
                return 5;
            case 'm','n','o':
                return 6;
            case 'p','q','r','s':
                return 7;
            case 't','u','v':
                return 8;
            case 'w','x','y','z':
                return 9;
        }
        
        return 1;
    }

    public static long convertToNum(String grossNum) throws Exception {
        for (int i = 0; i < 11; i++) {
            char val = grossNum.charAt(i);
            if (Character.isDigit(val)) {
                continue;
            }
            else if(Character.isLetter(val)) {
                int letter = letterToString(grossNum.charAt(i));
                String ah = Integer.toString(letter);
                String newStr = grossNum.substring(0, i) + "" + ah + "" + grossNum.substring(i + 1, grossNum.length());
                grossNum = newStr;
            }
            else {
                throw new Exception(grossNum.charAt(i) + " Character not allowed, please try again");
            }
        }
        long finalVal = Long.parseLong(grossNum);
        return finalVal;
    }
    public static void main(String[] args) throws Exception {
        String num = getNumber();
        long finalVal = convertToNum(num);
        System.out.println(finalVal);
        
    }


}