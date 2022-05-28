package exercise1;

import java.util.List;
import java.util.Scanner;

public class MainFirstExercise {
    public static void main(String[] args) {
        printN();

        int n = inputN();
        double x = generateX();

        MonteCarloMethod firstExercise = new MonteCarloMethod(n, x);

        P p = createP();
        Ro ro = createRo();

        List<Double> listY = firstExercise.generateY(p, ro);
        int count = firstExercise.countYWhichMoreOrEqualsX(listY);
        double probability = firstExercise.probability(count);

        printX(x);
        printProbability(probability);
    }

    public static int inputN() {
        return new Scanner(System.in).nextInt();
    }

    public static double generateX() {
        return Math.random();
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

    public static void printN() {
        System.out.print("n: ");
    }

    public static void printX(double x) {
        System.out.printf("x: %f\n", x);
    }

    public static void printProbability(double probability) {
        System.out.printf("Вероятность: %f\n", probability);
    }
}
