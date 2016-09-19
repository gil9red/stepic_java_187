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
        TestMain.test();
    }
}

class TestMain {
    static void test() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        if (!a.equals(b)) {
            throw new Error("a.equals(b)");
        }
        if (a.hashCode() != b.hashCode()) {
            throw new Error("a.hashCode() == b.hashCode()");
        }
    }
}
