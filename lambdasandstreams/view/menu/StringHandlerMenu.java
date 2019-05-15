package lambdasandstreams.view.menu;

import lambdasandstreams.controller.Controller;
import lambdasandstreams.model.Reader;
import lambdasandstreams.model.commandpattern.Command;
import lambdasandstreams.view.menu.Menu;


import java.util.Stack;

public class StringHandlerMenu extends Menu {
    private static final Controller controller = new Controller();
    private Stack<Command> commands = new Stack<>();
    private String userString;

    public void show(){
        System.out.println("Input string to handle");
        userString = controller.readStringValue();
        do{
            System.out.println("Command actions:\n" +
                    "- add command;\n" +
                    "- execute all;\n"+
                    "- execute;\n" +
                    "-print string;\n" +
                    "- exit;");
            String request = controller.readStringValue().toUpperCase();
            switch (request){
                case "ADD COMMAND":
                    System.out.println("Commands:\n" +
                            "-uppercase;\n" +
                            "-lowercase;\n" +
                            "-reverse;\n" +
                            "-double string;\n");
                    String commandName = Reader.stringValue().toUpperCase();
                    try{
                        commands.push(commandFactory(commandName));
                    }catch (NullPointerException e){
                        continue;
                    }
                    break;
                case "EXECUTE ALL":
                    while (commands.size() > 0){
                        controller.applyCommand(commands.pop(),userString);
                    }
                    break;
                case "EXECUTE":
                    if (commands.size() != 0){
                        controller.applyCommand(commands.pop(),userString);
                    }
                    break;
                case "PRINT STRING":
                    controller.printResult(this::print);
                case "EXIT":
                    return;
                default:
                    System.out.println("Bad request");
            }
        }while (true);
    }

    private Command commandFactory(String commandName) throws NullPointerException{
        Command command = null;
        switch (commandName){
            case "UPPERCASE":
                command = controller.getUpperCaseCommand();
                break;
            case "LOWERCASE":
                command = controller.getLowerCaseCommand();
                break;
            case "REVERSE":
                command = controller.getReversedStringCommand();
                break;
            case "DOUBLE STRING":
                command = controller.getDoubledStringCommand();
                break;
            default:
                System.out.println("No such command");
                command = null;
                throw new NullPointerException();
        }
        return command;
    }

    private void print(){
        System.out.println(userString);
    }
}
