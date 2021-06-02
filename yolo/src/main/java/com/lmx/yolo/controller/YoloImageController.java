package com.lmx.yolo.controller;


import com.lmx.yolo.beans.YoloImage;
import com.lmx.yolo.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController("yoloImageController")
public class YoloImageController {

    @Resource(name = "fileService")
    FileService fileService;

    @PostMapping("upLoadImage")
    public YoloImage upLoadImage(MultipartFile file) throws IOException {
        if (Objects.isNull(file) || file.isEmpty()) {
            //判断非空
            return null;
        }
        YoloImage yoloImage = fileService.storeImage(file);
        if (yoloImage.getImageUrl()!=null){
            return yoloImage;
        }else {
            return null;
        }
    }

    @PostMapping(value = "analysisImage")
    public YoloImage analysisImage(@RequestParam(name="file") MultipartFile file)throws IOException {
        System.out.println(file+"        aaaaaaaaaaaaaaaaaa");
        YoloImage yoloImage = upLoadImage(file);
        System.out.println(yoloImage);
        return fileService.analysisImage(yoloImage);
    }



    public List<YoloImage> analysisImages() throws IOException {
        return fileService.analysisList();
    }

    public YoloImage analysisImage(YoloImage yoloImage){
        return fileService.analysisImage(yoloImage);
    }

}
