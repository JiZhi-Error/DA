package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 625;
    public static final String NAME = "removeVoIPView";

    public d() {
        AppMethodBeat.i(174846);
        com.tencent.mm.plugin.appbrand.permission.c.aem(NAME);
        AppMethodBeat.o(174846);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(46684);
        int optInt = jSONObject.optInt("viewId", 0);
        AppMethodBeat.o(46684);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(46685);
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "onRemoveView," + jSONObject.toString());
        super.b(hVar, i2, view, jSONObject);
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(46685);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (view2 == null || !(view2 instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(46685);
            return false;
        }
        q.INSTANCE.qtf.a((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c) view2);
        AppMethodBeat.o(46685);
        return true;
    }
}
