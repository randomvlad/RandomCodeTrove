package string.sumbin;

public class Solution {

    public String sum(String number1, String number2) {

        StringBuilder sbSum = new StringBuilder();

        int index1 = number1.length() - 1;
        int index2 = number2.length() - 1;
        int carry = 0;

        while (index1 >= 0 || index2 >= 0) {
            int intermediateSum = carry;

            if (index1 >= 0) {
                intermediateSum += number1.charAt(index1) - '0';
                index1--;
            }

            if (index2 >= 0) {
                intermediateSum += number2.charAt(index2) - '0';
                index2--;
            }

            carry = intermediateSum >> 1;
            sbSum.append((intermediateSum & 1) == 1 ? '1' : '0');
        }

        if (carry > 0) {
            sbSum.append('1');
        }

        return sbSum.reverse().toString();
    }
}
