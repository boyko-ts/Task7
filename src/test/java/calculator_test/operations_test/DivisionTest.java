package calculator_test.operations_test;

import exceptions.DivisionByZeroException;
import operations.Division;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тест для деления
 *
 * @author Tatyana Boyko
 */
public class DivisionTest {
    private String fileRoot = "src\\test\\java\\calculator_test\\operations_test\\";

    @Test
    public void testPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "division-test_test-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Division sub = new Division();
        sub.setFirstOperand(scanner);
        sub.setSecondOperand(scanner);
        float expectedResult = 5;
        float result = sub.calculate();
        assertTrue(String.format("Значения не совпадают. Ожидается %.4f, пришло %.4f", expectedResult, result), expectedResult == result );
        scanner.close();
    }

    @Test
    public void testNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "division-test_test-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Division sub = new Division();
        sub.setFirstOperand(scanner);
        sub.setSecondOperand(scanner);
        float expectedResult = 6;
        float result = sub.calculate();
        assertFalse(String.format("Значения %.4f и %.4f не должны совпадать.", expectedResult, result), expectedResult == result );
        scanner.close();
    }
}