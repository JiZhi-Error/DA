package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p extends d {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137483);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.o(137483);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        boolean z;
        int[] p;
        AppMethodBeat.i(137484);
        Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(137484);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (view2 == null || !(view2 instanceof f)) {
            Log.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(137484);
            return false;
        }
        f fVar = (f) view2;
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("devicePosition", "back");
        String optString2 = jSONObject.optString("flash", "auto");
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        fVar.setAppId(hVar.getAppId());
        fVar.ar(optString, false);
        fVar.setFlash(optString2);
        fVar.setNeedOutput(optBoolean);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a2 = g.a(optJSONObject, "width", 0);
        int a3 = g.a(optJSONObject, "height", 0);
        Log.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a2), Integer.valueOf(a3));
        if (a2 == 0 || a3 == 0) {
            z = false;
        } else {
            z = fVar.dZ(a2, a3);
        }
        e eVar = (e) hVar.M(e.class);
        if (eVar != null && (p = eVar.p(hVar)) != null && p.length == 2 && p[0] > 0 && p[1] > 0) {
            fVar.setDisplayScreenSize(new Size(p[0], p[1]));
            Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", Integer.valueOf(p[0]), Integer.valueOf(p[1]));
        }
        String optString3 = jSONObject.optString("mode");
        if (!Util.isNullOrNil(optString3)) {
            fVar.setMode(optString3);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray != null && optJSONArray.length() == 4) {
            Log.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            fVar.x(g.zD(optJSONArray.optInt(0)), g.zD(optJSONArray.optInt(1)), g.zD(optJSONArray.optInt(2)), g.zD(optJSONArray.optInt(3)));
        }
        fVar.setScanFreq(jSONObject.optInt("scanFreq"));
        if (z) {
            fVar.release();
            fVar.initView();
        } else {
            fVar.bFM();
        }
        AppMethodBeat.o(137484);
        return true;
    }
}
