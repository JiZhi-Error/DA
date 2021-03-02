package com.tencent.mm.plugin.appbrand.jsapi.ag.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static final int CTRL_INDEX = 672;
    public static final String NAME = "insertXWebCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(139451);
        Context context = hVar.getContext();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            optJSONObject.optInt("width", 300);
            optJSONObject.optInt("height", 150);
            final d dVar = new d(context, d.G(hVar), H(jSONObject), hVar.getAppId());
            hVar.a(new i.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(215829);
                    dVar.notifyVisibilityChanged(false);
                    AppMethodBeat.o(215829);
                }
            });
            hVar.a(new i.d() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                public final void onForeground() {
                    AppMethodBeat.i(215830);
                    dVar.notifyVisibilityChanged(true);
                    AppMethodBeat.o(215830);
                }
            });
            hVar.a(new i.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    AppMethodBeat.i(215831);
                    dVar.release();
                    AppMethodBeat.o(215831);
                }
            });
            CoverViewContainer coverViewContainer = new CoverViewContainer(context, dVar);
            AppMethodBeat.o(139451);
            return coverViewContainer;
        } catch (JSONException e2) {
            Log.printInfoStack("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", e2);
            AppMethodBeat.o(139451);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(h hVar, int i2, View view, JSONObject jSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.i iVar) {
        AppMethodBeat.i(139452);
        ((d) ((CoverViewContainer) view).aB(d.class)).setOnReadyListener(new d.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.d.a
            public final void onReady() {
                AppMethodBeat.i(215832);
                iVar.ZA(a.this.h("ok", null));
                AppMethodBeat.o(215832);
            }
        });
        AppMethodBeat.o(139452);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(139453);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(139453);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEW() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEX() {
        return true;
    }
}
