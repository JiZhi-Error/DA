package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;

public enum NativeLibs {
    nlog("NLog", 1),
    audioCommon("audio_common", 1),
    QmNativeDataSource("QmNativeDataSource", 1),
    formatDetector("FormatDetector", 1),
    codecFactory("codec_factory", 3),
    decoderJni("qqmusic_decoder_jni", 3),
    FFmpeg("FFmpeg_audio", 3),
    cppShared("c++_shared", 3),
    stlportShared("stlport_shared", 3),
    xlog("wechatxlog", 3);
    
    private static final SparseArray<String> SUFFIX;
    private static final String TAG = "NativeLibs";
    private boolean mHasLoadSoSuccess;
    private final String name;
    private final long supportedAbi;

    public static NativeLibs valueOf(String str) {
        AppMethodBeat.i(114400);
        NativeLibs nativeLibs = (NativeLibs) Enum.valueOf(NativeLibs.class, str);
        AppMethodBeat.o(114400);
        return nativeLibs;
    }

    static {
        AppMethodBeat.i(114405);
        SparseArray<String> sparseArray = new SparseArray<>();
        SUFFIX = sparseArray;
        sparseArray.put(1, "");
        SUFFIX.put(2, "");
        AppMethodBeat.o(114405);
    }

    private NativeLibs(String str, long j2) {
        this.name = str;
        this.supportedAbi = j2;
    }

    public static boolean loadAll(NativeLibs... nativeLibsArr) {
        AppMethodBeat.i(114401);
        boolean loadAll = loadAll(Arrays.asList(nativeLibsArr));
        AppMethodBeat.o(114401);
        return loadAll;
    }

    public static boolean loadAll(Iterable<NativeLibs> iterable) {
        AppMethodBeat.i(114402);
        for (NativeLibs nativeLibs : iterable) {
            if (!nativeLibs.load()) {
                AppMethodBeat.o(114402);
                return false;
            }
        }
        AppMethodBeat.o(114402);
        return true;
    }

    public final boolean supportAbi(int i2) {
        return (this.supportedAbi & ((long) i2)) == ((long) i2);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean load() {
        AppMethodBeat.i(114403);
        if (this.mHasLoadSoSuccess) {
            AppMethodBeat.o(114403);
            return true;
        }
        this.mHasLoadSoSuccess = loadLibrary(getName());
        boolean z = this.mHasLoadSoSuccess;
        AppMethodBeat.o(114403);
        return z;
    }

    private boolean loadLibrary(String str) {
        boolean z = false;
        AppMethodBeat.i(114404);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(114404);
        } else {
            try {
                Logger.i(TAG, "[loadLibrary] loading: ".concat(String.valueOf(str)));
                z = AudioPlayerConfigure.getSoLibraryLoader().load(str);
            } catch (Throwable th) {
                Logger.e(TAG, "[loadLibrary] failed: ".concat(String.valueOf(str)), th);
            }
            if (z) {
                Logger.i(TAG, "[loadLibrary] succeed: ".concat(String.valueOf(str)));
            } else {
                Logger.e(TAG, "[loadLibrary] failed: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(114404);
        }
        return z;
    }
}
