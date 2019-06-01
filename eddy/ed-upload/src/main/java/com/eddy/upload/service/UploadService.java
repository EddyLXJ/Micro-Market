package com.eddy.upload.service;

import com.eddy.common.enums.ExceptionEnum;
import com.eddy.common.exception.EdException;
import com.eddy.upload.config.UploadProperties;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties properties;
    //private static final List<String> ALLOW_TYPE = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/jpg");

    public String uploadImage(MultipartFile file) {
        try {
            // 校验文件类型
            String contentType = file.getContentType();
            if (!properties.getAllowTypes().contains(contentType)){
                throw new EdException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw new EdException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            //准备目标路径
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            //  保存文件到本地

            // 返回路径
            return properties.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            // 上传失败
            log.error("Upload File Error", e);
            throw new EdException(ExceptionEnum.UPLOAD_ERROR);
        }

    }
}
