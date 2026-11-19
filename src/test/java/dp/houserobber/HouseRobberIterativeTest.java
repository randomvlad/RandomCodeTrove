package dp.houserobber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberIterativeTest {

    @Test
    void rob_LeetCodeExample1_ExpectedResult() {
        // Given
        int[] houseValues = { 1, 2, 3, 1};

        // When
        int actualMaxLoot = new HouseRobberIterative().rob(houseValues);

        // Then
        assertThat(actualMaxLoot).isEqualTo(4); // rob first and third house for max loot
    }

    @Test
    void rob_LeetCodeExample2_ExpectedResult() {
        // Given
        int[] houseValues = { 2, 7, 9, 3, 1};

        // When
        int actualMaxLoot = new HouseRobberIterative().rob(houseValues);

        // Then
        assertThat(actualMaxLoot).isEqualTo(12); // rob first, third and fifth house for max loot
    }

    @Test
    void rob_AllZeroes_ExpectedZero() {
        // Given
        int[] houseValues = { 0, 0, 0, 0, 0};

        // When
        int actualMaxLoot = new HouseRobberIterative().rob(houseValues);

        // Then
        assertThat(actualMaxLoot).isEqualTo(0);
    }
}
