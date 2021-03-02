package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;

public class NativeDataSourceFactory {
    private static final String TAG = "NativeDataSourceFactory";
    private static final boolean soLoaded;

    public static native long localFile(String str, int i2);

    static {
        AppMethodBeat.i(114305);
        boolean loadAll = NativeLibs.loadAll(Arrays.asList(NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg));
        soLoaded = loadAll;
        if (!loadAll) {
            Logger.e(TAG, "[static initializer] failed to load so!");
        }
        AppMethodBeat.o(114305);
    }

    public static INativeDataSource fileDataSource(final String str) {
        AppMethodBeat.i(114303);
        AnonymousClass1 r0 = new INativeDataSource() {
            /* class com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public final long getNativeInstance() {
                long j2 = 0;
                AppMethodBeat.i(114298);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j2 = NativeDataSourceFactory.localFile(str, 0);
                        AppMethodBeat.o(114298);
                    } catch (Throwable th) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.o(114298);
                    }
                } else {
                    Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.o(114298);
                }
                return j2;
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public final AudioFormat.AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.o(114303);
        return r0;
    }

    public static INativeDataSource fileDataSource(final String str, final int i2) {
        AppMethodBeat.i(114304);
        AnonymousClass2 r0 = new INativeDataSource() {
            /* class com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.AnonymousClass2 */

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public final long getNativeInstance() {
                long j2 = 0;
                AppMethodBeat.i(114306);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j2 = NativeDataSourceFactory.localFile(str, i2 > 0 ? 1 : 0);
                        AppMethodBeat.o(114306);
                    } catch (Throwable th) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.o(114306);
                    }
                } else {
                    Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.o(114306);
                }
                return j2;
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public final AudioFormat.AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.o(114304);
        return r0;
    }
}
