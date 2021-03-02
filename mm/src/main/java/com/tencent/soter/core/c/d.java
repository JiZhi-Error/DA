package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class d {
    private static c RPJ = new a((byte) 0);

    static {
        AppMethodBeat.i(88658);
        AppMethodBeat.o(88658);
    }

    public static void a(c cVar) {
        AppMethodBeat.i(88651);
        Assert.assertTrue(cVar != null);
        RPJ = cVar;
        AppMethodBeat.o(88651);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(88652);
        RPJ.v(str, str2, objArr);
        AppMethodBeat.o(88652);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(88653);
        RPJ.d(str, str2, objArr);
        AppMethodBeat.o(88653);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(88654);
        RPJ.i(str, str2, objArr);
        AppMethodBeat.o(88654);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(88655);
        RPJ.w(str, str2, objArr);
        AppMethodBeat.o(88655);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(88656);
        RPJ.e(str, str2, objArr);
        AppMethodBeat.o(88656);
    }

    public static void a(String str, Throwable th, String str2) {
        AppMethodBeat.i(88657);
        RPJ.a(str, th, str2);
        AppMethodBeat.o(88657);
    }

    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.soter.core.c.c
        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(88646);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(88646);
            } catch (Exception e2) {
                AppMethodBeat.o(88646);
            }
        }

        @Override // com.tencent.soter.core.c.c
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(88647);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(88647);
            } catch (Exception e2) {
                AppMethodBeat.o(88647);
            }
        }

        @Override // com.tencent.soter.core.c.c
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(88648);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(88648);
            } catch (Exception e2) {
                AppMethodBeat.o(88648);
            }
        }

        @Override // com.tencent.soter.core.c.c
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(88649);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(88649);
            } catch (Exception e2) {
                AppMethodBeat.o(88649);
            }
        }

        @Override // com.tencent.soter.core.c.c
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(88650);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(88650);
            } catch (Exception e2) {
                AppMethodBeat.o(88650);
            }
        }

        @Override // com.tencent.soter.core.c.c
        public final void a(String str, Throwable th, String str2) {
        }
    }
}
