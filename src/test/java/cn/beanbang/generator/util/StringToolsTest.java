package cn.beanbang.generator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToolsTest {

    @Test
    void parseUpperCamel() {
        String s1 = "my_first_name";
        String s2 = "aaaaaa";
        String r1 = StringTools.parseUpperCamel(s1);
        String r2 = StringTools.parseUpperCamel(s2);

        System.out.println(r1);
        System.out.println(r2);

        assertEquals(r1, "MyFirstName");
        assertEquals(r2, "Aaaaaa");
    }
}