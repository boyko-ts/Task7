package calculator_test.operations_test;

import operations.Addition;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тест для сложения
 *
 * @author Tatyana Boyko
 *
 * */
public class AdditionTest {
    private String fileRoot = "src\\test\\java\\calculator_test\\operations_test\\";

    @Test
    public void testPositive() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "addition-test_test-positive.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setFirstOperand(scanner);
        add.setSecondOperand(scanner);
        float expectedResult = 6;
        float result = add.calculate();
        assertTrue(String.format("Значения не совпадают. Ожидается %.4f, пришло %.4f", expectedResult, result), expectedResult == result );
        scanner.close();
    }

    @Test
    public void testNegative() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileRoot + "addition-test_test-negative.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Addition add = new Addition();
        add.setFirstOperand(scanner);
        add.setSecondOperand(scanner);
        float expectedResult = 5;
        float result = add.calculate();
        assertFalse(String.format("Значения %.4f и %.4f не должны совпадать.", expectedResult, result), expectedResult == result );
        scanner.close();
    }
}
