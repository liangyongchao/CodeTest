package service;

import java.util.List;

public abstract class StringServiceImpl implements StringService {

    @Override
    public String process(String input) {

        if (!Util.inputListValidation(Util.StringToList(input))) return "";

        String output = input;

        for (Integer i = 0; i <= output.length(); i++) {

            output = traverse(Util.StringToList(output));

        }

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
                body += current;
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


}