package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class FfmpegRecognition implements IAudioRecognition {
    private static final String SO_AUDIO_COMMON = "audio_common";
    private static final String SO_BASE_NAME = "FFmpeg";
    private static final String SO_NAME = "ffmpeg_decoder";
    private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
    private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
    private static final String TAG = "FfmpegRecognition";

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006d  */
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType getAudioType(java.lang.String r7, byte[] r8) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition.getAudioType(java.lang.String, byte[]):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114354);
        AudioFormat.AudioType audioType = getAudioType(str, null);
        AppMethodBeat.o(114354);
        return audioType;
    }

    public static boolean isM4a(IDataSource iDataSource) {
        AppMethodBeat.i(114355);
        byte[] bArr = new byte[4];
        try {
            iDataSource.readAt(4, bArr, 0, 4);
        } catch (IOException e2) {
        }
        if (bArr[0] == 102 && bArr[1] == 116 && bArr[2] == 121 && bArr[3] == 112) {
            AppMethodBeat.o(114355);
            return true;
        }
        AppMethodBeat.o(114355);
        return false;
    }
}
