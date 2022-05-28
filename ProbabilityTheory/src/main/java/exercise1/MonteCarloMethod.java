package exercise1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Data
public class MonteCarloMethod {
    private final int N;
    private final double X;

    public MonteCarloMethod(int n, double x) {
        this.N = n;
        this.X = x;
    }

    public List<Double> generateY(P p, Ro ro) {
        List<Double> listY = new ArrayList<>();
        double resultOfFunction;

        for (int i = 0; i < N; i++) {
            double randomNumber = Math.random();

            if (randomNumber < p.getP1()) {
                resultOfFunction = executeFunction(ro.getRo1(), X);
            } else {
                resultOfFunction = executeFunction(ro.getRo2(), X);
            }

            listY.add(resultOfFunction);
        }

        return listY;
    }

    private double executeFunction(Function<Double, Double> function, Double argument) {
        return function.apply(argument);
    }

    public int countYWhichMoreOrEqualsX(List<Double> listY) {
        int count = 0;

        for (Double y : listY) {
            if (y >= X) {
                count++;
            }
        }

        return count;
    }

    public double probability(int countY) {
        return ((double) countY ) / N;
    }
}
