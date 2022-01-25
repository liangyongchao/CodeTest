package service;

import java.util.List;

public class StringServiceImpl implements StringService {

    private char chars[];
    private List<String> list;

    private Integer tagRemove = 1;
    private Integer tagReplace = 2;


    @Override
    public String process(String input, Integer tag) {

        this.list = Util.StringToList(input);

        if (!validation(list)) return "";

        String output = input;
        for (Integer i = 0; i <= output.length(); i++) {
            output = processWithTag(Util.StringToList(output), tag);
        }
        return output;
    }


    private String processWithTag(List<String> list, Integer tag) {
        String body = "";
        String repeatLetter = "";
        Integer repeatCnt = 0;
        Integer len = list.size();
        Integer currLocation = 0;

        if (len < 3) {
            return String.join("", list);
        }

        for (String curr : list) {
            currLocation++;

            //Repeating, not at the end
            if (repeatLetter.equals(curr) && currLocation < len) {
                body = body + curr;
                repeatCnt++;
            }

            //Repeating, at the end
            if (repeatLetter.equals(curr) && currLocation == len) {
                body = processRepeat(body, repeatCnt, repeatLetter, tag);
            }

            //Repeating stopped, repeat cnt is larger than 2, not at the end
            if (!repeatLetter.equals(curr) && repeatCnt >= 2 && currLocation < len) {
                body = processRepeat(body, repeatCnt, repeatLetter, tag) + curr;
                repeatLetter = curr;
                repeatCnt = 0;
            }

            //Repeating stopped, repeat cnt is larger than 2, at the end
            if (!repeatLetter.equals(curr) && repeatCnt >= 2 && currLocation == len) {
                body = processRepeat(body, repeatCnt, repeatLetter, tag) + curr;
                repeatLetter = curr;
                repeatCnt = 0;
            }

            //Repeating stopped, repeat cnt is smaller than 2
            if (!repeatLetter.equals(curr) && repeatCnt < 2) {
                body += curr;
                repeatLetter = curr;
                repeatCnt = 0;
            }

        }
        return body;
    }

    private String processRepeat(String body, Integer repeatCount, String repeatLetter, Integer tag) {

        String conv = "";

        if (tag == tagRemove) {
            conv = body.substring(0, body.length() - repeatCount - 1);
        }

        if (tag == tagReplace) {
            conv = body.substring(0, body.length() - repeatCount - 1) + Util.GetFrontLetter(repeatLetter);  //get the letter before current in alphabet
        }

        return conv;
    }


    public boolean validation(List<String> li) {

        String badChar = "";

        badChar = (String) li.stream().filter(ch -> !Character.isLowerCase(ch.charAt(0)))
                .findAny().map(r -> {
                    System.out.println("Sorry, the input is invalid.");
                    return r;
                })
                .orElse("");

        return (badChar == "") ? true : false;
    }
}