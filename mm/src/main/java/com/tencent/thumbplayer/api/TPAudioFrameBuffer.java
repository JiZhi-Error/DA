package com.tencent.thumbplayer.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPAudioFrameBuffer {
    public static final int TP_AUDIO_CH_LAYOUT_MONO = 4;
    public static final int TP_AUDIO_CH_LAYOUT_NONE = 0;
    public static final int TP_AUDIO_CH_LAYOUT_STEREO = 3;
    private static final int TP_CH_FRONT_CENTER = 4;
    private static final int TP_CH_FRONT_LEFT = 1;
    private static final int TP_CH_FRONT_RIGHT = 2;
    public long channelLayout;
    public int channels;
    public byte[][] data;
    public int format;
    public int nbSamples;
    public long ptsMs;
    public int sampleRate;
    public int[] size;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TP_AUDIO_CH_LAYOUT {
    }

    public byte[][] getData() {
        return this.data;
    }

    public int[] getSize() {
        return this.size;
    }

    public int getFormat() {
        return this.format;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public long getChannelLayout() {
        return this.channelLayout;
    }

    public long getPtsMs() {
        return this.ptsMs;
    }
}
