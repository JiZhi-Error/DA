package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends i {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "operateCallTone";
    private static String TAG = "MicroMsg.OpenVoice.JsApiOperateCallTone";

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(c cVar, JSONObject jSONObject, int i2) {
        int i3 = 1;
        AppMethodBeat.i(226940);
        if (jSONObject == null) {
            cVar.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(226940);
            return;
        }
        Log.i(TAG, "hy: appId:" + cVar.getAppId() + ", data:" + jSONObject.toString());
        try {
            if (AssetExtension.SCENE_PLAY.equalsIgnoreCase(jSONObject.getString("type"))) {
                q qVar = q.INSTANCE;
                if (qVar.qtm == 1) {
                    i3 = 0;
                }
                if (qVar.qtg != null) {
                    qVar.qtg.bl(i3, true);
                }
                qVar.mainHandler.sendEmptyMessage(272);
            } else {
                Log.i(TAG, "operate: stop ring");
                q.INSTANCE.stopRing();
            }
            cVar.i(i2, h("ok", null));
            AppMethodBeat.o(226940);
        } catch (JSONException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            cVar.i(i2, h("fail: param error!", null));
            AppMethodBeat.o(226940);
        }
    }
}
