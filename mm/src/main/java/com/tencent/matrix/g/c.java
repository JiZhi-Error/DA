package com.tencent.matrix.g;

import android.util.Log;

public final class c {
    private static a dfa;
    private static a dfb;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        AnonymousClass1 r0 = new a() {
            /* class com.tencent.matrix.g.c.AnonymousClass1 */

            @Override // com.tencent.matrix.g.c.a
            public final void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            @Override // com.tencent.matrix.g.c.a
            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            @Override // com.tencent.matrix.g.c.a
            public final void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            @Override // com.tencent.matrix.g.c.a
            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            @Override // com.tencent.matrix.g.c.a
            public final void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            @Override // com.tencent.matrix.g.c.a
            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                String format = (objArr == null || objArr.length == 0) ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
            }
        };
        dfa = r0;
        dfb = r0;
    }

    public static void b(a aVar) {
        dfb = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.v(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (dfb != null) {
            dfb.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
