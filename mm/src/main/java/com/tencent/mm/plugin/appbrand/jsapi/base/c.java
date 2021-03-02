package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends h> extends e<f> {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        if (MMHandlerThread.isMainThread()) {
            c(fVar, jSONObject, i2);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.base.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(140653);
                    c.this.c(fVar, jSONObject, i2);
                    AppMethodBeat.o(140653);
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.c<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.h> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(f fVar, JSONObject jSONObject, int i2) {
        boolean z;
        String str;
        if (fVar.bsV() || fVar.isRunning()) {
            h d2 = d(fVar, jSONObject);
            if (d2 == null) {
                Log.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
                fVar.i(i2, h("fail:ComponentView is null.", null));
            } else if (d2.getCustomViewContainer() == null) {
                Log.w("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
                fVar.i(i2, h("fail:remove view failed", null));
            } else {
                try {
                    int H = H(jSONObject);
                    boolean optBoolean = jSONObject.optBoolean("independent", false);
                    View viewById = d2.gA(optBoolean).getViewById(H);
                    if ((viewById instanceof CoverViewContainer) && jSONObject.has("draggable") && jSONObject.optBoolean("draggable", false)) {
                        CoverViewContainer.xb(H);
                    }
                    if (d2.gA(optBoolean).wD(H)) {
                        z = d2.gA(optBoolean).wF(H);
                        if (z) {
                            z = b(d2, H, viewById, jSONObject);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        d2.gA(optBoolean).wC(H);
                    }
                    Log.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(H), Boolean.valueOf(z));
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    fVar.i(i2, h(str, null));
                } catch (JSONException e2) {
                    Log.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", e2);
                    fVar.i(i2, h("fail:view id do not exist", null));
                }
            }
        } else {
            fVar.i(i2, "fail:interrupted");
        }
    }

    private static h d(f fVar, JSONObject jSONObject) {
        g gVar = (g) fVar.M(g.class);
        if (gVar != null) {
            return gVar.c(fVar, jSONObject);
        }
        Log.e("MicroMsg.BaseRemoveViewJsApi", "getComponentView NULL IComponentConverter");
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean b(CONTEXT context, int i2, View view, JSONObject jSONObject) {
        return true;
    }
}
