package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import android.view.View;
import com.facebook.internal.ServerProtocol;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends d {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(f fVar, JSONObject jSONObject, int i2) {
        e.ZZ(getName());
    }

    /* access modifiers changed from: protected */
    public final void a(f fVar, int i2, String str, boolean z, boolean z2) {
        fVar.i(i2, str);
        e.e(getName(), z, z2);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.appbrand.jsapi.k.a.b h(f fVar, JSONObject jSONObject) {
        if (fVar instanceof h) {
            return g.dz(fVar.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar, jSONObject));
        }
        if (fVar.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class) == null) {
            Log.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", getName());
            return null;
        }
        h c2 = ((com.tencent.mm.plugin.appbrand.jsapi.base.g) fVar.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(fVar, jSONObject);
        if (c2 != null) {
            return g.dz(c2.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(c2, jSONObject));
        }
        Log.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", getName());
        return null;
    }

    protected static b.v a(f fVar, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        b.v vVar = new b.v();
        if (jSONObject2.has("joinCluster")) {
            vVar.maN = jSONObject2.optBoolean("joinCluster", false);
        }
        if (jSONObject2.has("clusterId")) {
            vVar.mao = jSONObject2.optInt("clusterId", -1);
        }
        if (jSONObject2.has("latitude") && jSONObject2.has("longitude")) {
            double d2 = Util.getDouble(jSONObject2.optString("latitude"), 0.0d);
            double d3 = Util.getDouble(jSONObject2.optString("longitude"), 0.0d);
            vVar.latitude = d2;
            vVar.longitude = d3;
        }
        String optString = jSONObject2.optString("iconPath");
        float a2 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject2, "width", 0.0f);
        float a3 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject2, "height", 0.0f);
        if (!Util.isNullOrNil(optString) && fVar.M(com.tencent.mm.plugin.appbrand.f.b.class) != null) {
            vVar.mav = ((com.tencent.mm.plugin.appbrand.f.b) fVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(fVar, optString);
            vVar.maO = a2;
            vVar.maP = a3;
        }
        vVar.mat = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
        vVar.alpha = (float) jSONObject2.optDouble("alpha", 1.0d);
        vVar.data = jSONObject2.optString("data");
        vVar.maQ = jSONObject2.optString("ariaLabel");
        if (jSONObject2.has("anchor")) {
            try {
                jSONObject6 = new JSONObject(jSONObject2.optString("anchor"));
            } catch (JSONException e2) {
                jSONObject6 = null;
            }
            if (jSONObject6 != null) {
                vVar.M((float) jSONObject6.optDouble("x", 0.5d), (float) jSONObject6.optDouble("y", 1.0d));
            } else {
                vVar.M(0.5f, 1.0f);
            }
        }
        vVar.zIndex = jSONObject2.optInt("zIndex", 0);
        String optString2 = jSONObject2.optString("label");
        if (!Util.isNullOrNil(optString2)) {
            try {
                jSONObject5 = new JSONObject(optString2);
            } catch (JSONException e3) {
                jSONObject5 = null;
            }
            if (jSONObject5 != null) {
                String optString3 = jSONObject5.optString("content");
                int cu = com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject5.optString("color", "#000000"), Color.parseColor("#000000"));
                int optInt = jSONObject5.optInt("fontSize", 12);
                int a4 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "anchorX", com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "x", 0));
                int a5 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "anchorY", com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "y", 0));
                int f2 = com.tencent.mm.plugin.appbrand.ac.g.f(jSONObject5, "borderRadius");
                int f3 = com.tencent.mm.plugin.appbrand.ac.g.f(jSONObject5, "borderWidth");
                int afD = com.tencent.mm.plugin.appbrand.ac.g.afD(jSONObject5.optString("borderColor"));
                int cu2 = com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject5.optString("bgColor", ""), Color.parseColor("#000000"));
                int a6 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "padding", 0);
                String optString4 = jSONObject5.optString("textAlign", "");
                int a7 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "width", -1);
                int a8 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject5, "height", -1);
                vVar.maS = new b.v.C0671b(optString3, cu, optInt, a4, a5, cu2, f2, f3, afD, optString4, a6);
                vVar.maS.width = a7;
                vVar.maS.height = a8;
            }
        }
        String optString5 = jSONObject2.optString("callout");
        if (!Util.isNullOrNil(optString5)) {
            try {
                jSONObject4 = new JSONObject(optString5);
            } catch (JSONException e4) {
                jSONObject4 = null;
            }
            if (jSONObject4 != null) {
                vVar.maR = new b.v.a(jSONObject4.optString("content"), com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject4.optString("color", "#000000"), Color.parseColor("#000000")), jSONObject4.optInt("fontSize", 12), com.tencent.mm.plugin.appbrand.ac.g.f(jSONObject4, "borderRadius"), com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject4.optString("bgColor", "#000000"), Color.parseColor("#000000")), com.tencent.mm.plugin.appbrand.ac.g.f(jSONObject4, "borderWidth"), com.tencent.mm.plugin.appbrand.ac.g.afD(jSONObject4.optString("borderColor")), com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject4, "padding", 0), com.tencent.mm.plugin.appbrand.ac.g.cu(jSONObject4.optString("shadowColor", "#000000"), Color.parseColor("#000000")), jSONObject4.optInt("shadowOpacity"), com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject4, "shadowOffsetX", 0), com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject4, "shadowOffsetY", 0), jSONObject4.optInt(ServerProtocol.DIALOG_PARAM_DISPLAY, 0), jSONObject4.optString("textAlign", ""), com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject4, "anchorX", 0), com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject4, "anchorY", 0));
            }
        }
        String optString6 = jSONObject2.optString("customCallout");
        if (!Util.isNullOrNil(optString6)) {
            try {
                jSONObject3 = new JSONObject(optString6);
            } catch (JSONException e5) {
                jSONObject3 = null;
            }
            if (jSONObject3 != null) {
                int optInt2 = jSONObject3.optInt("viewId", 0);
                int optInt3 = jSONObject3.optInt(ServerProtocol.DIALOG_PARAM_DISPLAY, 0);
                boolean optBoolean = jSONObject.optBoolean("independent", false);
                int a9 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject3, "anchorX", 0);
                int a10 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject3, "anchorY", 0);
                View viewById = ((com.tencent.mm.plugin.appbrand.jsapi.base.g) fVar.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(fVar, jSONObject).gA(optBoolean).getViewById(optInt2);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(optInt2);
                objArr[1] = Boolean.valueOf(viewById != null);
                Log.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", objArr);
                if (viewById != null) {
                    vVar.maR = new b.v.a();
                    vVar.maR.view = viewById;
                    vVar.maR.maY = optInt3;
                    vVar.maR.maZ = a9;
                    vVar.maR.mba = a10;
                }
            }
        }
        String optString7 = jSONObject2.optString("buildingId");
        String optString8 = jSONObject2.optString("floorName");
        vVar.buildingId = optString7;
        vVar.floorName = optString8;
        return vVar;
    }
}
