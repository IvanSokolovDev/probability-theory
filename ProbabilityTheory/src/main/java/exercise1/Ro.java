package exercise1;

import lombok.Data;

import java.util.function.Function;

@Data
public class Ro {
    private Function<Double, Double> ro1;
    private Function<Double, Double> ro2;
}
