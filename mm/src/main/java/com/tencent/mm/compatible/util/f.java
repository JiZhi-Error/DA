package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static int getLine() {
        AppMethodBeat.i(155881);
        int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
        AppMethodBeat.o(155881);
        return lineNumber;
    }

    public static String app() {
        AppMethodBeat.i(155882);
        String stackTraceElement = new Throwable().getStackTrace()[1].toString();
        AppMethodBeat.o(155882);
        return stackTraceElement;
    }

    public static String apq() {
        AppMethodBeat.i(155883);
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
        AppMethodBeat.o(155883);
        return str;
    }

    public static class a {
        public long gLm = SystemClock.elapsedRealtime();

        public a() {
            AppMethodBeat.i(155878);
            AppMethodBeat.o(155878);
        }

        public final void reset() {
            AppMethodBeat.i(261881);
            this.gLm = SystemClock.elapsedRealtime();
            AppMethodBeat.o(261881);
        }

        public final long apr() {
            AppMethodBeat.i(155880);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gLm;
            AppMethodBeat.o(155880);
            return elapsedRealtime;
        }
    }
}
