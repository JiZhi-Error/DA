package com.tencent.mm.dynamicbackground.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static a gRu;
    private static a gRv;

    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    static {
        AppMethodBeat.i(102977);
        AnonymousClass1 r0 = new a() {
            /* class com.tencent.mm.dynamicbackground.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.dynamicbackground.a.c.a
            public final void v(String str, String str2) {
            }

            @Override // com.tencent.mm.dynamicbackground.a.c.a
            public final void d(String str, String str2) {
            }

            @Override // com.tencent.mm.dynamicbackground.a.c.a
            public final void i(String str, String str2) {
            }

            @Override // com.tencent.mm.dynamicbackground.a.c.a
            public final void w(String str, String str2) {
            }

            @Override // com.tencent.mm.dynamicbackground.a.c.a
            public final void e(String str, String str2) {
            }
        };
        gRu = r0;
        gRv = r0;
        AppMethodBeat.o(102977);
    }

    public static void a(a aVar) {
        gRv = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(102971);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.v(str, format);
        }
        AppMethodBeat.o(102971);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(102972);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.d(str, format);
        }
        AppMethodBeat.o(102972);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(102973);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.i(str, format);
        }
        AppMethodBeat.o(102973);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(102974);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.w(str, format);
        }
        AppMethodBeat.o(102974);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(102975);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.e(str, format);
        }
        AppMethodBeat.o(102975);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(102976);
        if (gRv != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            gRv.e(str, format + "  " + Log.getStackTraceString(th));
        }
        AppMethodBeat.o(102976);
    }
}
