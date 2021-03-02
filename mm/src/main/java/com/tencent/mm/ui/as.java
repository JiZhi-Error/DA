package com.tencent.mm.ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as {
    private static a OLQ;
    private static a OLR;

    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    static {
        AppMethodBeat.i(159124);
        AnonymousClass1 r0 = new a() {
            /* class com.tencent.mm.ui.as.AnonymousClass1 */

            @Override // com.tencent.mm.ui.as.a
            public final void v(String str, String str2) {
            }

            @Override // com.tencent.mm.ui.as.a
            public final void d(String str, String str2) {
            }

            @Override // com.tencent.mm.ui.as.a
            public final void i(String str, String str2) {
            }

            @Override // com.tencent.mm.ui.as.a
            public final void w(String str, String str2) {
            }

            @Override // com.tencent.mm.ui.as.a
            public final void e(String str, String str2) {
            }
        };
        OLQ = r0;
        OLR = r0;
        AppMethodBeat.o(159124);
    }

    public static void a(a aVar) {
        OLR = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(159118);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.v(str, format);
        }
        AppMethodBeat.o(159118);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(159119);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.d(str, format);
        }
        AppMethodBeat.o(159119);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(159120);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.i(str, format);
        }
        AppMethodBeat.o(159120);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(159121);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.w(str, format);
        }
        AppMethodBeat.o(159121);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(159122);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.e(str, format);
        }
        AppMethodBeat.o(159122);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(159123);
        if (OLR != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            OLR.e(str, format + "  " + Log.getStackTraceString(th));
        }
        AppMethodBeat.o(159123);
    }
}
