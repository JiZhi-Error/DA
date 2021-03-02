package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends b {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(com.tencent.mm.plugin.appbrand.jsapi.h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(137528);
        WxaScrollView wxaScrollView = new WxaScrollView(hVar.getContext());
        AppMethodBeat.o(137528);
        return wxaScrollView;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137529);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137529);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137530);
        Log.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        final WxaScrollView wxaScrollView = (WxaScrollView) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String optString = jSONObject.optString("data", "");
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        final boolean optBoolean2 = jSONObject.optBoolean("independent", false);
        hVar.gA(optBoolean2).L(i2, true).l("data", optString);
        if (optBoolean) {
            wxaScrollView.setOnScrollChangedListener(new t() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.h.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.t
                public final void p(View view, int i2, int i3) {
                    AppMethodBeat.i(137526);
                    if (!(view instanceof WxaScrollView)) {
                        AppMethodBeat.o(137526);
                        return;
                    }
                    ad.b L = hVar.gA(optBoolean2).L(i2, false);
                    if (L == null) {
                        AppMethodBeat.o(137526);
                        return;
                    }
                    String string = L.getString("data", null);
                    if (string == null) {
                        AppMethodBeat.o(137526);
                        return;
                    }
                    ViewGroup targetView = ((WxaScrollView) view).getTargetView();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", string);
                    hashMap.put("scrollLeft", Integer.valueOf(g.zC(i2)));
                    hashMap.put("scrollTop", Integer.valueOf(g.zC(i3)));
                    hashMap.put("scrollWidth", Integer.valueOf(g.zC(targetView.getWidth())));
                    hashMap.put("scrollHeight", Integer.valueOf(g.zC(targetView.getHeight())));
                    hVar.a(new s().L(hashMap), (int[]) null);
                    AppMethodBeat.o(137526);
                }
            });
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            boolean optBoolean3 = jSONObject.optBoolean("scrollX", true);
            Log.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", Boolean.valueOf(optBoolean3));
            wxaScrollView.setScrollHorizontal(optBoolean3);
        }
        if (jSONObject.has("scrollY")) {
            boolean optBoolean4 = jSONObject.optBoolean("scrollY", true);
            Log.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", Boolean.valueOf(optBoolean4));
            wxaScrollView.setScrollVertical(optBoolean4);
        }
        if (jSONObject.has("scrollTop")) {
            final int a2 = g.a(jSONObject, "scrollTop", wxaScrollView.getScrollY());
            Log.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", Integer.valueOf(a2));
            wxaScrollView.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(137527);
                    wxaScrollView.scrollTo(wxaScrollView.getScrollX(), a2);
                    AppMethodBeat.o(137527);
                }
            }, 100);
        }
        AppMethodBeat.o(137530);
    }
}
