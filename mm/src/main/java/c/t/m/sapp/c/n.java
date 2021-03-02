package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class n implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f84a = TencentLocation.class.getPackage().getName();

    /* renamed from: b  reason: collision with root package name */
    public static n f85b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f86c;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f87d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f88e = false;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f89f;

    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public String f90a;

        public a(String str) {
            AppMethodBeat.i(223005);
            this.f90a = str;
            AppMethodBeat.o(223005);
        }

        public void run() {
            AppMethodBeat.i(223006);
            e.a(n.this.f86c).a(this.f90a);
            n.this.f89f.countDown();
            AppMethodBeat.o(223006);
        }
    }

    static {
        AppMethodBeat.i(223009);
        AppMethodBeat.o(223009);
    }

    public n(Context context) {
        AppMethodBeat.i(223007);
        this.f86c = context;
        AppMethodBeat.o(223007);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(223010);
        if (a(th) && this.f86c != null) {
            String b2 = b(th);
            if (!b2.contains("onLocationChanged") && !b2.contains("onStatusUpdate")) {
                q.b(this.f86c, "__bad_dex_info___sapp", q.f96d);
                q.b(this.f86c, "__loc_sdk_run_duration___sapp", Long.valueOf(System.currentTimeMillis() - q.f97e));
                String str = "EXP:" + q.f96d + "," + b2;
                if (str.contains("\n")) {
                    str = str.replaceAll("\n", "$");
                }
                this.f89f = new CountDownLatch(1);
                new a(str).start();
                try {
                    this.f89f.await(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                }
                TencentLocationManager.getInstance(this.f86c).removeUpdates(null);
                AppMethodBeat.o(223010);
                return;
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f87d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        AppMethodBeat.o(223010);
    }

    public static n a(Context context) {
        AppMethodBeat.i(223008);
        if (f85b == null) {
            synchronized (n.class) {
                try {
                    if (f85b == null) {
                        f85b = new n(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(223008);
                    throw th;
                }
            }
        }
        n nVar = f85b;
        AppMethodBeat.o(223008);
        return nVar;
    }

    public final String b(Throwable th) {
        AppMethodBeat.i(223013);
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
        AppMethodBeat.o(223013);
        return stringBuffer2;
    }

    public final boolean a(Throwable th) {
        AppMethodBeat.i(223012);
        if (th == null) {
            AppMethodBeat.o(223012);
            return false;
        }
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if ("TLSAPP".equals(stackTraceElement.getFileName())) {
                    AppMethodBeat.o(223012);
                    return true;
                }
            }
            th = th.getCause();
        }
        AppMethodBeat.o(223012);
        return false;
    }

    public void a() {
        AppMethodBeat.i(223011);
        if (!this.f88e) {
            this.f87d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(f85b);
            this.f88e = true;
        }
        AppMethodBeat.o(223011);
    }
}
