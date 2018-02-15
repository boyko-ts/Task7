package calculator_test;

import main.Calculator;

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
 * Тест для запросов калькулятора
 *
 * @author Tatyana Boyko
 */
public class CalculatorTest {
    private final ByteArrayOutputStream outContest = new ByteArrayOutputStream();
    private String fileRoot = "src\\test\\java\\calculator_test\\";

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContest));
    }

    @After
    public void cleanUpStream() {
        System.setOut(null);
    }

    @Test
    public void testSelectOperationNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "calculator-test_test-select-operation-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        calculator.selectOperation(scanner);
        String expectedResult = "Выберите операцию: Не знаю такой операции. Значение не установлено.\r\n"
                + "Выберите операцию: ";

        scanner.close();
        assertEquals("Значения не совпадают.", expectedResult, outContest.toString());
    }

    @Test
    public void testSelectOperationAdditionPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "calculator-test_test-select-operation-addition-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        calculator.selectOperation(scanner);
        String expectedResult = "Выберите операцию: ";

        scanner.close();
        assertEquals("Значения не совпадают.", expectedResult, outContest.toString());
    }

    @Test
    public void testSelectOperationSubtractionPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "calculator-test_test-select-operation-subtraction-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        calculator.selectOperation(scanner);
        String expectedResult = "Выберите операцию: ";

        scanner.close();
        assertEquals("Значения не совпадают.", expectedResult, outContest.toString());
    }

    @Test
    public void testSelectOperationMultiplicationPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "calculator-test_test-select-operation-multiplication-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        calculator.selectOperation(scanner);
        String expectedResult = "Выберите операцию: ";

        scanner.close();
        assertEquals("Значения не совпадают.", expectedResult, outContest.toString());
    }

    @Test
    public void testSelectOperationDivisionPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "calculator-test_test-select-operation-division-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        calculator.selectOperation(scanner);
        String expectedResult = "Выберите операцию: ";

        scanner.close();
        assertEquals("Значения не совпадают.", expectedResult, outContest.toString());
    }
}
