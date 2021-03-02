package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class v {
    public static boolean bvE() {
        AppMethodBeat.i(44269);
        if (!g.aAc()) {
            AppMethodBeat.o(44269);
            return false;
        }
        AppMethodBeat.o(44269);
        return true;
    }

    public static boolean bvF() {
        AppMethodBeat.i(44270);
        if (!g.aAc()) {
            AppMethodBeat.o(44270);
            return false;
        }
        AppMethodBeat.o(44270);
        return true;
    }

    public static boolean bvG() {
        int i2;
        AppMethodBeat.i(44273);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_appbrand_game_split_plugincode, false);
        Object[] objArr = new Object[1];
        if (a2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        Log.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", objArr);
        AppMethodBeat.o(44273);
        return a2;
    }

    public static boolean bvH() {
        int i2;
        AppMethodBeat.i(226355);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_appbrand_game_split_multi_plugincode, false);
        Object[] objArr = new Object[1];
        if (a2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        Log.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", objArr);
        AppMethodBeat.o(226355);
        return a2;
    }
}
