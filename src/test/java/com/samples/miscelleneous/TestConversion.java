package com.samples.miscelleneous;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**

 MS-Excel columns has naming conventions like A..Z,AA,AB..AZ, BA, BB...

 column 1 is called as “A”, column 2 as “B”, column 27 as “AA” and so on.

 Write a function to take a column number as input and output the column name

 eg: col num  - col name

 5 - E
 26 - Z
 27 - AA
 28 - AB

 702 - ZZ
 703 - AAA


 */

public class TestConversion {

    static Map<Integer, Character> conversionMap = new HashMap<>();

    static {
        conversionMap.put(1, 'A');
        conversionMap.put(2, 'B');
        conversionMap.put(3, 'C');
        conversionMap.put(4, 'D');
        conversionMap.put(5, 'E');
        conversionMap.put(6, 'F');
        conversionMap.put(7, 'G');
        conversionMap.put(8, 'H');
        conversionMap.put(9, 'I');
        conversionMap.put(10, 'J');
        conversionMap.put(11, 'K');
        conversionMap.put(12, 'L');
        conversionMap.put(13, 'M');
        conversionMap.put(14, 'N');
        conversionMap.put(15, 'O');
        conversionMap.put(16, 'P');
        conversionMap.put(17, 'Q');
        conversionMap.put(18, 'R');
        conversionMap.put(19, 'S');
        conversionMap.put(20, 'T');
        conversionMap.put(21, 'U');
        conversionMap.put(22, 'V');
        conversionMap.put(23, 'W');
        conversionMap.put(24, 'X');
        conversionMap.put(25, 'Y');
        conversionMap.put(26, 'Z');
    }

    static String convertToColumnIndex(int number) {
        Stack<String> derivedChars = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            int quotient = number / 26;
            int remainder = number % 26;
            if(remainder == 0) {
                //This will be zero, when the input is completely divisible by 26. Only executes ones
                derivedChars.push("Z");
                number = quotient -1;
            } else {
                derivedChars.push(String.valueOf(conversionMap.get(remainder)));
                number = quotient;
            }
        }
        while(!derivedChars.isEmpty()) {
            sb.append(derivedChars.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToColumnIndex(1));//A
        System.out.println(convertToColumnIndex(27));//AA
        System.out.println(convertToColumnIndex(53));//BA
        System.out.println(convertToColumnIndex(55)); //BC
        System.out.println(convertToColumnIndex(703));//AAA

        System.out.println(convertToColumnIndex(26));//Z
        System.out.println(convertToColumnIndex(52));//AZ
        System.out.println(convertToColumnIndex(78));//BZ
        System.out.println(convertToColumnIndex(702));//ZZ
        System.out.println(convertToColumnIndex(728));//AAZ
        System.out.println(convertToColumnIndex(26000));//ALKZ
        System.out.println(convertToColumnIndex(475254));//ZZZZ
    }
}
