package stepic.solutions_12776_step_15;

import java.util.*;

/**
 * Created by ipetrash on 30.09.2016.
 */
public class Main {
/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, затем
удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном
порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

Sample Input:
1 2 3 4 5 6 7

Sample Output:
6 4 2

*/

    public static void main(String[] args) throws Exception {
        List<Integer> evenNumbers = new ArrayList<>();

        int i = 1;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();

            if (i++ % 2 == 0) {
                evenNumbers.add(val);
            }
        }

        Collections.reverse(evenNumbers);
        evenNumbers.forEach(x -> System.out.print(x + " "));
    }
}
