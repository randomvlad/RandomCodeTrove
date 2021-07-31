package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SafeComboGeneratorMain {

	public static void main(String[] args) {
		SafeComboGenerator generator = new SafeComboGenerator();
		generator.printCombos(2, 4);
	}

	private static class SafeComboGenerator {

		private final Map<Integer, List<Integer>> lookup;

		public SafeComboGenerator() {
			lookup = new HashMap<>();
			lookup.put(2, Arrays.asList(7, 9));
			lookup.put(3, Arrays.asList(4, 8));
			lookup.put(4, Arrays.asList(3, 9));
			lookup.put(6, Collections.singletonList(7));
			lookup.put(7, Arrays.asList(2, 6));
			lookup.put(8, Collections.singletonList(3));
			lookup.put(9, Arrays.asList(2, 4));
		}

		public void printCombos(int startButtonNumber, int sequenceLength) {
			pickButton(startButtonNumber, new ArrayList<>(), sequenceLength);
		}

		private void pickButton(int buttonNumber, List<Integer> fragment, int sequenceLength) {
			fragment.add(buttonNumber);

			if (fragment.size() == sequenceLength) {
				System.out.println(fragment);
				return;
			}

			List<Integer> allowedMoves = lookup.get(buttonNumber);
			if (allowedMoves.size() == 2) {
				pickButton(allowedMoves.get(0), new ArrayList<>(fragment), sequenceLength);
				pickButton(allowedMoves.get(1), new ArrayList<>(fragment), sequenceLength);
			} else {
				pickButton(allowedMoves.get(0), new ArrayList<>(fragment), sequenceLength);
			}
		}
	}
}
