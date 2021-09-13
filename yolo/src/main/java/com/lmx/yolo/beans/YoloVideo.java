package com.lmx.yolo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoloVideo implements Serializable {
    private String videoName;
    private String storePath;
    private String imageStorePath;
}