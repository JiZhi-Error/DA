package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class l {
    public static boolean cE(String str, String str2) {
        AppMethodBeat.i(134327);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                long nowMilliSecond = Util.nowMilliSecond();
                String k = s.k(str, true);
                String k2 = s.k(str2, true);
                new a();
                Os.rename(k, k2);
                Log.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                AppMethodBeat.o(134327);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", Util.stackTraceToString(e2));
                FilesCopy.copy(s.k(str, true), s.k(str2, true), true);
            }
        }
        boolean am = new o(str).am(new o(str2));
        AppMethodBeat.o(134327);
        return am;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        a() {
        }
    }
}
