package com.xubowen.controller;

import com.xubowen.pojo.UploadResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2022/2/27 17:18
 */

@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("uploadMethod")
    public UploadResult regUpload(MultipartFile photo) throws IOException {
        System.out.println("yes");
        System.out.println(photo.getOriginalFilename());
        System.out.println("no");
        // 上传资源存储到硬盘中
        photo.transferTo(new File("F:\\ProgrammingSoftware\\IntelliJ IDEA Workspace\\backend\\springmvc\\03-upload\\output\\1.jpg"));
        return new UploadResult(true,"成功","");
    }
}
