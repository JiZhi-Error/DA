package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends a {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137601);
        b(hVar, jSONObject, i2);
        AppMethodBeat.o(137601);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a
    public final void b(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137600);
        new e() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.i.AnonymousClass1 */

            static /* synthetic */ c a(AnonymousClass1 r2, Class cls) {
                AppMethodBeat.i(193689);
                c aL = r2.aL(cls);
                AppMethodBeat.o(193689);
                return aL;
            }

            static /* synthetic */ c b(AnonymousClass1 r2, Class cls) {
                AppMethodBeat.i(193690);
                c aL = r2.aL(cls);
                AppMethodBeat.o(193690);
                return aL;
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
            public final void ac(JSONObject jSONObject) {
                AppMethodBeat.i(137597);
                super.ac(jSONObject);
                AppMethodBeat.o(137597);
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
            public final void ad(JSONObject jSONObject) {
                AppMethodBeat.i(137598);
                final int optInt = jSONObject.optInt("column", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                    q("fail:invalid data", null);
                    AppMethodBeat.o(137598);
                    return;
                }
                try {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = optJSONArray.getString(i2);
                    }
                    final AppBrandMultiOptionsPicker.a aVar = new AppBrandMultiOptionsPicker.a(strArr, jSONObject.optInt("current", 0));
                    P(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.r.i.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(137595);
                            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) AnonymousClass1.a(AnonymousClass1.this, AppBrandMultiOptionsPicker.class);
                            if (appBrandMultiOptionsPicker == null) {
                                AnonymousClass1.this.q("fail picker not exists", null);
                                AppMethodBeat.o(137595);
                                return;
                            }
                            int i2 = optInt;
                            AppBrandMultiOptionsPicker.a aVar = aVar;
                            if (i2 >= 0 && i2 < appBrandMultiOptionsPicker.getPickersCount() && aVar != null) {
                                appBrandMultiOptionsPicker.setLayoutFrozen(true);
                                appBrandMultiOptionsPicker.At(i2).setOptionsArray(aVar.ozw);
                                if (!Util.isNullOrNil(aVar.ozw)) {
                                    appBrandMultiOptionsPicker.At(i2).setValue(aVar.selected);
                                }
                                appBrandMultiOptionsPicker.setLayoutFrozen(false);
                            }
                            AnonymousClass1.this.q("ok", null);
                            AppMethodBeat.o(137595);
                        }
                    });
                    AppMethodBeat.o(137598);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e2, "opt params", new Object[0]);
                    q("fail:invalid data", null);
                    AppMethodBeat.o(137598);
                }
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
            public final void ae(JSONObject jSONObject) {
                AppMethodBeat.i(137599);
                final int optInt = jSONObject.optInt("column", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                    q("fail:invalid data", null);
                    AppMethodBeat.o(137599);
                    return;
                }
                try {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = optJSONArray.getString(i2);
                    }
                    final AppBrandMultiOptionsPickerV2.a aVar = new AppBrandMultiOptionsPickerV2.a(strArr, jSONObject.optInt("current", 0));
                    P(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.r.i.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(137596);
                            AppBrandMultiOptionsPickerV2 appBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2) AnonymousClass1.b(AnonymousClass1.this, AppBrandMultiOptionsPickerV2.class);
                            if (appBrandMultiOptionsPickerV2 == null) {
                                AnonymousClass1.this.q("fail picker not exists", null);
                                AppMethodBeat.o(137596);
                                return;
                            }
                            int i2 = optInt;
                            AppBrandMultiOptionsPickerV2.a aVar = aVar;
                            if (i2 >= 0 && i2 < appBrandMultiOptionsPickerV2.getPickersCount() && aVar != null) {
                                appBrandMultiOptionsPickerV2.setLayoutFrozen(true);
                                appBrandMultiOptionsPickerV2.Av(i2).setOptionsArray(aVar.ozw);
                                if (!Util.isNullOrNil(aVar.ozw)) {
                                    AppBrandOptionsPickerV3 Av = appBrandMultiOptionsPickerV2.Av(i2);
                                    Av.ozD.blh().setCurrentItem(aVar.selected);
                                }
                                appBrandMultiOptionsPickerV2.setLayoutFrozen(false);
                            }
                            AnonymousClass1.this.q("ok", null);
                            AppMethodBeat.o(137596);
                        }
                    });
                    AppMethodBeat.o(137599);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e2, "opt params", new Object[0]);
                    q("fail:invalid data", null);
                    AppMethodBeat.o(137599);
                }
            }
        }.a(this, hVar, jSONObject, i2, this.mmD);
        AppMethodBeat.o(137600);
    }
}
