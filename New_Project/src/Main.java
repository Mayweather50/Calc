import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public  class Main {

    public static void main(String[] args)
    {
        //Scanner input = new Scanner(System.in);
        //String inputString = input.nextLine();
        //String result = calc(inputString);


        String input = "5 / 3";
        System.out.println(calc(input));



    }




    public static String calc(String input) {
        String[] parts = input.split(" ");
        boolean inter = parts[0].matches("[-+]?\\d+")
                &&parts[1].matches("[-+]?\\d+");
        int numInteger1 = Integer.parseInt(parts[0]);
        int numInteger2 = Integer.parseInt(parts[1]);
        if (inter) {

            if (numInteger1 <= 0 || numInteger2 > 10) {
                throw new IllegalArgumentException("Numbers must be in the range 1-10");
            }
        }

        int num1 = ToArabic(parts[0]);
        String operator = parts[1];
        int num2 = ToArabic(parts[2]);
        int result;
        int operand1 = inter ? numInteger1 : num1;
        int operand2 = inter ? numInteger2 : num2;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Error! Dividing by zero is not allowed.");
                }
                break;
            default:
                throw new IllegalArgumentException("Error! Invalid operator. Only +, -, * and / are allowed.");
        }
        if(inter){
            return Integer.toString(result);
        }

        else {


        return ToRoman(result);
        }
    }

    public static int ToArabic(String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral");
        }
    }
    public static String ToRoman(int arabic) {
        switch (arabic) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                throw new IllegalArgumentException("Invalid Arabic numeral");
        }
    }



}



