package string.braces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import string.braces.Solution.Brace;
import string.braces.Solution.Result;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void validate_Valid_ResultTrue() {
        Result result = solution.validate("{ [i] (love) [lamp] }");
        assertThat(result.isValid()).isTrue();

        result = solution.validate("[({})]");
        assertThat(result.isValid()).isTrue();

        result = solution.validate("(hi) [there[!]] {waffles}");
        assertThat(result.isValid()).isTrue();
    }

    @Test
    public void validate_Invalid_ResultFalseAndExpectedError() {
        String value = "[";
        Result result = solution.validate(value);
        assertThat(result.isValid()).isFalse();
        assertThat(result.getValidMessage()).isEqualTo(Result.getErrorMessage(value, new Brace('[', 0)));

        value = "[(}";
        result = solution.validate(value);
        assertThat(result.isValid()).isFalse();
        assertThat(result.getValidMessage()).isEqualTo(Result.getErrorMessage(value, new Brace('}', 2)));

        value = "carelessly )bracing about";
        result = solution.validate(value);
        assertThat(result.isValid()).isFalse();
        assertThat(result.getValidMessage()).isEqualTo(Result.getErrorMessage(value, new Brace(')', 11)));
    }
}
