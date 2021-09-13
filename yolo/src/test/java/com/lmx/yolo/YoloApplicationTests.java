package com.lmx.yolo;

import com.lmx.yolo.beans.YoloVideo;
import com.lmx.yolo.controller.YoloImageController;
import com.lmx.yolo.controller.YoloVideoController;
import com.lmx.yolo.service.FileService;
import com.lmx.yolo.task.YoloTask;
import com.lmx.yolo.utils.CameraUtil;
import com.lmx.yolo.utils.FfmpegUtil;
import com.lmx.yolo.utils.YoloUtil;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;

@EnableAsync
@SpringBootTest
class YoloApplicationTests {
    @Autowired
    CameraUtil cameraUtil;
    @Autowired
    YoloTask yoloTask;
    @Autowired
    FileService fileService;
    @Autowired
    YoloImageController yoloImageController;
    @Autowired
    YoloVideoController videoController;

    @Autowired
    FfmpegUtil ffmpegUtil;
    @Autowired
    YoloUtil yoloUtil;
    @Test
    void contextLoads() throws IOException, InterruptedException {

        new Thread(new Runnable(){
            @Override
            public void run() {

            }
        }).start();String line;
        while(true) {
            try {
                if (yoloUtil.br!=null){

                    line = yoloUtil.br.readLine();
                    System.out.println("======================"+line);

                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
//        yoloUtil.yoloImage("C:\\mask_detecting-master\\image\\2.jpg");
//        yoloUtil.yoloImage("C:\\mask_detecting-master\\image\\3.jpg");


    }



    @Test
    public void thread() throws ExecutionException, InterruptedException, IOException {

//        YoloImage yoloImage = yoloUtil.yoloImage("C:\\mask_detecting-master\\image\\2.jpg");
//        System.out.println(yoloImage);
//        YoloImage yoloImage1 = yoloUtil.yoloImage("C:\\mask_detecting-master\\image\\3.jpg");
//        System.out.println(yoloImage1);
    }


    @Test
    public void Ffmpeg() throws Exception {
        Integer integer = ffmpegUtil.videoToImage("D:\\yolo\\storeVideo\\WeChat_20200117234311.mp4", "D:\\yolo\\outputImage", "WeChat_20200117234311.mp4");
        System.out.println(integer);
    }


    @Test
    public void FfmpegVideo() throws Exception {
//      ffmpegUtil.imageToVideo("WeChat_20200117234311.mp4","D:\\yolo\\storeVideo\\test.mp4","D:\\yolo\\outputImage");
    }

    public static void main(String[] args) {
        FfmpegUtil ffmpegUtil = new FfmpegUtil();
        //ffmpegUtil.imageToVideo("","C:\\Users\\Legion\\Desktop\\video\\","test2","C:\\Users\\Legion\\Desktop\\outputPath\\outputImage2\\");
        try {
            ffmpegUtil.videoToImage("C:\\Users\\Legion\\Desktop\\VID_20210517_182141.mp4","C:\\Users\\Legion\\Desktop\\outputPath\\outputCamera","temp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCamera() throws InterruptedException, FrameGrabber.Exception {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        while (true) {
            if (!canvas.isDisplayable()) {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(-1);//退出
            }

            Frame frame = grabber.grab();

            canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            Thread.sleep(50);//50毫秒刷新一次图像
        }
    }

    @Test
    public void testCamera1() throws FrameGrabber.Exception, InterruptedException {
        VideoInputFrameGrabber grabber = VideoInputFrameGrabber.createDefault(0);
        grabber.start();
        CanvasFrame canvasFrame = new CanvasFrame("摄像头");
        canvasFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvasFrame.setAlwaysOnTop(true);
        while (true) {
            if (!canvasFrame.isDisplayable()) {
                grabber.stop();
                System.exit(-1);
            }
            Frame frame = grabber.grab();
            canvasFrame.showImage(frame);
            Thread.sleep(30);
        }
    }
    @Test
    public void testVideoToImage(){
        YoloVideo yoloVideo = new YoloVideo();
        yoloVideo.setVideoName("WeChat_20200117234311.mp4");
        yoloVideo.setStorePath("D:\\yolo\\storeVideo\\WeChat_20200117234311.mp4");

        fileService.videoToImage(yoloVideo);
    }

    @Test
    public void cameralImg() throws InterruptedException, FrameGrabber.Exception {
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        int ex = 0;
        while(true)
        {
            if(!canvas.isDisplayable())
            {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(2);//退出
                break;
            }
            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
            ex++;
            opencv_imgcodecs.imwrite("C:\\mask_detecting-master\\uploadImage\\" + ex + ".jpg", mat);
            Thread.sleep(200);//50毫秒刷新一次图像
        }

    }

    /*@Test
    public void testCameralUtil() throws Exception {

        YoloImage yoloImage1 =new YoloImage();
        yoloImage1.setImageUrl("C:\\mask_detecting-master\\image\\2.jpg");
        yoloImage1.setImageName("2.jpg");
       yoloImageController.analysisImage(yoloImage1);
       for (int i=1;i<=100;i++){
           YoloImage yoloImage = videoController.analysisRunTime(true);
       }
    }*/


}
