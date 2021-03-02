package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends d {
    private static final int CTRL_INDEX = 365;
    public static final String NAME = "updateLivePlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145895);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(145895);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        i iVar;
        AppMethodBeat.i(145896);
        Log.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145896);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePlayerView)) {
            Log.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(145896);
            return false;
        }
        AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
        Bundle Y = k.Y(jSONObject);
        appBrandLivePlayerView.cFE = Y.getBoolean("needEvent", appBrandLivePlayerView.cFE);
        l lVar = appBrandLivePlayerView.lXC;
        if (!lVar.mInited) {
            iVar = new i(-3, "uninited livePlayer");
        } else {
            l.l(NAME, Y);
            lVar.a(Y, false);
            boolean isPlaying = lVar.cFu.isPlaying();
            String string = Y.getString("playUrl", lVar.cEW);
            if (string != null && !string.isEmpty() && lVar.cEW != null && !lVar.cEW.equalsIgnoreCase(string) && lVar.cFu.isPlaying()) {
                Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + lVar.cEW + " playUrl-new = " + string);
                lVar.cFu.stopPlay(true);
            }
            lVar.cEW = string;
            int n = lVar.n(Y);
            if (n != lVar.cFx && lVar.cFu.isPlaying()) {
                Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + lVar.cFx + " playType-new = " + n);
                lVar.cFu.stopPlay(true);
            }
            lVar.cFx = n;
            lVar.cEZ = Y.getBoolean("autoplay", lVar.cEZ);
            if ((lVar.cEZ || isPlaying) && lVar.cEW != null && !lVar.cEW.isEmpty() && !lVar.cFu.isPlaying()) {
                Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                lVar.cFu.startPlay(lVar.cEW, lVar.cFx);
            }
            iVar = new i();
        }
        Log.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        AppMethodBeat.o(145896);
        return true;
    }
}
