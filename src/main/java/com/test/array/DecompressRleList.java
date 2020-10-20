package com.test.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 崔航
 * @date 2020/7/8 13:10
 * 1313. 解压缩编码列表
 */
@Slf4j
public class DecompressRleList {

    public static void main(String[] args) {
        int[] result = solutionOne(new int[]{1, 2, 3, 4});
        log.info("{}", result);
    }

    private static int[] solutionOne(int[] nums) {
        List<Integer> list = new ArrayList<>(16);
        for (int i = 0; i < nums.length; i++, i++) {
            int num = nums[i];
            while (num > 0) {
                list.add(nums[i + 1]);
                num--;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i< list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
