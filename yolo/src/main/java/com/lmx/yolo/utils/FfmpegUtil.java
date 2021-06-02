package com.lmx.yolo.utils;

import com.lmx.yolo.beans.YoloVideo;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component("ffmpegUtil")
public class FfmpegUtil {


        private static final String ffmpegEXE = "ffmpeg";

        // ffmpeg -i videopath imagepath\\%d.jpg
        public Integer videoToImage(String videoInputPath, String imageOutPutPath,String videoName) throws Exception {
             Integer frame=null;
            List<String> command = new ArrayList<>();
            command.add(ffmpegEXE);
            command.add("-i");
            command.add(videoInputPath);
            command.add(imageOutPutPath+"\\"+videoName+"%d.jpg");
            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = null;
            try {
                process = builder.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 使用这种方式会在瞬间大量消耗CPU和内存等系统资源，所以这里我们需要对流进行处理
            assert process != null;
            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            String line;
            List<String> lines=new ArrayList<>();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
            for (String s:lines){
                if (isFrame(s)){
                    int i = s.indexOf("=");
                    int fps = s.indexOf("fps");
                    String substring = s.substring(i + 1, fps);
                    String trim = substring.trim();
                    frame=Integer.parseInt(trim);
                }
            }
            br.close();
            inputStreamReader.close();
            errorStream.close();
            return frame;

        }

    private static boolean isFrame(String line) {
        return line.contains("frame");
    }


    // 将视频和音频结合，并指定视频的长度，同时生成结合之后的视频文件
        //ffmpeg -f image2 -i output\%d.jpg test.mp4
        public YoloVideo imageToVideo(String videoName, String videoOutputPath,String newVideoName, String imageInputPath) {


            List<String> command = new ArrayList<>();
            command.add(ffmpegEXE);
            command.add("-f");
            command.add("image2");
            command.add("-i");
            command.add(imageInputPath+"/"+videoName+"%d.jpg");
            command.add("-vcodec");
            command.add("libx264");
            command.add(videoOutputPath+newVideoName+".mp4");
            ProcessBuilder builder = new ProcessBuilder(command);
            try {
                builder.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 使用这种方式会在瞬间大量消耗CPU和内存等系统资源，所以这里我们需要对流进行处理

            YoloVideo yoloVideo = new YoloVideo();
            yoloVideo.setVideoName(newVideoName+".mp4");
            yoloVideo.setStorePath(videoOutputPath+newVideoName);
            yoloVideo.setImageStorePath(imageInputPath);
            return yoloVideo;
        }

}
