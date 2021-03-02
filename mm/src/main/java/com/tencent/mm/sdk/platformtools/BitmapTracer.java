package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Debug;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.GZIPOutputStream;

public class BitmapTracer {
    private static final boolean RECORD_STACK_TRACE = true;
    private static final String TAG = "MicroMsg.BitmapTracer";
    private static final WeakHashMap<Bitmap, BitmapTraceInfo> bitmapTraces = new WeakHashMap<>();
    private static boolean checkingScheduled;
    private static final MMHandler handler;

    static /* synthetic */ String access$100(long j2) {
        AppMethodBeat.i(156094);
        String humanReadableSize = humanReadableSize(j2);
        AppMethodBeat.o(156094);
        return humanReadableSize;
    }

    static /* synthetic */ void access$200(PrintWriter printWriter, long j2, int i2) {
        AppMethodBeat.i(215296);
        printStatistics(printWriter, j2, i2);
        AppMethodBeat.o(215296);
    }

    static /* synthetic */ void access$300(long j2, int i2) {
        AppMethodBeat.i(215297);
        dumpReadableLog(j2, i2);
        AppMethodBeat.o(215297);
    }

    static {
        AppMethodBeat.i(156097);
        if (!WeChatEnvironment.isMonkeyEnv()) {
            handler = null;
            MTimerHandler mTimerHandler = new MTimerHandler("BitmapBriefTracer", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.sdk.platformtools.BitmapTracer.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(156078);
                    BitmapTracer.briefDump();
                    AppMethodBeat.o(156078);
                    return true;
                }
            }, true);
            mTimerHandler.startTimer(120000);
            mTimerHandler.setLogging(false);
        } else {
            handler = new MMHandler("BitmapTracer", new MMHandler.Callback() {
                /* class com.tencent.mm.sdk.platformtools.BitmapTracer.AnonymousClass2 */
                long lastGCTime = 0;
                boolean traceDumped = false;

                public final boolean handleMessage(Message message) {
                    Throwable th;
                    PrintWriter printWriter;
                    Exception e2;
                    AppMethodBeat.i(156079);
                    boolean unused = BitmapTracer.checkingScheduled = false;
                    Runtime runtime = Runtime.getRuntime();
                    long j2 = runtime.totalMemory();
                    long freeMemory = runtime.freeMemory();
                    Log.i(BitmapTracer.TAG, "Memory level: %s (+%s) / %s", BitmapTracer.access$100(j2 - freeMemory), BitmapTracer.access$100(freeMemory), BitmapTracer.access$100(runtime.maxMemory()));
                    if (!this.traceDumped && j2 - freeMemory > 209715200) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.lastGCTime > 180000) {
                            System.gc();
                            this.lastGCTime = currentTimeMillis;
                            AppMethodBeat.o(156079);
                            return true;
                        }
                        PrintWriter printWriter2 = null;
                        try {
                            printWriter = new PrintWriter(new GZIPOutputStream(s.dw(b.aKJ() + "BitmapTraces.txt.gz", false)));
                            try {
                                BitmapTracer.access$200(printWriter, 0, -1);
                                Util.qualityClose(printWriter);
                            } catch (Exception e3) {
                                e2 = e3;
                                try {
                                    Log.printErrStackTrace(BitmapTracer.TAG, e2, "", new Object[0]);
                                    Util.qualityClose(printWriter);
                                    Debug.dumpHprofData(b.aKJ() + "Memory.hprof");
                                    this.traceDumped = true;
                                    AppMethodBeat.o(156079);
                                    return true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    printWriter2 = printWriter;
                                    Util.qualityClose(printWriter2);
                                    AppMethodBeat.o(156079);
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            printWriter = null;
                            Log.printErrStackTrace(BitmapTracer.TAG, e2, "", new Object[0]);
                            Util.qualityClose(printWriter);
                            Debug.dumpHprofData(b.aKJ() + "Memory.hprof");
                            this.traceDumped = true;
                            AppMethodBeat.o(156079);
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            Util.qualityClose(printWriter2);
                            AppMethodBeat.o(156079);
                            throw th;
                        }
                        try {
                            Debug.dumpHprofData(b.aKJ() + "Memory.hprof");
                        } catch (Exception e5) {
                            Log.printErrStackTrace(BitmapTracer.TAG, e5, "", new Object[0]);
                        }
                        this.traceDumped = true;
                    }
                    AppMethodBeat.o(156079);
                    return true;
                }
            });
        }
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
            /* class com.tencent.mm.sdk.platformtools.BitmapTracer.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
            public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                AppMethodBeat.i(215293);
                if (!(th instanceof OutOfMemoryError)) {
                    AppMethodBeat.o(215293);
                    return;
                }
                BitmapTracer.access$300(1048576, -1);
                AppMethodBeat.o(215293);
            }
        });
        AppMethodBeat.o(156097);
    }

    public static void briefDump() {
        AppMethodBeat.i(156085);
        dumpReadableLog(2097152, 3);
        AppMethodBeat.o(156085);
    }

    private static void dumpReadableLog(long j2, int i2) {
        AppMethodBeat.i(156086);
        printStatistics(new PrintWriter((Writer) new Writer() {
            /* class com.tencent.mm.sdk.platformtools.BitmapTracer.AnonymousClass4 */
            private StringWriter sw;

            @Override // java.io.Writer
            public final void write(char[] cArr, int i2, int i3) {
                AppMethodBeat.i(156081);
                if (this.sw == null) {
                    this.sw = new StringWriter();
                }
                this.sw.write(cArr, i2, i3);
                AppMethodBeat.o(156081);
            }

            @Override // java.io.Writer, java.io.Flushable
            public final void flush() {
                AppMethodBeat.i(156082);
                if (this.sw == null) {
                    AppMethodBeat.o(156082);
                    return;
                }
                String stringWriter = this.sw.toString();
                this.sw = null;
                Log.w(BitmapTracer.TAG, stringWriter);
                AppMethodBeat.o(156082);
            }

            @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
            public final void close() {
                AppMethodBeat.i(156083);
                flush();
                AppMethodBeat.o(156083);
            }
        }, false), j2, i2);
        AppMethodBeat.o(156086);
    }

    /* access modifiers changed from: package-private */
    public static final class BitmapTraceInfo {
        final long acquiredTime = System.currentTimeMillis();
        final BitmapFactory.Options options;
        final String source;
        final StackTraceElement[] stack;

        BitmapTraceInfo(String str, BitmapFactory.Options options2) {
            AppMethodBeat.i(215294);
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            this.stack = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, 4, stackTrace.length);
            this.source = str;
            this.options = options2;
            AppMethodBeat.o(215294);
        }
    }

    public static Bitmap trace(Bitmap bitmap) {
        AppMethodBeat.i(156087);
        Bitmap trace = trace(bitmap, null, null);
        AppMethodBeat.o(156087);
        return trace;
    }

    public static Bitmap trace(Bitmap bitmap, String str) {
        AppMethodBeat.i(156088);
        Bitmap trace = trace(bitmap, str, null);
        AppMethodBeat.o(156088);
        return trace;
    }

    public static Bitmap trace(Bitmap bitmap, String str, BitmapFactory.Options options) {
        AppMethodBeat.i(215295);
        if (bitmap == null) {
            AppMethodBeat.o(215295);
            return null;
        } else if (bitmap.getAllocationByteCount() >= 1048576 || WeChatEnvironment.isMonkeyEnv()) {
            BitmapTraceInfo bitmapTraceInfo = new BitmapTraceInfo(str, options);
            synchronized (bitmapTraces) {
                try {
                    bitmapTraces.put(bitmap, bitmapTraceInfo);
                    if (handler != null && !checkingScheduled) {
                        handler.sendEmptyMessageDelayed(0, 5000);
                        checkingScheduled = true;
                    }
                } finally {
                    AppMethodBeat.o(215295);
                }
            }
            return bitmap;
        } else {
            AppMethodBeat.o(215295);
            return bitmap;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String humanReadableSize(long j2) {
        AppMethodBeat.i(156090);
        if (j2 >= TPAudioFrame.TP_CH_STEREO_RIGHT) {
            String format = String.format("%.2f GB", Double.valueOf(((double) j2) / 1.073741824E9d));
            AppMethodBeat.o(156090);
            return format;
        } else if (j2 >= 1048576) {
            String format2 = String.format("%.2f MB", Double.valueOf(((double) j2) / 1048576.0d));
            AppMethodBeat.o(156090);
            return format2;
        } else if (j2 >= 1024) {
            String format3 = String.format("%.2f kB", Double.valueOf(((double) j2) / 1024.0d));
            AppMethodBeat.o(156090);
            return format3;
        } else {
            String format4 = String.format("%d bytes", Long.valueOf(j2));
            AppMethodBeat.o(156090);
            return format4;
        }
    }

    private static void printStack(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        AppMethodBeat.i(156091);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.append("  at ").println(stackTraceElement.toString());
        }
        AppMethodBeat.o(156091);
    }

    private static void printStatistics(PrintWriter printWriter, long j2, int i2) {
        BitmapTraceInfo bitmapTraceInfo;
        Bitmap bitmap;
        AppMethodBeat.i(156092);
        if (j2 > 0) {
            printWriter.format("Statistics for all Bitmaps larger than %.2f MB:\n", Double.valueOf(((double) j2) / 1048576.0d));
        } else {
            printWriter.print("Statistics for all Bitmaps alive:\n");
        }
        printWriter.flush();
        int i3 = 0;
        int i4 = 0;
        long j3 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = 0;
        synchronized (bitmapTraces) {
            try {
                ArrayList<Map.Entry> arrayList = new ArrayList();
                try {
                    arrayList.addAll(bitmapTraces.entrySet());
                    bitmapTraceInfo = null;
                    bitmap = null;
                    for (Map.Entry entry : arrayList) {
                        Bitmap bitmap2 = (Bitmap) entry.getKey();
                        BitmapTraceInfo bitmapTraceInfo2 = (BitmapTraceInfo) entry.getValue();
                        if (bitmap2 != null) {
                            if (bitmap2.isRecycled()) {
                                i4++;
                            } else {
                                long allocationByteCount = (long) bitmap2.getAllocationByteCount();
                                j3 += allocationByteCount;
                                i3++;
                                if (bitmap == null || allocationByteCount > ((long) bitmap.getAllocationByteCount())) {
                                    bitmapTraceInfo = bitmapTraceInfo2;
                                    bitmap = bitmap2;
                                }
                                if (allocationByteCount >= j2 && (i2 == -1 || j4 < ((long) i2))) {
                                    j4++;
                                    printWriter.append('#').println(i3);
                                    printAllocationStack(printWriter, bitmap2, bitmapTraceInfo2, currentTimeMillis);
                                }
                                j4 = j4;
                            }
                        }
                    }
                } catch (ConcurrentModificationException e2) {
                    printWriter.print("ConcurrentModificationException occur.");
                    printWriter.flush();
                    printWriter.close();
                    return;
                }
            } finally {
                AppMethodBeat.o(156092);
            }
        }
        if (!(bitmap == null || bitmapTraceInfo == null)) {
            printWriter.append("# Biggest Bitmap");
            printAllocationStack(printWriter, bitmap, bitmapTraceInfo, currentTimeMillis);
        }
        printWriter.format("\n\nLiving Bitmaps: %d, %s\n", Integer.valueOf(i3), humanReadableSize(j3));
        printWriter.append("Recycled Bitmaps: ").println(i4);
        printWriter.flush();
        printWriter.close();
        AppMethodBeat.o(156092);
    }

    private static void printAllocationStack(PrintWriter printWriter, Bitmap bitmap, BitmapTraceInfo bitmapTraceInfo, long j2) {
        String name;
        AppMethodBeat.i(156093);
        Bitmap.Config config = bitmap.getConfig();
        Object[] objArr = new Object[4];
        objArr[0] = humanReadableSize((long) bitmap.getAllocationByteCount());
        objArr[1] = Integer.valueOf(bitmap.getWidth());
        objArr[2] = Integer.valueOf(bitmap.getHeight());
        if (config == null) {
            name = "UNKNOWN";
        } else {
            name = config.name();
        }
        objArr[3] = name;
        printWriter.format("\nSize: %s (%d x %d, %s)\n", objArr);
        printWriter.append("Source: ").println(bitmapTraceInfo.source);
        printWriter.format("Acquired: %d seconds ago\n", Long.valueOf((j2 - bitmapTraceInfo.acquiredTime) / 1000));
        printWriter.print("Stack:\n");
        printStack(bitmapTraceInfo.stack, printWriter);
        printWriter.print("=======================================================\n");
        printWriter.flush();
        AppMethodBeat.o(156093);
    }
}
