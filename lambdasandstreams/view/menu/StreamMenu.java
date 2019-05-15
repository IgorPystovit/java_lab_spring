package lambdasandstreams.view.menu;

import lambdasandstreams.controller.Controller;
import lambdasandstreams.view.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMenu extends Menu {
    private List<Integer> randomValues = new ArrayList<>();
    private Controller controller = new Controller();

    public void show(){
        randomValues = generateRandomList();
        System.out.println("Generated list ");
        controller.printResult(this::printList);
        System.out.println();
        do{
            System.out.println("Stream actions:\n" +
                    "- Generate;\n" +
                    "- MaxValue;\n" +
                    "- MinValue;\n" +
                    "- ReduceSum;\n" +
                    "- Sum;\n" +
                    "- Average;\n" +
                    "- GreaterThanAvg;\n" +
                    "- Print;\n" +
                    "- Exit");
            String request = controller.readStringValue().toUpperCase();
            switch (request){
                case "GENERATE":
                    randomValues = generateRandomList();
                    controller.printResult(this::printList);
                    break;
                case "MAXVALUE":
                    controller.printResult(() -> System.out.println("Max value:"+controller.getStreamMaxValue(randomValues)));
                    break;
                case "MINVALUE":
                    controller.printResult(() -> System.out.println("Min value:"+controller.getStreamMinValue(randomValues)));
                    break;
                case "REDUCESUM":
                    controller.printResult(() -> System.out.println("Sum value:"+controller.getStreamRedueSumValue(randomValues)));
                    break;
                case "SUM":
                    controller.printResult(() -> System.out.println("Sum value:"+controller.getStreamSumValue(randomValues)));
                    break;
                case "AVERAGE":
                    controller.printResult(() -> System.out.println("Average value:"+controller.getStreamAverageValue(randomValues)));
                    break;
                case "GREATERTHANAVG":
                    controller.printResult(() -> System.out.println("Greater than average number of values:"+controller.getStreamBiggerThanAverageValues(randomValues)));
                    break;
                case "PRINT":
                    controller.printResult(this::printList);
                case "EXIT":
                    return;
                default:
                    controller.printResult(() -> System.out.println("Bad request"));
            }
        }while (true);

    }

    private void printList(){
        randomValues.stream().forEach(a -> System.out.print(a+" "));
    }

    public List<Integer> generateRandomList(){
        return Stream.generate(() -> new Random().nextInt(100)).limit(5).collect(Collectors.toList());
    }
}
