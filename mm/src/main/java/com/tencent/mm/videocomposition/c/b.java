package com.tencent.mm.videocomposition.c;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J9\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J7\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J9\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J9\u0010\u001a\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014JC\u0010\u001b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001eJ9\u0010\u001f\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ9\u0010!\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014J9\u0010\"\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", LocaleUtil.TURKEY, "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"})
public final class b {
    private static a Rih;
    public static final b Rii = new b();

    @l(hxD = {1, 1, 15}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JP\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&JP\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&JP\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&JP\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&JP\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&JP\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"})
    public interface a {
        void aTZ(String str);

        void lh(String str, String str2);

        void li(String str, String str2);

        void lj(String str, String str2);

        void lk(String str, String str2);
    }

    static {
        AppMethodBeat.i(216869);
        AppMethodBeat.o(216869);
    }

    private b() {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(216861);
        p.h(aVar, "logImp");
        Rih = aVar;
        AppMethodBeat.o(216861);
    }

    public static final void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(216862);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.li(str, format);
            AppMethodBeat.o(216862);
            return;
        }
        AppMethodBeat.o(216862);
    }

    public static final void s(String str, Object... objArr) {
        AppMethodBeat.i(216863);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, 0);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.aTZ(format);
            AppMethodBeat.o(216863);
            return;
        }
        AppMethodBeat.o(216863);
    }

    public static final void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(216864);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.lj(str, format);
            AppMethodBeat.o(216864);
            return;
        }
        AppMethodBeat.o(216864);
    }

    public static final void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(216865);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.lh(str, format);
            AppMethodBeat.o(216865);
            return;
        }
        AppMethodBeat.o(216865);
    }

    public static final void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(216866);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, 0);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.lk(str, format);
            AppMethodBeat.o(216866);
            return;
        }
        AppMethodBeat.o(216866);
    }

    public static final void printInfoStack(String str, String str2, Object... objArr) {
        AppMethodBeat.i(216867);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, 0);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.lj(str, format + "  " + new e());
            AppMethodBeat.o(216867);
            return;
        }
        AppMethodBeat.o(216867);
    }

    public static final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(216868);
        p.h(objArr, "obj");
        a aVar = Rih;
        if (aVar != null) {
            ae aeVar = ae.SYK;
            if (str2 == null) {
                p.hyc();
            }
            Object[] copyOf = Arrays.copyOf(objArr, 0);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            p.g(format, "java.lang.String.format(format, *args)");
            if (format == null) {
                format = "";
            }
            Process.myTid();
            Process.myPid();
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            currentThread.getId();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            p.g(thread, "Looper.getMainLooper().thread");
            thread.getId();
            aVar.li(str, format + "  " + Log.getStackTraceString(th));
            AppMethodBeat.o(216868);
            return;
        }
        AppMethodBeat.o(216868);
    }
}
