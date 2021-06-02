package com.lmx.yolo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoloImage implements Serializable {
    private String imageName;
    private String imageUrl;
    private String imageNewName;
    private String saveDir;
    private Integer peonum;
}
