package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends b<ac> {
    private static final int CTRL_INDEX = 809;
    public static final String NAME = "insertImagePreviewer";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* synthetic */ View a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226739);
        ac acVar2 = acVar;
        Context context = acVar2.getContext();
        ZoomImagePreviewer zoomImagePreviewer = new ZoomImagePreviewer(context, null);
        zoomImagePreviewer.setComponent(acVar2);
        zoomImagePreviewer.setViewId(jSONObject.optInt("viewId", 0));
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, zoomImagePreviewer);
        AppMethodBeat.o(226739);
        return coverViewContainer;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, int, android.view.View, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* synthetic */ void a(ac acVar, int i2, View view, JSONObject jSONObject) {
        float[] L;
        AppMethodBeat.i(226738);
        super.a(acVar, i2, view, jSONObject);
        Log.d("MicroMsg.JsApiInsertImagePreviewer", "insertImagePreviewer(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        Log.d("MicroMsg.JsApiInsertImagePreviewer", "onInsertView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        ZoomImagePreviewer zoomImagePreviewer = (ZoomImagePreviewer) ((CoverViewContainer) view).aB(ZoomImagePreviewer.class);
        if (zoomImagePreviewer == null) {
            Log.w("MicroMsg.JsApiInsertImagePreviewer", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i2));
            AppMethodBeat.o(226738);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ac.f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        com.tencent.mm.plugin.appbrand.jsapi.ac.b.a(zoomImagePreviewer, jSONObject);
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
                    Log.e("MicroMsg.JsApiInsertImagePreviewer", "urls is empty");
                }
                if (!arrayList.isEmpty()) {
                    zoomImagePreviewer.setData(arrayList);
                }
            }
            AppMethodBeat.o(226738);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.JsApiInsertImagePreviewer", e2, "", new Object[0]);
            AppMethodBeat.o(226738);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(226737);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(226737);
        return i2;
    }
}
