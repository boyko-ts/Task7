package calculator_test.operations_test;

import operations.Multiplication;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тест для умножения
 *
 * @author Tatyana Boyko
 */
public class MultiplicationTest {
    private String fileRoot = "src\\test\\java\\calculator_test\\operations_test\\";

    @Test
    public void testPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "multiplication-test_test-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Multiplication mul = new Multiplication();
        mul.setFirstOperand(scanner);
        mul.setSecondOperand(scanner);
        float expectedResult = 12;
        float result = mul.calculate();
        assertTrue(String.format("Значения не совпадают. Ожидается %.4f, пришло %.4f", expectedResult, result), expectedResult == result );
        scanner.close();
    }

    @Test
    public void testNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "multiplication-test_test-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Multiplication mul = new Multiplication();
        mul.setFirstOperand(scanner);
        mul.setSecondOperand(scanner);
        float expectedResult = 1;
        float result = mul.calculate();
        assertFalse(String.format("Значения %.4f и %.4f не должны совпадать.", expectedResult, result), expectedResult == result );
        scanner.close();
    }
}