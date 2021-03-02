package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b ljt = new b() {
        /* class com.tencent.mm.plugin.appbrand.g.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void i(String str, String str2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void e(String str, String str2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void a(String str, Throwable th, String str2) {
        }
    };
    private static String lju;

    static {
        AppMethodBeat.i(222902);
        AppMethodBeat.o(222902);
    }

    public static void a(String str, b bVar) {
        lju = str;
        ljt = bVar;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(222899);
        ljt.i(lju + str, str2);
        new StringBuilder().append(lju).append(str);
        AppMethodBeat.o(222899);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(222900);
        ljt.e(lju + str, str2);
        new StringBuilder().append(lju).append(str);
        AppMethodBeat.o(222900);
    }

    public static void a(String str, Throwable th, String str2) {
        AppMethodBeat.i(222901);
        ljt.a(str, th, str2);
        new StringBuilder().append(lju).append(str);
        AppMethodBeat.o(222901);
    }
}
