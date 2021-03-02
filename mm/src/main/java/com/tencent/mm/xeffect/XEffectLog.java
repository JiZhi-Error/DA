package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog {
    public static b RxP = new a((byte) 0);

    public interface b {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);
    }

    private static native long nGetXLogImpl();

    static {
        AppMethodBeat.i(236771);
        AppMethodBeat.o(236771);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(236766);
        RxP.d(str, str2, objArr);
        AppMethodBeat.o(236766);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(236767);
        RxP.i(str, str2, objArr);
        AppMethodBeat.o(236767);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(236768);
        RxP.e(str, str2, objArr);
        AppMethodBeat.o(236768);
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(236763);
            String.format(str2, objArr);
            AppMethodBeat.o(236763);
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(236764);
            String.format(str2, objArr);
            AppMethodBeat.o(236764);
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(236765);
            String.format(str2, objArr);
            AppMethodBeat.o(236765);
        }
    }

    private static long hit() {
        AppMethodBeat.i(236769);
        try {
            long nGetXLogImpl = nGetXLogImpl();
            AppMethodBeat.o(236769);
            return nGetXLogImpl;
        } catch (Throwable th) {
            e("XEffectLog", "get native log error %s", th.getMessage());
            AppMethodBeat.o(236769);
            return 0;
        }
    }

    public static void a(b bVar) {
        AppMethodBeat.i(236770);
        RxP = bVar;
        try {
            d.load("xeffect_xlog");
            WeEffectRender.nSetNativeLog(hit());
            AppMethodBeat.o(236770);
        } catch (Throwable th) {
            e("XEffectLog", "init xlog error %s", th.getMessage());
            AppMethodBeat.o(236770);
        }
    }
}
