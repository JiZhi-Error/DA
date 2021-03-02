package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a extends s {
    private static final int CTRL_INDEX = 460;
    private static final String NAME = "onH5Data";

    public static void s(q qVar) {
        AppMethodBeat.i(46352);
        String str = qVar.mAppId;
        final AnonymousClass1 r1 = new MMToClientEvent.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
            public final void cq(Object obj) {
                AppMethodBeat.i(46350);
                if (obj instanceof SendDataToMiniProgramFromH5Event) {
                    SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
                    String str = sendDataToMiniProgramFromH5Event.lWe;
                    String str2 = sendDataToMiniProgramFromH5Event.data;
                    int i2 = sendDataToMiniProgramFromH5Event.lWf;
                    if (!Util.isNullOrNil(str)) {
                        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(str);
                        if (TQ == null || !TQ.mInitialized) {
                            AppMethodBeat.o(46350);
                            return;
                        }
                        try {
                            JSONObject put = new JSONObject().put("data", str2).put("webviewId", String.valueOf(i2));
                            a aVar = new a();
                            aVar.g(TQ.bsE()).Zg(put.toString());
                            aVar.bEo();
                            AppMethodBeat.o(46350);
                            return;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", e2);
                        }
                    }
                }
                AppMethodBeat.o(46350);
            }
        };
        MMToClientEvent.a(str, r1);
        qVar.kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, b bVar) {
                AppMethodBeat.i(46351);
                if (bVar == b.DESTROYED) {
                    MMToClientEvent.b(str, r1);
                }
                AppMethodBeat.o(46351);
            }
        });
        AppMethodBeat.o(46352);
    }
}
