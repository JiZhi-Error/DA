package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends d {
    private static final int CTRL_INDEX = 810;
    public static final String NAME = "updateImagePreviewer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        float[] L;
        AppMethodBeat.i(226742);
        Log.d("MicroMsg.JsApiUpdateImagePreviewer", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateImagePreviewer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(226742);
            return false;
        }
        ZoomImagePreviewer zoomImagePreviewer = (ZoomImagePreviewer) ((CoverViewContainer) view).aB(ZoomImagePreviewer.class);
        if (zoomImagePreviewer == null) {
            Log.w("MicroMsg.JsApiUpdateImagePreviewer", "the target view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(226742);
            return false;
        }
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        try {
            if (jSONObject.has("position") && (L = L(jSONObject)) != null) {
                zoomImagePreviewer.ec((int) L[2], (int) L[3]);
            }
            if (jSONObject.has("scale")) {
                zoomImagePreviewer.setScale((float) jSONObject.optDouble("scale"));
            }
            if (jSONObject.has("urls")) {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String obj = optJSONArray.get(i3).toString();
                        if (!TextUtils.isEmpty(obj)) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    Log.e("MicroMsg.JsApiUpdateImagePreviewer", "urls is empty");
                }
                if (!arrayList.isEmpty()) {
                    zoomImagePreviewer.C(arrayList);
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.JsApiUpdateImagePreviewer", e2, "", new Object[0]);
        }
        boolean c2 = super.c(hVar, i2, view, jSONObject);
        AppMethodBeat.o(226742);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(226743);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(226743);
        return i2;
    }
}
