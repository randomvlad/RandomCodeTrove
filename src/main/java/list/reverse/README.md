## Linked List Reversals

### Problem Definition:

Reverse a linked list in 3 different ways:

1. reverse each element
2. reverse each pair of elements
3. reverse alternate K elements

**Input Format:** First line contains a string (Note: treat each character as an element of the linked list). Second line has an integer value K >= 1.

**Output Format:** Three individual lines representing the linked list reversed in different ways. Display all elements joined by " -> " string.

Example:
```
Input:
abcdefghi
3

Output:
i -> h -> g -> f -> e -> d -> c -> b -> a
h -> i -> f -> g -> d -> e -> b -> c- > a
c -> b -> a -> d -> e -> f -> i -> h -> g
```

## Solution:
See main class [ReverseListMain.java](ReverseListMain.java) and unit tests [ReverseListTest.java](ReverseListTest.java).

### Notes:
- Dealing with linked lists and in particular reversing them has been a classic staple of tech interviews. I've encountered it once in an Amazon phone tech screen.
- Reversing a linked list can also be done recursively ([StackOverflow post](http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively)). I've included it in LinkedList class for fun (see function reverseRecursive). A Stack Overflow user "Steve Jessop" accurately summed up the recursive approach as "O(N) stack is for the birds." He is certainly not wrong, but chances are good it may come up in an interview anyway.