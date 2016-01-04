## Arithmetic Progression Missing Element Finder

### Problem Definition:

Find the missing element in an (arithmetic progression)[https://en.wikipedia.org/wiki/Arithmetic_progression] of N elements. 

#### Input Format:
First line contains number of elements N. Second line has N number of space separated integers.

#### Output Format:
Print the missing element.

#### Constraints & Assumptions:
- each element is to be treated as a whole integer
- sequence will contain at least 3 elements
- each sequence is missing 1 element (no more, no less)
- missing element will exist somewhere after the first element

Example:
```
Input:
5
-5 5 15 20 25

Output:
0
```

Example 2:
```
Input:
4
6 3 0 -3

Output:
-6
```

### Notes:
- A naive solution will run in O(n) as the full sequence is iterated over to establish the missing element. However, there is a faster approach O(log(n)) by using a slightly tweaked version of a binary search. That's possible due to the nature of arithmetic sequences where each element a(i) = a(0) + step * i.