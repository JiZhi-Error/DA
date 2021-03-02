package com.tencent.mars.xlog;

import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LogDecryptor;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;

public class Xlog implements Log.LogImp {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    public static final int ZLIB_MODE = 0;
    public static final int ZSTD_COMPRESS_LEVEL1 = 1;
    public static final int ZSTD_COMPRESS_LEVEL2 = 2;
    public static final int ZSTD_COMPRESS_LEVEL3 = 3;
    public static final int ZSTD_COMPRESS_LEVEL4 = 4;
    public static final int ZSTD_COMPRESS_LEVEL5 = 5;
    public static final int ZSTD_COMPRESS_LEVEL6 = 6;
    public static final int ZSTD_COMPRESS_LEVEL7 = 7;
    public static final int ZSTD_COMPRESS_LEVEL8 = 8;
    public static final int ZSTD_COMPRESS_LEVEL9 = 9;
    public static final int ZSTD_MODE = 1;
    public static LogDecryptor logDecryptor;
    private static String mCacheDir = null;
    private static String mLogDir = null;
    private static String xlog_pubkey = "1dac3876bd566b60c7dcbffd219ca6af2d2c07f045711bf2a6d111a2b1fc27c4df31c1f568879708c5159e370ab141e6627ea028b47f8a5cf4d39ca30d501f81";

    private static native void appenderOpen(XLogConfig xLogConfig);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(long j2, int i2, String str, String str2, String str3, int i3, int i4, long j3, long j4, String str4);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void appenderClose();

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void appenderFlush(long j2, boolean z);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native int getLogLevel(long j2);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native long getXlogInstance(String str);

    public native long newXlogInstance(XLogConfig xLogConfig);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void releaseXlogInstance(String str);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void setAppenderMode(long j2, int i2);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void setConsoleLogOpen(long j2, boolean z);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void setMaxAliveTime(long j2, long j3);

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public native void setMaxFileSize(long j2, long j3);

    static class XLoggerInfo {
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;

        XLoggerInfo() {
        }
    }

    static class XLogConfig {
        public int cachedays = 0;
        public String cachedir;
        public int compresslevel = 6;
        public int compressmode = 0;
        public int level = 2;
        public String logdir;
        public int mode = 0;
        public String nameprefix;
        public String pubkey = "";

        XLogConfig() {
        }
    }

    public static void open(boolean z, int i2, int i3, String str, String str2, String str3, int i4) {
        if (z) {
            System.loadLibrary("tencentxlog");
        }
        Log.appenderOpen(i2, i3, str, str2, str3, i4);
    }

    private static String decryptTag(String str) {
        if (logDecryptor != null) {
            return logDecryptor.decryptTag(str);
        }
        return str;
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logV(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 0, decryptTag(str), str2, str3, i2, i3, j3, j4, str4);
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logD(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 1, decryptTag(str), str2, str3, i2, i3, j3, j4, LogLogic.appendMemLog(str4));
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logI(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 2, decryptTag(str), str2, str3, i2, i3, j3, j4, LogLogic.appendMemLog(str4));
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logW(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 3, decryptTag(str), str2, str3, i2, i3, j3, j4, LogLogic.appendMemLog(str4));
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logE(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 4, decryptTag(str), str2, str3, i2, i3, j3, j4, LogLogic.appendMemLog(str4));
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void logF(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
        logWrite2(j2, 5, decryptTag(str), str2, str3, i2, i3, j3, j4, str4);
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void appenderOpen(int i2, int i3, String str, String str2, String str3, int i4) {
        mCacheDir = str;
        mLogDir = str2;
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i2;
        xLogConfig.mode = i3;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = xlog_pubkey;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i4;
        appenderOpen(xLogConfig);
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public void moveLogsFromCacheDirToLogDir() {
        if (!(mCacheDir == null || mLogDir == null || mCacheDir.length() == 0 || mLogDir.length() == 0)) {
            o oVar = new o(mCacheDir);
            if (oVar.exists()) {
                o[] a2 = oVar.a(new q() {
                    /* class com.tencent.mars.xlog.Xlog.AnonymousClass1 */

                    @Override // com.tencent.mm.vfs.q
                    public boolean accept(o oVar) {
                        if (oVar.isDirectory()) {
                            return false;
                        }
                        return oVar.getName().toLowerCase().endsWith(".xlog");
                    }
                });
                if (a2.length != 0) {
                    for (o oVar2 : a2) {
                        s.nx(aa.z(oVar2.mUri), mLogDir + FilePathGenerator.ANDROID_DIR_SEP + oVar2.getName());
                    }
                }
            }
        }
    }

    public static void logWrite2(int i2, String str, String str2, String str3, int i3, int i4, long j2, long j3, String str4) {
        logWrite2(0, i2, str, str2, str3, i3, i4, j2, j3, str4);
    }

    @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
    public long openLogInstance(int i2, int i3, String str, String str2, String str3, int i4) {
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i2;
        xLogConfig.mode = i3;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = xlog_pubkey;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i4;
        return newXlogInstance(xLogConfig);
    }
}
