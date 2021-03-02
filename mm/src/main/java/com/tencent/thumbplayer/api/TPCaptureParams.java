package com.tencent.thumbplayer.api;

public class TPCaptureParams {
    public static final int TP_PIX_FMT_NONE = -1;
    public static final int TP_PIX_FMT_RGB565 = 37;
    public static final int TP_PIX_FMT_YUV420P = 0;
    public int format;
    public int height;
    public long requestedTimeMsToleranceAfter;
    public long requestedTimeMsToleranceBefore;
    public int width;
}
