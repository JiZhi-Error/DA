package com.tencent.qqmusic.mediaplayer.audiofx;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public interface IAudioListener {
    long getActualTime(long j2);

    boolean isEnabled();

    boolean isTerminal();

    boolean onPcm(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2);

    boolean onPcm(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2, long j2);

    long onPlayerReady(int i2, AudioInformation audioInformation, long j2);

    void onPlayerSeekComplete(long j2);

    void onPlayerStopped();
}
