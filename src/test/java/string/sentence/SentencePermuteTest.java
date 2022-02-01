package string.sentence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SentencePermuteTest {

    private final Permutator permutator = new Permutator();

    @Test
    public void extractGroups_MultipleGroups_ExpectedGroups() {
        List<List<String>> groups = permutator.extractGroups("{A, B} then {1, 2, 3} and finally {w, x, y, z}");

        assertThat(groups).hasSize(3);
        assertThat(groups.get(0)).containsExactly("A", "B");
        assertThat(groups.get(1)).containsExactly("1", "2", "3");
        assertThat(groups.get(2)).containsExactly("w", "x", "y", "z");
    }

    @Test
    public void generateTemplate_ThreeGroups_TemplateWithThreeVars() {
        String template = permutator.generateTemplate("{A} with {B,C} and {D,E,F}");
        assertThat(template).isEqualTo("%s with %s and %s");
    }

    @Test
    public void permute_ThreeGroups_ExpectedPermutations() {
        List<String> sentences =
                permutator.permute("{Vlad} was in {fantastic, crabby} mood and went to the {beach, party, library}.");

        assertThat(sentences).containsExactly(//@formatter:off
                "Vlad was in fantastic mood and went to the beach.",
                "Vlad was in fantastic mood and went to the party.",
                "Vlad was in fantastic mood and went to the library.",
                "Vlad was in crabby mood and went to the beach.",
                "Vlad was in crabby mood and went to the party.",
                "Vlad was in crabby mood and went to the library."
        );//@formatter:on
    }
}
