package service;

public class RepeatStringReplacement extends RepeatStringRemoval{

    @Override
    public String processRepeat(String body, Integer repeatCount, String repeatLetter, Integer tag) {

        return body.substring(0, body.length() - repeatCount - 1) + Util.GetFrontLetter(repeatLetter);

    }
}
