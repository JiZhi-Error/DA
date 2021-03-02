package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends b {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143660);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapLines", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143660);
            return;
        }
        Log.i("MicroMsg.JsApiAddMapLines", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143660);
            return;
        }
        try {
            if (jSONObject.has("lines")) {
                if (jSONObject.optBoolean("clear", true)) {
                    h2.bHb();
                }
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                        arrayList.add(new b.i(Util.getDouble(jSONObject3.optString("latitude"), 0.0d), Util.getDouble(jSONObject3.optString("longitude"), 0.0d)) {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.g.AnonymousClass1 */
                        });
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONObject2.has("colorList")) {
                        JSONArray jSONArray3 = new JSONArray(jSONObject2.optString("colorList"));
                        for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                            arrayList2.add(Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.cu(jSONArray3.getString(i5), Color.parseColor("#000000"))));
                        }
                        if (arrayList2.size() > 0 && arrayList2.size() < arrayList.size() - 1) {
                            int intValue = ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue();
                            for (int size = arrayList2.size(); size < arrayList.size() - 1; size++) {
                                arrayList2.add(Integer.valueOf(intValue));
                            }
                        } else if (arrayList2.size() > arrayList.size() && arrayList.size() > 0) {
                            for (int size2 = arrayList2.size() - 1; size2 > arrayList.size() - 1; size2--) {
                                arrayList2.remove(size2);
                            }
                        }
                        Log.i("MicroMsg.JsApiAddMapLines", "colorList size:%d ", Integer.valueOf(arrayList2.size()));
                    }
                    String optString = jSONObject2.optString("id");
                    int cu = com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int optInt = jSONObject2.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, -1);
                    int a2 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject2, "width", 0);
                    boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                    int cu2 = com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                    int a3 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject2, "borderWidth", 0);
                    boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                    String optString2 = jSONObject2.optString("arrowIconPath", "");
                    int a4 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject2, "arrowGap", 0);
                    String optString3 = jSONObject2.optString("level");
                    b.k kVar = new b.k();
                    kVar.id = optString;
                    kVar.style = optInt;
                    kVar.maG = new ArrayList();
                    kVar.maG.addAll(arrayList);
                    kVar.maL = arrayList2;
                    kVar.color = cu;
                    kVar.width = a2;
                    kVar.maH = optBoolean;
                    kVar.borderColor = cu2;
                    kVar.rc = a3;
                    kVar.maI = optBoolean2;
                    kVar.maK = a4;
                    if (optBoolean2) {
                        kVar.maJ = ((com.tencent.mm.plugin.appbrand.f.b) fVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(fVar, optString2);
                    }
                    String optString4 = jSONObject2.optString("buildingId");
                    String optString5 = jSONObject2.optString("floorName");
                    kVar.buildingId = optString4;
                    kVar.floorName = optString5;
                    kVar.mau = optString3;
                    h2.a(kVar, (a) fVar.M(a.class));
                }
            } else {
                Log.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
            }
            a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
            AppMethodBeat.o(143660);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(143660);
        }
    }
}
