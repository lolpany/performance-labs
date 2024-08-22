import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class task3 {

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        String valuesFile = inputScanner.nextLine();
        String testsFile = inputScanner.nextLine();
        String reportFile = inputScanner.nextLine();
        String valuesFileContents = FileUtils.readFileToString(new File(valuesFile), StandardCharsets.UTF_8);
        String testsFileContents = FileUtils.readFileToString(new File(testsFile), StandardCharsets.UTF_8);
        Values values = new Gson().fromJson(valuesFileContents, Values.class);
        Tests tests = new Gson().fromJson(testsFileContents, Tests.class);
        Map<Integer, String> idToValue = new HashMap<>();
        for (Values.Value value: values.values) {
            idToValue.put(value.id, value.value);
        }
        fillTests(idToValue, tests.tests);
        FileUtils.writeStringToFile(new File(reportFile), new Gson().toJson(tests), StandardCharsets.UTF_8);
    }

    private static void fillTests(Map<Integer, String> idToValue, Tests.Test[] tests) {
        for (Tests.Test test: tests) {
            test.value = idToValue.get(test.id);
            if (test.values != null) {
                fillTests(idToValue, test.values);
            }
        }
    }

    static class Values {

        Value[] values;

        static class Value {
            int id;
            String value;
        }
    }

    static class Tests {
        Test[] tests;

        static class Test {
            int id;
            String title;
            String value;
            Test[] values;
        }
    }

}