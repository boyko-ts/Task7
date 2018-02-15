package main;

import operations.*;

import java.util.Scanner;

/**
 * Калькулятор
 *
 * @author Tatyana Boyko
 */
public class Calculator {

    /**
     * Текущая операция, выбранная в калькуляторе
     */
    private Operation currentOperation;

    public Calculator() {
    }

    /**
     * Получает выбранную в калькуляторе операцию
     *
     * @return Название операции
     */
    public Operation getCurrentOperation() {
        return currentOperation;
    }

    /**
     * Устанавливает текущуюю операцию в калькуляторе
     *
     * @param currentOperation Текущая операция
     */
    private void setCurrentOperation(Operation currentOperation) {
        this.currentOperation = currentOperation;
    }

    /**
     * Выбирает операцию калькулятора
     *
     * @param scanner общий сканнер для консоли
     */
    public void selectOperation(Scanner scanner) {
        System.out.print("Выберите операцию: ");
        switch (scanner.next()) {
            case "+":
                this.setCurrentOperation(new Addition());
                break;
            case "-":
                this.setCurrentOperation(new Subtraction());
                break;
            case "*":
                this.setCurrentOperation(new Multiplication());
                break;
            case "/":
                this.setCurrentOperation(new Division());
                break;
            default:
                System.out.println("Не знаю такой операции. Значение не установлено.");
                this.selectOperation(scanner);
                break;
        }
    };

    /**
     * Выбирает будет ли следующая операция в калькуляторе
     *
     * @param scanner общий сканнер для консоли
     * @return флаг следующей операции
     */
    public Boolean selectNextOperation(Scanner scanner) {
        System.out.println("\nТребуется ли ещё одна операция? (да/нет) ");
        return (scanner.next().equals("да"));
    };
}