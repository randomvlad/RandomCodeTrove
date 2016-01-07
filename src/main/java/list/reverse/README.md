## Linked List Reversals

### Problem Definition:

Reverse a linked list in 3 different ways:
1. reverse each element
2. reverse each pair of elements
3. TODO: figure out which one  

See below links for inspiration:
	http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
	http://www.crazyforcode.com/linked-list/ 

**Input Format:** A single string value. Treat each character as an element of the linked list.

**Output Format:** Three individual lines representing the linked list reversed in different ways. Display all elements joined by " -> " string.

Example:
```
Input:
abcde

Output:
e -> d -> c -> b -> a
d -> e -> b -> c- > a
TODO: figure out third way
```

## Solution:
See main class [ReverseListMain.java](ReverseListMain.java) and unit tests [ReverseListTest.java](ReverseListTest.java).

### Notes:
- Reversing a linked list can also be done recursively ([StackOverflow post](http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively)). I've included it in LinkedList class for fun (see function reverseRecursive). A Stack Overflow user "Steve Jessop" accurately summed up the recursive approach as "O(N) stack is for the birds." He is certainly not wrong, but chances are good it may come up on a tech interview anyway.