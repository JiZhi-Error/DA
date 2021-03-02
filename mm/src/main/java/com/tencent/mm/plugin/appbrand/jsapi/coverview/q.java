package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class q extends d {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137545);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137545);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(final h hVar, final int i2, View view, final JSONObject jSONObject) {
        AppMethodBeat.i(137546);
        Log.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        if (!(view instanceof WxaScrollView)) {
            Log.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", Integer.valueOf(i2));
            AppMethodBeat.o(137546);
            return false;
        }
        WxaScrollView wxaScrollView = (WxaScrollView) view;
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        try {
            if (jSONObject.getBoolean("needScrollEvent")) {
                wxaScrollView.setOnScrollChangedListener(new t() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.q.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.t
                    public final void p(View view, int i2, int i3) {
                        AppMethodBeat.i(137544);
                        if (!(view instanceof WxaScrollView)) {
                            AppMethodBeat.o(137544);
                            return;
                        }
                        ad.b L = hVar.gA(jSONObject.optBoolean("independent", false)).L(i2, false);
                        if (L == null) {
                            AppMethodBeat.o(137544);
                            return;
                        }
                        String string = L.getString("data", null);
                        if (string == null) {
                            AppMethodBeat.o(137544);
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
                        AppMethodBeat.o(137544);
                    }
                });
            } else {
                wxaScrollView.setOnScrollChangedListener(null);
            }
        } catch (JSONException e2) {
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            boolean optBoolean = jSONObject.optBoolean("scrollX", true);
            Log.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", Boolean.valueOf(optBoolean));
            wxaScrollView.setScrollHorizontal(optBoolean);
        }
        if (jSONObject.has("scrollY")) {
            boolean optBoolean2 = jSONObject.optBoolean("scrollY", true);
            Log.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", Boolean.valueOf(optBoolean2));
            wxaScrollView.setScrollVertical(optBoolean2);
        }
        if (jSONObject.has("scrollTop")) {
            int a2 = g.a(jSONObject, "scrollTop", wxaScrollView.getScrollY());
            Log.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", Integer.valueOf(a2));
            wxaScrollView.scrollTo(wxaScrollView.getScrollX(), a2);
        }
        boolean c2 = super.c(hVar, i2, view, jSONObject);
        AppMethodBeat.o(137546);
        return c2;
    }
}
