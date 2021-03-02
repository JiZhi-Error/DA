package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends h> extends e<f> {
    static /* synthetic */ void a(b bVar, h hVar, int i2, View view, JSONObject jSONObject, boolean z) {
        if (bVar.bEW()) {
            ad.b L = hVar.gA(z).L(i2, true);
            L.H("disableScroll", jSONObject.optBoolean("disableScroll", false));
            L.H("enableLongClick", bVar.bEX());
            L.aK("data", jSONObject.optString("data"));
            if (!jSONObject.optBoolean("gesture", false)) {
                return;
            }
            if (hVar == null || view == null || L == null) {
                Log.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
            } else {
                view.setOnTouchListener(new d.a(hVar, L));
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(f fVar, final JSONObject jSONObject, int i2) {
        final h c2;
        g gVar = (g) fVar.M(g.class);
        if (gVar == null) {
            Log.e("MicroMsg.BaseInsertViewJsApi", "getComponentView NULL IComponentConverter");
            c2 = null;
        } else {
            c2 = gVar.c(fVar, jSONObject);
        }
        if (c2 == null) {
            Log.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
            fVar.i(i2, h("fail:ComponentView is null.", null));
            return;
        }
        final i iVar = new i(fVar, i2);
        c2.P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.base.b.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.b */
            /* JADX DEBUG: Multi-variable search result rejected for r1v29, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.b */
            /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: com.tencent.mm.plugin.appbrand.jsapi.base.b */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                boolean z;
                String str;
                AppMethodBeat.i(140651);
                if (!c2.bsV() && !c2.isRunning()) {
                    Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
                    AppMethodBeat.o(140651);
                } else if (c2.getCustomViewContainer() == null) {
                    Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component custom view container is null");
                    iVar.ZA(b.this.h("fail:insert view failed", null));
                    AppMethodBeat.o(140651);
                } else {
                    try {
                        int H = b.this.H(jSONObject);
                        View a2 = b.this.a(c2, jSONObject, H);
                        if (a2 == null) {
                            Log.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                            iVar.ZA(b.this.h("fail:inflate view failed", null));
                            AppMethodBeat.o(140651);
                            return;
                        }
                        boolean optBoolean = jSONObject.optBoolean("independent", false);
                        if ((a2 instanceof CoverViewContainer) && jSONObject.has("draggable")) {
                            ((CoverViewContainer) a2).a(jSONObject.optBoolean("draggable", false), H, jSONObject.optString("data"));
                            ((CoverViewContainer) a2).setDragConfig(jSONObject.optString("dragConfig"));
                        }
                        if (c2.gA(optBoolean).wD(H)) {
                            Log.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", Integer.valueOf(H));
                            iVar.ZA(b.this.h("fail:the view has already exist", null));
                            AppMethodBeat.o(140651);
                            return;
                        }
                        int optInt = jSONObject.optInt("parentId", 0);
                        try {
                            float[] L = b.L(jSONObject);
                            int M = b.M(jSONObject);
                            Boolean N = b.N(jSONObject);
                            Boolean O = b.O(jSONObject);
                            Boolean I = b.this.I(jSONObject);
                            z = c2.gA(optBoolean).a(a2, H, optInt, L, M, N != null && N.booleanValue(), O != null && O.booleanValue(), I != null && I.booleanValue());
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", e2);
                            z = false;
                        }
                        boolean bEV = b.this.bEV();
                        if (z) {
                            b.a(b.this, c2, H, a2, jSONObject, optBoolean);
                            if (bEV) {
                                b.this.a(c2, H, a2, jSONObject, iVar);
                            } else {
                                b.this.a(c2, H, a2, jSONObject);
                            }
                        }
                        b bVar = b.this;
                        h hVar = c2;
                        ad.b L2 = hVar.gA(optBoolean).L(H, true);
                        if (((i.c) L2.get("baseViewDestroyListener", null)) == null) {
                            AnonymousClass2 r7 = new i.c(hVar, optBoolean, H, L2) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.base.b.AnonymousClass2 */
                                final /* synthetic */ ad.b lEe;
                                final /* synthetic */ h lJT;
                                final /* synthetic */ boolean lJW;
                                final /* synthetic */ int lJX;

                                {
                                    this.lJT = r2;
                                    this.lJW = r3;
                                    this.lJX = r4;
                                    this.lEe = r5;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                                public final void onDestroy() {
                                    AppMethodBeat.i(140652);
                                    this.lJT.gA(this.lJW).wC(this.lJX);
                                    this.lEe.recycle();
                                    System.gc();
                                    AppMethodBeat.o(140652);
                                }
                            };
                            L2.l("baseViewDestroyListener", r7);
                            hVar.a(r7);
                        }
                        Log.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", Integer.valueOf(optInt), Integer.valueOf(H), Integer.valueOf(a2.hashCode()), Boolean.valueOf(z));
                        if (!bEV) {
                            i iVar = iVar;
                            b bVar2 = b.this;
                            if (z) {
                                str = "ok";
                            } else {
                                str = "fail:insert view fail";
                            }
                            iVar.ZA(bVar2.h(str, null));
                        }
                        AppMethodBeat.o(140651);
                    } catch (JSONException e3) {
                        iVar.ZA(b.this.h("fail:invalid view id", null));
                        AppMethodBeat.o(140651);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public View a(CONTEXT context, JSONObject jSONObject, int i2) {
        return a(context, jSONObject);
    }

    /* access modifiers changed from: protected */
    public View a(CONTEXT context, JSONObject jSONObject) {
        throw new IllegalStateException("inflateView must be inflated.".concat(String.valueOf(this)));
    }

    /* access modifiers changed from: protected */
    public void a(CONTEXT context, int i2, View view, JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    public void a(CONTEXT context, int i2, View view, JSONObject jSONObject, i iVar) {
    }

    /* access modifiers changed from: protected */
    public boolean bEV() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bEW() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bEX() {
        return false;
    }
}
