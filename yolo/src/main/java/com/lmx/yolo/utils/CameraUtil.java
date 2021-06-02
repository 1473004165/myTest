package com.lmx.yolo.utils;

import com.lmx.yolo.beans.YoloImage;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component("cameraUtil")
public class CameraUtil {

    public static volatile boolean start=false;
    public static Integer number=0;

    private OpenCVFrameGrabber grabber;
    private OpenCVFrameConverter.ToIplImage converter;

    @Async
    public Future<List<YoloImage>> cameraImage() throws FrameGrabber.Exception {
        ArrayList<YoloImage> yoloImages = new ArrayList<>();
        int i = 0;
        while (number < 10){
            if (!start){
              if (converter!=null){
                  converter=null;
              }
              if (this.grabber!=null){
                  grabber.stop();
                  grabber.close();
                  grabber=null;
              }
              return null;
          }else {
              number++;
              if (converter==null){
                  converter = new OpenCVFrameConverter.ToIplImage();
              }
              if (grabber==null){
                  grabber=new OpenCVFrameGrabber(0);
              }
              grabber.start();
              YoloImage yoloImage=new YoloImage();
              opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
              String imgOpPath = "C:/Users/Legion/Desktop/outputPath/outputCamera/";
              opencv_imgcodecs.imwrite(imgOpPath + number + ".jpg", mat);
              yoloImage.setImageName(number+".jpg");
              yoloImage.setImageUrl(imgOpPath + number + ".jpg");
              yoloImages.add(i++,yoloImage);
          }
        }
        return new AsyncResult<>(yoloImages);
    }

}
