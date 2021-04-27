package com.atguigu.boot;


import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestAssert02 {

    @Test
    @DisplayName("测试对象是否相等")
    void test01(){
        assertEquals(5,5,"实际值和期望值不一致");
    }

    @Test
    @DisplayName("测试是否是同一对象")
    void test02(){
        String str1 = "123";
        String str2 = "123";
        assertSame(str1,str2,"不是同一个对象");
    }

    @Test
    @DisplayName("测试给定的布尔值条件是否满足")
    void test03(){
        assertTrue(2<3,"实际值比期望值小");
    }

    @Test
    @DisplayName("非空")
    void test04(){
        String str=null;
        assertNull(str,"参数为空");
    }

    @Test
    @DisplayName("数组断言")
    void test05(){
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"两数组值不等");
    }

    @Test
    @DisplayName("组合断言")
    void test06(){
        assertAll("mystr",()->assertEquals(2,1+1),
                ()->assertTrue(1==1));
    }

    @Test
    @Disabled
    @DisplayName("跳过断言")
    void test07(){
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"两数组值不等");
    }

    @Test
    @DisplayName("异常断言")
    void test08(){
        String str = null;
        assertThrows(NullPointerException.class,()->str.length(),"竟然没有抛出异常");
    }

    @Test
    @DisplayName("超时断言")
    void test09(){
        assertTimeout(Duration.ofSeconds(2),()-> Thread.sleep(3000),"超时会抛出异常");
    }

    @Test
    @DisplayName("快速失败")
    void test10(){
        fail("快速失败");
    }





}
