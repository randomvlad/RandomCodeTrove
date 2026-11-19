package dp.knightdialer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnightDialerRecursiveTest {

    @Test
    void knightDialer_LeetCodeExample2_ExpectedCount() {
        // Given
        int moves = 2;

        // When
        int actualCount = new KnightDialerRecursive().knightDialer(moves);

        // Then
        assertThat(actualCount).isEqualTo(20);
    }

    @Test
    void knightDialer_LeetCodeExample3_ExpectedCount() {
        // Given
        int moves = 3131;

        // When
        int actualCount = new KnightDialerRecursive().knightDialer(moves);

        // Then
        assertThat(actualCount).isEqualTo(136_006_598);
    }
}
