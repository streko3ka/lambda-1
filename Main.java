import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1); // операция вычитания даёт ноль
        /*
        - для решения проблемы достаточно изменить одно из значений х или у для b
        - можно использовать другое арифметическое действие для b. Например, умножение.
        */

        // обработка ошибки в случае деления на ноль
        try {
            calc.divide.apply(a,b);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        int c = calc.divide.apply(a, b);// операция деления невозможна, делитель b = 0
        calc.println.accept(c);
    }
}


class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}