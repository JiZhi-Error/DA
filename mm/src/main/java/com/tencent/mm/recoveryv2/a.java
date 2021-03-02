package com.tencent.mm.recoveryv2;

import android.support.v4.e.l;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.l;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class a {
    public static void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(193757);
        C2043a.log(5, str, str2 + " : " + Log.getStackTraceString(th));
        AppMethodBeat.o(193757);
    }

    /* renamed from: com.tencent.mm.recoveryv2.a$a  reason: collision with other inner class name */
    public static class C2043a {
        private static final List<b> NBq = new LinkedList();

        C2043a() {
        }

        static {
            AppMethodBeat.i(193754);
            AppMethodBeat.o(193754);
        }

        public static void log(int i2, String str, String str2) {
            AppMethodBeat.i(193752);
            b guz = b.guz();
            long currentTimeMillis = System.currentTimeMillis();
            String name = Thread.currentThread().getName();
            guz.priority = i2;
            guz.time = currentTimeMillis;
            guz.tag = str;
            guz.NBt = name;
            guz.msg = str2;
            synchronized (C2043a.class) {
                try {
                    NBq.add(guz);
                } finally {
                    AppMethodBeat.o(193752);
                }
            }
        }

        public static void L(File file) {
            LinkedList<b> linkedList;
            PrintWriter printWriter;
            Throwable th;
            String str;
            AppMethodBeat.i(193753);
            if (!file.exists()) {
                try {
                    l.b.O(file);
                } catch (IOException e2) {
                    a.w("MicroMsg.recovery.logFile", "create log file error", e2);
                    AppMethodBeat.o(193753);
                    return;
                }
            }
            synchronized (C2043a.class) {
                try {
                    linkedList = new LinkedList(NBq);
                    NBq.clear();
                } catch (Throwable th2) {
                    AppMethodBeat.o(193753);
                    throw th2;
                }
            }
            try {
                printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, true), ProtocolPackage.ServerEncoding));
                try {
                    for (b bVar : linkedList) {
                        StringBuilder append = new StringBuilder().append(b.NBs.format(Long.valueOf(bVar.time))).append("  ");
                        switch (bVar.priority) {
                            case 4:
                                str = "INFO";
                                break;
                            case 5:
                                str = "WARN";
                                break;
                            default:
                                str = "UNKNOWN";
                                break;
                        }
                        printWriter.println(append.append(str).append(FilePathGenerator.ANDROID_DIR_SEP).append(bVar.tag).append("  [").append(bVar.NBt).append("]  ").append(bVar.msg).toString());
                    }
                    l.b.closeQuietly(printWriter);
                    AppMethodBeat.o(193753);
                } catch (IOException e3) {
                    e = e3;
                    try {
                        a.w("MicroMsg.recovery.logFile", "write to file error", e);
                        l.b.closeQuietly(printWriter);
                        AppMethodBeat.o(193753);
                    } catch (Throwable th3) {
                        th = th3;
                        l.b.closeQuietly(printWriter);
                        AppMethodBeat.o(193753);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                printWriter = null;
                a.w("MicroMsg.recovery.logFile", "write to file error", e);
                l.b.closeQuietly(printWriter);
                AppMethodBeat.o(193753);
            } catch (Throwable th4) {
                th = th4;
                printWriter = null;
                l.b.closeQuietly(printWriter);
                AppMethodBeat.o(193753);
                throw th;
            }
        }
    }

    public static class b {
        private static final l.c<b> NBr = new l.c<>(20);
        static final SimpleDateFormat NBs = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        public String NBt;
        public String msg;
        public int priority;
        public String tag;
        public long time;

        static {
            AppMethodBeat.i(193756);
            AppMethodBeat.o(193756);
        }

        public static b guz() {
            AppMethodBeat.i(193755);
            b acquire = NBr.acquire();
            if (acquire != null) {
                AppMethodBeat.o(193755);
                return acquire;
            }
            b bVar = new b();
            AppMethodBeat.o(193755);
            return bVar;
        }
    }
}
