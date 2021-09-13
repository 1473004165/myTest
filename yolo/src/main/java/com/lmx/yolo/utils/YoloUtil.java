package com.lmx.yolo.utils;

import com.lmx.yolo.beans.YoloImage;
import com.lmx.yolo.task.YoloTask;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component("yoloUtil")
public class YoloUtil {
    @Resource(name = "yoloTask")
    YoloTask yoloTask;


    public String commend = "python";

    public String filePath = "C:/Users/Legion/Desktop/yolov5-master/";

    public String pyName = "detect.py";

    public Process process;
    public SequenceInputStream sis;
    public InputStreamReader isr;
    public BufferedReader br;
    public OutputStreamWriter osw;
    public BufferedWriter bw;

    public void init() throws IOException {
        process = Runtime.getRuntime ().exec ("cmd");
        sis = new SequenceInputStream (process.getInputStream (), process.getErrorStream ());
        isr = new InputStreamReader (sis, "gbk");
        br = new BufferedReader (isr);
        // next command
        osw = new OutputStreamWriter (process.getOutputStream ());
        bw = new BufferedWriter (osw);
        bw.write ("C: ");
        bw.newLine ();
        bw.write ("cd "+filePath);
        bw.newLine ();
    }

     public YoloImage yoloImage(YoloImage yoloImg) throws IOException {
         init();
         bw.write (commend+" "+pyName+" --source ");
         bw.write (yoloImg.getImageUrl());
         bw.newLine ();
         bw.flush ();
         // read
         YoloImage yoloImage = yoloTask.listenCMD(this);
         System.out.println(yoloImage);
         return yoloImage;
     }

    public List<YoloImage> yoloImages() throws IOException {
        init();
        bw.write (commend+" "+pyName+" --source ");
        bw.write ("C:/Users/Legion/Desktop/outputPath/outputCamera");
        bw.newLine ();
        bw.flush ();
        // read
        List<YoloImage> yoloImageList = yoloTask.listenCMDs(this);
        System.out.println(yoloImageList);

        return yoloImageList;
    }

     public static String collectJSON(String buffer){
         int first = buffer.indexOf("{");
         int last = buffer.lastIndexOf("}");
         return buffer.substring(first, last+1);
     }

     public void destory(){
         process.destroy ();
         try {
             bw.close ();
             osw.close ();
             br.close ();
             isr.close ();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
