/**
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
**/

class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) negative = true;
        int add = 0;
        if (dividend == (1 << 31)) {
            if (divisor == 1) return dividend;
            if (divisor == -1) return (1 << 31) - 1;
            if (divisor == (1 << 31)) return 1;
            dividend = dividend + 1;
            add = 1;
        }
        if (divisor == (1 << 31)) return 0;
        int ret = 0;
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        int tmpdividend = dividend;
        int tmpdivisor = divisor;
        int addtmp = 1;
        while (tmpdividend >= tmpdivisor) {
            tmpdividend = tmpdividend - tmpdivisor;
            ret = ret + addtmp;
            tmpdivisor = tmpdivisor << 1;
            addtmp = addtmp << 1;
            if (tmpdividend < tmpdivisor || tmpdivisor < 0) {
                tmpdivisor = divisor;
                addtmp = 1;
            }
        }
        tmpdividend = tmpdividend + add;
        if (tmpdividend >= divisor) ret++;
        return negative ? -ret : ret;
    }
}