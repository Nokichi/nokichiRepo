package ru.slava.popov;

/**
 * Created by Popov on 12/17/2017.
 */
public enum ArithmeticalType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private char character;

    ArithmeticalType(char character) {
        this.character = character;
    }

    public static ArithmeticalType parseArithmeticalType(String input) throws Exception {
        if (input.length() == 1) {
            char character = input.toCharArray()[0];
            switch (character) {
                case '+':
                    return ArithmeticalType.ADDITION;
                case '-':
                    return ArithmeticalType.SUBTRACTION;
                case '*':
                    return ArithmeticalType.MULTIPLICATION;
                case '/':
                    return ArithmeticalType.DIVISION;
            }
        }
        throw new Exception("Can't parse the arithmetical type. Incorrect character \'" + input + "\'.");
    }

    public char getCharacter() {
        return character;
    }
}
