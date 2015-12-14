## Rotate Square Clockwise

### Problem Definition:

Given an NxN square of integers (array of arrays), rotate it by one position clockwise. If given input is not a square, print out ERROR.

Example 1:
```
1 2 3
4 5 6
7 8 9

// after one rotation clockwise

4 1 2
7 5 3
8 9 6
```
 
Example 2:
```
10 11 12 13
21 50 51 14
20 53 52 15
19 18 17 16

// after one rotation clockwise

21 10 11 12
20 53 50 13
19 52 51 14
18 17 16 15
```

### Notes:
- Encountered this problem during an Amazon HackerRank challenge interview 
- I was hoping there was a clever way of rotating a matrix, like there is for 90 degree rotations ([example](http://rajendrauppal.blogspot.com/2011/12/rotating-2d-array-of-integers-matrix-by.html)). Unfortunately I couldn't discover one and went ahead with a straightforward/brute-force approach.