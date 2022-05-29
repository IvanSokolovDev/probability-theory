package exercise2;

public class MainSecondExercise {
    public static void main(String[] args) {
        for (int n = 10; n <= 10000; n *= 10) {
            printN(n);
            AreaCalculation areaCalculation = new AreaCalculation(10);
            printN(n);
            double s = areaCalculation.calculation();
            printS(s);
        }
    }

    public static void printN(int n) {
        System.out.printf("n: %d; ", n);
    }

    public static void printS(double s) {
        System.out.printf("s: %f\n", s);
    }
}
