package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class VorbisRecognition implements IAudioRecognition {
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(114313);
        if (bArr == null || bArr.length <= 0 || !new String(bArr).startsWith("OggS")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114313);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.OGG;
        AppMethodBeat.o(114313);
        return audioType2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114314);
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".ogg")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114314);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.OGG;
        AppMethodBeat.o(114314);
        return audioType2;
    }
}
