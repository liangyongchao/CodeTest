package service;

import pojo.Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static List StringToList(String input) {

        List list = Arrays.asList(input.split(""));

        return list;
    }

    public static String GetFrontLetter(String input) {

        ArrayList<String> list = Alphabet.alphabet;

        Integer i = list.indexOf(input);

        String front = (i > 0) ? list.get(i - 1) : "";

        return front;

    }

    public static boolean inputListValidation(List<String> li) {

        String badChar = "";

        badChar = (String) li.stream().filter(ch -> !Character.isLowerCase(ch.charAt(0)))
                .findAny().map(r -> {
                    System.out.println("Input Invalid");
                    return r;
                })
                .orElse("");

        return (badChar == "") ? true : false;
    }
}
