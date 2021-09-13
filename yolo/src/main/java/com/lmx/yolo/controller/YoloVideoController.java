package com.lmx.yolo.controller;


import com.lmx.yolo.beans.YoloImage;
import com.lmx.yolo.beans.YoloVideo;
import com.lmx.yolo.service.FileService;
import com.lmx.yolo.utils.CameraUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@CrossOrigin
public class YoloVideoController {

    @Resource(name = "cameraUtil")
    CameraUtil cameraUtil;

    @Resource(name = "yoloImageController")
    YoloImageController yoloImageController;

    @Resource(name = "fileService")
    FileService fileService;


    @RequestMapping(value="/uploadVideo",produces="application/json;charset=UTF-8")
    public YoloVideo uploadVideo(@RequestParam("video") MultipartFile file) throws IOException {

        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            return null;
        }
        //存储video视频文件，获得video对象
        return fileService.storeVideo(file);
    }



    @RequestMapping(value="analysisVideo",produces="application/json;charset=UTF-8")
    public YoloVideo
    analysisVideo(@RequestParam("images") MultipartFile file) throws Exception {
        YoloVideo yoloVideo = uploadVideo(file);
        List<YoloImage> newVideoImgList =new ArrayList<>();
        if (yoloVideo!=null){
            List<YoloImage> list=fileService.videoToImage(yoloVideo);
            for (YoloImage image:list ){
                YoloImage yoloImage = yoloImageController.analysisImage(image);
                newVideoImgList.add(yoloImage);
            }
            YoloVideo newVideo=fileService.listImgToVideo(newVideoImgList);
            newVideo.setStorePath("http://localhost:8888/storePath/"+newVideo.getVideoName());
            Thread.sleep(5000);
            return newVideo;
        }else {
         return null;
        }
    }


    @RequestMapping("analysisRunTime")
    public List<YoloImage> analysisRunTime(@RequestParam("videoStart") Boolean videoStart) throws Exception {
        List<YoloImage> yoloImageList;
        if (!videoStart){
            CameraUtil.start=false;
            return null;
        }else {
            CameraUtil.start=true;
            cameraUtil.cameraImage();
            yoloImageList = yoloImageController.analysisImages();
            return yoloImageList;
        }
    }

}
