package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.widget.NumberPicker;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class b extends e {
    private volatile a mmF;
    private volatile Long mmG = null;
    private volatile Long mmH = null;
    private volatile int mmI = -1;
    private volatile int mmJ = -1;
    private volatile int mmK = -1;

    b() {
    }

    /* access modifiers changed from: package-private */
    public enum a {
        YEAR(new SimpleDateFormat("yyyy", Locale.US)),
        MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
        DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
        
        final DateFormat mmP;

        public static a valueOf(String str) {
            AppMethodBeat.i(137571);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(137571);
            return aVar;
        }

        static {
            AppMethodBeat.i(137574);
            AppMethodBeat.o(137574);
        }

        private a(DateFormat dateFormat) {
            this.mmP = dateFormat;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0035, code lost:
            if (r2.equals("year") != false) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.tencent.mm.plugin.appbrand.jsapi.r.b.a aaD(java.lang.String r5) {
            /*
            // Method dump skipped, instructions count: 120
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.r.b.a.aaD(java.lang.String):com.tencent.mm.plugin.appbrand.jsapi.r.b$a");
        }

        /* access modifiers changed from: package-private */
        public final Date parse(String str) {
            AppMethodBeat.i(137573);
            try {
                Date parse = this.mmP.parse(str);
                AppMethodBeat.o(137573);
                return parse;
            } catch (Exception e2) {
                AppMethodBeat.o(137573);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ac(JSONObject jSONObject) {
        AppMethodBeat.i(137575);
        super.ac(jSONObject);
        AppMethodBeat.o(137575);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ad(JSONObject jSONObject) {
        AppMethodBeat.i(137576);
        this.mmF = a.aaD(jSONObject.optString(GraphRequest.FIELDS_PARAM));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            Date parse = this.mmF.parse(optJSONObject.optString("start", ""));
            Date parse2 = this.mmF.parse(optJSONObject.optString("end", ""));
            if (parse != null) {
                this.mmG = Long.valueOf(parse.getTime());
            }
            if (parse2 != null) {
                this.mmH = Long.valueOf(parse2.getTime());
            }
        }
        if (this.mmG == null) {
            Calendar instance = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
            instance.set(1900, 0, 1);
            this.mmG = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.mmH == null) {
            Calendar instance2 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
            instance2.set(2100, 11, 31);
            this.mmH = Long.valueOf(instance2.getTimeInMillis());
        }
        Date parse3 = this.mmF.parse(jSONObject.optString("current", ""));
        if (parse3 == null) {
            Date date = new Date(System.currentTimeMillis());
            parse3 = new Date(this.mmH.longValue());
            Date date2 = new Date(this.mmG.longValue());
            if (!date.after(parse3)) {
                if (date.before(date2)) {
                    parse3 = date2;
                } else {
                    parse3 = date;
                }
            }
        }
        this.mmI = parse3.getYear() + 1900;
        this.mmJ = parse3.getMonth() + 1;
        this.mmK = parse3.getDate();
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(137566);
                b.a(b.this);
                AppMethodBeat.o(137566);
            }
        });
        AppMethodBeat.o(137576);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.e
    public final void ae(JSONObject jSONObject) {
        AppMethodBeat.i(137577);
        this.mmF = a.aaD(jSONObject.optString(GraphRequest.FIELDS_PARAM));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            Date parse = this.mmF.parse(optJSONObject.optString("start", ""));
            Date parse2 = this.mmF.parse(optJSONObject.optString("end", ""));
            if (parse != null) {
                this.mmG = Long.valueOf(parse.getTime());
            }
            if (parse2 != null) {
                this.mmH = Long.valueOf(parse2.getTime());
            }
        }
        if (this.mmG == null) {
            Calendar instance = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
            instance.set(1900, 0, 1);
            this.mmG = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.mmH == null) {
            Calendar instance2 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
            instance2.set(2100, 11, 31);
            this.mmH = Long.valueOf(instance2.getTimeInMillis());
        }
        Date parse3 = this.mmF.parse(jSONObject.optString("current", ""));
        if (parse3 == null) {
            Date date = new Date(System.currentTimeMillis());
            parse3 = new Date(this.mmH.longValue());
            Date date2 = new Date(this.mmG.longValue());
            if (!date.after(parse3)) {
                if (date.before(date2)) {
                    parse3 = date2;
                } else {
                    parse3 = date;
                }
            }
        }
        this.mmI = parse3.getYear() + 1900;
        this.mmJ = parse3.getMonth() + 1;
        this.mmK = parse3.getDate();
        P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(137567);
                b.b(b.this);
                AppMethodBeat.o(137567);
            }
        });
        AppMethodBeat.o(137577);
    }

    static /* synthetic */ void a(b bVar) {
        boolean z;
        int i2;
        boolean z2 = true;
        int i3 = 0;
        AppMethodBeat.i(193678);
        AppBrandDatePicker appBrandDatePicker = (AppBrandDatePicker) bVar.aK(AppBrandDatePicker.class);
        if (appBrandDatePicker == null) {
            bVar.q("fail cant init view", null);
            AppMethodBeat.o(193678);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.picker.a aVar = bVar.oza;
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.b.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* bridge */ /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137569);
                b.a(b.this, z, str);
                AppMethodBeat.o(137569);
            }
        });
        if (bVar.mmG != null) {
            appBrandDatePicker.setMinDate(bVar.mmG.longValue());
        }
        if (bVar.mmH != null) {
            appBrandDatePicker.setMaxDate(bVar.mmH.longValue());
        }
        appBrandDatePicker.a(bVar.mmI, bVar.mmJ, bVar.mmK, null);
        boolean z3 = bVar.mmF.ordinal() >= a.YEAR.ordinal();
        if (bVar.mmF.ordinal() >= a.MONTH.ordinal()) {
            z = true;
        } else {
            z = false;
        }
        if (bVar.mmF.ordinal() < a.DAY.ordinal()) {
            z2 = false;
        }
        appBrandDatePicker.ozb = z3;
        appBrandDatePicker.ozc = z;
        appBrandDatePicker.ozd = z2;
        if (appBrandDatePicker.oze != null) {
            appBrandDatePicker.oze.setEnabled(z3);
            appBrandDatePicker.oze.setVisibility(z3 ? 0 : 8);
        }
        if (appBrandDatePicker.ozf != null) {
            appBrandDatePicker.ozf.setEnabled(z);
            NumberPicker numberPicker = appBrandDatePicker.ozf;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            numberPicker.setVisibility(i2);
        }
        if (appBrandDatePicker.ozg != null) {
            appBrandDatePicker.ozg.setEnabled(z2);
            NumberPicker numberPicker2 = appBrandDatePicker.ozg;
            if (!z2) {
                i3 = 8;
            }
            numberPicker2.setVisibility(i3);
        }
        aVar.show();
        AppMethodBeat.o(193678);
    }

    static /* synthetic */ void b(b bVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(193679);
        AppBrandDatePickerV2 appBrandDatePickerV2 = (AppBrandDatePickerV2) bVar.aK(AppBrandDatePickerV2.class);
        if (appBrandDatePickerV2 == null) {
            bVar.q("fail cant init view", null);
            AppMethodBeat.o(193679);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.picker.a aVar = bVar.oza;
        aVar.setOnResultListener(new c.a<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.widget.picker.c.a
            public final /* bridge */ /* synthetic */ void a(boolean z, String str) {
                AppMethodBeat.i(137568);
                b.a(b.this, z, str);
                AppMethodBeat.o(137568);
            }
        });
        if (bVar.mmG != null) {
            appBrandDatePickerV2.ozh = new Date(bVar.mmG.longValue());
        }
        if (bVar.mmH != null) {
            appBrandDatePickerV2.ozi = new Date(bVar.mmH.longValue());
        }
        int i2 = bVar.mmI;
        int i3 = bVar.mmJ;
        int i4 = bVar.mmK;
        boolean z3 = bVar.mmF.ordinal() >= a.YEAR.ordinal();
        if (bVar.mmF.ordinal() >= a.MONTH.ordinal()) {
            z = true;
        } else {
            z = false;
        }
        if (bVar.mmF.ordinal() < a.DAY.ordinal()) {
            z2 = false;
        }
        appBrandDatePickerV2.a(i2, i3, i4, z3, z, z2);
        aVar.setHeader(bVar.mmU);
        aVar.show();
        AppMethodBeat.o(193679);
    }

    static /* synthetic */ void a(b bVar, boolean z, String str) {
        AppMethodBeat.i(137578);
        if (bVar.oza != null) {
            if (!z) {
                bVar.q("fail cancel", null);
            }
            if (Util.isNullOrNil(str)) {
                bVar.q("fail", null);
            } else {
                HashMap hashMap = new HashMap(1);
                hashMap.put("value", str);
                bVar.q("ok", hashMap);
            }
            bVar.oza.hide();
        }
        AppMethodBeat.o(137578);
    }
}
