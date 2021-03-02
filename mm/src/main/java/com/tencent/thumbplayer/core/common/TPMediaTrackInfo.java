package com.tencent.thumbplayer.core.common;

public class TPMediaTrackInfo {
    public static final int TP_NATIVE_MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int TP_NATIVE_MEDIA_TRACK_TYPE_SUBTITLE = 3;
    public static final int TP_NATIVE_MEDIA_TRACK_TYPE_UNKNOW = 0;
    public static final int TP_NATIVE_MEDIA_TRACK_TYPE_VIDEO = 1;
    public boolean isExclusive = true;
    public boolean isInternal = false;
    public boolean isSelected = false;
    public String trackName = "";
    public int trackType = 0;
}
