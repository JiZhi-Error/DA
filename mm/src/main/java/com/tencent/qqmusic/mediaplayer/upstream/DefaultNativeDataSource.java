package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;

public class DefaultNativeDataSource implements INativeDataSource {
    private final AudioFormat.AudioType audioType;
    private final long nativeInstance;

    public DefaultNativeDataSource(long j2, AudioFormat.AudioType audioType2) {
        this.nativeInstance = j2;
        this.audioType = audioType2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
    public long getNativeInstance() {
        return this.nativeInstance;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
    public AudioFormat.AudioType getAudioType() {
        return this.audioType;
    }

    public String toString() {
        return "DefaultNativeDataSource";
    }
}
