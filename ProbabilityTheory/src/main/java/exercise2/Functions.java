package exercise2;

import lombok.Data;

import java.util.function.Function;

@Data
public class Functions {
    private Function<Double, Double> function1 =
            x -> Math.sqrt(2 - Math.sqrt(x));

    private Function<Double, Double> function2 =
            x -> (-1) * Math.sqrt(2 - Math.sqrt(x));

    private Function<Double, Double> function3 =
            x -> Math.pow(2, (x - 1) / 2);

    private Function<Double, Double> function4 =
            x -> ((2 - Math.sqrt(2)) / 3) * x + Math.sqrt(2);
}
