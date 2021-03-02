package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f extends c {
    private static final int CTRL_INDEX = 362;
    public static final String NAME = "removeLivePusher";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145893);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(145893);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(145894);
        super.b(hVar, i2, view, jSONObject);
        Log.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145894);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePusherView)) {
            Log.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(145894);
            return false;
        }
        ((AppBrandLivePusherView) view2).onExit();
        AppMethodBeat.o(145894);
        return true;
    }
}
