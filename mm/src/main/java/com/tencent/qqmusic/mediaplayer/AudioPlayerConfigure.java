package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure {
    private static final String LIB_PREFIX = "lib";
    private static final String LIB_SUFFIX = ".so";
    private static final String TAG = "AudioPlayerConfigure";
    static ISoLibraryLoader mISoLibraryLoader = new ISoLibraryLoader() {
        /* class com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure.AnonymousClass1 */

        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public final boolean load(String str) {
            AppMethodBeat.i(114307);
            System.loadLibrary(str);
            AppMethodBeat.o(114307);
            return true;
        }

        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public final String findLibPath(String str) {
            AppMethodBeat.i(114308);
            if (!str.startsWith("lib")) {
                str = "lib".concat(String.valueOf(str));
            }
            if (!str.endsWith(AudioPlayerConfigure.LIB_SUFFIX)) {
                str = str + AudioPlayerConfigure.LIB_SUFFIX;
            }
            AppMethodBeat.o(114308);
            return str;
        }
    };
    static int minAudioTrackWaitTimeMs = 300;
    private static boolean sIsNlogEnabled = false;

    static {
        AppMethodBeat.i(114397);
        AppMethodBeat.o(114397);
    }

    private static byte[] findLibPath(byte[] bArr) {
        AppMethodBeat.i(114393);
        byte[] bytes = mISoLibraryLoader.findLibPath(new String(bArr)).getBytes();
        AppMethodBeat.o(114393);
        return bytes;
    }

    public static void setSoLibraryLoader(ISoLibraryLoader iSoLibraryLoader) {
        if (iSoLibraryLoader != null) {
            mISoLibraryLoader = iSoLibraryLoader;
        }
    }

    public static ISoLibraryLoader getSoLibraryLoader() {
        return mISoLibraryLoader;
    }

    public static void setLog(ILog iLog) {
        AppMethodBeat.i(114394);
        if (iLog != null) {
            iLog.i(TAG, "QQMusicAudioPlayer codec version:1.29.1");
        }
        Logger.setLog(iLog);
        AppMethodBeat.o(114394);
    }

    public static boolean enableNativeLog(String str) {
        AppMethodBeat.i(114395);
        boolean enableNativeLog = enableNativeLog(NativeLibs.nlog.getName(), str);
        AppMethodBeat.o(114395);
        return enableNativeLog;
    }

    public static boolean enableNativeLog(String str, String str2) {
        AppMethodBeat.i(114396);
        if (sIsNlogEnabled) {
            AppMethodBeat.o(114396);
            return true;
        }
        String findLibPath = getSoLibraryLoader().findLibPath(str);
        Logger.i(TAG, "[enableNativeLog] loading log lib: ".concat(String.valueOf(findLibPath)));
        boolean z = str2 == null;
        if (!NLog.init(str, str2, 0) || NativeLog.init(findLibPath) != 0) {
            Logger.e(TAG, "[enableNativeLog] failed");
        } else {
            sIsNlogEnabled = true;
            NLog.setWriteCallback(z);
            Logger.i(TAG, "[enableNativeLog] succeed");
        }
        boolean z2 = sIsNlogEnabled;
        AppMethodBeat.o(114396);
        return z2;
    }

    public static void setAudioTrackMinWaitTimeMs(int i2) {
        minAudioTrackWaitTimeMs = i2;
    }
}
