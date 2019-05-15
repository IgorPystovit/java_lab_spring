package lambdasandstreams.view.menu;

import lambdasandstreams.controller.Controller;

import java.util.Scanner;

public abstract class Menu {
    private static Scanner scan = new Scanner(System.in);
    private static Controller controller = new Controller();

    public abstract void show();

    public static void execute(){
        Menu menu;
        do{
            System.out.println("Actions:\n" +
                    "- lambda (to execute lambda menu);\n" +
                    "- command (to execute command menu;\n" +
                    "- stream (to execute stream menu);\n" +
                    "- words (to execute words menu);\n" +
                    "- exit;");
            String request = scan.nextLine().toUpperCase();
            if (request.equals("EXIT")){
                return;
            }
            try{
                menu = menuFactory(request);
            } catch (NullPointerException e){
                continue;
            }
            menu.show();
        } while (true);
    }

    private static Menu menuFactory(String menuName){
        Menu menu = null;
        switch (menuName){
            case "LAMBDA":
                menu = new LambdaMenu();
                break;
            case "COMMAND":
                menu = new StringHandlerMenu();
                break;
            case "STREAM":
                menu = new StreamMenu();
                break;
            case "WORDS":
                menu = new WordHandlerMenu();
                break;
            default:
                System.out.println("No such menu please retry\n");
                throw new NullPointerException();
        }
        return menu;
    }



}
