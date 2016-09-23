package stepic.solutions_12772_step_9;

/**
 * Created by ipetrash on 11.09.2016.
 */


public class Main {

/*
Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(), это метод при передаче
отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException с сообщением "Expected
non-negative number, got ?", где вместо вопросика будет подставлено фактически переданное в метод число.
*/

    public static double sqrt(double x) {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        }

        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        double x = -2.0;
        System.out.println(Math.sqrt(x));
        System.out.println(sqrt(x));
    }
}

