package lambdasandstreams.model.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamEvaluator {
    public Integer maxValue(List<Integer> list){
        return list.stream().reduce(Math::max).orElse(0);
    }

    public Integer averageValue(List<Integer> list){
        return list.stream().reduce((a,b) -> a+b).map(a -> a / list.size()).orElse(0);
    }

    public Integer minValue(List<Integer> list){
        return list.stream().reduce(Math::min).orElse(0);
    }

    public Integer sumValueWithSum(List<Integer> list){
        return list.stream().mapToInt(a -> a).sum();
    }

    public Integer sumValueWithReduce(List<Integer> list){
        return list.stream().reduce((s,b) -> s+b).orElse(0);
    }

    public Integer biggerThanAverageValues(List<Integer> list){
        int average = averageValue(list);
        return (int) list.stream().filter(a -> a > average).count();
    }
}
