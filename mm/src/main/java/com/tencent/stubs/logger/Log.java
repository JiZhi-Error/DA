package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

public final class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final long LOGGER_JAVA = 3;
    private static final long LOGGER_LOGCAT = 2;
    private static final long LOGGER_NOOP = 0;
    private static final long LOGGER_STDOUT = 1;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    static volatile Logger sLogger;
    static volatile long sLoggerPtr;

    public interface Logger {
        boolean isLoggable(String str, int i2);

        void println(int i2, String str, String str2);
    }

    private Log() {
    }

    public static void setLogger(Logger logger) {
        sLogger = logger;
        sLoggerPtr = logger == null ? LOGGER_NOOP : 3;
    }

    public static void println(int i2, String str, String str2) {
        AppMethodBeat.i(73497);
        Logger logger = sLogger;
        if (logger == null) {
            AppMethodBeat.o(73497);
            return;
        }
        logger.println(i2, str, str2);
        AppMethodBeat.o(73497);
    }

    public static void printStack(int i2, String str, Throwable th) {
        AppMethodBeat.i(73498);
        Logger logger = sLogger;
        if (logger == null || !logger.isLoggable(str, i2)) {
            AppMethodBeat.o(73498);
            return;
        }
        StringWriter stringWriter = new StringWriter(512);
        th.printStackTrace(new PrintWriter(stringWriter));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            logger.println(i2, str, stringTokenizer.nextToken());
        }
        AppMethodBeat.o(73498);
    }

    public static void printFormat(int i2, String str, String str2, Object... objArr) {
        AppMethodBeat.i(73499);
        Logger logger = sLogger;
        if (logger == null || !logger.isLoggable(str, i2)) {
            AppMethodBeat.o(73499);
            return;
        }
        logger.println(i2, str, String.format(str2, objArr));
        AppMethodBeat.o(73499);
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(73500);
        println(7, str, str2);
        AppMethodBeat.o(73500);
    }

    public static void f(String str, Throwable th, String str2) {
        AppMethodBeat.i(73501);
        if (str2 != null && !str2.isEmpty()) {
            println(7, str, str2);
        }
        if (th != null) {
            printStack(7, str, th);
        }
        AppMethodBeat.o(73501);
    }

    public static void f(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73502);
        printFormat(7, str, str2, objArr);
        AppMethodBeat.o(73502);
    }

    public static void f(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73503);
        printFormat(7, str, str2, objArr);
        if (th != null) {
            printStack(7, str, th);
        }
        AppMethodBeat.o(73503);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(73504);
        println(6, str, str2);
        AppMethodBeat.o(73504);
    }

    public static void e(String str, Throwable th, String str2) {
        AppMethodBeat.i(73505);
        if (str2 != null && !str2.isEmpty()) {
            println(6, str, str2);
        }
        if (th != null) {
            printStack(6, str, th);
        }
        AppMethodBeat.o(73505);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73506);
        printFormat(6, str, str2, objArr);
        AppMethodBeat.o(73506);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73507);
        printFormat(6, str, str2, objArr);
        if (th != null) {
            printStack(6, str, th);
        }
        AppMethodBeat.o(73507);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(73508);
        println(5, str, str2);
        AppMethodBeat.o(73508);
    }

    public static void w(String str, Throwable th, String str2) {
        AppMethodBeat.i(73509);
        if (str2 != null && !str2.isEmpty()) {
            println(5, str, str2);
        }
        if (th != null) {
            printStack(5, str, th);
        }
        AppMethodBeat.o(73509);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73510);
        printFormat(5, str, str2, objArr);
        AppMethodBeat.o(73510);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73511);
        printFormat(5, str, str2, objArr);
        if (th != null) {
            printStack(7, str, th);
        }
        AppMethodBeat.o(73511);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(73512);
        println(4, str, str2);
        AppMethodBeat.o(73512);
    }

    public static void i(String str, Throwable th, String str2) {
        AppMethodBeat.i(73513);
        if (str2 != null && !str2.isEmpty()) {
            println(4, str, str2);
        }
        if (th != null) {
            printStack(4, str, th);
        }
        AppMethodBeat.o(73513);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73514);
        printFormat(4, str, str2, objArr);
        AppMethodBeat.o(73514);
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73515);
        printFormat(4, str, str2, objArr);
        if (th != null) {
            printStack(4, str, th);
        }
        AppMethodBeat.o(73515);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(73516);
        println(3, str, str2);
        AppMethodBeat.o(73516);
    }

    public static void d(String str, Throwable th, String str2) {
        AppMethodBeat.i(73517);
        if (str2 != null && !str2.isEmpty()) {
            println(3, str, str2);
        }
        if (th != null) {
            printStack(3, str, th);
        }
        AppMethodBeat.o(73517);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73518);
        printFormat(3, str, str2, objArr);
        AppMethodBeat.o(73518);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73519);
        printFormat(3, str, str2, objArr);
        if (th != null) {
            printStack(3, str, th);
        }
        AppMethodBeat.o(73519);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(73520);
        println(2, str, str2);
        AppMethodBeat.o(73520);
    }

    public static void v(String str, Throwable th, String str2) {
        AppMethodBeat.i(73521);
        if (str2 != null && !str2.isEmpty()) {
            println(2, str, str2);
        }
        if (th != null) {
            printStack(2, str, th);
        }
        AppMethodBeat.o(73521);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73522);
        printFormat(2, str, str2, objArr);
        AppMethodBeat.o(73522);
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73523);
        printFormat(2, str, str2, objArr);
        if (th != null) {
            printStack(2, str, th);
        }
        AppMethodBeat.o(73523);
    }

    static {
        Logger r2;
        long j2;
        AppMethodBeat.i(73524);
        try {
            Class.forName("android.util.Log");
            r2 = new AndroidLogcat();
            j2 = 2;
        } catch (ClassNotFoundException e2) {
            r2 = new Logger() {
                /* class com.tencent.stubs.logger.Log.AnonymousClass1 */

                @Override // com.tencent.stubs.logger.Log.Logger
                public final void println(int i2, String str, String str2) {
                    AppMethodBeat.i(73525);
                    System.out.println("[" + str + "] " + str2);
                    AppMethodBeat.o(73525);
                }

                @Override // com.tencent.stubs.logger.Log.Logger
                public final boolean isLoggable(String str, int i2) {
                    return true;
                }
            };
            j2 = 1;
        }
        sLogger = r2;
        sLoggerPtr = j2;
        AppMethodBeat.o(73524);
    }
}
