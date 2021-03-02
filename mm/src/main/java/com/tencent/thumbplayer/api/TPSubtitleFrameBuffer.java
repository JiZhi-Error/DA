package com.tencent.thumbplayer.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPSubtitleFrameBuffer {
    public static final int TP_PLAYER_SUBTITLE_OUTPUT_FORMAT_NONE = -1;
    public static final int TP_PLAYER_SUBTITLE_OUTPUT_FORMAT_RGBA = 26;
    public byte[][] data;
    public int dstHeight;
    public int dstWidth;
    public int flags;
    public int format;
    public int[] lineSize;
    public long ptsMs;
    public int rotation;
    public int srcHeight;
    public int srcWidth;
    public int trackID;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_SUBTITLE_FRAME_FORMAT_ID {
    }

    public byte[][] getData() {
        return this.data;
    }

    public int[] getLineSize() {
        return this.lineSize;
    }

    public int getFormat() {
        return this.format;
    }

    public int getSrcWidth() {
        return this.srcWidth;
    }

    public int getSrcHeight() {
        return this.srcHeight;
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getPtsMs() {
        return this.ptsMs;
    }

    public int getDstWidth() {
        return this.dstWidth;
    }

    public int getDstHeight() {
        return this.dstHeight;
    }

    public int getTrackID() {
        return this.trackID;
    }

    public int getFlags() {
        return this.flags;
    }
}
