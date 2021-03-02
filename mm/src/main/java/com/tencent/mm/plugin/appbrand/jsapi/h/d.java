package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends h {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136269);
        super.a(acVar, jSONObject, i2);
        AppMethodBeat.o(136269);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.widget.input.d.f, org.json.JSONObject, com.tencent.mm.plugin.appbrand.page.ac, int] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h, com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final /* bridge */ /* synthetic */ boolean a(e eVar, JSONObject jSONObject, ac acVar, int i2) {
        AppMethodBeat.i(136268);
        boolean a2 = a(eVar, jSONObject, acVar, i2);
        AppMethodBeat.o(136268);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136264);
        super.a(acVar, jSONObject, i2);
        AppMethodBeat.o(136264);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final boolean bGA() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final boolean bGB() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final boolean a(e eVar, JSONObject jSONObject, ac acVar, int i2) {
        AppMethodBeat.i(136265);
        if (!super.a(eVar, jSONObject, acVar, i2)) {
            AppMethodBeat.o(136265);
            return false;
        }
        eVar.oya = Boolean.TRUE;
        eVar.cKo = "emoji";
        eVar.cKr = false;
        eVar.oxG = false;
        eVar.oyb = Boolean.valueOf(jSONObject.optBoolean("confirm", true));
        eVar.oyq = Boolean.valueOf(jSONObject.optBoolean("showCoverView", false));
        AppMethodBeat.o(136265);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final void a(final i iVar) {
        AppMethodBeat.i(136266);
        super.a(iVar);
        iVar.JtW = new i.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i.c
            public final void ed(int i2, int i3) {
                ac acVar;
                AppMethodBeat.i(136258);
                int i4 = iVar.osn;
                ad.b JV = ad.aVe().JV("AppBrandJsInput@".concat(String.valueOf(i4)));
                if (JV == null) {
                    acVar = null;
                } else {
                    WeakReference weakReference = (WeakReference) JV.get("webview_reference", null);
                    acVar = weakReference == null ? null : (ac) weakReference.get();
                }
                if (acVar == null || !acVar.isRunning()) {
                    AppMethodBeat.o(136258);
                    return;
                }
                a aVar = new a((byte) 0);
                HashMap hashMap = new HashMap();
                hashMap.put("height", Integer.valueOf(g.zC(i3)));
                hashMap.put("lineCount", Integer.valueOf(i2));
                hashMap.put("inputId", Integer.valueOf(i4));
                aVar.g(acVar).L(hashMap).bEo();
                AppMethodBeat.o(136258);
            }
        };
        AppMethodBeat.o(136266);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.h
    public final i a(final WeakReference<ac> weakReference, final String str, final int i2) {
        AppMethodBeat.i(136267);
        AnonymousClass2 r0 = new x() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.d.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void a(String str, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(136259);
                if (weakReference.get() != null) {
                    try {
                        String jSONObject = new JSONObject().put("value", f.afI(str)).put("inputId", this.osn).put("cursor", i2).toString();
                        if (z) {
                            ((ac) weakReference.get()).c("onKeyboardConfirm", jSONObject, 0);
                        }
                        if (!z2) {
                            ((ac) weakReference.get()).c("onKeyboardComplete", jSONObject, 0);
                        }
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", Util.stackTraceToString(e2));
                    }
                    if (!z2) {
                        bGE();
                    }
                }
                AppMethodBeat.o(136259);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void bGC() {
                AppMethodBeat.i(136260);
                if (weakReference.get() != null) {
                    int i2 = this.osn;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i2));
                    ((ac) weakReference.get()).i(i2, d.this.n("ok", hashMap));
                    d.al(i2, str);
                    d.a(i2, (ac) weakReference.get());
                }
                AppMethodBeat.o(136260);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void ZN(String str) {
                AppMethodBeat.i(136261);
                ac acVar = (ac) weakReference.get();
                if (acVar == null) {
                    AppMethodBeat.o(136261);
                    return;
                }
                try {
                    int i2 = this.osn;
                    new h.a().b(acVar.getRuntime().NY(), acVar.getComponentId()).Zg(new JSONObject().put("value", f.afI(str)).put("data", d.xc(i2)).put("cursor", 0).put("inputId", i2).put("keyCode", 8).toString()).bEo();
                    AppMethodBeat.o(136261);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", e2);
                    AppMethodBeat.o(136261);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void bGD() {
                AppMethodBeat.i(136262);
                if (weakReference.get() != null) {
                    ((ac) weakReference.get()).i(i2, d.this.h("fail", null));
                    bGE();
                }
                AppMethodBeat.o(136262);
            }

            private void bGE() {
                AppMethodBeat.i(136263);
                ac acVar = (ac) weakReference.get();
                if (acVar == null || acVar.nmX == null) {
                    AppMethodBeat.o(136263);
                    return;
                }
                com.tencent.mm.plugin.appbrand.widget.input.h.cbe().e(acVar.nmX);
                AppMethodBeat.o(136263);
            }
        };
        AppMethodBeat.o(136267);
        return r0;
    }

    static final class a extends s {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
