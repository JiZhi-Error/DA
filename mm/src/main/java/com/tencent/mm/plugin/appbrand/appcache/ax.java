package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;

public final class ax {
    public final void clear(final String str) {
        o[] b2;
        AppMethodBeat.i(44352);
        AnonymousClass1 r0 = new w() {
            /* class com.tencent.mm.plugin.appbrand.appcache.ax.AnonymousClass1 */

            @Override // com.tencent.mm.vfs.w
            public final boolean accept(o oVar, String str) {
                AppMethodBeat.i(226365);
                boolean endsWith = str.endsWith("_" + str);
                AppMethodBeat.o(226365);
                return endsWith;
            }
        };
        o oVar = new o(ad.bMK());
        if (oVar.exists() && oVar.isDirectory() && (b2 = oVar.b(r0)) != null && b2.length > 0) {
            for (o oVar2 : b2) {
                s.dy(aa.z(oVar2.mUri), true);
                Log.i("WxaJsCacheStorage", "clear file:%s", oVar2.getName());
            }
        }
        AppMethodBeat.o(44352);
    }
}
