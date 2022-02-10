package service;

import java.util.List;

public abstract class StringServiceImpl implements StringService {

    @Override
    public String process(String input) {

        if (!validation(Util.StringToList(input))) return "";

        System.out.println(input);

        String output = input;

        for (Integer i = 0; i <= output.length(); i++) {

            output = traverse(Util.StringToList(output));
            System.out.println(output);

        }

        System.out.println("=============");

        return output;
    }



    private String traverse(List<String> list) {
        String body = "";
        String repeatLetter = "";
        Integer repeatCnt = 0;
        Integer len = list.size();
        Integer currentLocation = 0;

        if (len < 3) {
            return String.join("", list);
        }

        for (String current : list) {
            currentLocation++;

            //Repeating, not at the end
            if (repeatLetter.equals(current) && currentLocation <= len) {
                body = body + current;
                repeatCnt++;
            }

            //Repeating, at the end
            if (repeatLetter.equals(current) && repeatCnt >= 2 && currentLocation == len) {
                body = processRepeat(body, repeatCnt, repeatLetter);
            }

            //Repeating stopped, repeat cnt is larger than 2
            if (!repeatLetter.equals(current) && repeatCnt >= 2) {
                body = processRepeat(body, repeatCnt, repeatLetter) + current;
                repeatLetter = current;
                repeatCnt = 0;
            }

            //Repeating stopped, repeat cnt is smaller than 2
            if (!repeatLetter.equals(current) && repeatCnt < 2) {
                body += current;
                repeatLetter = current;
                repeatCnt = 0;
            }

        }
        return body;
    }

    public abstract String processRepeat(String body, Integer repeatCount, String repeatLetter);

    public boolean validation(List<String> li) {

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