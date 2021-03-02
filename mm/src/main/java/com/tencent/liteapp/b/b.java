package com.tencent.liteapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static a cqZ = new a();

    static {
        AppMethodBeat.i(197713);
        AppMethodBeat.o(197713);
    }

    public static void a(a aVar) {
        cqZ = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(197708);
        cqZ.v(str, str2, objArr);
        AppMethodBeat.o(197708);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(197709);
        cqZ.d(str, str2, objArr);
        AppMethodBeat.o(197709);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(197710);
        cqZ.i(str, str2, objArr);
        AppMethodBeat.o(197710);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(197711);
        cqZ.w(str, str2, objArr);
        AppMethodBeat.o(197711);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(197712);
        cqZ.e(str, str2, objArr);
        AppMethodBeat.o(197712);
    }

    static class a implements a {
        a() {
        }

        @Override // com.tencent.liteapp.b.a
        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197703);
            String.format(str2, objArr);
            AppMethodBeat.o(197703);
        }

        @Override // com.tencent.liteapp.b.a
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197704);
            String.format(str2, objArr);
            AppMethodBeat.o(197704);
        }

        @Override // com.tencent.liteapp.b.a
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197705);
            String.format(str2, objArr);
            AppMethodBeat.o(197705);
        }

        @Override // com.tencent.liteapp.b.a
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197706);
            String.format(str2, objArr);
            AppMethodBeat.o(197706);
        }

        @Override // com.tencent.liteapp.b.a
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197707);
            String.format(str2, objArr);
            AppMethodBeat.o(197707);
        }
    }
}
