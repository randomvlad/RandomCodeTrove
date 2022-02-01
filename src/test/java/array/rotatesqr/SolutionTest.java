package array.rotatesqr;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void rotate_ThreeByThree_Rotated() {
        int[][] square = {//@formatter:off
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};//@formatter:on

        solution.rotate(square);

        assertThat(square).isDeepEqualTo(new int[][] {//@formatter:off
			    { 4, 1, 2 },
			    { 7, 5, 3 },
			    { 8, 9, 6 }
	    });//@formatter:on
    }

    @Test
    public void rotate_FourByFour_Rotated() {
        int[][] square = {//@formatter:off
				{ 100, 101, 102, 103 },
				{ 111, 200, 201, 104 },
				{ 110, 203, 202, 105 },
				{ 109, 108, 107, 106 }
		};//@formatter:on

        solution.rotate(square);

        assertThat(square).isDeepEqualTo(new int[][] {//@formatter:off
			    { 111, 100, 101, 102 },
			    { 110, 203, 200, 103 },
			    { 109, 202, 201, 104 },
			    { 108, 107, 106, 105}
	    });//@formatter:on
    }

    @Test
    public void rotate_FiveByFive_Rotated() {
        int[][] square = { //@formatter:off
				{ 110, 111, 112, 113, 114 },
				{ 125, 220, 221, 222, 115 },
				{ 124, 227, 999, 223, 116 },
				{ 123, 226, 225, 224, 117 },
				{ 122, 121, 120, 119, 118 }
		};//@formatter:on

        solution.rotate(square);

        assertThat(square).isDeepEqualTo(new int[][] {//@formatter:off
			    { 125, 110, 111, 112, 113 },
			    { 124, 227, 220, 221, 114 },
			    { 123, 226, 999, 222, 115 },
			    { 122, 225, 224, 223, 116 },
			    { 121, 120, 119, 118, 117 }
	    });//@formatter:on
    }
}
