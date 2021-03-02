package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger {
    private static ILog mILog = new ILog() {
        /* class com.tencent.qqmusic.mediaplayer.util.Logger.AnonymousClass1 */

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void d(String str, String str2) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void w(String str, String str2) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void e(String str, String str2) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void i(String str, String str2) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void i(String str, String str2, Throwable th) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void e(String str, Throwable th) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void e(String str, String str2, Throwable th) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(87747);
            String.format(str2, objArr);
            AppMethodBeat.o(87747);
        }
    };

    static {
        AppMethodBeat.i(87707);
        AppMethodBeat.o(87707);
    }

    public static void setLog(ILog iLog) {
        mILog = iLog;
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(87699);
        if (mILog != null) {
            mILog.d(str, str2);
        }
        AppMethodBeat.o(87699);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(87700);
        if (mILog != null) {
            mILog.w(str, str2);
        }
        AppMethodBeat.o(87700);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(87701);
        if (mILog != null) {
            mILog.e(str, str2);
        }
        AppMethodBeat.o(87701);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(87702);
        if (mILog != null) {
            mILog.i(str, str2);
        }
        AppMethodBeat.o(87702);
    }

    public static void e(String str, Throwable th) {
        AppMethodBeat.i(87703);
        if (mILog != null) {
            mILog.e(str, th);
        }
        AppMethodBeat.o(87703);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(87704);
        if (mILog != null) {
            mILog.e(str, str2, th);
        }
        AppMethodBeat.o(87704);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(87705);
        if (mILog != null) {
            mILog.e(str, str2, objArr);
        }
        AppMethodBeat.o(87705);
    }

    public static void i(String str, String str2, Throwable th) {
        AppMethodBeat.i(87706);
        if (mILog != null) {
            mILog.i(str, str2, th);
        }
        AppMethodBeat.o(87706);
    }
}
