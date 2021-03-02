package com.tencent.mm.sdk.platformtools;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.recovery.Recovery;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

public class CrashMonitorForJni {
    private static final String TAG = "MicroMsg.CrashMonitorForJni";
    private static ParcelFileDescriptor mCrashRecordFd = null;
    private static CrashExtraMessageGetter sCrashExtraMessageGetter;

    public interface CrashExtraMessageGetter {
        String getExtraMessage();
    }

    public static native String getCrashFilePath(String str);

    private static native void nativeSetCrashRecordLowFd(int i2);

    public static native void nativeStartCrashTest(int i2);

    public static native void setClientVersionMsg(String str);

    public static void setCrashExtraMessageGetter(CrashExtraMessageGetter crashExtraMessageGetter) {
        sCrashExtraMessageGetter = crashExtraMessageGetter;
    }

    public static void setCrashRecordLowFd(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(145682);
        mCrashRecordFd = parcelFileDescriptor;
        nativeSetCrashRecordLowFd(parcelFileDescriptor.getFd());
        AppMethodBeat.o(145682);
    }

    private static void OnCrash(int i2, int i3, String str) {
        AppMethodBeat.i(145683);
        Recovery.crash();
        new StringBuilder("OnCrash sig:").append(i2).append("  stack:").append(str);
        CrashReportFactory.reportJniCrash(i2, str, "CrashMonitor");
        Log.appenderClose();
        AppMethodBeat.o(145683);
    }

    private static void OnCrash(int i2, int i3, String str, String str2) {
        AppMethodBeat.i(145684);
        String threadJavaStack = getThreadJavaStack(getThreadByName(str2));
        writeStackToFile(str + "\n******* Java stack for JNI crash *******\n" + threadJavaStack);
        AppMethodBeat.o(145684);
    }

    private static CharSequence getAllThreadJavaStack() {
        AppMethodBeat.i(145685);
        StringBuilder sb = new StringBuilder(8192);
        StringBuilder sb2 = new StringBuilder(2048);
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            sb2.setLength(0);
            sb2.append("\n (").append(key.getId()).append(") [").append(key.getName()).append("] ************\n");
            boolean z = false;
            for (int i2 = 0; i2 < value.length; i2++) {
                if (value[i2].toString().startsWith("com.tencent.mm.")) {
                    z = true;
                }
                sb2.append("\tat ").append(value[i2].toString()).append("\n");
            }
            if (z) {
                sb.append((CharSequence) sb2);
            }
        }
        AppMethodBeat.o(145685);
        return sb;
    }

    public static String getCrashThreadJavaStack() {
        AppMethodBeat.i(145686);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        CrashExtraMessageGetter crashExtraMessageGetter = sCrashExtraMessageGetter;
        if (crashExtraMessageGetter != null) {
            printWriter.append((CharSequence) "\n");
            printWriter.append((CharSequence) crashExtraMessageGetter.getExtraMessage());
            printWriter.append((CharSequence) "\n");
        }
        Throwable th = new Throwable("\n******* Java stack for JNI crash *******");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length - 1)];
            for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
                stackTraceElementArr[i2] = stackTrace[i2 + 1];
            }
            th.setStackTrace(stackTraceElementArr);
        }
        th.printStackTrace(printWriter);
        printWriter.append(getAllThreadJavaStack());
        printWriter.append('\n');
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(145686);
        return stringWriter2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC, Splitter:B:16:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043 A[SYNTHETIC, Splitter:B:24:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeStackToFile(java.lang.String r5) {
        /*
            r4 = 145687(0x23917, float:2.04151E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r1 = 0
            android.os.ParcelFileDescriptor r0 = com.tencent.mm.sdk.platformtools.CrashMonitorForJni.mCrashRecordFd     // Catch:{ Throwable -> 0x002e, all -> 0x003e }
            if (r0 == 0) goto L_0x0052
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x002e, all -> 0x003e }
            android.os.ParcelFileDescriptor r2 = com.tencent.mm.sdk.platformtools.CrashMonitorForJni.mCrashRecordFd     // Catch:{ Throwable -> 0x002e, all -> 0x003e }
            java.io.FileDescriptor r2 = r2.getFileDescriptor()     // Catch:{ Throwable -> 0x002e, all -> 0x003e }
            r0.<init>(r2)     // Catch:{ Throwable -> 0x002e, all -> 0x003e }
            byte[] r1 = r5.getBytes()     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
            r0.write(r1)     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
            r0.flush()     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ Throwable -> 0x0029 }
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0028:
            return
        L_0x0029:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0028
        L_0x002e:
            r0 = move-exception
            r0 = r1
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ Throwable -> 0x0039 }
        L_0x0035:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0028
        L_0x0039:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0028
        L_0x003e:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0041:
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ Throwable -> 0x004a }
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x004a:
            r0 = move-exception
            goto L_0x0046
        L_0x004c:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0041
        L_0x0050:
            r1 = move-exception
            goto L_0x0030
        L_0x0052:
            r0 = r1
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.CrashMonitorForJni.writeStackToFile(java.lang.String):void");
    }

    public static String getThreadJavaStack(Thread thread) {
        AppMethodBeat.i(145688);
        if (thread == null) {
            AppMethodBeat.o(145688);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        int length = stackTrace.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(stackTrace[i2].toString() + "\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(145688);
        return sb2;
    }

    public static Thread getThreadByName(String str) {
        Thread thread = null;
        AppMethodBeat.i(145689);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(145689);
        } else {
            Set<Thread> keySet = Thread.getAllStackTraces().keySet();
            Thread[] threadArr = (Thread[]) keySet.toArray(new Thread[keySet.size()]);
            int length = threadArr.length;
            int i2 = 0;
            while (i2 < length) {
                Thread thread2 = threadArr[i2];
                if (!thread2.getName().equals(str)) {
                    thread2 = thread;
                }
                i2++;
                thread = thread2;
            }
            AppMethodBeat.o(145689);
        }
        return thread;
    }
}
