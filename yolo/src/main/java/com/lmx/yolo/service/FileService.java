package com.lmx.yolo.service;

import com.lmx.yolo.beans.YoloImage;
import com.lmx.yolo.beans.YoloVideo;
import com.lmx.yolo.utils.FfmpegUtil;
import com.lmx.yolo.utils.YoloUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("fileService")
public class FileService {

    @Resource(name = "yoloUtil")
    YoloUtil yoloUtil;

    @Resource(name = "ffmpegUtil")
    FfmpegUtil ffmpegUtil;
    private static Integer num=0;


    /**
     * 存储图片的方法
     * @param pic 前台上传的图片
     * @return 存储在服务器的图片
     */
    public YoloImage storeImage(MultipartFile pic) throws IOException {
        String storePath = "C:/Users/Legion/Desktop/storePath/";
        Path path = Paths.get(storePath);
        //如果没有files文件夹，则创建
        if (!Files.isWritable(path)) {
            Files.createDirectories(path);
        }
        String suffixName = ".jpg";
        //重新生成文件名
        String fileName = UUID.randomUUID()+suffixName;
        fileName = fileName.replaceAll("-","");
        FileUtils.copyToFile(pic.getInputStream(),new File(storePath + fileName));
        YoloImage yoloImage=new YoloImage();
        yoloImage.setImageName(fileName);
        yoloImage.setImageUrl(storePath +fileName);
        return yoloImage;
    }

    /**
     * 调用分析方法分析图片返回新生成的图片路径
     * @param yoloImage 待分析的图片
     * @return 分析结果
     */
    public YoloImage analysisImage(YoloImage yoloImage) {
        YoloImage yoloImage1=null;
        try {
            yoloImage1 = yoloUtil.yoloImage(yoloImage);
            yoloImage1.setImageUrl("http://localhost:8888/storePath/"+yoloImage.getImageName());
            yoloImage1.setSaveDir(yoloImage1.getSaveDir()+yoloImage.getImageName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return yoloImage1;
    }

    public YoloVideo storeVideo(MultipartFile file) throws IOException {
        String videoStorePath = "C:/Users/Legion/Desktop/storeVideo/";
        Path path = Paths.get(videoStorePath);
        //如果没有files文件夹，则创建
        if (!Files.isWritable(path)) {
            Files.createDirectories(path);
        }

        //file.transferTo(new File(videoStorePath +file.getOriginalFilename()));
        FileUtils.copyToFile(file.getInputStream(),new File(videoStorePath +file.getOriginalFilename()));
        YoloVideo yoloVideo=new YoloVideo();
        yoloVideo.setStorePath(videoStorePath +file.getOriginalFilename());
        yoloVideo.setVideoName(file.getOriginalFilename());
        return yoloVideo;
    }

    public List<YoloImage> videoToImage(YoloVideo yoloVideo) {
        String videoName = yoloVideo.getVideoName();
        Integer integer=null;
        String imgOutputPath = "C:/Users/Legion/Desktop/result/";
        try {
         integer = ffmpegUtil.videoToImage(yoloVideo.getStorePath(), imgOutputPath, videoName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<YoloImage> yoloImages=new ArrayList<>();
        YoloImage yoloImage=new YoloImage();
        if (!ObjectUtils.isEmpty(integer)) {
            for (int i=1;i<=integer;i++){
                yoloImage.setImageName(videoName+i+".jpg");
                yoloImage.setImageUrl(imgOutputPath +yoloImage.getImageName());
                yoloImages.add(yoloImage);
            }
        }
        return yoloImages;
    }

    public YoloVideo listImgToVideo(List<YoloImage> newVideoImgList) {
        num++;
        YoloImage yoloImage = newVideoImgList.get(0);
        //int size = newVideoImgList.size();
        int i = yoloImage.getImageNewName().indexOf(".");
        String videoNewName = yoloImage.getImageNewName().substring(0, i)+num;
        //String imageNewName = yoloImage.getImageNewName();
        String videoName;
        int j;
        if (yoloImage.getImageNewName().contains("1")){
            j=yoloImage.getImageNewName().lastIndexOf("1");
        }else {
            j=yoloImage.getImageNewName().lastIndexOf(".");
        }
        videoName=yoloImage.getImageNewName().substring(0,j);
        String videoNewPath = "C:/Users/Legion/Desktop/storePath/";
        String resultPath = "C:/Users/Legion/Desktop/result/";
        return ffmpegUtil.imageToVideo(videoName, videoNewPath,videoNewName, resultPath);
    }

    public List<YoloImage> analysisList() throws IOException {
        return yoloUtil.yoloImages();
    }
}
