package teme.teme1;

import java.io.*;
import java.util.*;

public class ProblemaTest {
    static class TestCase {
        String name;
        int[] punctaje;
        int pct;
        int expectedPosition;
        boolean shouldThrowException;

        TestCase(String name, int[] punctaje, int pct, int expectedPosition, boolean shouldThrowException) {
            this.name = name;
            this.punctaje = punctaje;
            this.pct = pct;
            this.expectedPosition = expectedPosition;
            this.shouldThrowException = shouldThrowException;
        }
    }
    public static void main(String[] args) {
        List<TestCase> testCases = null;
        try {
            testCases = readTestCasesFromFile();
            System.out.println("Successfully loaded test cases from file.");
        } catch (Exception e) {
            System.out.println("Could not read from file: " + e.getMessage());
        }
        assert testCases != null;
        int totalTests = testCases.size();
        int passedTests = 0;

        for (int i = 0; i < totalTests; i++) {
            TestCase testCase = testCases.get(i);
            boolean passed = runTest(testCase, i + 1);
            if (passed) {
                passedTests++;
            }
        }

        double passRate = (double) passedTests / totalTests * 100;
        System.out.println("\nTest Results:");
        System.out.println("Passed: " + passedTests + "/" + totalTests);
        System.out.println("Pass Rate: " + String.format("%.2f", passRate) + "%");
    }

    private static List<TestCase> readTestCasesFromFile() throws IOException {
        List<TestCase> testCases = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("test_data.txt"));
        String line;
        String testName = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (testName == null) {
                testName = line;
            } else {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String punctajeStr = parts[0];
                    int[] punctaje = null;

                    if (!punctajeStr.equals("null")) {
                        punctajeStr = punctajeStr.replaceAll("[\\[\\]]", "");
                        if (!punctajeStr.isEmpty()) {
                            String[] numStrs = punctajeStr.split(",");
                            punctaje = new int[numStrs.length];

                            for (int i = 0; i < numStrs.length; i++) {
                                punctaje[i] = Integer.parseInt(numStrs[i].trim());
                            }
                        } else {
                            punctaje = new int[0];
                        }
                    }

                    int pct = Integer.parseInt(parts[1].trim());
                    int expectedPosition = Integer.parseInt(parts[2].trim());
                    boolean shouldThrowException = Boolean.parseBoolean(parts[3].trim());

                    testCases.add(new TestCase(testName, punctaje, pct, expectedPosition, shouldThrowException));
                }

                testName = null;
            }
        }
        reader.close();
        return testCases;
    }


    private static boolean runTest(TestCase testCase, int testNumber) {
        System.out.println("\nTest #" + testNumber + ": " + testCase.name);
        System.out.print("Input Array: ");
        if (testCase.punctaje == null) {
            System.out.println("null");
        } else {
            System.out.println(Arrays.toString(testCase.punctaje));
        }
        System.out.println("Search Value: " + testCase.pct);
        System.out.println("Expected Position: " + testCase.expectedPosition);
        System.out.println("Should Throw Exception: " + testCase.shouldThrowException);

        try {
            Problema problema = new Problema(testCase.punctaje);
            int position = problema.getPozitie(testCase.pct);

            System.out.println("Actual Position: " + position);

            if (testCase.shouldThrowException) {
                System.out.println("FAILED: Expected exception, but none was thrown");
                return false;
            }

            if (position == testCase.expectedPosition) {
                System.out.println("PASSED");
                return true;
            } else {
                System.out.println("FAILED: Expected " + testCase.expectedPosition + ", got " + position);
                return false;
            }
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());

            if (testCase.shouldThrowException) {
                System.out.println("PASSED: Expected exception was thrown");
                return true;
            } else {
                System.out.println("FAILED: Unexpected exception");
                return false;
            }
        }
    }
}
