package com.video.pojo;

import lombok.Data;

@Data
public class Video {
    private int videoId;
    private String videoTitle;
    private String videoDetail;
    private int videoTime;
    private int videoSpeakerId;
    private int videoCourseId;
    private String  videoUrl;
    private String  videoImageUrl;
    private int  videoPlayNum;
    private Speaker speaker;

}
