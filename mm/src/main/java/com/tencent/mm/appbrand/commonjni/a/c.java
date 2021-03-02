package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public interface b {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.c.b
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201245);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(201245);
                    return;
                }
            }
            AppMethodBeat.o(201245);
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.c.b
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201246);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(201246);
                    return;
                }
            }
            AppMethodBeat.o(201246);
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.c.b
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201247);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(201247);
                    return;
                }
            }
            AppMethodBeat.o(201247);
        }
    }

    /* renamed from: com.tencent.mm.appbrand.commonjni.a.c$c  reason: collision with other inner class name */
    public static class C0267c {
        private static b doN = new a((byte) 0);

        static {
            AppMethodBeat.i(201251);
            AppMethodBeat.o(201251);
        }

        public static void a(b bVar) {
            doN = bVar;
        }

        public static void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201248);
            doN.i(str, str2, objArr);
            AppMethodBeat.o(201248);
        }

        public static void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201249);
            doN.w(str, str2, objArr);
            AppMethodBeat.o(201249);
        }

        public static void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(201250);
            doN.e(str, str2, objArr);
            AppMethodBeat.o(201250);
        }
    }
}
