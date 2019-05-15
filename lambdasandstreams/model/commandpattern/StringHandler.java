package lambdasandstreams.model.commandpattern;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringHandler {

    public Command upperCase = (a) -> a.toUpperCase();
    public Command lowerCase = this::commandMethod;
    public Command reverse = new Command() {
        @Override
        public String execute(String str) {
            return Stream.of(str)
                    .map(new StringHandler()::reverse)
                    .collect(Collectors.joining());
        }
    };
    public Command doubleString = new DoubleString();

    private class DoubleString implements Command{
        @Override
        public String execute(String str) {
            return str.concat(str);
        }
    }

//    public DoubleString getDoubleStringClass(){
//        return new DoubleString();
//    }

    private String commandMethod(String str){
        return str.toLowerCase();
    }

    private String reverse(String string){
        int length = string.length();
        String newString = "";
        for (int i = 0; i < length; i++){
            newString = newString.concat(String.valueOf(string.charAt(length - 1 - i)));
        }
        return newString;
    }
}
