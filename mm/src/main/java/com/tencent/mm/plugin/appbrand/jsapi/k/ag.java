package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag extends d {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(143701);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(143701);
            return optInt;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", e2);
            AppMethodBeat.o(143701);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(143702);
        e.xg(3);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiUpdateMap", "data is null");
            AppMethodBeat.o(143702);
            return false;
        }
        String appId = hVar.getAppId();
        Log.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", appId, Integer.valueOf(i2), jSONObject);
        b dz = g.dz(appId, f.i(hVar, jSONObject));
        if (dz == null) {
            Log.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
            AppMethodBeat.o(143702);
            return false;
        }
        if (jSONObject.has("enableZoom")) {
            dz.hw(jSONObject.optBoolean("enableZoom", true));
        }
        if (jSONObject.has("enableScroll")) {
            dz.hx(jSONObject.optBoolean("enableScroll", true));
        }
        if (jSONObject.has("enableRotate")) {
            dz.hy(jSONObject.optBoolean("enableRotate", true));
        }
        if (jSONObject.has("showCompass")) {
            dz.hz(jSONObject.optBoolean("showCompass", false));
        }
        if (jSONObject.has("enable3D")) {
            dz.setBuilding3dEffectEnable(jSONObject.optBoolean("enable3D", false));
        }
        if (jSONObject.has("enableOverlooking")) {
            dz.hA(jSONObject.optBoolean("enableOverlooking", false));
        }
        if (jSONObject.has("enableSatellite")) {
            dz.hB(jSONObject.optBoolean("enableSatellite", false));
        }
        if (jSONObject.has("enableTraffic")) {
            dz.hC(jSONObject.optBoolean("enableTraffic", false));
        }
        if (jSONObject.has("enableIndoor")) {
            dz.hD(jSONObject.optBoolean("enableIndoor", false));
        }
        if (jSONObject.has("enableIndoorLevelPick")) {
            dz.hE(jSONObject.optBoolean("enableIndoorLevelPick", false));
        }
        if (jSONObject.has("showLocation")) {
            dz.hH(jSONObject.optBoolean("showLocation", false));
        }
        if (jSONObject.has("showScale")) {
            dz.hF(jSONObject.optBoolean("showScale", true));
        }
        if (jSONObject.has("styleId")) {
            dz.setMapStyle(jSONObject.optInt("styleId", 0));
        }
        if (jSONObject.has("maxScale")) {
            dz.setMaxZoomLevel(Util.getInt(jSONObject.optString("maxScale"), 20));
        }
        if (jSONObject.has("minScale")) {
            dz.setMinZoomLevel(Util.getInt(jSONObject.optString("minScale"), 3));
        }
        if (jSONObject.has("enablePoi")) {
            dz.setPoisEnabled(jSONObject.optBoolean("enablePoi", true));
        }
        if (jSONObject.has("enableBuilding")) {
            dz.hG(jSONObject.optBoolean("enableBuilding", true));
        }
        try {
            if (jSONObject.has("covers")) {
                dz.bHd();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    double d2 = Util.getDouble(jSONObject2.optString("latitude"), 0.0d);
                    double d3 = Util.getDouble(jSONObject2.optString("longitude"), 0.0d);
                    String b2 = ((com.tencent.mm.plugin.appbrand.f.b) hVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(hVar, jSONObject2.optString("iconPath"));
                    b.d dVar = new b.d();
                    dVar.g(d2, d3);
                    dVar.mav = b2;
                    dVar.mat = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    dz.a(dVar, (a) hVar.M(a.class));
                }
            }
            if (jSONObject.has("scale") || jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION) || jSONObject.has("skew") || jSONObject.has("centerLatitude") || jSONObject.has("centerLongitude")) {
                float optDouble = (float) jSONObject.optDouble("scale", -1.0d);
                float optDouble2 = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, -1.0d);
                float optDouble3 = (float) jSONObject.optDouble("skew", -1.0d);
                dz.a(Util.getDouble(jSONObject.optString("centerLatitude", "-1"), -1.0d), Util.getDouble(jSONObject.optString("centerLongitude", "-1"), -1.0d), -1.0f, -1.0f, -1.0f, false);
                dz.a(-1.0d, -1.0d, optDouble, optDouble2, optDouble3, true);
            }
            e.xg(4);
            AppMethodBeat.o(143702);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", e2);
            AppMethodBeat.o(143702);
            return false;
        }
    }
}
