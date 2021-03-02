package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class j extends e {
    j() {
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(137613);
        super.bIo();
        AppMethodBeat.o(137613);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(137614);
        super.bIo();
        AppMethodBeat.o(137614);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ac(JSONObject jSONObject) {
        AppMethodBeat.i(137610);
        super.ac(jSONObject);
        AppMethodBeat.o(137610);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ad(JSONObject jSONObject) {
        AppMethodBeat.i(137611);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
            q("ok", null);
            P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(137602);
                    j.a(j.this);
                    AppMethodBeat.o(137602);
                }
            });
            AppMethodBeat.o(137611);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                strArr[i2] = optJSONArray.getString(i2);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", Util.stackTraceToString(e2));
                q("fail", null);
                AppMethodBeat.o(137611);
                return;
            }
        }
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(137603);
                j.a(j.this, strArr, optInt);
                AppMethodBeat.o(137603);
            }
        });
        AppMethodBeat.o(137611);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ae(JSONObject jSONObject) {
        AppMethodBeat.i(137612);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
            q("ok", null);
            P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(137604);
                    j.b(j.this);
                    AppMethodBeat.o(137604);
                }
            });
            AppMethodBeat.o(137612);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                strArr[i2] = optJSONArray.getString(i2);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", Util.stackTraceToString(e2));
                q("fail", null);
                AppMethodBeat.o(137612);
                return;
            }
        }
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(137605);
                j.b(j.this, strArr, optInt);
                AppMethodBeat.o(137605);
            }
        });
        AppMethodBeat.o(137612);
    }

    static /* synthetic */ void a(j jVar, String[] strArr, int i2) {
        AppMethodBeat.i(193691);
        final AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) jVar.aK(AppBrandOptionsPicker.class);
        if (appBrandOptionsPicker == null) {
            jVar.q("fail cant init view", null);
            AppMethodBeat.o(193691);
            return;
        }
        final a aVar = jVar.oza;
        aVar.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(137608);
                if (aVar.getPicker() != null && (aVar.getPicker() instanceof View)) {
                    ((View) aVar.getPicker()).requestLayout();
                }
                AppMethodBeat.o(137608);
            }
        });
        appBrandOptionsPicker.setOptionsArray(strArr);
        appBrandOptionsPicker.setValue(i2);
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137609);
                aVar.hide();
                if (!z) {
                    j.this.q("fail cancel", null);
                    AppMethodBeat.o(137609);
                    return;
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("value", appBrandOptionsPicker.currentValue());
                hashMap.put(FirebaseAnalytics.b.INDEX, Integer.valueOf(appBrandOptionsPicker.getValue()));
                j.this.q("ok", hashMap);
                AppMethodBeat.o(137609);
            }
        });
        aVar.show();
        AppMethodBeat.o(193691);
    }

    static /* synthetic */ void b(j jVar, String[] strArr, int i2) {
        AppMethodBeat.i(193692);
        final AppBrandOptionsPickerV3 appBrandOptionsPickerV3 = (AppBrandOptionsPickerV3) jVar.aK(AppBrandOptionsPickerV3.class);
        if (appBrandOptionsPickerV3 == null) {
            jVar.q("fail cant init view", null);
            AppMethodBeat.o(193692);
            return;
        }
        final a aVar = jVar.oza;
        aVar.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(137606);
                if (aVar.getPicker() != null && (aVar.getPicker() instanceof View)) {
                    ((View) aVar.getPicker()).requestLayout();
                }
                AppMethodBeat.o(137606);
            }
        });
        appBrandOptionsPickerV3.ozF = i2;
        appBrandOptionsPickerV3.init();
        appBrandOptionsPickerV3.setOptionsArray(strArr);
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.j.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137607);
                aVar.hide();
                if (!z) {
                    j.this.q("fail cancel", null);
                    AppMethodBeat.o(137607);
                    return;
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("value", appBrandOptionsPickerV3.currentValue());
                hashMap.put(FirebaseAnalytics.b.INDEX, Integer.valueOf(appBrandOptionsPickerV3.getValue()));
                j.this.q("ok", hashMap);
                AppMethodBeat.o(137607);
            }
        });
        aVar.setHeader(jVar.mmU);
        aVar.show();
        AppMethodBeat.o(193692);
    }
}
