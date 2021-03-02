package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class WavRecognition implements IAudioRecognition {
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(114317);
        if (WaveReader.isWavFormat(str)) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.WAV;
            AppMethodBeat.o(114317);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.UNSUPPORT;
        AppMethodBeat.o(114317);
        return audioType2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114318);
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".wav")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114318);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.WAV;
        AppMethodBeat.o(114318);
        return audioType2;
    }

    public static boolean isWav(IDataSource iDataSource) {
        AppMethodBeat.i(114319);
        byte[] bArr = new byte[4];
        try {
            iDataSource.readAt(0, bArr, 0, 4);
        } catch (IOException e2) {
        }
        if (bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70) {
            AppMethodBeat.o(114319);
            return true;
        }
        try {
            iDataSource.readAt(8, bArr, 0, 4);
        } catch (IOException e3) {
        }
        if (bArr[0] == 87 && bArr[1] == 65 && bArr[2] == 86 && bArr[3] == 69) {
            AppMethodBeat.o(114319);
            return true;
        }
        AppMethodBeat.o(114319);
        return false;
    }
}
