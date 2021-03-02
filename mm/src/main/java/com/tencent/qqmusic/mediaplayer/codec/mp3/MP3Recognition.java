package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class MP3Recognition implements IAudioRecognition {
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(114332);
        if (MP3FileCheck.isMp3File(str)) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.MP3;
            AppMethodBeat.o(114332);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.UNSUPPORT;
        AppMethodBeat.o(114332);
        return audioType2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114333);
        if (TextUtils.isEmpty(str) || (!str.toLowerCase().endsWith(".mp3") && !str.endsWith(".mp3.tmp") && !str.endsWith(".mp3.mqcc") && !str.endsWith(".ofl") && !str.endsWith(".efe"))) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114333);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.MP3;
        AppMethodBeat.o(114333);
        return audioType2;
    }
}
