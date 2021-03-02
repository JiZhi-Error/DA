package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

public class ApeRecognition implements IAudioRecognition {
    public static final String TAG = "ApeRecognition";

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AudioInformation audioInformation;
        AppMethodBeat.i(114356);
        if (bArr == null || bArr.length <= 0 || !new String(bArr).startsWith("MAC")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            NativeDecoder nativeDecoder = new NativeDecoder();
            if (nativeDecoder.init(new FileDataSource(str)) == 0 && (audioInformation = nativeDecoder.getAudioInformation()) != null && audioInformation.getAudioType() == AudioFormat.AudioType.APE) {
                audioType = AudioFormat.AudioType.APE;
            }
            AppMethodBeat.o(114356);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.APE;
        AppMethodBeat.o(114356);
        return audioType2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114357);
        if (TextUtils.isEmpty(str) || (!str.toLowerCase().contains(".ape") && !str.toLowerCase().contains(".mac"))) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114357);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.APE;
        AppMethodBeat.o(114357);
        return audioType2;
    }
}
