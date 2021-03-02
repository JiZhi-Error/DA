package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "updateXWebMap";

    public static boolean j(f fVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(139552);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiUpdateXWebMap", "data is null");
            AppMethodBeat.o(139552);
            return false;
        }
        String appId = fVar.getAppId();
        Log.i("MicroMsg.JsApiUpdateXWebMap", "data:%s", jSONObject);
        b dz = g.dz(appId, com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar, jSONObject));
        if (dz == null) {
            Log.e("MicroMsg.JsApiUpdateXWebMap", "mapView is null, return");
            AppMethodBeat.o(139552);
            return false;
        }
        if (jSONObject.has("position") && (optJSONObject = jSONObject.optJSONObject("position")) != null && optJSONObject.has("width") && optJSONObject.has("height")) {
            dz.onSizeChanged(com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "width", 0), com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "height", 0));
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
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    float f2 = Util.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f3 = Util.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    String b2 = ((com.tencent.mm.plugin.appbrand.f.b) fVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(fVar, jSONObject2.optString("iconPath"));
                    float optDouble = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    b.d dVar = new b.d();
                    dVar.g((double) f2, (double) f3);
                    dVar.mav = b2;
                    dVar.mat = optDouble;
                    dz.a(dVar, (a) fVar.M(a.class));
                }
            }
            if (jSONObject.has("scale") || jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION) || jSONObject.has("skew") || jSONObject.has("centerLatitude") || jSONObject.has("centerLongitude")) {
                float optDouble2 = (float) jSONObject.optDouble("scale", -1.0d);
                float optDouble3 = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, -1.0d);
                float optDouble4 = (float) jSONObject.optDouble("skew", -1.0d);
                dz.a(Util.getDouble(jSONObject.optString("centerLatitude", "-1"), -1.0d), Util.getDouble(jSONObject.optString("centerLongitude", "-1"), -1.0d), -1.0f, -1.0f, -1.0f, false);
                dz.a(-1.0d, -1.0d, optDouble2, optDouble3, optDouble4, true);
            }
            AppMethodBeat.o(139552);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiUpdateXWebMap", "parse covers error, exception : %s", e2);
            AppMethodBeat.o(139552);
            return false;
        }
    }
}
