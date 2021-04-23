package com.dongye.sanquan;

import com.dongye.sanquan.utils.SHA256Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SanquanApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) {
        String dvalvna = SHA256Util.sha256("dvalvna", "vnalnv;amca");
        System.out.println(dvalvna);
    }
}
