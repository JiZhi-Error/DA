package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class YtLogger {
    public static final int DEBUG_LEVEL = 4;
    public static final int ERROR_LEVEL = 0;
    public static final int INFO_LEVEL = 2;
    public static final int VERB_LEVEL = 5;
    public static final int WARN_LEVEL = 1;
    private static int currentLogLevel = 0;
    @SuppressLint({"SimpleDateFormat"})
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
    private static File localFile = null;
    private static String localLogName = "youtu_log";
    private static IYtLoggerListener loggerListener = null;
    private static ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private static boolean needLogFile = false;

    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    static {
        AppMethodBeat.i(192587);
        AppMethodBeat.o(192587);
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static void setLogLevel(int i2) {
        AppMethodBeat.i(192575);
        currentLogLevel = Math.min(i2, Math.max(i2, 0));
        AppMethodBeat.o(192575);
    }

    public static void setNeedLogFile(boolean z, String str) {
        AppMethodBeat.i(192576);
        needLogFile = z;
        if (z) {
            localLogName = str;
            localFile = getLogFile(str);
        }
        AppMethodBeat.o(192576);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(192577);
        if (currentLogLevel >= 0) {
            showLog(str, "[YoutuLog]-[ERROR]-".concat(String.valueOf(str2)));
        }
        AppMethodBeat.o(192577);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(192578);
        if (currentLogLevel > 0) {
            showLog(str, "[YoutuLog]-[WARN]-".concat(String.valueOf(str2)));
        }
        AppMethodBeat.o(192578);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(192579);
        if (currentLogLevel >= 2) {
            showLog(str, "[YoutuLog]-[INFO]-".concat(String.valueOf(str2)));
        }
        AppMethodBeat.o(192579);
    }

    public static void d(String str, Object obj) {
        AppMethodBeat.i(192580);
        if (currentLogLevel >= 4) {
            showLog(str, "[YoutuLog]-[DEBUG]-".concat(String.valueOf(obj)));
        }
        AppMethodBeat.o(192580);
    }

    public static void v(String str, Object obj) {
        AppMethodBeat.i(192581);
        if (currentLogLevel >= 5) {
            showLog(str, "[YoutuLog]-[VERB]-".concat(String.valueOf(obj)));
        }
        AppMethodBeat.o(192581);
    }

    private static void showLog(String str, String str2) {
        AppMethodBeat.i(192582);
        if (loggerListener != null) {
            loggerListener.log(str, str2);
        }
        buildMessage(str, str2, null);
        AppMethodBeat.o(192582);
    }

    private static String buildMessage(String str, String str2, Throwable th) {
        AppMethodBeat.i(192583);
        if (localLogName != null && !"".equals(localLogName) && needLogFile) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(dateFormat.format(new Date()));
            stringBuffer2.append("    ");
            stringBuffer2.append("    ");
            stringBuffer2.append(str);
            stringBuffer2.append("    ");
            stringBuffer2.append(stringBuffer);
            if (th != null) {
                stringBuffer2.append(System.getProperty("line.separator"));
                stringBuffer2.append(Log.getStackTraceString(th));
            }
            save2File(stringBuffer2.toString());
        }
        AppMethodBeat.o(192583);
        return str2;
    }

    private static void save2File(String str) {
        AppMethodBeat.i(192584);
        if (localFile != null) {
            writeFile(localFile, str);
        }
        AppMethodBeat.o(192584);
    }

    private static File getLogFile(String str) {
        AppMethodBeat.i(192585);
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "youtulog" + File.separator + str);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file.getPath() + File.separator + (dateFormat.format(new Date()) + ".log"));
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(192585);
            return file2;
        }
        AppMethodBeat.o(192585);
        return null;
    }

    private static void writeFile(final File file, final String str) {
        AppMethodBeat.i(192586);
        mExecutorService.submit(new Runnable() {
            /* class com.tencent.youtu.sdkkitframework.common.YtLogger.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r7 = this;
                    r6 = 192574(0x2f03e, float:2.69854E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                    r1 = 0
                    java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    java.io.File r4 = r3     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    r0.<init>(r2)     // Catch:{ Exception -> 0x0028, all -> 0x0033 }
                    java.lang.String r1 = r4     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
                    r0.println(r1)     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
                    r0.flush()     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
                    r0.close()
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                L_0x0027:
                    return
                L_0x0028:
                    r0 = move-exception
                    r0 = r1
                L_0x002a:
                    if (r0 == 0) goto L_0x003f
                    r0.close()
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    goto L_0x0027
                L_0x0033:
                    r0 = move-exception
                    r2 = r0
                    r3 = r1
                L_0x0036:
                    if (r3 == 0) goto L_0x003b
                    r3.close()
                L_0x003b:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    throw r2
                L_0x003f:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    goto L_0x0027
                L_0x0043:
                    r1 = move-exception
                    r2 = r1
                    r3 = r0
                    goto L_0x0036
                L_0x0047:
                    r1 = move-exception
                    goto L_0x002a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.common.YtLogger.AnonymousClass1.run():void");
            }
        });
        AppMethodBeat.o(192586);
    }
}
