package com.github.tanxiaofan.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: fan.tan
 * @CreateDate: 2019/11/25 18:46
 */
public class JavaTest {

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void testInstanceOf() {
        String s = "hello";
        println(s instanceof CharSequence);

        CharSequence cs = "abc";
        println(cs instanceof String);

        List<String> stringList = new ArrayList<>();
        println(stringList instanceof LinkedList);
    }
}
