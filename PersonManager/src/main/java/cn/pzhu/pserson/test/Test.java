package cn.pzhu.pserson.test;

import cn.pzhu.pserson.util.MD5Util;

public class Test {
    public static void main(String[] args) {
        String crypt = MD5Util.crypt("ybh121314");
        System.out.println(crypt);
    }
}
