package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends b {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(137523);
        Context context = hVar.getContext();
        com.tencent.mm.plugin.appbrand.widget.b.a aVar = null;
        if (e.M(com.tencent.mm.plugin.appbrand.widget.b.b.class) != null) {
            aVar = ((com.tencent.mm.plugin.appbrand.widget.b.b) e.M(com.tencent.mm.plugin.appbrand.widget.b.b.class)).ed(context);
        }
        if (aVar == null) {
            Log.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
            aVar = new com.tencent.mm.plugin.appbrand.widget.b.e(context);
        }
        aVar.setScaleType(ImageView.ScaleType.FIT_XY);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, aVar.getView());
        AppMethodBeat.o(137523);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137524);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137524);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137525);
        Log.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        com.tencent.mm.plugin.appbrand.widget.b.a aVar = (com.tencent.mm.plugin.appbrand.widget.b.a) ((CoverViewContainer) view).aB(com.tencent.mm.plugin.appbrand.widget.b.a.class);
        if (aVar == null) {
            Log.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i2));
            AppMethodBeat.o(137525);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("gesture");
        boolean optBoolean3 = jSONObject.optBoolean("draggable", false);
        boolean optBoolean4 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        JSONObject optJSONObject = jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        final ad.b L = hVar.gA(jSONObject.optBoolean("independent", false)).L(i2, true);
        L.l("data", optString2);
        L.l("sendTo", optString);
        L.l("transEvt", Boolean.valueOf(optBoolean4));
        L.l("clickable", Boolean.valueOf(optBoolean));
        aVar.setKeyValueSet(L);
        f.b(view, optJSONObject);
        c.a(hVar, i2, aVar, jSONObject, new b(i2, L, hVar));
        com.tencent.mm.plugin.appbrand.jsapi.ac.b.a(aVar.getView(), jSONObject);
        boolean optBoolean5 = jSONObject.optBoolean("independent", false);
        boolean z = false;
        int i3 = -1;
        if (optBoolean5) {
            int optInt = jSONObject.optInt("parentId", 0);
            if (optInt != 0) {
                z = hVar.gA(optBoolean5).wI(optInt);
                i3 = hVar.gA(optBoolean5).wJ(optInt);
            }
            L.aK("sendTo", "appservice");
        }
        Log.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean5), Boolean.valueOf(z));
        if (!optBoolean5 || (!z && !optBoolean3)) {
            Log.i("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
            aVar.getView().setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.g.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(193668);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!L.JY("clickable")) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(193668);
                        return;
                    }
                    a aVar = new a((byte) 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", L.getString("data", ""));
                    aVar.L(hashMap);
                    aVar.h(hVar);
                    if ("webview".equals(L.getString("sendTo", null))) {
                        hVar.a(aVar);
                    } else {
                        hVar.a(aVar, (int[]) null);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(193668);
                }
            });
            aVar.getView().setClickable(optBoolean);
        } else {
            Log.i("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
            if (optBoolean) {
                ((CoverViewContainer) view).eb(i2, i3);
                ((CoverViewContainer) view).setIsInterceptEvent(true);
                ((CoverViewContainer) view).setOnCustomerClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.g.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(137521);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.JsApiInsertImageView", "onClick");
                        a aVar = new a((byte) 0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("data", L.getString("data", ""));
                        aVar.L(hashMap);
                        if ("webview".equals(L.getString("sendTo", null))) {
                            hVar.a(aVar);
                        } else {
                            hVar.a(aVar, (int[]) null);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(137521);
                    }
                });
            }
            ((CoverViewContainer) view).setDragEventCallback(new CoverViewContainer.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer.a
                public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
                    AppMethodBeat.i(193667);
                    i.b bVar = new i.b();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str2);
                    hashMap.put("stage", str);
                    hashMap.put("drag", jSONObject);
                    hashMap.put("target", jSONObject2);
                    bVar.L(hashMap);
                    Log.i("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s, target:%s", str, jSONObject, str2, jSONObject2);
                    if ("webview".equals(L.getString("sendTo", null))) {
                        hVar.a(bVar);
                        AppMethodBeat.o(193667);
                        return;
                    }
                    hVar.a(bVar, (int[]) null);
                    AppMethodBeat.o(193667);
                }
            });
        }
        Log.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3));
        if (!optBoolean && optBoolean2 && !optBoolean3) {
            view.setDuplicateParentStateEnabled(true);
            aVar.getView().setDuplicateParentStateEnabled(true);
            aVar.getView().setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.g.AnonymousClass4 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(193669);
                    d.a(hVar, i2, motionEvent, L.getString("data", ""), "webview".equals(L.getString("sendTo", null)));
                    AppMethodBeat.o(193669);
                    return true;
                }
            });
        }
        AppMethodBeat.o(137525);
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
