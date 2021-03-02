package com.tencent.thumbplayer.api.composition;

public interface ITPMediaAsset {
    public static final int INVALID_ID = -1;
    public static final int MEDIA_TYPE_AUDIO = 3;
    public static final int MEDIA_TYPE_AV_MIX = 1;
    public static final int MEDIA_TYPE_MUTABLE = 4;
    public static final int MEDIA_TYPE_VIDEO = 2;

    int getMediaType();

    String getUrl();
}
