package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends h> extends e<f> {
    static /* synthetic */ void a(d dVar, h hVar, int i2, JSONObject jSONObject, boolean z) {
        boolean z2 = false;
        if (dVar.bEW()) {
            try {
                ad.b L = hVar.gA(z).L(i2, false);
                if (L != null) {
                    boolean z3 = jSONObject.getBoolean("disableScroll");
                    if (L.JY("isTouching")) {
                        if (!z3) {
                            z2 = true;
                        }
                        if (L.getBoolean("disableScroll", z2) != z3) {
                            L.H("disableScroll-nextState", z3);
                            return;
                        }
                        return;
                    }
                    L.H("disableScroll", z3);
                }
            } catch (JSONException e2) {
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        h c2;
        g gVar = (g) fVar.M(g.class);
        if (gVar == null) {
            Log.e("MicroMsg.BaseUpdateViewJsApi", "getComponentView NULL IComponentConverter");
            c2 = null;
        } else {
            c2 = gVar.c(fVar, jSONObject);
        }
        if (c2 == null) {
            fVar.i(i2, h("fail:ComponentView is null.", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(c2);
        fVar.P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.base.d.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v21, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.d */
            /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.d */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                boolean z;
                String str;
                AppMethodBeat.i(140654);
                h hVar = (h) weakReference.get();
                if (hVar == null || !hVar.isRunning()) {
                    Log.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
                    fVar.i(i2, d.this.h("fail:page is null", null));
                    AppMethodBeat.o(140654);
                } else if (hVar.getCustomViewContainer() == null) {
                    Log.w("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
                    fVar.i(i2, d.this.h("fail:update view failed", null));
                    AppMethodBeat.o(140654);
                } else {
                    try {
                        int H = d.this.H(jSONObject);
                        boolean optBoolean = jSONObject.optBoolean("independent", false);
                        View viewById = hVar.gA(optBoolean).getViewById(H);
                        if (viewById == null) {
                            Log.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", Integer.valueOf(H));
                            fVar.i(i2, d.this.h("fail:got 'null' when get view by the given viewId", null));
                            AppMethodBeat.o(140654);
                            return;
                        }
                        if ((viewById instanceof CoverViewContainer) && jSONObject.has("draggable")) {
                            CoverViewContainer coverViewContainer = (CoverViewContainer) viewById;
                            coverViewContainer.a(jSONObject.optBoolean("draggable", false), H, coverViewContainer.lSX);
                            ((CoverViewContainer) viewById).setDragConfig(jSONObject.optString("dragConfig"));
                        }
                        d.a(d.this, hVar, H, jSONObject, optBoolean);
                        try {
                            z = hVar.gA(optBoolean).a(H, d.L(jSONObject), d.M(jSONObject), d.N(jSONObject), d.O(jSONObject));
                            Log.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", Integer.valueOf(hVar.gA(optBoolean).wE(H)), Integer.valueOf(H), Integer.valueOf(viewById.hashCode()), Boolean.valueOf(z));
                        } catch (JSONException e2) {
                            z = true;
                        }
                        boolean bEV = d.this.bEV();
                        if (z) {
                            if (bEV) {
                                z = d.this.b(hVar, H, viewById, jSONObject, new i(fVar, i2));
                            } else {
                                z = d.this.c(hVar, H, viewById, jSONObject);
                            }
                        }
                        if (!bEV) {
                            f fVar = fVar;
                            int i2 = i2;
                            d dVar = d.this;
                            if (z) {
                                str = "ok";
                            } else {
                                str = "fail";
                            }
                            fVar.i(i2, dVar.h(str, null));
                        }
                        AppMethodBeat.o(140654);
                    } catch (JSONException e3) {
                        fVar.i(i2, d.this.h("fail:view id do not exist", null));
                        AppMethodBeat.o(140654);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean c(CONTEXT context, int i2, View view, JSONObject jSONObject) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean b(CONTEXT context, int i2, View view, JSONObject jSONObject, i iVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean bEW() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bEV() {
        return false;
    }
}
