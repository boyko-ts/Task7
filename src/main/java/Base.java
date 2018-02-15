import exceptions.DivisionByZeroException;
import main.Calculator;
import java.util.Scanner;

/**
 * Калькулятор
 *
 * @author Tatyana Boyko
 */
public class Base {
    public static void main(String[] args) {
        System.out.println("В калькуляторе доступны следующие операции:");
        System.out.println("для сложения введите - '+',");
        System.out.println("для вычитания введите - '-',");
        System.out.println("для умножения введите - '*',");
        System.out.println("для деления введите - '/'.");

        Calculator calculator = new Calculator();

        try(Scanner scanner = new Scanner(System.in)) {
            do {
                calculator.selectOperation(scanner);
                calculator.getCurrentOperation().setFirstOperand(scanner);
                calculator.getCurrentOperation().setSecondOperand(scanner);

                try {
                    calculator.getCurrentOperation().calculate();
                } catch (DivisionByZeroException e) {
                    System.out.println((char) 27 + "[31mНельзя делить на 0. Операция не выполнена. " + (char) 27 + "[0m");
                } catch (ArithmeticException e) {
                    System.out.println((char) 27 + "[31mОшибка вычисления операции. " + (char) 27 + "[0m");
                    System.out.println("Выброшено исключение:");
                    System.out.println(e.toString());
                }

            } while(calculator.selectNextOperation(scanner));
        } catch(Exception e) {
            System.out.println((char) 27 + "[31m\nИзвините, произошла ошибка при работе приложения. " + (char)27 + "[0m");
            e.printStackTrace();
        }
    }
}
