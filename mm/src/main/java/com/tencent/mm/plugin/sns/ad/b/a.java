package com.tencent.mm.plugin.sns.ad.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a {
    public static synchronized String eWC() {
        String nullAsNil;
        int i2 = 0;
        synchronized (a.class) {
            AppMethodBeat.i(192739);
            C1702a aVar = new C1702a();
            long currentTimeMillis = System.currentTimeMillis();
            if (com.tencent.mm.plugin.sns.ad.i.a.eYf()) {
                aVar.Dsg = f.aoK();
            }
            if (com.tencent.mm.plugin.sns.ad.i.a.eYg()) {
                aVar.Dsh = f.eYj();
                aVar.dGL = f.getDeviceId();
                aVar.Dsi = f.getDeviceId(0);
                aVar.Dsj = f.getDeviceId(1);
                aVar.imei = f.aoz();
                aVar.Dsk = f.XT(0);
                aVar.Dsl = f.XT(1);
                aVar.Dsm = f.eYi();
                aVar.Dsn = f.XU(0);
                aVar.Dso = f.XU(1);
                aVar.Dsp = f.aoA();
            }
            if (com.tencent.mm.plugin.sns.ad.i.a.eYh()) {
                aVar.uuid = f.eYl();
            }
            if (com.tencent.mm.plugin.sns.ad.i.a.eYe()) {
                aVar.androidId = f.getAndroidId();
            }
            Log.d("AdDeviceInfo", "genAllDeviceInfo, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
            nullAsNil = Util.nullAsNil(aVar.eWF());
            StringBuilder sb = new StringBuilder("getAllDeviceInfo, len = ");
            if (nullAsNil != null) {
                i2 = nullAsNil.length();
            }
            Log.i("AdDeviceInfo", sb.append(i2).toString());
            AppMethodBeat.o(192739);
        }
        return nullAsNil;
    }

    public static synchronized String eWD() {
        String eYl;
        synchronized (a.class) {
            AppMethodBeat.i(192740);
            eYl = f.eYl();
            AppMethodBeat.o(192740);
        }
        return eYl;
    }

    public static String aoK() {
        AppMethodBeat.i(192741);
        String str = "";
        if (com.tencent.mm.plugin.sns.ad.i.a.eYf()) {
            str = f.aoK();
        }
        AppMethodBeat.o(192741);
        return str;
    }

    public static String eWE() {
        AppMethodBeat.i(192742);
        String str = "";
        if (com.tencent.mm.plugin.sns.ad.i.a.eYg()) {
            str = f.eYj();
        }
        AppMethodBeat.o(192742);
        return str;
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.b.a$a  reason: collision with other inner class name */
    public static final class C1702a {
        String Dsg;
        String Dsh;
        String Dsi;
        String Dsj;
        String Dsk;
        String Dsl;
        String Dsm;
        String Dsn;
        String Dso;
        String Dsp;
        String androidId;
        String dGL;
        String imei;
        String uuid;

        /* access modifiers changed from: package-private */
        public final String eWF() {
            AppMethodBeat.i(192738);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                if (!Util.isNullOrNil(this.Dsg)) {
                    jSONObject.put("oaid", this.Dsg);
                }
                if (!Util.isNullOrNil(this.Dsh)) {
                    jSONObject.put("imeiWx", this.Dsh);
                }
                if (!Util.isNullOrNil(this.dGL)) {
                    jSONObject.put("deviceId", this.dGL);
                }
                if (!Util.isNullOrNil(this.Dsi)) {
                    jSONObject.put("deviceId0", this.Dsi);
                }
                if (!Util.isNullOrNil(this.Dsj)) {
                    jSONObject.put("deviceId1", this.Dsj);
                }
                if (!Util.isNullOrNil(this.imei)) {
                    jSONObject.put("imei", this.imei);
                }
                if (!Util.isNullOrNil(this.Dsk)) {
                    jSONObject.put("imei0", this.Dsk);
                }
                if (!Util.isNullOrNil(this.Dsl)) {
                    jSONObject.put("imei1", this.Dsl);
                }
                if (!Util.isNullOrNil(this.Dsm)) {
                    jSONObject.put("meid", this.Dsm);
                }
                if (!Util.isNullOrNil(this.Dsn)) {
                    jSONObject.put("meid0", this.Dsn);
                }
                if (!Util.isNullOrNil(this.Dso)) {
                    jSONObject.put("meid1", this.Dso);
                }
                if (!Util.isNullOrNil(this.Dsp)) {
                    jSONObject.put("subscriberId", this.Dsp);
                }
                if (!Util.isNullOrNil(this.uuid)) {
                    jSONObject.put("uuid", this.uuid);
                }
                if (!Util.isNullOrNil(this.androidId)) {
                    jSONObject.put("androidId", this.androidId);
                }
                String jSONObject2 = jSONObject.toString();
                Log.d("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (System.currentTimeMillis() - currentTimeMillis) + ", ret = " + jSONObject2);
                AppMethodBeat.o(192738);
                return jSONObject2;
            } catch (Throwable th) {
                Log.e("AdDeviceInfo", th.toString());
                AppMethodBeat.o(192738);
                return "";
            }
        }
    }
}
