package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137591);
        b(hVar, jSONObject, i2);
        AppMethodBeat.o(137591);
    }

    /* access modifiers changed from: package-private */
    public final class c extends e implements Runnable {
        private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> mmX;

        private c() {
            AppMethodBeat.i(137586);
            this.mmX = new AtomicReference<>();
            AppMethodBeat.o(137586);
        }

        /* synthetic */ c(g gVar, byte b2) {
            this();
        }

        static /* synthetic */ void a(c cVar) {
            AppMethodBeat.i(137589);
            super.bIo();
            AppMethodBeat.o(137589);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ac(JSONObject jSONObject) {
            AppMethodBeat.i(137587);
            super.ac(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                q("fail:invalid data", null);
                AppMethodBeat.o(137587);
            } else if (optJSONArray.length() <= 0) {
                q("ok", null);
                Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                P(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(137582);
                        c.this.bIo();
                        AppMethodBeat.o(137582);
                    }
                });
                AppMethodBeat.o(137587);
            } else {
                try {
                    AppBrandMultiOptionsPickerV2.a[] aVarArr = new AppBrandMultiOptionsPickerV2.a[optJSONArray.length()];
                    boolean z = true;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        aVarArr[i2] = g.a(jSONArray, optJSONArray2.getInt(i2));
                        z &= jSONArray.length() <= 0;
                    }
                    if (z) {
                        q("ok", null);
                        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.c.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(137583);
                                c.a(c.this);
                                AppMethodBeat.o(137583);
                            }
                        });
                        AppMethodBeat.o(137587);
                        return;
                    }
                    this.mmX.set(aVarArr);
                    P(this);
                    AppMethodBeat.o(137587);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e2, "opt params", new Object[0]);
                    q("fail:invalid data", null);
                    AppMethodBeat.o(137587);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ad(JSONObject jSONObject) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ae(JSONObject jSONObject) {
        }

        public final void run() {
            AppMethodBeat.i(137588);
            AppBrandMultiOptionsPickerV2 appBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2) aK(AppBrandMultiOptionsPickerV2.class);
            if (appBrandMultiOptionsPickerV2 == null) {
                q("fail cant init view", null);
                AppMethodBeat.o(137588);
                return;
            }
            AppBrandMultiOptionsPickerV2.a[] aVarArr = this.mmX.get();
            if (aVarArr == null || aVarArr.length <= 0) {
                q("fail error data", null);
                AppMethodBeat.o(137588);
                return;
            }
            if (aVarArr != null && aVarArr.length > 0) {
                int pickersCount = appBrandMultiOptionsPickerV2.getPickersCount();
                appBrandMultiOptionsPickerV2.setLayoutFrozen(true);
                if (pickersCount < aVarArr.length) {
                    int length = aVarArr.length - pickersCount;
                    if (length > 0) {
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = aVarArr[i2].selected;
                            AppBrandOptionsPickerV3 appBrandOptionsPickerV3 = new AppBrandOptionsPickerV3(appBrandMultiOptionsPickerV2.getContext());
                            appBrandOptionsPickerV3.ozF = i3;
                            appBrandOptionsPickerV3.init();
                            appBrandOptionsPickerV3.setDividerHeight((float) appBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(R.dimen.tv));
                            appBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(R.dimen.afs);
                            appBrandMultiOptionsPickerV2.ozx.add(appBrandOptionsPickerV3);
                            appBrandMultiOptionsPickerV2.addView(appBrandOptionsPickerV3.ozD.blh(), new LinearLayout.LayoutParams(-1, -2, 1.0f));
                        }
                        appBrandMultiOptionsPickerV2.ccr();
                    }
                } else if (pickersCount > aVarArr.length) {
                    appBrandMultiOptionsPickerV2.Au(pickersCount - aVarArr.length);
                }
                for (int i4 = 0; i4 < aVarArr.length; i4++) {
                    AppBrandOptionsPickerV3 Av = appBrandMultiOptionsPickerV2.Av(i4);
                    AppBrandMultiOptionsPickerV2.a aVar = aVarArr[i4];
                    Av.setOptionsArray(aVar.ozw);
                    Av.ozF = aVar.selected;
                    Av.ozD.a(new com.tencent.mm.picker.d.b(i4) {
                        /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.AnonymousClass1 */
                        final /* synthetic */ int ozy;

                        {
                            this.ozy = r2;
                        }

                        @Override // com.tencent.mm.picker.d.b
                        public final void uO(int i2) {
                            AppMethodBeat.i(138005);
                            if (AppBrandMultiOptionsPickerV2.this.ozt != null) {
                                AppBrandMultiOptionsPickerV2.this.ozt.cY(new int[]{this.ozy, i2});
                            }
                            AppMethodBeat.o(138005);
                        }
                    });
                }
                appBrandMultiOptionsPickerV2.setWeightSum((float) appBrandMultiOptionsPickerV2.getPickersCount());
                appBrandMultiOptionsPickerV2.setLayoutFrozen(false);
            }
            this.oza.setOnResultListener(new c.a<int[]>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.c.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
                public final /* synthetic */ void a(boolean z, int[] iArr) {
                    AppMethodBeat.i(137584);
                    int[] iArr2 = iArr;
                    c.this.oza.hide();
                    if (!z) {
                        c.this.q("fail cancel", null);
                        AppMethodBeat.o(137584);
                    } else if (iArr2 == null || iArr2.length <= 0) {
                        c.this.q("fail error result", null);
                        AppMethodBeat.o(137584);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 : iArr2) {
                            jSONArray.put(i2);
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("current", jSONArray);
                        c.this.q("ok", hashMap);
                        AppMethodBeat.o(137584);
                    }
                }
            });
            this.oza.setOnValueUpdateListener(new c.b<int[]>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.c.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.b
                public final /* synthetic */ void cH(int[] iArr) {
                    AppMethodBeat.i(137585);
                    int[] iArr2 = iArr;
                    int i2 = iArr2[0];
                    int i3 = iArr2[1];
                    a aVar = new a((byte) 0);
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("column", Integer.valueOf(i2));
                    hashMap.put("current", Integer.valueOf(i3));
                    aVar.L(hashMap);
                    c.this.b(aVar);
                    AppMethodBeat.o(137585);
                }
            });
            this.oza.setHeader(this.mmU);
            this.oza.show();
            AppMethodBeat.o(137588);
        }
    }

    /* access modifiers changed from: package-private */
    public final class b extends e implements Runnable {
        private final AtomicReference<AppBrandMultiOptionsPicker.a[]> mmX;

        private b() {
            AppMethodBeat.i(193684);
            this.mmX = new AtomicReference<>();
            AppMethodBeat.o(193684);
        }

        /* synthetic */ b(g gVar, byte b2) {
            this();
        }

        static /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(193687);
            super.bIo();
            AppMethodBeat.o(193687);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ac(JSONObject jSONObject) {
            AppMethodBeat.i(193685);
            super.ac(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                q("fail:invalid data", null);
                AppMethodBeat.o(193685);
            } else if (optJSONArray.length() <= 0) {
                q("ok", null);
                Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                P(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(193680);
                        b.this.bIo();
                        AppMethodBeat.o(193680);
                    }
                });
                AppMethodBeat.o(193685);
            } else {
                try {
                    AppBrandMultiOptionsPicker.a[] aVarArr = new AppBrandMultiOptionsPicker.a[optJSONArray.length()];
                    boolean z = true;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        aVarArr[i2] = g.b(jSONArray, optJSONArray2.getInt(i2));
                        z &= jSONArray.length() <= 0;
                    }
                    if (z) {
                        q("ok", null);
                        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(193681);
                                b.a(b.this);
                                AppMethodBeat.o(193681);
                            }
                        });
                        AppMethodBeat.o(193685);
                        return;
                    }
                    this.mmX.set(aVarArr);
                    P(this);
                    AppMethodBeat.o(193685);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e2, "opt params", new Object[0]);
                    q("fail:invalid data", null);
                    AppMethodBeat.o(193685);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ad(JSONObject jSONObject) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
        public final void ae(JSONObject jSONObject) {
        }

        public final void run() {
            AppMethodBeat.i(193686);
            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) aK(AppBrandMultiOptionsPicker.class);
            if (appBrandMultiOptionsPicker == null) {
                q("fail cant init view", null);
                AppMethodBeat.o(193686);
                return;
            }
            AppBrandMultiOptionsPicker.a[] aVarArr = this.mmX.get();
            if (aVarArr == null || aVarArr.length <= 0) {
                q("fail error data", null);
                AppMethodBeat.o(193686);
                return;
            }
            if (aVarArr != null && aVarArr.length > 0) {
                int pickersCount = appBrandMultiOptionsPicker.getPickersCount();
                appBrandMultiOptionsPicker.setLayoutFrozen(true);
                if (pickersCount < aVarArr.length) {
                    int length = aVarArr.length - pickersCount;
                    if (length > 0) {
                        while (length > 0) {
                            AppBrandMultiOptionsPicker.AnonymousClass2 r4 = new AppBrandOptionsPickerV2(appBrandMultiOptionsPicker.getContext()) {
                                /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.AnonymousClass2 */
                            };
                            r4.setOnValueChangedListener(appBrandMultiOptionsPicker.ozu);
                            r4.setEllipsizeType("end");
                            r4.setDividerHeight(com.tencent.mm.cb.a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                            r4.setTag(R.id.pj, Integer.valueOf(appBrandMultiOptionsPicker.ozr.getChildCount()));
                            appBrandMultiOptionsPicker.ozr.addView(r4, new LinearLayout.LayoutParams(0, -1, 1.0f));
                            length--;
                        }
                    }
                } else if (pickersCount > aVarArr.length) {
                    appBrandMultiOptionsPicker.Au(pickersCount - aVarArr.length);
                }
                for (int i2 = 0; i2 < aVarArr.length; i2++) {
                    AppBrandOptionsPickerV2 At = appBrandMultiOptionsPicker.At(i2);
                    AppBrandMultiOptionsPicker.a aVar = aVarArr[i2];
                    At.setOptionsArray(aVar.ozw);
                    At.setValue(aVar.selected);
                    At.setOnValueChangedListener(appBrandMultiOptionsPicker.ozu);
                }
                appBrandMultiOptionsPicker.ozr.setWeightSum((float) appBrandMultiOptionsPicker.getPickersCount());
                appBrandMultiOptionsPicker.setLayoutFrozen(false);
            }
            this.oza.setOnResultListener(new c.a<int[]>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
                public final /* synthetic */ void a(boolean z, int[] iArr) {
                    AppMethodBeat.i(193682);
                    int[] iArr2 = iArr;
                    b.this.oza.hide();
                    if (!z) {
                        b.this.q("fail cancel", null);
                        AppMethodBeat.o(193682);
                    } else if (iArr2 == null || iArr2.length <= 0) {
                        b.this.q("fail error result", null);
                        AppMethodBeat.o(193682);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 : iArr2) {
                            jSONArray.put(i2);
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("current", jSONArray);
                        b.this.q("ok", hashMap);
                        AppMethodBeat.o(193682);
                    }
                }
            });
            this.oza.setOnValueUpdateListener(new c.b<int[]>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.r.g.b.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.b
                public final /* synthetic */ void cH(int[] iArr) {
                    AppMethodBeat.i(193683);
                    int[] iArr2 = iArr;
                    int i2 = iArr2[0];
                    int i3 = iArr2[1];
                    a aVar = new a((byte) 0);
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("column", Integer.valueOf(i2));
                    hashMap.put("current", Integer.valueOf(i3));
                    aVar.L(hashMap);
                    b.this.b(aVar);
                    AppMethodBeat.o(193683);
                }
            });
            this.oza.show();
            AppMethodBeat.o(193686);
        }
    }

    static final class a extends bc {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a
    public final void b(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137590);
        if (this.mmD) {
            new c(this, (byte) 0).a(this, hVar, jSONObject, i2, this.mmD);
            AppMethodBeat.o(137590);
            return;
        }
        new b(this, (byte) 0).a(this, hVar, jSONObject, i2, this.mmD);
        AppMethodBeat.o(137590);
    }

    static /* synthetic */ AppBrandMultiOptionsPickerV2.a a(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(137592);
        String[] strArr = new String[jSONArray.length()];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = jSONArray.getString(i3);
        }
        AppBrandMultiOptionsPickerV2.a aVar = new AppBrandMultiOptionsPickerV2.a(strArr, i2);
        AppMethodBeat.o(137592);
        return aVar;
    }

    static /* synthetic */ AppBrandMultiOptionsPicker.a b(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(193688);
        String[] strArr = new String[jSONArray.length()];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = jSONArray.getString(i3);
        }
        AppBrandMultiOptionsPicker.a aVar = new AppBrandMultiOptionsPicker.a(strArr, i2);
        AppMethodBeat.o(193688);
        return aVar;
    }
}
