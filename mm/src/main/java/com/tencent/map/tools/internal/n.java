package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class n implements Thread.UncaughtExceptionHandler {

    /* renamed from: c  reason: collision with root package name */
    private static final String f1377c = n.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1378a = false;

    /* renamed from: b  reason: collision with root package name */
    public ModuleUncaughtListener f1379b;

    /* renamed from: d  reason: collision with root package name */
    private Context f1380d;

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f1381e;

    static {
        AppMethodBeat.i(180832);
        AppMethodBeat.o(180832);
    }

    public n(Context context) {
        this.f1380d = context;
    }

    private static String a(Throwable th) {
        AppMethodBeat.i(180831);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
        } catch (Throwable th2) {
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(180831);
        return stringBuffer2;
    }

    class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private String f1383b;

        public a(String str) {
            AppMethodBeat.i(180826);
            this.f1383b = str + a();
            AppMethodBeat.o(180826);
        }

        public final void run() {
            AppMethodBeat.i(180827);
            g a2 = g.a(n.this.f1380d);
            String str = this.f1383b;
            if (a.f1317i && a2.f1335e != null) {
                k kVar = a2.f1335e;
                byte[] bytes = str.getBytes();
                if (a.f1317i) {
                    kVar.f1355b.a(bytes);
                }
            }
            n.this.f1381e.countDown();
            AppMethodBeat.o(180827);
        }

        private String a() {
            AppMethodBeat.i(180828);
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String str = x.b() + "_" + x.a();
                stringBuffer.append(x.c(n.this.f1380d)).append(",").append(str).append(",").append(x.c()).append(",").append("").append(",").append(a.f1310b).append(".").append(a.f1311c).append(',').append(a.f1314f).append(",").append(a.f1313e);
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(180828);
                return stringBuffer2;
            } catch (Exception e2) {
                AppMethodBeat.o(180828);
                return "";
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(180830);
        if (th != null) {
            Throwable th2 = th;
            loop0:
            while (true) {
                if (th2 == null) {
                    break;
                }
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if ("TMS".equals(stackTraceElement.getFileName())) {
                        z = true;
                        break loop0;
                    }
                }
                th2 = th2.getCause();
            }
        }
        z = false;
        if (z && this.f1380d != null) {
            String a2 = a(th);
            if (a.f1316h == null || a.f1316h.length <= 0) {
                z2 = false;
            } else {
                z2 = false;
                for (int i2 = 0; i2 < a.f1316h.length; i2++) {
                    if (a2.contains(a.f1316h[i2])) {
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                x.a(this.f1380d, t.v, x.f1429f);
                x.a(this.f1380d, t.y, Long.valueOf(System.currentTimeMillis() - y.f1433a));
                if (this.f1379b != null) {
                    z3 = this.f1379b.onModuleSDKCrashed(th);
                }
                if (z3) {
                    AppMethodBeat.o(180830);
                    return;
                }
                String str = "EXP:" + x.f1429f + "," + a2;
                if (str.contains("\n")) {
                    str = str.replaceAll("\\n", "\\$");
                }
                this.f1381e = new CountDownLatch(1);
                new a(str).start();
                try {
                    this.f1381e.await(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                }
            }
        }
        if (this.f1379b != null) {
            this.f1379b.uncaughtException(thread, th);
        }
        AppMethodBeat.o(180830);
    }
}
