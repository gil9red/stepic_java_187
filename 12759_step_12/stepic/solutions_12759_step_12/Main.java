package stepic.solutions_12759_step_12;

/**
 * Created by ipetrash on 10.09.2016.
 */
public class Main {

//    Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
//    Допустимая погрешность – 0.0001 (1E-4)
//
//    Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
//
//    Sample Input:
//            0.1 0.2 0.3
//
//    Sample Output:
//            true
    public static boolean doubleExpression(double a, double b, double c) {
        final double Eps = 0.001;

        return Math.abs((a + b - c)) < Eps;
    }

    public static void main(String[] args) {
        System.out.println(doubleExpression(0.1, 0.2, 0.3));
    }
}
