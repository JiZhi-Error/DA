package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class AudioRecognition {
    private static final int READ_FILE_HEADER_SIZE = 64;
    private static String TAG = "AudioRecognition";
    private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache = new HashMap<>();
    private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache = new HashMap<>();

    static {
        AppMethodBeat.i(114289);
        AppMethodBeat.o(114289);
    }

    public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String str) {
        AppMethodBeat.i(114283);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(114283);
            return null;
        } else if (mRecognitionResultCache.containsKey(str)) {
            AudioFormat.AudioType audioType = mRecognitionResultCache.get(str);
            Logger.w(TAG, "Get from cache " + audioType + ",filepath = " + str + ",retType = " + audioType);
            AppMethodBeat.o(114283);
            return audioType;
        } else {
            AudioFormat.AudioType guessFormat = guessFormat(str);
            if (!AudioFormat.isAudioType(guessFormat)) {
                Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = ".concat(String.valueOf(str)));
                try {
                    guessFormat = recognitionAudioFormatExactly(str);
                } catch (IOException e2) {
                    Logger.e(TAG, e2);
                }
            }
            Logger.i(TAG, "recognitionAudioFormatByExtensions filepath = " + str + ",guessAudioType = " + guessFormat);
            AppMethodBeat.o(114283);
            return guessFormat;
        }
    }

    public static AudioFormat.AudioType guessFormat(String str) {
        AppMethodBeat.i(114284);
        if (mGuessFormatResultCache == null || !mGuessFormatResultCache.containsKey(str)) {
            Iterator<AudioFormat.AudioType> it = MediaCodecFactory.getSupportAudioType().iterator();
            while (it.hasNext()) {
                IAudioRecognition createDecoderByType = MediaCodecFactory.createDecoderByType(it.next());
                if (createDecoderByType != null) {
                    AudioFormat.AudioType guessAudioType = createDecoderByType.guessAudioType(str);
                    if (AudioFormat.isAudioType(guessAudioType)) {
                        mGuessFormatResultCache.put(str, guessAudioType);
                        AppMethodBeat.o(114284);
                        return guessAudioType;
                    }
                }
            }
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114284);
            return audioType;
        }
        AudioFormat.AudioType audioType2 = mGuessFormatResultCache.get(str);
        AppMethodBeat.o(114284);
        return audioType2;
    }

    public static NativeDecoder getDecoderFormFile(String str) {
        AppMethodBeat.i(114285);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(114285);
            return null;
        }
        NativeDecoder nativeDecoder = new NativeDecoder();
        if (nativeDecoder.init(str, false) == 0) {
            AppMethodBeat.o(114285);
            return nativeDecoder;
        }
        AppMethodBeat.o(114285);
        return null;
    }

    public static int getAudioBitDept(BaseDecoder baseDecoder, AudioInformation audioInformation) {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(114286);
        boolean z = audioInformation.getAudioType() == AudioFormat.AudioType.FLAC;
        if (z) {
            try {
                i4 = (int) baseDecoder.getMinBufferSize();
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), audioInformation.getChannels(), 2);
        if (!z) {
            i2 = minBufferSize % 2048 != 0 ? ((minBufferSize / 2048) + 1) * 2048 : minBufferSize;
        } else {
            i2 = i4;
        }
        int decodeData = baseDecoder.decodeData(i2, new byte[i2]);
        if (decodeData <= 0) {
            i3 = i2 * 2;
        } else {
            i3 = decodeData;
        }
        int calcBitDept = calcBitDept((long) i3, baseDecoder.getCurrentTime(), audioInformation.getChannels(), audioInformation.getSampleRate());
        AppMethodBeat.o(114286);
        return calcBitDept;
    }

    public static int calcBitDept(long j2, long j3, int i2, long j4) {
        AppMethodBeat.i(114287);
        if (0 == j3 || i2 == 0) {
            AppMethodBeat.o(114287);
            return 0;
        }
        double d2 = (double) ((1000.0f * ((float) j2)) / ((float) ((((long) i2) * j3) * j4)));
        int round = (int) Math.round(d2);
        Logger.i(TAG, "byteNumbers = " + j2 + ",time = " + j3 + ",channels = " + i2 + ",sampleRate = " + j4 + ",bitDept = " + d2);
        AppMethodBeat.o(114287);
        return round;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018e A[SYNTHETIC, Splitter:B:54:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a1 A[SYNTHETIC, Splitter:B:62:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f7 A[EDGE_INSN: B:81:0x01f7->B:76:0x01f7 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType recognitionAudioFormatExactly(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 512
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.AudioRecognition.recognitionAudioFormatExactly(java.lang.String):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }
}
