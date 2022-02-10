import service.RepeatStringRemoval;
import service.RepeatStringReplacement;
import service.StringService;
import service.StringServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        StringService service;

        String result = "";

        System.out.print("Please input the stage number ( 1 - stage 1, 2 - stage 2 ): ");

        String stage = sc.nextLine();

        if (TagValidation(stage)) {

            Integer tag = Integer.parseInt(stage);

            System.out.print("Please input the test string: ");

            String testString = sc.nextLine();

            System.out.println(testString);

            service = tag.equals(1) ? new RepeatStringRemoval() : new RepeatStringReplacement();

            result = service.process(testString, tag);

            System.out.println(result);
        }

        sc.close();
    }

    private static boolean TagValidation(String stage) {
        boolean isValid = (stage.equals("1") || stage.equals("2")) ? true : false;

        if (isValid != true) {
            System.out.println("stage is invalid. (Tag should be 1 or 2)");
        }
        return isValid;
    }
}
