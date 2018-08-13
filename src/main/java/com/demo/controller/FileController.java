package com.demo.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController extends PublicController{


    @RequestMapping("/fileupload")
    @ResponseBody
    public String fileupload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
	    String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "上传成功";
	    
    }
	
}
