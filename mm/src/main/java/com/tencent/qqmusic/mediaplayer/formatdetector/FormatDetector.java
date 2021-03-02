package com.tencent.qqmusic.mediaplayer.formatdetector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FormatDetector {
    private static final String TAG = "FormatDetector";
    private static final FormatDetector mInstance = new FormatDetector();
    public static boolean sIsLoadSuccess;

    private native int getFormat(String str, boolean z);

    private native int getFormatFromDataSource(IDataSource iDataSource, boolean z);

    static {
        AppMethodBeat.i(114176);
        sIsLoadSuccess = false;
        sIsLoadSuccess = NativeLibs.loadAll(NativeLibs.audioCommon, NativeLibs.formatDetector);
        AppMethodBeat.o(114176);
    }

    public static AudioFormat.AudioType getAudioFormat(String str) {
        AppMethodBeat.i(114170);
        AudioFormat.AudioType audioFormat = getAudioFormat(str, true);
        AppMethodBeat.o(114170);
        return audioFormat;
    }

    public static AudioFormat.AudioType getAudioFormat(String str, boolean z) {
        AudioFormat.AudioType guessFormat;
        AppMethodBeat.i(114171);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("filePath can't be null!");
            AppMethodBeat.o(114171);
            throw illegalArgumentException;
        }
        try {
            guessFormat = AudioFormat.getAudioType(mInstance.getFormat(str, z));
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            guessFormat = AudioRecognition.guessFormat(str);
        }
        AppMethodBeat.o(114171);
        return guessFormat;
    }

    public static AudioFormat.AudioType getAudioFormat(IDataSource iDataSource, boolean z) {
        AppMethodBeat.i(114172);
        if (iDataSource == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSource can't be null!");
            AppMethodBeat.o(114172);
            throw illegalArgumentException;
        }
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        try {
            audioType = AudioFormat.getAudioType(mInstance.getFormatFromDataSource(iDataSource, z));
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
        }
        AppMethodBeat.o(114172);
        return audioType;
    }

    public static AudioFormat.AudioType getAudioTypeFromExtension(String str) {
        AppMethodBeat.i(114173);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(114173);
            return null;
        }
        AudioFormat.AudioType[] values = AudioFormat.AudioType.values();
        for (AudioFormat.AudioType audioType : values) {
            if (audioType.getExtension().equalsIgnoreCase(str)) {
                AppMethodBeat.o(114173);
                return audioType;
            }
        }
        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.UNSUPPORT;
        AppMethodBeat.o(114173);
        return audioType2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType getAudioType(java.lang.String r4) {
        /*
            r1 = 0
            r3 = 114174(0x1bdfe, float:1.59992E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0011
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0010:
            return r1
        L_0x0011:
            boolean r0 = com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.sIsLoadSuccess
            if (r0 == 0) goto L_0x003e
            com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType r0 = getAudioFormat(r4)
            boolean r2 = com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0)
            if (r2 == 0) goto L_0x003e
        L_0x001f:
            boolean r1 = com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0)
            if (r1 != 0) goto L_0x0039
            r0 = 46
            int r0 = r4.lastIndexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r4.substring(r0)
            java.lang.String r0 = r0.toLowerCase()
            com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType r0 = getAudioTypeFromExtension(r0)
        L_0x0039:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r1 = r0
            goto L_0x0010
        L_0x003e:
            r0 = r1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.getAudioType(java.lang.String):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0) != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType getAudioType(com.tencent.qqmusic.mediaplayer.upstream.IDataSource r4) {
        /*
            r3 = 114175(0x1bdff, float:1.59993E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r4 != 0) goto L_0x0014
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "dataSource can't be null!"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0014:
            com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType r1 = com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType.UNSUPPORT
            boolean r0 = com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.sIsLoadSuccess
            if (r0 == 0) goto L_0x0029
            r0 = 0
            com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType r0 = getAudioFormat(r4, r0)
            boolean r2 = com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0)
            if (r2 == 0) goto L_0x0029
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        L_0x0029:
            r0 = r1
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.getAudioType(com.tencent.qqmusic.mediaplayer.upstream.IDataSource):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }
}
