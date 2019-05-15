package lambdasandstreams.model;

import java.util.Scanner;

public class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static int intValue(){
        int intValue = 0;
        do{
            try{
                String checker = scan.nextLine();
                if (checker.equals("exit")){
                    return 0;
                }
                intValue = Integer.parseInt(checker);
            } catch (NumberFormatException e){
                System.out.println("You have entered wrong value! Please retry!");
                continue;
            }
            return intValue;
        } while (true);
    }

    public static String stringValue(){
        do{
            String string = scan.nextLine();
            if (string.equals("")){
                System.out.println("You are disabled to input void strings! Please retry!");
                continue;
            }
            return string;
        } while (true);
    }
}
