package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Logger {
    public static final int NO_LOG = Integer.MAX_VALUE;
    private static int level = 3;
    private static ILog logProxy = new DefaultLogProxy();

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    static {
        AppMethodBeat.i(218458);
        AppMethodBeat.o(218458);
    }

    public static void setLevel(int i2) {
        level = i2;
    }

    public static void setLogProxy(ILog iLog) {
        logProxy = iLog;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(218452);
        if (logProxy == null || level > 2) {
            AppMethodBeat.o(218452);
            return;
        }
        logProxy.v(str, str2);
        AppMethodBeat.o(218452);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(218453);
        if (logProxy == null || level > 3) {
            AppMethodBeat.o(218453);
            return;
        }
        logProxy.d(str, str2);
        AppMethodBeat.o(218453);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(218454);
        if (logProxy == null || level > 4) {
            AppMethodBeat.o(218454);
            return;
        }
        logProxy.i(str, str2);
        AppMethodBeat.o(218454);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(218455);
        if (logProxy == null || level > 5) {
            AppMethodBeat.o(218455);
            return;
        }
        logProxy.w(str, str2);
        AppMethodBeat.o(218455);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(218456);
        if (logProxy == null || level > 6) {
            AppMethodBeat.o(218456);
            return;
        }
        logProxy.e(str, str2);
        AppMethodBeat.o(218456);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(218457);
        if (logProxy == null || level > 6) {
            AppMethodBeat.o(218457);
            return;
        }
        logProxy.e(str, str2, th);
        AppMethodBeat.o(218457);
    }

    static class DefaultLogProxy implements ILog {
        private DefaultLogProxy() {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void v(String str, String str2) {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void d(String str, String str2) {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void i(String str, String str2) {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void w(String str, String str2) {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(String str, String str2) {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(String str, String str2, Throwable th) {
        }
    }
}
