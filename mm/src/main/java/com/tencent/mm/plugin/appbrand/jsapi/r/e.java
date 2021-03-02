package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends b {
    private static q.a mmV = a.ogC;
    private int csv;
    private p lAi;
    private boolean mmD;
    private WeakReference<h> mmT;
    String mmU;

    /* access modifiers changed from: package-private */
    public abstract void ad(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public abstract void ae(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public final void P(Runnable runnable) {
        h hVar = this.mmT == null ? null : this.mmT.get();
        if (hVar != null) {
            hVar.P(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void ac(JSONObject jSONObject) {
        if (this.mmD) {
            this.mmU = jSONObject.optString("headerText");
            ae(jSONObject);
            return;
        }
        ad(jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final void a(p pVar, h hVar, JSONObject jSONObject, int i2, boolean z) {
        this.lAi = pVar;
        this.mmT = new WeakReference<>(hVar);
        this.csv = i2;
        this.mmD = z;
        ac(jSONObject);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.b
    public final View bIn() {
        try {
            return this.mmT.get().getCustomViewContainer().getRootView();
        } catch (NullPointerException e2) {
            Log.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(bc bcVar) {
        h hVar = this.mmT == null ? null : this.mmT.get();
        if (hVar != null) {
            bcVar.h(hVar).bEo();
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(String str, Map<String, Object> map) {
        if (this.mmT != null && this.mmT.get() != null && this.lAi != null) {
            this.mmT.get().i(this.csv, this.lAi.n(str, map));
        }
    }

    /* access modifiers changed from: package-private */
    public final void bIo() {
        if (((AppBrandEmptyPickerView) aK(AppBrandEmptyPickerView.class)) == null) {
            Log.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
            return;
        }
        this.oza.setOnResultListener(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final void a(boolean z, Object obj) {
                AppMethodBeat.i(137579);
                e.this.oza.hide();
                AppMethodBeat.o(137579);
            }
        });
        this.oza.show();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.b
    public final com.tencent.mm.plugin.appbrand.widget.picker.a dR(Context context) {
        h hVar;
        com.tencent.mm.plugin.appbrand.widget.picker.a dR = super.dR(context);
        Log.d("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
        if (!(dR == null || this.mmT == null || (hVar = this.mmT.get()) == null)) {
            dR.setOrientationGetter(mmV.a(hVar));
        }
        return dR;
    }

    public static void a(q.a aVar) {
        mmV = aVar;
    }
}
