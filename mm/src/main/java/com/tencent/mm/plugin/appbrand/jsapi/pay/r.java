package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class r extends d<c> {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        com.tencent.luggage.game.page.d dVar;
        AppMethodBeat.i(46743);
        final c cVar2 = cVar;
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46743);
            return;
        }
        try {
            jSONObject.put("appId", cVar2.getAppId());
            ag bsz = cVar2.bsz();
            if (!(bsz == null || (dVar = (com.tencent.luggage.game.page.d) bsz.S(com.tencent.luggage.game.page.d.class)) == null)) {
                dVar.MP();
            }
            AppBrandJsApiPayService.INSTANCE.sendBizRedPacket(ay, cVar2.getRuntime().ON().cyA, jSONObject, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.r.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.b
                public final void a(int i2, String str, Map<String, Object> map) {
                    AppMethodBeat.i(46742);
                    switch (i2) {
                        case 1:
                            cVar2.i(i2, r.this.h("ok", null));
                            AppMethodBeat.o(46742);
                            return;
                        case 2:
                            if (Util.isNullOrNil(str)) {
                                cVar2.i(i2, r.this.h("fail", null));
                                AppMethodBeat.o(46742);
                                return;
                            }
                            cVar2.i(i2, r.this.h(String.format("fail %s", str), null));
                            AppMethodBeat.o(46742);
                            return;
                        default:
                            cVar2.i(i2, r.this.h("cancel", null));
                            AppMethodBeat.o(46742);
                            return;
                    }
                }
            });
            AppMethodBeat.o(46743);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiSendBizRedPacket", e2.getMessage());
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46743);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
