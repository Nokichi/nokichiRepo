package ru.slava.popov;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Popov on 12/17/2017.
 */
@RunWith(Parameterized.class)
public class Tests {
    private static final String FILE_NAME = "testcases.txt";

    @Parameterized.Parameters(name = "{0}")
    public static List<String> data() {
        InputStream is = Tests.class.getClassLoader().getResourceAsStream(FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader.lines().collect(Collectors.toList());
    }

    @Parameterized.Parameter
    public static String line;

    @Test()
    public void test() throws Exception {
        ArithmeticalAction action = ArithmeticalAction.parse(line, ";");
        String resultString = line.split(";")[3];
        Double result = Double.parseDouble(resultString);

        boolean isEquals = action.calculate() == result;
        Assert.assertTrue(action.toString() + " not equals " + result + ".\nCorrect value is " + action.calculate() + ".", isEquals);
    }
}
