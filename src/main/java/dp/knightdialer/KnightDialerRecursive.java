package dp.knightdialer;

import annotation.DynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Recursive top-down approach with memoization: O(n) time complexity, O(n) space complexity (n = number of moves)
 *
 * @see <a href="https://leetcode.com/problems/knight-dialer/description/">935. Knight Dialer</a>
 * @see <a href="https://anothercasualcoder.blogspot.com/2019/06/knight-dialer-classic-dynamic.html">Knight Dialer - A Classic Dynamic Programming Problem</a>
 *
 * @see KnightDialerIterative
 */
@DynamicProgramming
public class KnightDialerRecursive {

    private final Map<Integer, List<Integer>> nextMoves;
    private static final int ANSWER_MOD = 1_000_000_007; // 10^9 + 7
    private int[][] movesMemo;

    public KnightDialerRecursive() {
        nextMoves = new HashMap<>();

        nextMoves.put(0, List.of(4, 6));
        nextMoves.put(1, List.of(6, 8));
        nextMoves.put(2, List.of(7, 9));
        nextMoves.put(3, List.of(4, 8));
        nextMoves.put(4, List.of(0, 3, 9));
        nextMoves.put(5, List.of());
        nextMoves.put(6, List.of(0, 1, 7));
        nextMoves.put(7, List.of(2, 6));
        nextMoves.put(8, List.of(1, 3));
        nextMoves.put(9, List.of(2, 4));
    }

    /**
     * Approach: recursive top-down with memoization
     */
    public int knightDialer(int moves) {
        movesMemo = new int[moves][10];
        int numberCombos = 0;
        for (int numericCell = 0; numericCell <= 9; numericCell++) {
           numberCombos = (numberCombos + move(numericCell, moves - 1)) % ANSWER_MOD;
        }
        return numberCombos;
    }

    private int move(int numericCell, int movesRemaining) {
        if (movesRemaining == 0) {
            return 1;
        }

        if (movesMemo[movesRemaining][numericCell] != 0) {
            return movesMemo[movesRemaining][numericCell];
        }

        int numberCombos = 0;
        for (int nextCell : nextMoves.get(numericCell)) {
            numberCombos = (numberCombos + move(nextCell, movesRemaining - 1)) % 1_000_000_007;
        }

        movesMemo[movesRemaining][numericCell] = numberCombos;

        return numberCombos;
    }
}
