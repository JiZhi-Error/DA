package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;

public interface INativeDataSource {
    AudioFormat.AudioType getAudioType();

    long getNativeInstance();
}
