package lambdasandstreams.controller;

import lambdasandstreams.model.Reader;
import lambdasandstreams.model.commandpattern.Command;
import lambdasandstreams.model.commandpattern.StringHandler;
import lambdasandstreams.model.lambdas.LambdaActions;
import lambdasandstreams.model.streams.StreamEvaluator;
import lambdasandstreams.model.words.WordsHandler;
import lambdasandstreams.view.prints.Printable;

import java.util.List;
import java.util.Map;

public class Controller {
    private static final LambdaActions LAMBDA_ACTIONS = new LambdaActions();
    private static final StringHandler STRING_ACTIONS = new StringHandler();
    private static final StreamEvaluator STREAM_EVALUATOR = new StreamEvaluator();
    private static final WordsHandler WORDS_HANDLER = new WordsHandler();

    public int getLamdaMaxValue(int a,int b,int c){
        return LAMBDA_ACTIONS.maxValue.evaluate(a,b,c);
    }

    public int getLambdaAverageValue(int a,int b,int c){
        return LAMBDA_ACTIONS.averageValue.evaluate(a,b,c);
    }

    public void printResult(Printable printable){
        printable.print();
    }

    public String applyCommand(Command command,String string){
        return command.execute(string);
    }

    public Command getUpperCaseCommand(){
        return STRING_ACTIONS.upperCase;
    }

    public Command getLowerCaseCommand(){
        return STRING_ACTIONS.lowerCase;
    }

    public Command getDoubledStringCommand(){
        return STRING_ACTIONS.doubleString;
    }

    public Command getReversedStringCommand(){
        return STRING_ACTIONS.reverse;
    }

    public String readStringValue(){
        return Reader.stringValue();
    }

    public Integer readIntValue(){
        return Reader.intValue();
    }

     public Integer getStreamMaxValue(List<Integer> list){
        return STREAM_EVALUATOR.maxValue(list);
    }

    public Integer getStreamAverageValue(List<Integer> list){
        return STREAM_EVALUATOR.averageValue(list);
    }

    public Integer getStreamMinValue(List<Integer> list){
        return STREAM_EVALUATOR.minValue(list);
    }

    public Integer getStreamRedueSumValue(List<Integer> list){
        return STREAM_EVALUATOR.sumValueWithReduce(list);
    }

    public Integer getStreamSumValue(List<Integer> list){
        return STREAM_EVALUATOR.sumValueWithSum(list);
    }

    public Integer getStreamBiggerThanAverageValues(List<Integer> list){
        return STREAM_EVALUATOR.biggerThanAverageValues(list);
    }

    public Integer getUniqueWordsNumber(List<String> words){
        return WORDS_HANDLER.uniqueWordsNumber(words);
    }

    public List<String> getSortedUniqueWords(List<String> words){
        return WORDS_HANDLER.sortedUniquesWords(words);
    }

    public Map<String,Long> getWordsOccurrences(List<String> words){
        return WORDS_HANDLER.wordOccurrences(words);
    }

    public Map<String,Long> getCharacterOccurences(List<String> words){
        return WORDS_HANDLER.characterOccurrences(words);
    }
}
