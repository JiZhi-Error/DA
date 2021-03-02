package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.ae;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a<e> {
    public static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    public static final class a extends s {
        public static final int CTRL_INDEX = 78;
        public static final String NAME = "onKeyboardValueChange";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public /* bridge */ /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136289);
        a(acVar, jSONObject, i2);
        AppMethodBeat.o(136289);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.widget.input.d.f, org.json.JSONObject, com.tencent.mm.plugin.appbrand.page.ac, int] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public /* bridge */ /* synthetic */ boolean a(e eVar, JSONObject jSONObject, ac acVar, int i2) {
        AppMethodBeat.i(136288);
        boolean a2 = a(eVar, jSONObject, acVar, i2);
        AppMethodBeat.o(136288);
        return a2;
    }

    public void a(final ac acVar, JSONObject jSONObject, final int i2) {
        final int i3;
        final int i4;
        AppMethodBeat.i(136285);
        int optInt = jSONObject.optInt("cursor", -2);
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            i4 = jSONObject.optInt("selectionStart", -2);
            i3 = jSONObject.optInt("selectionEnd", -2);
        } else {
            i3 = optInt;
            i4 = optInt;
        }
        try {
            final int i5 = jSONObject.getInt("inputId");
            if (bGA()) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(136275);
                        if (o.a(acVar, i5, i4, i3)) {
                            acVar.i(i2, h.this.h("ok", null));
                            AppMethodBeat.o(136275);
                            return;
                        }
                        acVar.i(i2, h.this.h("fail:invalid data", null));
                        AppMethodBeat.o(136275);
                    }
                });
                AppMethodBeat.o(136285);
                return;
            }
        } catch (JSONException e2) {
        }
        final e eVar = new e();
        if (!a(eVar, jSONObject, acVar, i2)) {
            AppMethodBeat.o(136285);
            return;
        }
        if (!jSONObject.has("inputId")) {
            eVar.orE = (acVar.hashCode() + "#" + System.currentTimeMillis() + "#" + System.nanoTime()).hashCode();
            a(eVar.orE, 0, acVar);
        }
        final String optString = jSONObject.optString("data");
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(136276);
                h.a(h.this, acVar, i4, i3, optString, eVar, i2);
                AppMethodBeat.o(136276);
            }
        });
        AppMethodBeat.o(136285);
    }

    /* access modifiers changed from: protected */
    public boolean bGA() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean bGB() {
        return true;
    }

    static void a(int i2, int i3, ac acVar) {
        AppMethodBeat.i(230570);
        try {
            acVar.c("onKeyboardShow", com.tencent.mm.ab.h.ayS().T("inputId", i2).T("height", g.zB(i3)).toString(), 0);
            AppMethodBeat.o(230570);
        } catch (com.tencent.mm.ab.g e2) {
            Log.e("MicroMsg.JsApiShowKeyboard", "", e2.getMessage());
            AppMethodBeat.o(230570);
        }
    }

    /* access modifiers changed from: protected */
    public void a(i iVar) {
    }

    /* access modifiers changed from: protected */
    public i a(final WeakReference<ac> weakReference, final String str, final int i2) {
        AppMethodBeat.i(136286);
        AnonymousClass6 r0 = new i() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void a(String str, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(136280);
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
                        Log.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", Util.stackTraceToString(e2));
                    }
                    if (!z2) {
                        bGE();
                    }
                }
                AppMethodBeat.o(136280);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void bGC() {
                AppMethodBeat.i(136281);
                if (weakReference.get() != null) {
                    int i2 = this.osn;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i2));
                    ((ac) weakReference.get()).i(i2, h.this.n("ok", hashMap));
                    h.al(i2, str);
                    h.a(i2, (ac) weakReference.get());
                }
                AppMethodBeat.o(136281);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void bGD() {
                AppMethodBeat.i(136282);
                if (weakReference.get() != null) {
                    ((ac) weakReference.get()).i(i2, h.this.h("fail", null));
                    bGE();
                }
                AppMethodBeat.o(136282);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i
            public final void ZN(String str) {
                AppMethodBeat.i(136283);
                ac acVar = (ac) weakReference.get();
                if (acVar == null) {
                    AppMethodBeat.o(136283);
                    return;
                }
                try {
                    int i2 = this.osn;
                    new a().b(acVar.getRuntime().NY(), acVar.getComponentId()).Zg(new JSONObject().put("value", f.afI(str)).put("data", h.xc(i2)).put("cursor", 0).put("inputId", i2).put("keyCode", 8).toString()).bEo();
                    AppMethodBeat.o(136283);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", e2);
                    AppMethodBeat.o(136283);
                }
            }

            private void bGE() {
                AppMethodBeat.i(136284);
                ac acVar = (ac) weakReference.get();
                if (acVar == null || acVar.nmX == null) {
                    AppMethodBeat.o(136284);
                    return;
                }
                com.tencent.mm.plugin.appbrand.widget.input.h.cbe().e(acVar.nmX);
                AppMethodBeat.o(136284);
            }
        };
        AppMethodBeat.o(136286);
        return r0;
    }

    /* access modifiers changed from: protected */
    public boolean a(e eVar, JSONObject jSONObject, ac acVar, int i2) {
        JSONObject optJSONObject;
        AppMethodBeat.i(136287);
        if (!super.a((com.tencent.mm.plugin.appbrand.widget.input.d.f) eVar, jSONObject, acVar, i2)) {
            AppMethodBeat.o(136287);
            return false;
        }
        eVar.oxF = jSONObject.optInt("parentId");
        eVar.orE = jSONObject.optInt("inputId");
        eVar.oxK = Integer.valueOf(Math.max(0, eVar.oxK.intValue()));
        eVar.oxL = Integer.valueOf(eVar.oxL == null ? 0 : Math.max(0, eVar.oxL.intValue()));
        eVar.cKo = jSONObject.optString("type", "text");
        if (!o.otm.contains(eVar.cKo)) {
            acVar.i(i2, h("fail:unsupported input type", null));
            AppMethodBeat.o(136287);
            return false;
        }
        if (eVar.oyh == null) {
            eVar.oyh = Boolean.TRUE;
        }
        eVar.cKr = jSONObject.optBoolean("password");
        eVar.oyp = Boolean.valueOf(jSONObject.optBoolean("password"));
        if (jSONObject.has("showCoverView")) {
            eVar.oyq = Boolean.valueOf(jSONObject.optBoolean("showCoverView", false));
        }
        if (bGB() && (optJSONObject = jSONObject.optJSONObject("dropdown")) != null) {
            a.C0823a aVar = new a.C0823a();
            aVar.oxq = optJSONObject.optInt("marginLeft");
            aVar.oxr = optJSONObject.optInt("marginRight");
            aVar.oxs = optJSONObject.optString("width");
            JSONArray optJSONArray = optJSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                aVar.oxt = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("id");
                        String optString2 = optJSONObject2.optString("title");
                        String optString3 = optJSONObject2.optString("content");
                        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
                            a.b bVar = new a.b();
                            bVar.id = optString;
                            bVar.title = optString2;
                            bVar.content = optString3;
                            aVar.oxt.add(bVar);
                        }
                    }
                }
                eVar.oxI = aVar;
            }
        }
        AppMethodBeat.o(136287);
        return true;
    }

    static /* synthetic */ void a(h hVar, final ac acVar, final int i2, final int i3, String str, final e eVar, int i4) {
        boolean z;
        Integer valueOf;
        AppMethodBeat.i(136290);
        j cbp = j.a.cbp();
        c a2 = c.a.a(eVar.cKo, acVar, eVar);
        if (a2 == null) {
            valueOf = null;
        } else {
            if (eVar.oxJ != null) {
                a2.afY(eVar.oxJ);
            }
            a2.a(eVar);
            if (eVar.oxI != null) {
                a.C0823a aVar = eVar.oxI;
                ac acVar2 = a2.orG.get();
                if (!(acVar2 == null || a2.caS() == null)) {
                    d.a(acVar2, a2.caS(), aVar);
                }
            }
            int intValue = eVar.oxK.intValue();
            int intValue2 = eVar.oxL.intValue();
            int intValue3 = eVar.oxN.intValue();
            int intValue4 = eVar.oxM.intValue();
            ac acVar3 = a2.orG.get();
            if (acVar3 == null || acVar3.nmX == null) {
                z = false;
            } else {
                EditText caS = a2.caS();
                if (caS == null) {
                    z = false;
                } else {
                    com.tencent.mm.plugin.appbrand.widget.input.g gVar = (com.tencent.mm.plugin.appbrand.widget.input.g) acVar3.bRe();
                    if (gVar == null) {
                        z = false;
                    } else {
                        boolean a3 = gVar.a(acVar3.nmX, caS, intValue, intValue2, intValue3, intValue4);
                        if (a3) {
                            ((ab) caS).a(a2.JtR);
                            caS.addTextChangedListener(a2);
                        }
                        z = a3;
                    }
                }
            }
            if (!z) {
                valueOf = null;
            } else if (!a2.q(i2, i3, acVar.kEb.OG())) {
                valueOf = null;
            } else {
                WeakReference weakReference = new WeakReference(acVar);
                int i5 = a2.orE;
                ((ab) a2.caS()).setOnKeyUpPostImeListener(new ab.b(weakReference, a2, str) {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass2 */
                    final /* synthetic */ WeakReference lWB;
                    final /* synthetic */ c osM;
                    final /* synthetic */ String osN;

                    {
                        this.lWB = r2;
                        this.osM = r3;
                        this.osN = r4;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab.b
                    public final boolean Aa(int i2) {
                        AppMethodBeat.i(136381);
                        if (i2 == 67) {
                            ac acVar = (ac) this.lWB.get();
                            if (acVar != null) {
                                try {
                                    int i3 = this.osM.orE;
                                    new h.a().b(acVar.getRuntime().NY(), acVar.getComponentId()).Zg(new JSONObject().put("value", this.osM.caS().getText().toString()).put("data", this.osN).put("cursor", 0).put("inputId", i3).put("keyCode", 8).toString()).bEo();
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", e2);
                                }
                            }
                            AppMethodBeat.o(136381);
                            return true;
                        }
                        AppMethodBeat.o(136381);
                        return false;
                    }
                });
                a2.JtN = new af(weakReference, a2, i5, str) {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass3 */
                    final /* synthetic */ WeakReference lWB;
                    final /* synthetic */ int lWD;
                    final /* synthetic */ c osM;
                    final /* synthetic */ String osN;

                    {
                        this.lWB = r2;
                        this.osM = r3;
                        this.lWD = r4;
                        this.osN = r5;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.af
                    public final void a(String str, int i2, af.a aVar) {
                        String str2;
                        AppMethodBeat.i(136382);
                        try {
                            ac acVar = (ac) this.lWB.get();
                            if (acVar == null) {
                                AppMethodBeat.o(136382);
                                return;
                            }
                            JSONObject put = new JSONObject().put("value", str).put("keyCode", (int) ((ab) this.osM.caS()).getLastKeyPressed()).put("inputId", this.lWD).put("cursor", i2);
                            if (af.a.CHANGED.equals(aVar)) {
                                h.a aVar2 = new h.a();
                                aVar2.b(acVar.getRuntime().NY(), acVar.getComponentId()).bEo();
                                aVar2.Zg(put.put("data", this.osN).toString());
                                aVar2.bEo();
                                AppMethodBeat.o(136382);
                                return;
                            }
                            switch (AnonymousClass5.osO[aVar.ordinal()]) {
                                case 1:
                                    str2 = "onKeyboardComplete";
                                    break;
                                case 2:
                                    str2 = "onKeyboardConfirm";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (Util.isNullOrNil(str2)) {
                                AppMethodBeat.o(136382);
                                return;
                            }
                            acVar.c(str2, put.toString(), 0);
                            AppMethodBeat.o(136382);
                        } catch (Exception e2) {
                            AppMethodBeat.o(136382);
                        }
                    }
                };
                a2.JtO = new ae(weakReference, i5) {
                    /* class com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass4 */
                    final /* synthetic */ WeakReference lWB;
                    final /* synthetic */ int lWD;

                    {
                        this.lWB = r2;
                        this.lWD = r3;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.widget.input.ae
                    public final void Ab(int i2) {
                        AppMethodBeat.i(136383);
                        try {
                            ac acVar = (ac) this.lWB.get();
                            if (acVar == null) {
                                AppMethodBeat.o(136383);
                                return;
                            }
                            acVar.c("onKeyboardShow", com.tencent.mm.ab.h.ayS().T("inputId", this.lWD).T("height", g.zB(i2)).toString(), 0);
                            new com.tencent.mm.plugin.appbrand.jsapi.af().a(i2, acVar.NY(), acVar, Integer.valueOf(this.lWD));
                            AppMethodBeat.o(136383);
                        } catch (Exception e2) {
                            AppMethodBeat.o(136383);
                        }
                    }
                };
                com.tencent.mm.plugin.appbrand.widget.input.e.a(acVar, a2);
                valueOf = Integer.valueOf(i5);
            }
        }
        if (valueOf != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("inputId", valueOf);
            acVar.i(i4, hVar.n("ok", hashMap));
            AppMethodBeat.o(136290);
            return;
        }
        final String appId = acVar.getAppId();
        acVar.getComponentId();
        final WeakReference<ac> weakReference2 = new WeakReference<>(acVar);
        eVar.orG = weakReference2;
        final i a4 = hVar.a(weakReference2, str, i4);
        a4.Juo.owK = new com.tencent.mm.plugin.appbrand.widget.input.c.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.c.c
            public final void bL(String str, int i2) {
                AppMethodBeat.i(136277);
                int i3 = a4.osn;
                if (a4.Juh == null) {
                    Log.e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", appId);
                    AppMethodBeat.o(136277);
                    return;
                }
                a aVar = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("value", f.afI(str));
                hashMap.put("data", h.xc(i3));
                hashMap.put("cursor", Integer.valueOf(i2));
                hashMap.put("inputId", Integer.valueOf(i3));
                hashMap.put("keyCode", Integer.valueOf(a4.Juh.getLastKeyPressed()));
                aVar.b(acVar.getRuntime().NY(), acVar.getComponentId()).L(hashMap).bEo();
                AppMethodBeat.o(136277);
            }
        };
        a4.JtZ = new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.i.b
            public final void a(aa aaVar, int i2) {
                AppMethodBeat.i(136278);
                try {
                    ac acVar = (ac) weakReference2.get();
                    if (acVar == null) {
                        AppMethodBeat.o(136278);
                        return;
                    }
                    h.a(aaVar.getInputId(), i2, acVar);
                    new com.tencent.mm.plugin.appbrand.jsapi.af().a(i2, acVar.NY(), acVar, Integer.valueOf(aaVar.getInputId()));
                    AppMethodBeat.o(136278);
                } catch (Exception e2) {
                    AppMethodBeat.o(136278);
                }
            }
        };
        hVar.a(a4);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.h.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(136279);
                ac acVar = (ac) weakReference2.get();
                if (acVar == null || acVar.nmX == null) {
                    AppMethodBeat.o(136279);
                    return;
                }
                i iVar = a4;
                e eVar = eVar;
                int i2 = i2;
                int i3 = i3;
                iVar.Juf = eVar;
                ac acVar2 = eVar.orG.get();
                if (acVar2 != null) {
                    new l(acVar2);
                }
                iVar.ht(i2, i3);
                AppMethodBeat.o(136279);
            }
        });
        AppMethodBeat.o(136290);
    }
}
