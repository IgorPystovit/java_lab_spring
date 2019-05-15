package lambdasandstreams.view.menu;

import lambdasandstreams.controller.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordHandlerMenu extends Menu{
    private List<String> words = new LinkedList<>();
    private static Scanner scan = new Scanner(System.in);
    private Controller controller = new Controller();

    public void show(){
        System.out.println("Input words ");
        readWords();
        do{
            System.out.println("Actions:\n" +
                    "-Read words;\n" +
                    "-Unique words num;\n" +
                    "-Sorted unique words;\n" +
                    "-Word occurrences;\n" +
                    "-Char occurrences;\n" +
                    "-Print words;\n" +
                    "-Exit;");
            String request = controller.readStringValue().toUpperCase();
            switch (request){
                case "READ WORDS":
                    words.clear();
                    readWords();
                    break;
                case "UNIQUE WORDS NUM":
                    controller.printResult(this::printUniqueWordsNumber);
                    break;
                case "SORTED UNIQUE WORDS":
                    controller.printResult(this::printSortedUniqueWords);
                    break;
                case "WORD OCCURRENCES":
                    controller.printResult(this::printWordsOccurrences);
                    break;
                case "CHAR OCCURRENCES":
                    controller.printResult(this::printCharOccurrences);
                    break;
                case "PRINT WORDS":
                    controller.printResult(this::printWords);
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("Bad request");
            }
        }while(true);
    }

    private void printWords(){
        words.stream().forEach(a -> System.out.print(a+" "));
    }

    private void printUniqueWordsNumber(){
        System.out.println("Unique words number: "+controller.getUniqueWordsNumber(words));
    }

    private void printSortedUniqueWords(){
        System.out.println("Unique sorted words: ");
        controller.getSortedUniqueWords(words).stream().forEach(a -> System.out.println(a+" "));
    }

    private void printWordsOccurrences(){
        System.out.println("Word occurrences: "+controller.getWordsOccurrences(words));
    }

    private void printCharOccurrences(){
        System.out.println("Char occurrences: "+controller.getCharacterOccurences(words));
    }

    private void readWords(){
        String word = null;
        do{
            word = scan.nextLine();
            if (!word.equals("")){
                words.add(word);
            }
        }while (!word.equals(""));
    }
}
