package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;

public final class o implements a {
    static {
        AppMethodBeat.i(20196);
        b.a(new o(), "//cleanwx", "//showfile", "//hidefile");
        AppMethodBeat.o(20196);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20195);
        String str2 = strArr[0];
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1470593122:
                if (str2.equals("//hidefile")) {
                    c2 = 2;
                    break;
                }
                break;
            case -35508263:
                if (str2.equals("//showfile")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2113467658:
                if (str2.equals("//cleanwx")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                EventCenter.instance.publish(new ca());
                u.makeText(context, "clean wx file index now.", 0).show();
                AppMethodBeat.o(20195);
                return true;
            case 1:
                try {
                    g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, (Object) 1);
                    u.makeText(context, "show file now.", 0).show();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(20195);
                return true;
            case 2:
                try {
                    g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, (Object) 0);
                    u.makeText(context, "hide file now.", 0).show();
                } catch (Exception e3) {
                }
                AppMethodBeat.o(20195);
                return true;
            default:
                AppMethodBeat.o(20195);
                return false;
        }
    }
}
