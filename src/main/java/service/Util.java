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
}
