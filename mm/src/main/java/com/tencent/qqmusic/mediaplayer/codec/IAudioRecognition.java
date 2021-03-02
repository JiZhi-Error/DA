package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioFormat;

public interface IAudioRecognition {
    AudioFormat.AudioType getAudioType(String str, byte[] bArr);

    AudioFormat.AudioType guessAudioType(String str);
}
