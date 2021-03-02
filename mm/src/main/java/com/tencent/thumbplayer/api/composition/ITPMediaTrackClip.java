package com.tencent.thumbplayer.api.composition;

public interface ITPMediaTrackClip extends ITPMediaAsset {
    ITPMediaTrackClip clone(int i2);

    int getClipId();

    long getEndTimeMs();

    String getFilePath();

    long getOriginalDurationMs();

    long getStartPositionMs();

    long getStartTimeMs();

    void setCutTimeRange(long j2, long j3);

    void setOriginalDurationMs(long j2);

    void setStartPositionMs(long j2);
}
