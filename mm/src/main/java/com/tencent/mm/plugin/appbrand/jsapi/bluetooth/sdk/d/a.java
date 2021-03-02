package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static AbstractC0652a lOT;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0652a {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(144653);
        if (lOT != null) {
            String.format(str2, objArr);
            lOT.e(str, str2, objArr);
        }
        AppMethodBeat.o(144653);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(144654);
        if (lOT != null) {
            String.format(str2, objArr);
            lOT.w(str, str2, objArr);
        }
        AppMethodBeat.o(144654);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(144655);
        if (lOT != null) {
            String.format(str2, objArr);
            lOT.i(str, str2, objArr);
        }
        AppMethodBeat.o(144655);
    }
}
