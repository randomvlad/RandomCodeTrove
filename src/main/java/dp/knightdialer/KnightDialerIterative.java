package dp.knightdialer;

import annotation.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Iterative bottom-up space optimized approach: O(n) time complexity, O(1) space complexity (keeps track of prev and current only)
 *
 * @see <a href="https://leetcode.com/problems/knight-dialer/description/">935. Knight Dialer</a>
 * @see <a href="https://anothercasualcoder.blogspot.com/2019/06/knight-dialer-classic-dynamic.html">Knight Dialer - A Classic Dynamic Programming Problem</a>
 *
 * @see KnightDialerRecursive
 */
@DynamicProgramming
public class KnightDialerIterative {

    private final Map<Integer, List<Integer>> nextMoves;
    private static final int ANSWER_MOD = 1_000_000_007; // 10^9+7

    public KnightDialerIterative() {
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

    public int knightDialer(int moves) {
        // base case moves = 1
        int[] previous = new int[10];
        Arrays.fill(previous, 1);

        // solve for moves > 1
        for (int movesLeft = 1; movesLeft < moves; movesLeft++) {
            int[] current = new int[10];
            for (int square = 0; square < 10; square++) {
                int numberCombos = 0;
                for (int nextSquare : nextMoves.get(square)) {
                    numberCombos = (numberCombos + previous[nextSquare]) % ANSWER_MOD;
                }

                current[square] = numberCombos;
            }

            previous = current;
        }

        int numberCombos = 0;
        for (int square = 0; square < 10; square++) {
            numberCombos = (numberCombos + previous[square]) % ANSWER_MOD;
        }

        return numberCombos;
    }
}
