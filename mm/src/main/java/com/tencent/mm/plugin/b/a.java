package com.tencent.mm.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static void bxk(String str) {
        AppMethodBeat.i(134212);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("reg_last_exit_ui", str).commit();
        AppMethodBeat.o(134212);
    }

    public static String caK() {
        AppMethodBeat.i(134213);
        String string = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("reg_last_exit_ui", "");
        AppMethodBeat.o(134213);
        return string;
    }

    public static void bxl(String str) {
        AppMethodBeat.i(134214);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("reg_next_enter_ui", str).commit();
        AppMethodBeat.o(134214);
    }

    private static String caW() {
        AppMethodBeat.i(134215);
        String string = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("reg_next_enter_ui", "");
        AppMethodBeat.o(134215);
        return string;
    }

    public static void DX(String str) {
        AppMethodBeat.i(134216);
        e.INSTANCE.a(10645, str + "," + Util.nowMilliSecond() + "," + caK(), true, true);
        AppMethodBeat.o(134216);
    }

    public static void j(boolean z, String str) {
        String str2;
        AppMethodBeat.i(134217);
        if (z) {
            str2 = str + "," + Util.nowMilliSecond() + "," + caK();
        } else {
            str2 = str + "," + Util.nowMilliSecond() + "," + caW();
        }
        e.INSTANCE.a(10645, str2, true, true);
        AppMethodBeat.o(134217);
    }
}
