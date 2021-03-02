package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static final String BlL = k.iOp;

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(27592);
        Log.d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", str, str2, str3, str4, 0, 0, 126, str5, str6, str7);
        h.INSTANCE.a(10809, str, str2, str3, str4, 0, 0, 126, str5, str6, str7);
        AppMethodBeat.o(27592);
    }

    public static String hP(int i2, int i3) {
        AppMethodBeat.i(27593);
        if (i2 < 0) {
            AppMethodBeat.o(27593);
            return "";
        } else if (i3 < 0) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(27593);
            return valueOf;
        } else {
            String str = i2 + "-" + i3;
            AppMethodBeat.o(27593);
            return str;
        }
    }
}
