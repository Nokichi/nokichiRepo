package ru.slava.popov;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Popov on 12/17/2017.
 */
public class ArithmeticalAction {
    private static final ScriptEngineManager engineManager;
    private static final ScriptEngine engine;

    private Double operand1;
    private Double operand2;
    private ArithmeticalType type;

    static {
        engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("JavaScript");
    }

    public ArithmeticalAction(double operand1, double operand2, ArithmeticalType type) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.type = type;
    }

    public double calculate() throws ScriptException {
        return (double) engine.eval(this.toString());
    }

    public Double getOperand1() {
        return operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public ArithmeticalType getType() {
        return type;
    }

    @Override
    public String toString() {
        return operand1.toString() + " " + type.getCharacter() + " " + operand2.toString();
    }

    public static ArithmeticalAction parse(String input) throws Exception {
        return ArithmeticalAction.parse(input, ";");
    }

    public static ArithmeticalAction parse(String input, String delimiter) throws Exception {
        List<String> splitted = Arrays.asList(input.split(delimiter));
        if (splitted.size() >= 3) {
            Double operand1 = Double.parseDouble(splitted.get(0));
            Double operand2 = Double.parseDouble(splitted.get(1));
            ArithmeticalType type = ArithmeticalType.parseArithmeticalType(splitted.get(2));
            return new ArithmeticalAction(operand1, operand2, type);
        }
        throw new Exception("Can't determine operands and the type of an action by \"" + delimiter + "\"");
    }
}
