package com.quyenlx.video;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class VideoPlayerManager {
    public static VideoPlayer FIRST_FLOOR_JCVD;
    public static VideoPlayer SECOND_FLOOR_JCVD;

    public static void setFirstFloor(VideoPlayer videoPlayer) {
        FIRST_FLOOR_JCVD = videoPlayer;
    }

    public static void setSecondFloor(VideoPlayer videoPlayer) {
        SECOND_FLOOR_JCVD = videoPlayer;
    }

    public static VideoPlayer getFirstFloor() {
        return FIRST_FLOOR_JCVD;
    }

    public static VideoPlayer getSecondFloor() {
        return SECOND_FLOOR_JCVD;
    }

    public static VideoPlayer getCurrentJcvd() {
        if (getSecondFloor() != null) {
            return getSecondFloor();
        }
        return getFirstFloor();
    }

    public static void completeAll() {
        if (SECOND_FLOOR_JCVD != null) {
            SECOND_FLOOR_JCVD.onCompletion();
            SECOND_FLOOR_JCVD = null;
        }
        if (FIRST_FLOOR_JCVD != null) {
            FIRST_FLOOR_JCVD.onCompletion();
            FIRST_FLOOR_JCVD = null;
        }
    }
}
