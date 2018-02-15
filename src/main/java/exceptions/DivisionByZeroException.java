package exceptions;

/**
 * Исключение для деления на ноль
 *
 * @author Tatyana Boyko
 */
public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException() {
        super("Ошибка деления на ноль.");
    }
}
