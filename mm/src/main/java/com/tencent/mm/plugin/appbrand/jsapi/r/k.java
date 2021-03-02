package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class k extends e {
    private int mMaxTimeHour = Integer.MAX_VALUE;
    private int mMaxTimeMinute = Integer.MAX_VALUE;
    private int mMinTimeHour = -1;
    private int mMinTimeMinute = -1;
    private int mnn = -1;
    private int mno = -1;

    k() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ac(JSONObject jSONObject) {
        AppMethodBeat.i(137619);
        super.ac(jSONObject);
        AppMethodBeat.o(137619);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ad(JSONObject jSONObject) {
        AppMethodBeat.i(137620);
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] agg = e.agg(optString);
            if (agg != null) {
                this.mMinTimeHour = agg[0];
                this.mMinTimeMinute = agg[1];
            }
            int[] agg2 = e.agg(optString2);
            if (agg2 != null) {
                this.mMaxTimeHour = agg2[0];
                this.mMaxTimeMinute = agg2[1];
            }
        }
        this.mMinTimeHour = Math.max(this.mMinTimeHour, 0);
        this.mMinTimeMinute = Math.max(this.mMinTimeMinute, 0);
        this.mMaxTimeHour = Math.min(this.mMaxTimeHour, 23);
        this.mMaxTimeMinute = Math.min(this.mMaxTimeMinute, 59);
        int[] agg3 = e.agg(jSONObject.optString("current"));
        if (agg3 != null) {
            this.mnn = agg3[0];
            this.mno = agg3[1];
        }
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(137615);
                k.a(k.this);
                AppMethodBeat.o(137615);
            }
        });
        AppMethodBeat.o(137620);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ae(JSONObject jSONObject) {
        AppMethodBeat.i(137621);
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] agg = e.agg(optString);
            if (agg != null) {
                this.mMinTimeHour = agg[0];
                this.mMinTimeMinute = agg[1];
            }
            int[] agg2 = e.agg(optString2);
            if (agg2 != null) {
                this.mMaxTimeHour = agg2[0];
                this.mMaxTimeMinute = agg2[1];
            }
        }
        this.mMinTimeHour = Math.max(this.mMinTimeHour, 0);
        this.mMinTimeMinute = Math.max(this.mMinTimeMinute, 0);
        this.mMaxTimeHour = Math.min(this.mMaxTimeHour, 23);
        this.mMaxTimeMinute = Math.min(this.mMaxTimeMinute, 59);
        int[] agg3 = e.agg(jSONObject.optString("current"));
        if (agg3 != null) {
            this.mnn = agg3[0];
            this.mno = agg3[1];
        }
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.k.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(137616);
                k.b(k.this);
                AppMethodBeat.o(137616);
            }
        });
        AppMethodBeat.o(137621);
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(193693);
        AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) kVar.aK(AppBrandTimePicker.class);
        if (appBrandTimePicker == null) {
            kVar.q("fail cant init view", null);
            AppMethodBeat.o(193693);
            return;
        }
        a aVar = kVar.oza;
        int i2 = kVar.mMinTimeHour;
        int i3 = kVar.mMinTimeMinute;
        appBrandTimePicker.mMinTimeHour = i2;
        appBrandTimePicker.mMinTimeMinute = i3;
        if (e.Ax(appBrandTimePicker.mMinTimeHour) && appBrandTimePicker.ozT != null) {
            appBrandTimePicker.ozT.setMinValue(appBrandTimePicker.mMinTimeHour);
        }
        int i4 = kVar.mMaxTimeHour;
        int i5 = kVar.mMaxTimeMinute;
        appBrandTimePicker.mMaxTimeHour = i4;
        appBrandTimePicker.mMaxTimeMinute = i5;
        if (e.Ax(appBrandTimePicker.mMaxTimeHour) && appBrandTimePicker.ozT != null) {
            appBrandTimePicker.ozT.setMaxValue(appBrandTimePicker.mMaxTimeHour);
        }
        int i6 = kVar.mnn;
        int i7 = kVar.mno;
        if (e.Ax(i6) && e.Aw(i7)) {
            appBrandTimePicker.setCurrentHour(Integer.valueOf(i6));
            appBrandTimePicker.setCurrentMinute(Integer.valueOf(i7));
        }
        appBrandTimePicker.dgV();
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.k.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* bridge */ /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137617);
                k.a(k.this, z, str);
                AppMethodBeat.o(137617);
            }
        });
        aVar.show();
        AppMethodBeat.o(193693);
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(193694);
        AppBrandTimePickerV2 appBrandTimePickerV2 = (AppBrandTimePickerV2) kVar.aK(AppBrandTimePickerV2.class);
        if (appBrandTimePickerV2 == null) {
            kVar.q("fail cant init view", null);
            AppMethodBeat.o(193694);
            return;
        }
        a aVar = kVar.oza;
        appBrandTimePickerV2.setMinTime(kVar.mMinTimeHour, kVar.mMinTimeMinute);
        appBrandTimePickerV2.setMaxTime(kVar.mMaxTimeHour, kVar.mMaxTimeMinute);
        appBrandTimePickerV2.init(kVar.mnn, kVar.mno);
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.k.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* bridge */ /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137618);
                k.a(k.this, z, str);
                AppMethodBeat.o(137618);
            }
        });
        aVar.setHeader(kVar.mmU);
        aVar.show();
        AppMethodBeat.o(193694);
    }

    static /* synthetic */ void a(k kVar, boolean z, String str) {
        AppMethodBeat.i(137622);
        if (kVar.oza != null) {
            kVar.oza.hide();
        }
        if (!z) {
            kVar.q("fail cancel", null);
            AppMethodBeat.o(137622);
        } else if (Util.isNullOrNil(str)) {
            kVar.q("fail", null);
            AppMethodBeat.o(137622);
        } else {
            HashMap hashMap = new HashMap(1);
            hashMap.put("value", str);
            kVar.q("ok", hashMap);
            AppMethodBeat.o(137622);
        }
    }
}
