package operations;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Операция
 *
 * @author Tatyana Boyko
 */
public abstract class Operation implements Calculable {

    Operation() {
    }

    /**
     * Первое число операции калькулятора
     */
    private float firstOperand;

    /**
     * Второе число операции калькулятора
     */
    private float secondOperand;

    /**
     * Получает первое число операции калькулятора
     *
     * @return Первое число операции калькулятора
     */
    float getFirstOperand() {
        return firstOperand;
    }

    /**
     * Устанавливает значение для первого числа операции калькулятора
     *
     * @param scanner общий сканнер для консоли
     */
    public void setFirstOperand(Scanner scanner) {
        System.out.println("Введите первое число: ");

        try {
            this.firstOperand = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println((char) 27 + "[31mНе корректное значение числа. " + (char) 27 + "[0m");
            System.out.printf("Введено \"%s\", требуется число с запятой.\n", scanner.next());
            this.setFirstOperand(scanner);
        }
    }

    /**
     * Получает второе число  операции калькулятора
     *
     * @return второе число операции калькулятора
     */
    float getSecondOperand() {
        return secondOperand;
    }

    /**
     * Устанавливает значение для второго числа операции калькулятора
     *
     * @param scanner общий сканнер для консоли
     */
    public void setSecondOperand(Scanner scanner) {
        System.out.println("Введите второе число: ");
        try {
            this.secondOperand = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println((char) 27 + "[31mНе корректное значение числа. " + (char) 27 + "[0m");
            System.out.printf("Введено \"%s\", требуется число с запятой.\n", scanner.next());
            this.setSecondOperand(scanner);
        }
    }
}
