package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WmaRecognition implements IAudioRecognition {
    public static String TAG = "WmaRecognition";
    private final int HEARER_LENGTH = 16;
    private final byte[] WMA_HEADER = {48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108};

    public WmaRecognition() {
        AppMethodBeat.i(114310);
        AppMethodBeat.o(114310);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043 A[SYNTHETIC, Splitter:B:29:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[SYNTHETIC, Splitter:B:36:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0062  */
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType getAudioType(java.lang.String r7, byte[] r8) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition.getAudioType(java.lang.String, byte[]):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114312);
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".wma")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114312);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.WMA;
        AppMethodBeat.o(114312);
        return audioType2;
    }
}
