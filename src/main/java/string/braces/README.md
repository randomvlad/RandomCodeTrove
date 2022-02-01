## Braces Validator

### Problem Definition:

Given an input of N string values, determine if each string contains properly opened and closed braces. Account for {}, () and [] braces. If valid print YES, otherwise output an error message as described below.

Error Message Format:
```
${original value}\n 
${padding up to invalid brace}^ ERROR: brace ${brace symbol} is not closed\n
```

Example:
```
Input:
2
{ [i] (love) [lamp] }
[forgot ( to close]

Output:
YES
[forgot ( to close]
        ^ ERROR: brace ( is not closed
```

For more examples, see [Unit Test](../../../../test/java/string/braces/SolutionTest.java).

### Notes:
* I've encountered a slightly simpler version of this problem on a HackerRank exam for a company that was hiring. Original requirements were merely to print out YES or NO if a string had correctly closed/opened braces.
* Java's Stack data structure is a little inconsistent and overall a strange creature from Java's early days. It is recommended to use [Deque](http://docs.oracle.com/javase/7/docs/api/java/util/Deque.html) interface and its implementing classes instead (see: [StackOverflow Question](http://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack)).
