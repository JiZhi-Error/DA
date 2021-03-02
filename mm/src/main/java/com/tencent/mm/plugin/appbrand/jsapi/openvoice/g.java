package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends i {
    public static final int CTRL_INDEX = 877;
    public static final String NAME = "hasJoinVoIPChat";
    private static String TAG = "MicroMsg.OpenVoice.JsApiHasJoinVoIPChat";

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(final c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226930);
        Log.i(TAG, NAME);
        b bVar = (b) com.tencent.mm.kernel.g.af(b.class);
        if (bVar != null) {
            bVar.a(new i() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.g.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:10:0x0079  */
                /* JADX WARNING: Removed duplicated region for block: B:18:0x00c7 A[SYNTHETIC] */
                @Override // com.tencent.mm.plugin.ball.c.i
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void bH(java.util.List<com.tencent.mm.plugin.ball.model.BallInfo> r10) {
                    /*
                    // Method dump skipped, instructions count: 201
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.openvoice.g.AnonymousClass1.bH(java.util.List):void");
                }
            });
            AppMethodBeat.o(226930);
            return;
        }
        Log.e(TAG, "IFloatBallService is null");
        HashMap hashMap = new HashMap();
        hashMap.put("join", Boolean.FALSE);
        cVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(226930);
    }
}
