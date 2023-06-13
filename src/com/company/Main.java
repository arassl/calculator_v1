package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Input:");
            String input = scanner.nextLine();

            System.out.println("Output:");
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static String calc(String input) throws Exception {
        String result = "";
        String[] array = extractNumbers(input);
        String operator = extractOperator(input);


        switch (operator) {
            case "+":
                result = Integer.toString(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));
                break;
            case "-":
                result = Integer.toString(Integer.parseInt(array[0]) - Integer.parseInt(array[1]));
                break;
            case "*":
                result = Integer.toString(Integer.parseInt(array[0]) * Integer.parseInt(array[1]));
                break;
            case "/":
                result = Integer.toString(Integer.parseInt(array[0]) / Integer.parseInt(array[1]));
                break;
        }

        return result;
    }

    public static String[] extractNumbers(String input) throws Exception {
        if (input.isEmpty()){
            throw new Exception("throws Exception: пустая строка, должно быть целое число 1-10 включительно");
        }

        String[] numbersArray;
        numbersArray = input.replaceAll("\\s", "").split("[+\\-*/]");

        if (numbersArray.length != 2) {
            throw new Exception("throws Exception: некорректный формат, должно быть два операнда (1-10) и один оператор (+, -, /, *)");
        }

        for (String s:numbersArray) {
            if (s.matches("\\d+")) {continue;}
            else {
                throw new Exception("throws Exception: некорректный формат, должно быть целое число 1-10 включительно");
            }
        }

        for (String s:numbersArray) {
            if (Integer.parseInt(s)>0 & Integer.parseInt(s)<=10) {continue;}
            else {throw new Exception("throws Exception: некорректный формат, должно быть целое число 1-10 включительно");}
        }

        return numbersArray;
    }

    public static String extractOperator(String input) throws Exception {
        String trimmedInput = input.replaceAll("\\s", "");
        String[] array = extractNumbers(input);
        String operator = trimmedInput;
        for (String s : array) {
            operator = operator.replaceAll(s, "");
        }
        if (operator.equals("+") | operator.equals("-") | operator.equals("*") | operator.equals("/")) {
            return operator;
        } else {
            throw new Exception("throws Exception: оператор может быть: +, -, *, /, ");
        }
    }
}
