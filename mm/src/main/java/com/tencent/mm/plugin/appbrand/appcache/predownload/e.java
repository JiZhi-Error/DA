package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.f;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.j;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.List;

public final class e {
    static void a(List<efx> list, boolean z, int i2) {
        AppMethodBeat.i(44374);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(44374);
            return;
        }
        for (efx efx : list) {
            if (efx.NfS == null) {
                Log.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", efx.Mmv, efx.KGX);
            } else {
                Object[] objArr = new Object[8];
                objArr[0] = efx.Mmv;
                objArr[1] = efx.KGX;
                objArr[2] = Boolean.valueOf(efx.NfS.NzS != null);
                objArr[3] = Boolean.valueOf(efx.NfS.NzT != null);
                objArr[4] = Boolean.valueOf(efx.NfS.NzU != null);
                objArr[5] = Boolean.valueOf(efx.NfS.NzV != null);
                objArr[6] = Boolean.valueOf(efx.NfS.NzW != null);
                objArr[7] = Boolean.valueOf(efx.NfS.NzX != null);
                Log.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", objArr);
                if (efx.NfS.NzS != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzS).j(new d());
                }
                if (efx.NfS.NzT != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzT).j(new c(z, i2)).g(new a<Void, Boolean>() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.e.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(Boolean bool) {
                            AppMethodBeat.i(44373);
                            Boolean bool2 = bool;
                            if (bool2 != null && bool2.booleanValue()) {
                                j.INSTANCE.bwR();
                            }
                            AppMethodBeat.o(44373);
                            return null;
                        }
                    });
                }
                if (efx.NfS.NzU != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzU).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.e());
                }
                if (efx.NfS.NzV != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzV).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.g());
                }
                if (efx.NfS.NzW != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzW).j(new f());
                }
                if (efx.NfS.NzX != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzX).j(new i());
                }
                if (efx.NfS.NzY != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzY).j(new b());
                }
                if (efx.NfS.NzZ != null) {
                    g.j(efx.Mmv, efx.KGX, efx.NfS.NzZ).j(new h());
                }
            }
        }
        AppMethodBeat.o(44374);
    }
}
