package exercise1;

import java.util.List;

public class MainFirstExercise {
    public static void main(String[] args) {
        double x = 0.12;

        for (int n = 10; n <= 10000; n *= 10) {
            printN(n);

            MonteCarloMethod firstExercise = new MonteCarloMethod(n, x);

            P p = createP();
            Ro ro = createRo();

            List<Double> listY = firstExercise.generateY(p, ro);
            int count = firstExercise.countYWhichMoreOrEqualsX(listY);
            double probability = firstExercise.probability(count);

            printX(x);
            printProbability(probability);
        }
    }

    public static P createP() {
        P p = new P();
        p.setP1(1.0 / 4.0);
        p.setP2(3.0 / 4.0);

        return p;
    }

    public static Ro createRo() {
        Ro ro = new Ro();
        ro.setRo1(z -> 3.0);
        ro.setRo2(z -> Math.pow(z, 2));

        return ro;
    }

    public static void printN(int n) {
        System.out.printf("n: %d; ", n);
    }

    public static void printX(double x) {
        System.out.printf("x: %f; ", x);
    }

    public static void printProbability(double probability) {
        System.out.printf("Вероятность: %f\n", probability);
    }
}
