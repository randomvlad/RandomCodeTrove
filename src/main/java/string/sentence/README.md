## Sentence Permutations

### Problem Definition:

Given a string with N number of word groups generate all possible sentences.

**Input Format:** A string with N number of word groups. Each group is surrounded in curly braces {} with comma separated words.

**Output Format:** All possible sentence permutations.

Example:
```
Input:
{Vlad} was in {fantastic, crabby} mood and went to the {beach, party, library}.

Output:
Vlad was in fantastic mood and went to the beach.
Vlad was in fantastic mood and went to the party.
Vlad was in fantastic mood and went to the library.
Vlad was in crabby mood and went to the beach.
Vlad was in crabby mood and went to the party.
Vlad was in crabby mood and went to the library.
```

## Solution:
See main class [SentencePermuteMain.java](SentencePermuteMain.java) and unit tests [SentencePermuteTest.java](SentencePermuteTest.java).