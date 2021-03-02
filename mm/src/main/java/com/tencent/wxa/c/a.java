package com.tencent.wxa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC2228a SxO;
    private static AbstractC2228a Sya;

    /* renamed from: com.tencent.wxa.c.a$a  reason: collision with other inner class name */
    public interface AbstractC2228a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        AppMethodBeat.i(206333);
        AnonymousClass1 r0 = new AbstractC2228a() {
            /* class com.tencent.wxa.c.a.AnonymousClass1 */

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void v(String str, String str2, Object... objArr) {
                AppMethodBeat.i(206323);
                String.format(str2, objArr);
                AppMethodBeat.o(206323);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(206324);
                String.format(str2, objArr);
                AppMethodBeat.o(206324);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(206325);
                String.format(str2, objArr);
                AppMethodBeat.o(206325);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(206326);
                String.format(str2, objArr);
                AppMethodBeat.o(206326);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(206327);
                String.format(str2, objArr);
                AppMethodBeat.o(206327);
            }
        };
        Sya = r0;
        SxO = r0;
        AppMethodBeat.o(206333);
    }

    public static void b(AbstractC2228a aVar) {
        SxO = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(206328);
        SxO.v(str, str2, objArr);
        AppMethodBeat.o(206328);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(206329);
        SxO.d(str, str2, objArr);
        AppMethodBeat.o(206329);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(206330);
        SxO.i(str, str2, objArr);
        AppMethodBeat.o(206330);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(206331);
        SxO.w(str, str2, objArr);
        AppMethodBeat.o(206331);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(206332);
        SxO.e(str, str2, objArr);
        AppMethodBeat.o(206332);
    }
}
