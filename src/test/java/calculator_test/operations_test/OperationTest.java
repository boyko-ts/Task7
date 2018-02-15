package calculator_test.operations_test;

import operations.Addition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Тест для операции (общие методы abstract класса)
 *
 * @author Tatyana Boyko
 */
public class OperationTest {
    private final ByteArrayOutputStream outContest = new ByteArrayOutputStream();
    private String fileRoot = "src\\test\\java\\calculator_test\\operations_test\\";

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContest));
    }

    @After
    public void cleanUpStream() {
        System.setOut(null);
    }

    @Test
    public void testSetFirstOperandPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "operation-test_test-set-first-operand-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setFirstOperand(scanner);
        String expectedResult = "Введите первое число: \r\n";

        scanner.close();
        assertEquals("Значения не совпадают.", (String)expectedResult.trim(), (String)outContest.toString().trim());
    }

    @Test
    public void testSetFirstOperandNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "operation-test_test-set-first-operand-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setFirstOperand(scanner);
        String expectedResult = "Введите первое число: \r\n" +
                (char) 27 + "[31mНе корректное значение числа. " + (char) 27 + "[0m\r\n" +
                "Введено \"вапрол\", требуется число с запятой.\nВведите первое число: \r\n";

        scanner.close();
        assertEquals("Вывод на консоль не совпадает.", expectedResult, outContest.toString());
    }

    @Test
    public void testSetSecondOperandPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "operation-test_test-set-second-operand-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setSecondOperand(scanner);
        String expectedResult = "Введите второе число: \r\n";

        scanner.close();
        assertEquals("Значения не совпадают.", (String)expectedResult.trim(), (String)outContest.toString().trim());
    }

    @Test
    public void testSetSecondOperandNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "operation-test_test-set-second-operand-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setSecondOperand(scanner);
        String expectedResult = "Введите второе число: \r\n" +
                (char) 27 + "[31mНе корректное значение числа. " + (char) 27 + "[0m\r\n" +
                "Введено \"1.5\", требуется число с запятой.\nВведите второй число: \r\n";

        scanner.close();
        assertEquals("Вывод на консоль не совпадает.", expectedResult, outContest.toString());
    }
}
