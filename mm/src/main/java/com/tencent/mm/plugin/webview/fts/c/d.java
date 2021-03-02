package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b.a {
    private h IBw;
    private b.AbstractC1953b IQD;
    FtsWebVideoView IQN;
    public MTimerHandler mAM;
    public int mAN;

    public d(FtsWebVideoView ftsWebVideoView, b.AbstractC1953b bVar, h hVar) {
        AppMethodBeat.i(210856);
        this.IQN = ftsWebVideoView;
        this.IQD = bVar;
        this.IQD.a(this);
        this.IBw = hVar;
        AppMethodBeat.o(210856);
    }

    public final void clean() {
        AppMethodBeat.i(78167);
        Log.i("MicroMsg.JsApiVideoCallback", "clean %s", toString());
        bKw();
        AppMethodBeat.o(78167);
    }

    public final void bY(JSONObject jSONObject) {
        AppMethodBeat.i(78168);
        this.IBw.b("onVideoPlayerCallback", null, jSONObject);
        AppMethodBeat.o(78168);
    }

    public final void d(int i2, boolean z, String str) {
        AppMethodBeat.i(78169);
        try {
            Log.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", Integer.valueOf(i2), Boolean.valueOf(z), str);
            bY(b(5, J(z, str)));
            AppMethodBeat.o(78169);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e2);
            AppMethodBeat.o(78169);
        }
    }

    public final void gaP() {
        AppMethodBeat.i(78170);
        try {
            bY(b(6, gaQ()));
            AppMethodBeat.o(78170);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", e2, null, new Object[0]);
            AppMethodBeat.o(78170);
        }
    }

    private JSONObject J(boolean z, String str) {
        AppMethodBeat.i(78171);
        JSONObject bKv = bKv();
        bKv.put("fullScreen", z);
        bKv.put(TencentLocation.EXTRA_DIRECTION, str);
        AppMethodBeat.o(78171);
        return bKv;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject bKv() {
        AppMethodBeat.i(78172);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.IQN.getCookieData());
        AppMethodBeat.o(78172);
        return jSONObject;
    }

    private JSONObject gaQ() {
        AppMethodBeat.i(78173);
        JSONObject bKv = bKv();
        bKv.put("currentTime", this.IQN.getCurrPosSec());
        AppMethodBeat.o(78173);
        return bKv;
    }

    public final void bKw() {
        AppMethodBeat.i(78174);
        if (this.mAM != null) {
            this.mAM.stopTimer();
        }
        AppMethodBeat.o(78174);
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void onForeground() {
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void onBackground() {
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void onDestroy() {
        AppMethodBeat.i(78175);
        Log.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.IQN.setCallback(null);
        AppMethodBeat.o(78175);
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void Na() {
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void gaM() {
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.a
    public final void gaN() {
    }

    public final JSONObject b(int i2, JSONObject jSONObject) {
        AppMethodBeat.i(78176);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.IQN.getmVideoPlayerId());
        jSONObject2.put("event", i2);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        AppMethodBeat.o(78176);
        return jSONObject2;
    }
}
