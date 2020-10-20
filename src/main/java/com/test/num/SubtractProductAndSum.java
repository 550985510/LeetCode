package com.test.num;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/7 17:04
 * 1281. 整数的各位积和之差
 */
@Slf4j
public class SubtractProductAndSum {

    public static void main(String[] args) {
        int n = 234;
        int result = solutionOne(n);
        result = solutionTwo(n);
        log.info("{}", result);
    }

    private static int solutionOne(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int sum = 0, product = 1;
        for (char c : chars) {
            sum += Integer.parseInt(String.valueOf(c));
            product *= Integer.parseInt(String.valueOf(c));
        }
        return product - sum;
    }

    private static int solutionTwo(int n) {
        int add = 0;
        int mul = 1;
        while(n != 0){
            int temp = n % 10;
            add = add + temp;
            mul = mul * temp;
            n = n / 10;
        }
        return mul -add;
    }
}
