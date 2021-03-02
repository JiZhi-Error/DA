package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e extends c {
    private static final int CTRL_INDEX = 366;
    public static final String NAME = "removeLivePlayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145891);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(145891);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(145892);
        super.b(hVar, i2, view, jSONObject);
        Log.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145892);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePlayerView)) {
            Log.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(145892);
            return false;
        }
        ((AppBrandLivePlayerView) view2).onExit();
        AppMethodBeat.o(145892);
        return true;
    }
}
