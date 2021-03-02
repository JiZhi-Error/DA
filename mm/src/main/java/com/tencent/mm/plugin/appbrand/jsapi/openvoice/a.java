package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a extends i {
    public static final int CTRL_INDEX = 517;
    public static final String NAME = "exitVoIPChat";

    public a() {
        AppMethodBeat.i(174844);
        c.aem(NAME);
        AppMethodBeat.o(174844);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46670);
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
        hl(false);
        final String appId = cVar.getAppId();
        final long currentTicks = Util.currentTicks();
        q.INSTANCE.a(new b<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
            public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                AppMethodBeat.i(46669);
                long ticksToNow = Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: exit conference result %d, %d, %s, %s, using %d ms", Integer.valueOf(i2), Integer.valueOf(i3), str, str2, Long.valueOf(ticksToNow));
                h.INSTANCE.a(16093, appId, Integer.valueOf(i3), Long.valueOf(ticksToNow));
                if (i2 == 0 && i3 == 0) {
                    h.INSTANCE.n(935, 2, 1);
                    cVar.i(i2, a.this.h("ok", null));
                    AppMethodBeat.o(46669);
                    return;
                }
                h.INSTANCE.n(935, 3, 1);
                cVar.i(i2, a.this.h("fail: ".concat(String.valueOf(str)), null));
                AppMethodBeat.o(46669);
            }
        }, q.a.ReasonManual);
        AppMethodBeat.o(46670);
    }
}
