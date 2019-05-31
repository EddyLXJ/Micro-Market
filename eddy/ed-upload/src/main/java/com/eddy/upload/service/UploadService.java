package com.eddy.upload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadService {

    public String uploadImage(MultipartFile file){
        //保存文件到本地
        this.getClass().getClassLoader().getResource("").getFile()
        File dest = new File();
        //返回路径
        return null;
    }
}
