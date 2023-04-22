import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        double a = calc.plus.apply(1, 2); // меняем тип переменных на double, чтобы произвести деление на ноль
        double b = calc.minus.apply(1, 1); // операция вычитания даёт ноль
        double c = calc.divide.apply(a, b); // операция деления вернёт значение Infinity
        calc.println.accept(c); // в выражениях BinaryOperator divide и для Consumer меняем типы обертки на Double
    }
}


class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator <Double> divide = (x, y) -> x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer <Double> println = System.out::println;
}