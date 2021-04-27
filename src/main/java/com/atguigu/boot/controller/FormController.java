package com.atguigu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {

    @RequestMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("用户名：{}, 邮箱：{}, 头像：{} , 生活照：{}",username,email,headerImg.getSize(),photos.length);
        headerImg.transferTo(new File("D:\\"+headerImg.getOriginalFilename()));
        for (MultipartFile photo : photos) {
            photo.transferTo(new File("D:\\"+photo.getOriginalFilename()));
        }
        return "redirect:/main.html";
    }
}
