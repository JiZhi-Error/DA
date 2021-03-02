package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class o extends c {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137481);
        int optInt = jSONObject.optInt("cameraId", 0);
        AppMethodBeat.o(137481);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137482);
        super.b(hVar, i2, view, jSONObject);
        Log.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(137482);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (view2 == null || !(view2 instanceof f)) {
            Log.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(137482);
            return false;
        }
        f fVar = (f) view2;
        hVar.b((i.d) fVar);
        hVar.b((i.b) fVar);
        hVar.b((i.c) fVar);
        a.C0654a.bFI().M(fVar.getCameraId(), true);
        fVar.release();
        AppMethodBeat.o(137482);
        return true;
    }
}
