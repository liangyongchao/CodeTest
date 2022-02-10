package service;

public class RepeatStringRemoval extends StringServiceImpl{

    @Override
    public String processRepeat(String body, Integer repeatCount, String repeatLetter, Integer tag) {

        return body.substring(0, body.length() - repeatCount - 1);

    }
}
