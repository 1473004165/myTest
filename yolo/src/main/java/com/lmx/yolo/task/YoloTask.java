package com.lmx.yolo.task;

import com.alibaba.fastjson.JSON;
import com.lmx.yolo.beans.YoloImage;
import com.lmx.yolo.utils.YoloUtil;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration("yoloTask")
public class YoloTask {
   /**
     *  带返回值的线程
     * 异步 监听cmd的输出
     * @return 包含分析后的图片的路径
     */
    public YoloImage listenCMD(YoloUtil yoloUtil)  {
        String line;
        while(true) {
            try {
                if (yoloUtil.br!=null){
                    line = yoloUtil.br.readLine();
                    System.out.println(line);
                    if (isJSON(line)){
                        String json = YoloUtil.collectJSON(line);
                        YoloImage yoloImage = JSON.parseObject(json, YoloImage.class);
                        StringBuilder url = new StringBuilder("http://localhost:8888/outputPath/");
                        int index = yoloImage.getSaveDir().indexOf("outputImage");
                        String substring = yoloImage.getSaveDir().substring(index);
                        url.append(substring).append("/");
                        yoloImage.setSaveDir(url.toString());
                        return yoloImage;
                    }
                }else{
                    yoloUtil.destory();
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        return null;
    }


    public List<YoloImage> listenCMDs(YoloUtil yoloUtil)  {
        List<YoloImage> yoloImages = new ArrayList<>();
        while (yoloUtil.br != null) {
            String line = null;
            try {
                line = yoloUtil.br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("======================\n" + line);
            assert line != null;
            if (line.contains("Done")){
                yoloUtil.destory();
                break;
            }
            if (isJSON(line)) {
                String outputCamera = line.substring(line.indexOf("outputCamera")+"outputCamera".length(), line.indexOf("{") - 2);
                System.out.println(outputCamera);
                String json = YoloUtil.collectJSON(line);
                YoloImage yoloImage = JSON.parseObject(json, YoloImage.class);
                StringBuilder url = new StringBuilder("localhost:8888/outputPath/");
                int index = yoloImage.getSaveDir().indexOf("outputImage");
                String substring = yoloImage.getSaveDir().substring(index);
                url.append(substring).append("/");
                url.append(outputCamera);
                yoloImage.setSaveDir(url.toString());
                yoloImages.add(yoloImage);
            }
        }
        System.out.println(yoloImages);
        return yoloImages;
    }

    public static  Boolean isJSON(String line){
        if (line==null){
            return false;
        }
        return line.contains("{") || line.contains("}");
    }
}