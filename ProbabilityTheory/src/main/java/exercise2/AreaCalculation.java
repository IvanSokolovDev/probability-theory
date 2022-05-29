package exercise2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
public class AreaCalculation {
    private int N;
    private int m = 0;
    private Square square = new Square();
    private double area;
    private Functions functions = new Functions();

    public AreaCalculation(int n) {
        this.N = n;
    }

    public double calculation() {
        for (int i = 0; i < N; i++) {
            double x = generateX();
            double y = generateY();

            if (figureBelongs(x, y)) {
                m++;
            }
        }

        return ((double) m / (double) N) * squareArea();
    }

    public double generateX() {
        Random random = new Random();

        while (true) {
            double x = random.nextDouble() * 5;

            if (x <= 4) {
                return x;
            }
        }
    }

    public double generateY() {
        Random random = new Random();
        boolean hasMinus;
        double y;

        while (true) {
            y = random.nextDouble() * 3;

            if (y <= 2) {
                hasMinus = random.nextBoolean();

                if (hasMinus) {
                    return y * (-1);
                }

                return y;
            }
        }
    }

    public boolean figureBelongs(double x, double y) {
        return firstFigureBelong(x, y) || secondFigureBelong(x, y);
    }

    public boolean firstFigureBelong(double x, double y) {
        double y1 = functions.getFunction2().apply(x);
        double y2 = functions.getFunction1().apply(x);
        double y3 = functions.getFunction3().apply(x);

        return (y >= y1) & (y <= y2) & (y <= y3);
    }

    public boolean secondFigureBelong(double x, double y) {
        double y1 = functions.getFunction1().apply(x);
        double y2 = functions.getFunction3().apply(x);
        double y3 = functions.getFunction4().apply(x);

        return (y >= y1) & (y >= y2) & (y <= y3);
    }

    public double squareArea() {
        double a = square.getA();
        double b = square.getB();
        double c = square.getC();
        double d = square.getD();

        return (b - a) * (Math.abs(c) + d);
    }
}
