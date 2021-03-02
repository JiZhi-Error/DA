package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.a;

public final class b {

    /* renamed from: com.tencent.mm.plugin.appbrand.aa.b$b  reason: collision with other inner class name */
    public enum EnumC0531b {
        INIT,
        PREPARE_RESOUCE,
        INJECT_JS,
        PREPARE_RENDER,
        JS_ERROR;

        public static EnumC0531b valueOf(String str) {
            AppMethodBeat.i(140796);
            EnumC0531b bVar = (EnumC0531b) Enum.valueOf(EnumC0531b.class, str);
            AppMethodBeat.o(140796);
            return bVar;
        }

        static {
            AppMethodBeat.i(140797);
            AppMethodBeat.o(140797);
        }
    }

    public static final class a {
        private static final b nOf = new b();

        static {
            AppMethodBeat.i(140794);
            AppMethodBeat.o(140794);
        }
    }

    public static void b(String str, String str2, EnumC0531b bVar) {
        AppMethodBeat.i(140798);
        a.C0530a.bVC().a(str, str2, bVar);
        AppMethodBeat.o(140798);
    }

    public static void N(String str, String str2, String str3) {
        AppMethodBeat.i(140799);
        a.C0530a.bVC().M(str, str2, str3);
        AppMethodBeat.o(140799);
    }
}
