package com.test.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/7 17:46
 *
 */
@Slf4j
public class InvalidIpAddr {

    public static void main(String[] args) {
        String address = "192.168.0.1";
        address = solutionOne(address);
        log.info("{}", address);
    }

    private static String solutionOne(String address) {
        return address.replace(".", "[.]");
    }
}
