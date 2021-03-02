package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;

public interface IAudioSource<T extends IDecoderTrack> {
    CMTime getDuration();

    T getSourceAudioDecoder(CMTimeRange cMTimeRange);
}
