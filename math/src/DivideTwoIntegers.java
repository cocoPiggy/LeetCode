/**
 * 29. Divide Two Integers
 * Medium
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    // time O(log(n)) space O(log(n)) 加等号后space小于O(log(n))
    public int divide(int dividend, int divisor) {
            //space O(logn) time O(logn)
            int sign=1;
            if(dividend<0&&divisor>0||dividend>0&&divisor<0) sign=-1;
            long ldividend=Math.abs((long)dividend);
            long ldivisor=Math.abs((long)divisor);
            if(ldividend<ldivisor||dividend==0) return 0;
            long res= divide(ldividend,ldivisor);
            if(res>Integer.MAX_VALUE){
                return sign==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            return (int)res*sign;
        }

        public long divide(long ldividend,long ldivisor){
            if(ldividend<ldivisor) return 0;
            long sum=ldivisor;
            long multiple=1;
            while((sum+sum)<=ldividend){
                sum+=sum;
                multiple+=multiple;
            }
            return multiple+divide(ldividend-sum,ldivisor);
        }
}
