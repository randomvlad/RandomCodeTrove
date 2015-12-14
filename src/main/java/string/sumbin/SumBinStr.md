## Sum Binary String Values

### Problem Definition:

Implement a function that takes two strings of binary values and sum them.

Example:
```
String value1 = "110"; // 6
String value2 = "101"; // 5
String sum = sum( value1, value2 ); // result is 1011 = 11
```

### Notes:
* I've encountered this problem during a Facebook Phone Interview
* Learned an interesting tidbit about Java's StringBuilder. I had assumed there was a handy prepend function, but there is only insert which seems inefficient. It's better to append values and later reverse for this particular situation ([stackoverflow post](http://stackoverflow.com/questions/738950/c-sharp-or-java-prepend-strings-with-stringbuilder)).
	
