package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SQLiteGlobal {
    private static final String TAG = "WCDB.SQLiteGlobal";
    public static final String defaultJournalMode = "PERSIST";
    public static final int defaultPageSize;
    public static final String defaultSyncMode = "FULL";
    public static final int journalSizeLimit = 524288;
    public static final int walAutoCheckpoint = 100;
    public static final int walConnectionPoolSize = 4;
    public static final String walSyncMode = "FULL";

    private static native int nativeReleaseMemory();

    private static native void nativeSetDefaultCipherSettings(int i2);

    static {
        int i2;
        AppMethodBeat.i(3268);
        if (!WCDBInitializationProbe.libLoaded) {
            System.loadLibrary("wcdb");
        }
        try {
            i2 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
        } catch (RuntimeException e2) {
            i2 = 4096;
        }
        defaultPageSize = i2;
        nativeSetDefaultCipherSettings(i2);
        AppMethodBeat.o(3268);
    }

    public static void loadLib() {
    }

    private SQLiteGlobal() {
    }

    public static int releaseMemory() {
        AppMethodBeat.i(3267);
        int nativeReleaseMemory = nativeReleaseMemory();
        AppMethodBeat.o(3267);
        return nativeReleaseMemory;
    }
}
