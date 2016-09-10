/**
 * Created by ipetrash on 10.09.2016.
 */
public class Main {
    /*
    Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) \
    на расстоянии a.

    В качестве примера написано заведомо неправильное выражение. Исправьте его.
    Sample Input 1:
        12

    Sample Output 1:
        h

    Sample Input 2:
        29

    Sample Output 2:
        y
    */
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    public static void main(String[] args) {
        System.out.println(charExpression(12));
        System.out.println(charExpression(29));
    }

}
