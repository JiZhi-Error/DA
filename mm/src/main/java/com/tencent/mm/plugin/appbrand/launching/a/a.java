package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;

public final class a {
    public final f<c.a<che>> a(chd chd, boolean z, final c cVar) {
        AppMethodBeat.i(180318);
        String str = chd.jfi;
        int i2 = chd.Mmn.Scene;
        int i3 = chd.Mmp.MqF;
        final Pair<che, Long> bd = ((e) n.W(e.class)).bd(str, i2);
        if (bd.first != null) {
            Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", str, Integer.valueOf(i2));
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Long) bd.second).longValue(), 106);
            f<c.a<che>> c2 = g.c(new c.a<c.a<che>>() {
                /* class com.tencent.mm.plugin.appbrand.launching.a.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.vending.g.c.a
                public final /* synthetic */ c.a<che> call() {
                    AppMethodBeat.i(47388);
                    c.a a2 = c.a.a(0, 0, null, (dpc) bd.first, null, cVar);
                    AppMethodBeat.o(47388);
                    return a2;
                }
            });
            AppMethodBeat.o(180318);
            return c2;
        }
        Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(chd.Mmt));
        if (!z) {
            Pair<Boolean, Integer> J = ((b) n.W(b.class)).J(str, 2, i2);
            if (((Boolean) J.first).booleanValue()) {
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) ((Integer) J.second).intValue(), 168);
                Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", str, Integer.valueOf(i2));
                f<c.a<che>> c3 = g.c(new c.a<c.a<che>>() {
                    /* class com.tencent.mm.plugin.appbrand.launching.a.a.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.vending.g.c.a
                    public final /* synthetic */ c.a<che> call() {
                        AppMethodBeat.i(47389);
                        c.a a2 = c.a.a(3, 99999999, "Async Launch Blocked", null, null, cVar);
                        AppMethodBeat.o(47389);
                        return a2;
                    }
                });
                AppMethodBeat.o(180318);
                return c3;
            }
        }
        AppMethodBeat.o(180318);
        return null;
    }
}
