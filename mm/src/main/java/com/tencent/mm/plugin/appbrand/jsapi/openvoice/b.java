package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    private static final int CTRL_INDEX = 623;
    public static final String NAME = "insertVoIPView";

    public b() {
        AppMethodBeat.i(174845);
        c.aem(NAME);
        AppMethodBeat.o(174845);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(46671);
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflateView," + jSONObject.toString());
        Context context = hVar.getContext();
        if (context == null) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, context is null, %s", getName());
            AppMethodBeat.o(46671);
            return null;
        } else if (q.INSTANCE.qtm == 2) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s, audio room", getName());
            AppMethodBeat.o(46671);
            return null;
        } else {
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c a2 = q.INSTANCE.qtf.a(context, jSONObject, false);
            if (a2 == null) {
                Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s", getName());
                AppMethodBeat.o(46671);
                return null;
            }
            CoverViewContainer coverViewContainer = new CoverViewContainer(context, (View) a2);
            AppMethodBeat.o(46671);
            return coverViewContainer;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(46672);
        int optInt = jSONObject.optInt("viewId");
        AppMethodBeat.o(46672);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(46673);
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c cVar = (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c) ((CoverViewContainer) view).aB(View.class);
        if (cVar == null) {
            Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView failed, view is null, viewId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(46673);
            return;
        }
        Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView, viewId:[" + i2 + "," + cVar.getViewId() + "],data:" + jSONObject.toString());
        cVar.aG(jSONObject);
        AppMethodBeat.o(46673);
    }
}
