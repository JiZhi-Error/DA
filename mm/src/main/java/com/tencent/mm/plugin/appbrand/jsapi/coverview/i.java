package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    public static class b extends bc {
        private static final int CTRL_INDEX = 840;
        private static final String NAME = "onTextViewDrag";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(137533);
        Context context = hVar.getContext();
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, new d(context));
        AppMethodBeat.o(137533);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137534);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137534);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final h hVar, final int i2, View view, JSONObject jSONObject) {
        int i3;
        int optInt;
        AppMethodBeat.i(137535);
        Log.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        d dVar = (d) ((CoverViewContainer) view).aB(d.class);
        if (dVar == null) {
            Log.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i2));
            AppMethodBeat.o(137535);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        boolean optBoolean3 = jSONObject.optBoolean("gesture");
        boolean optBoolean4 = jSONObject.optBoolean("draggable", false);
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        c.a(dVar, jSONObject.optJSONObject("label"));
        com.tencent.mm.plugin.appbrand.jsapi.ac.b.a(dVar, jSONObject);
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        final ad.b L = hVar.gA(jSONObject.optBoolean("independent", false)).L(i2, true);
        L.l("data", optString2);
        L.l("sendTo", optString);
        L.l("transEvt", Boolean.valueOf(optBoolean2));
        L.l("clickable", Boolean.valueOf(optBoolean));
        boolean optBoolean5 = jSONObject.optBoolean("independent", false);
        boolean z = false;
        if (!optBoolean5 || (optInt = jSONObject.optInt("parentId", 0)) == 0) {
            i3 = -1;
        } else {
            z = hVar.gA(optBoolean5).wI(optInt);
            i3 = hVar.gA(optBoolean5).wJ(optInt);
        }
        Log.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean4), Boolean.valueOf(optBoolean5), Boolean.valueOf(z));
        if (!optBoolean5 || (!z && !optBoolean4)) {
            Log.i("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
            dVar.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.i.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(193671);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!L.JY("clickable")) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(193671);
                        return;
                    }
                    Log.i("MicroMsg.JsApiInsertTextView", "onClick");
                    a aVar = new a((byte) 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", L.getString("data", ""));
                    aVar.L(hashMap);
                    if ("webview".equals(L.getString("sendTo", null))) {
                        hVar.a(aVar);
                    } else {
                        hVar.a(aVar, (int[]) null);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(193671);
                }
            });
            dVar.setClickable(optBoolean);
        } else {
            Log.i("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
            if (optBoolean) {
                ((CoverViewContainer) view).eb(i2, i3);
                ((CoverViewContainer) view).setIsInterceptEvent(true);
                ((CoverViewContainer) view).setOnCustomerClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.i.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(137531);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.JsApiInsertTextView", "onClick");
                        a aVar = new a((byte) 0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("data", L.getString("data", ""));
                        aVar.L(hashMap);
                        if ("webview".equals(L.getString("sendTo", null))) {
                            hVar.a(aVar);
                        } else {
                            hVar.a(aVar, (int[]) null);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(137531);
                    }
                });
            }
            ((CoverViewContainer) view).setDragEventCallback(new CoverViewContainer.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.i.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer.a
                public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
                    AppMethodBeat.i(193670);
                    b bVar = new b();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str2);
                    hashMap.put("stage", str);
                    hashMap.put("drag", jSONObject);
                    hashMap.put("target", jSONObject2);
                    bVar.L(hashMap);
                    Log.i("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s， target:%s", str, jSONObject, str2, jSONObject2);
                    if ("webview".equals(L.getString("sendTo", null))) {
                        hVar.a(bVar);
                        AppMethodBeat.o(193670);
                        return;
                    }
                    hVar.a(bVar, (int[]) null);
                    AppMethodBeat.o(193670);
                }
            });
        }
        if (!optBoolean && optBoolean3 && !optBoolean4) {
            view.setDuplicateParentStateEnabled(true);
            dVar.setDuplicateParentStateEnabled(true);
            dVar.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.i.AnonymousClass4 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(193672);
                    d.a(hVar, i2, motionEvent, L.getString("data", ""), "webview".equals(L.getString("sendTo", null)));
                    AppMethodBeat.o(193672);
                    return true;
                }
            });
        }
        AppMethodBeat.o(137535);
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
