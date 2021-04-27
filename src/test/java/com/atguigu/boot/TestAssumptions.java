package com.atguigu.boot;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAssumptions {

    @Test
    @DisplayName("前置条件")
    void test01(){
        assumeTrue(1==2,"条件不满足");
        assertTrue(1==2,"不相等");
    }

    @Test
    @DisplayName("简单测试")
    void test02(){
        assumingThat(1==1,()-> System.out.println("====="));
    }




}
