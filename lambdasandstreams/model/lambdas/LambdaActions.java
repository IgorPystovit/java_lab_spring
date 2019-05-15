package lambdasandstreams.model.lambdas;

import lambdasandstreams.model.lambdas.LambdaInterface;

public class LambdaActions {
    public LambdaInterface maxValue = (a, b, c) -> a > b? ((a > c)? a : c) : ((b > c)? b : c);
    public LambdaInterface averageValue = (a, b, c) -> (a + b + c) / 3;
}
