package com.atguigu.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@DisplayName("断言测试类")
public class TestAssert01 {

    @Test
    @DisplayName("简单测试")
    void simpleTest(){
        System.out.println("第一次简单测试.....");
    }

    @Test
    @BeforeEach
    void test01(){
        System.out.println("测试开始执行前.......");
    }



}
