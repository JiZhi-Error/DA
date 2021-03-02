package com.tencent.thumbplayer.core.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public class TPPlayerCoreConfig {
    private static boolean mIsLibLoaded;

    private static native int _getVideoMediaCodecCoexistMaxCnt();

    private static native void _setVideoMediaCodecCoexistMaxCnt(int i2);

    static {
        AppMethodBeat.i(189867);
        mIsLibLoaded = false;
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            mIsLibLoaded = true;
            AppMethodBeat.o(189867);
        } catch (UnsupportedOperationException e2) {
            mIsLibLoaded = false;
            AppMethodBeat.o(189867);
        }
    }

    public static void setVideoMediaCodecCoexistMaxCnt(int i2) {
        AppMethodBeat.i(189865);
        if (!mIsLibLoaded) {
            AppMethodBeat.o(189865);
            return;
        }
        _setVideoMediaCodecCoexistMaxCnt(i2);
        AppMethodBeat.o(189865);
    }

    public static int getVideoMediaCodecCoexistMaxCnt() {
        AppMethodBeat.i(189866);
        if (!mIsLibLoaded) {
            AppMethodBeat.o(189866);
            return -1;
        }
        int _getVideoMediaCodecCoexistMaxCnt = _getVideoMediaCodecCoexistMaxCnt();
        AppMethodBeat.o(189866);
        return _getVideoMediaCodecCoexistMaxCnt;
    }
}
