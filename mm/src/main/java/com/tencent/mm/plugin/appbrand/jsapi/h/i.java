package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.graphics.Rect;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public /* bridge */ /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136293);
        a(acVar, jSONObject, i2);
        AppMethodBeat.o(136293);
    }

    public void a(final ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136292);
        final h hVar = new h();
        if (!a(hVar, jSONObject, acVar, i2)) {
            AppMethodBeat.o(136292);
            return;
        }
        try {
            final int i3 = jSONObject.getInt("inputId");
            if (hVar.oxK != null && hVar.oxK.intValue() < 0) {
                hVar.oxK = 0;
            }
            if (hVar.oxL != null && hVar.oxL.intValue() < 0) {
                hVar.oxL = 0;
            }
            String optString = jSONObject.optString("data", null);
            if (optString != null) {
                al(i3, optString);
            }
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.h.i.AnonymousClass1 */

                public final void run() {
                    c cVar;
                    boolean z;
                    ac acVar;
                    g gVar;
                    AppMethodBeat.i(136291);
                    j cbp = j.a.cbp();
                    ac acVar2 = acVar;
                    int i2 = i3;
                    h hVar = hVar;
                    aa a2 = e.a(acVar2, new e.a(i2) {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass1 */
                        final /* synthetic */ int lWD;

                        {
                            this.lWD = r2;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.widget.input.e.a
                        public final boolean a(aa aaVar) {
                            AppMethodBeat.i(136380);
                            if (aaVar.caV() == null || ((ab) aaVar.caV()).getInputId() != this.lWD) {
                                AppMethodBeat.o(136380);
                                return false;
                            }
                            AppMethodBeat.o(136380);
                            return true;
                        }
                    });
                    if (a2 instanceof c) {
                        cVar = (c) a2;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        if (hVar.oxJ != null) {
                            cVar.afY(hVar.oxJ);
                        }
                        cVar.a(hVar);
                        EditText caS = cVar.caS();
                        if (!(caS == null || (acVar = cVar.orG.get()) == null || acVar.nmX == null || (gVar = (g) acVar.bRe()) == null)) {
                            Rect caT = cVar.caT();
                            gVar.c(acVar.nmX, caS, caT.width(), caT.height(), caT.left, caT.top);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        acVar.i(i2, i.this.h("ok", null));
                        AppMethodBeat.o(136291);
                        return;
                    }
                    aa a3 = o.a(acVar, i3);
                    if (a3 instanceof com.tencent.mm.plugin.appbrand.widget.input.i) {
                        com.tencent.mm.plugin.appbrand.widget.input.i iVar = (com.tencent.mm.plugin.appbrand.widget.input.i) a3;
                        h hVar2 = hVar;
                        if (!(iVar.Juf == null || iVar.Juh == null)) {
                            iVar.Juf.a(hVar2);
                            if (iVar.Juf.oxH || (iVar.Juf.oxL != null && iVar.Juf.oxL.intValue() > 0)) {
                                iVar.Juh.setWillNotDraw(true);
                                iVar.ccw();
                                if (iVar.Juf.oxJ != null) {
                                    iVar.Juh.G(Util.nullAsNil(iVar.Juf.oxJ));
                                }
                                if (!aj.i(iVar.Juf.oyc)) {
                                    iVar.b(iVar.Juh, iVar.Juf);
                                } else {
                                    i.AnonymousClass1 r1 = new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.widget.input.i.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(136359);
                                            i.this.cbo();
                                            i.this.cEK();
                                            AppMethodBeat.o(136359);
                                        }
                                    };
                                    if (iVar.Juh.getLayout() == null) {
                                        iVar.Juh.post(r1);
                                    } else {
                                        r1.run();
                                    }
                                }
                                iVar.Juh.setWillNotDraw(false);
                                iVar.Juh.invalidate();
                            }
                        }
                        acVar.i(i2, i.this.h("ok", null));
                        AppMethodBeat.o(136291);
                        return;
                    }
                    Log.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", Integer.valueOf(i3)));
                    acVar.i(i2, i.this.h(String.format(Locale.US, "fail found no input with %d", Integer.valueOf(i3)), null));
                    AppMethodBeat.o(136291);
                }
            });
            AppMethodBeat.o(136292);
        } catch (JSONException e2) {
            acVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(136292);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final boolean bGz() {
        return true;
    }
}
