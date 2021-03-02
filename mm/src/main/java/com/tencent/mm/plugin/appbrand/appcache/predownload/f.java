package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f implements p {
    INSTANCE;

    public static f valueOf(String str) {
        AppMethodBeat.i(44378);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(44378);
        return fVar;
    }

    static {
        AppMethodBeat.i(44381);
        AppMethodBeat.o(44381);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(44379);
        String str2 = map.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
        if (!Util.isNullOrNil(str2)) {
            g.ey(str2).j(new a<Void, String>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.f.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(String str) {
                    AppMethodBeat.i(44376);
                    Void VD = VD(str);
                    AppMethodBeat.o(44376);
                    return VD;
                }

                private static Void VD(String str) {
                    AppMethodBeat.i(44375);
                    try {
                        f.VC(str);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", e2, "process pbBase64", new Object[0]);
                    }
                    AppMethodBeat.o(44375);
                    return null;
                }
            });
        }
        AppMethodBeat.o(44379);
        return null;
    }

    static /* synthetic */ void VC(String str) {
        AppMethodBeat.i(44380);
        fdc fdc = new fdc();
        fdc.parseFrom(Base64.decode(str, 0));
        if (fdc.KPd == null || fdc.KPd.size() == 0) {
            Log.e("MicroMsg.AppBrand.PredownloadXmlProcessor", "process, empty RespInfoList, time %d", Long.valueOf(((long) fdc.NyN) & Util.MAX_32BIT_VALUE));
            AppMethodBeat.o(44380);
            return;
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(0, 3);
        e.a(fdc.KPd, false, 0);
        AppMethodBeat.o(44380);
    }
}
