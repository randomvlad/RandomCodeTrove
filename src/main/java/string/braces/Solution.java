package string.braces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Braces Validator
 */
class Solution {

    private final Map<Character, Character> startEndDefs;

    public Solution() {
        startEndDefs = Map.of(//@formatter:off
				'[', ']',
				'(', ')',
				'{', '}'
		);//@formatter:on
    }

    public boolean isBrace(char value) {
        return value == '[' || value == ']' || value == '(' || value == ')' || value == '{' || value == '}';
    }

    public Result validate(String value) {

        Deque<Brace> opened = new ArrayDeque<>();

        Result result = new Result(value);

        for (int i = 0; i < value.length(); i++) {

            char character = value.charAt(i);
            if (!isBrace(character)) {
                continue;
            }

            Brace brace = new Brace(character, i);

            if (startEndDefs.containsKey(brace.value)) {
                opened.push(brace);
                continue;
            }

            if (opened.isEmpty()) {
                result.setBraceInError(brace);
                break;
            }

            Brace lastOpenBrace = opened.pop();

            char expectedCloseBrace = startEndDefs.get(lastOpenBrace.value);
            if (brace.value != expectedCloseBrace) {
                result.setBraceInError(brace);
                break;
            }
        }

        if (result.isValid() && !opened.isEmpty()) {
            result.setBraceInError(opened.pop());
        }

        return result;
    }

    public static class Brace {

        public char value;
        public int index;

        public Brace(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static class Result {

        private boolean valid;
        private Brace braceInError;
        private String value;

        public Result(String value) {
            this.valid = true;
            this.value = value;
        }

        public void setBraceInError(Brace brace) {
            this.braceInError = brace;
            this.valid = false;
        }

        public boolean isValid() {
            return valid;
        }

        public Brace getBraceInError() {
            return braceInError;
        }

        public String getValue() {
            return value;
        }

        public String getValidMessage() {
            return valid ? "YES" : string.braces.Solution.Result.getErrorMessage(value, braceInError);
        }

        public static String getErrorMessage(String value, Brace brace) {
            String pad = " ".repeat(Math.max(0, brace.index));
            return value + System.lineSeparator() + pad + "^ ERROR: brace " + brace.value + " is not closed";
        }
    }
}
