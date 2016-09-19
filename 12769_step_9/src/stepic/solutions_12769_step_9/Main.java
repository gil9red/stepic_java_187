package stepic.solutions_12769_step_9;

/**
 * Created by ipetrash on 11.09.2016.
 */


public class Main {

/*
Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

Пример
ComplexNumber a = new ComplexNumber(1, 1);
ComplexNumber b = new ComplexNumber(1, 1);
// a.equals(b) must return true
// a.hashCode() must be equal to b.hashCode()

*/


    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        System.out.println("" + a.equals(b) + " " + a.hashCode() + " " + b.hashCode() + " = " + (a.hashCode() == b.hashCode()));
        if (!a.equals(b)) {
            System.err.println("a.equals(b)");
        }
        if (a.hashCode() != b.hashCode()) {
            System.err.println("a.hashCode() == b.hashCode()");
        }
    }
}
