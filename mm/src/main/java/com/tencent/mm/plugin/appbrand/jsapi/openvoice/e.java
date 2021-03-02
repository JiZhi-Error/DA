package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e extends d {
    private static final int CTRL_INDEX = 624;
    public static final String NAME = "updateVoIPView";

    public e() {
        AppMethodBeat.i(174847);
        c.aem(NAME);
        AppMethodBeat.o(174847);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(46686);
        int optInt = jSONObject.optInt("viewId");
        AppMethodBeat.o(46686);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(46687);
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView," + jSONObject.toString());
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(46687);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (view2 == null || !(view2 instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the camera view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(46687);
            return false;
        }
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView,viewId:[" + i2 + "," + H(jSONObject) + "],data:" + jSONObject.toString());
        ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c) view2).aH(jSONObject);
        AppMethodBeat.o(46687);
        return true;
    }
}
