package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import java.nio.ByteBuffer;

public interface AudioTapProcessor {
    AudioInfo getDestAudioInfo();

    ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo);

    void release();
}
