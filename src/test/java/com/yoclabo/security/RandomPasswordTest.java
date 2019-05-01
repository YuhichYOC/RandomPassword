package com.yoclabo.security;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class RandomPasswordTest {
    @Test
    public void test01() {
        try {
            String test = RandomPassword.get(8);
            System.out.println(test);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void test02() {
        try {
            String test = RandomPassword.get(12);
            System.out.println(test);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}
