package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static volatile a lMc = null;
    public static boolean lMf = false;
    public static boolean lMg = true;
    public static boolean lMi = true;
    public static boolean lMk = false;
    public static int lMl = 5;
    public static boolean lMp = true;
    public boolean aXs;
    public int gTn;
    public boolean lMd;
    public long lMe;
    public boolean lMh;
    public boolean lMj;
    public String lMm;
    public int lMn;
    public boolean lMo;
    public boolean lMq;

    static {
        AppMethodBeat.i(144530);
        AppMethodBeat.o(144530);
    }

    public static synchronized a bFm() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(215146);
            if (lMc == null) {
                lMc = new C0651a().bFn();
            }
            aVar = lMc;
            AppMethodBeat.o(215146);
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            lMc = aVar;
        }
    }

    public a(C0651a aVar) {
        this.gTn = aVar.gTn;
        this.lMd = aVar.lMd;
        this.lMe = aVar.lMe;
        this.aXs = aVar.aXs;
        this.lMh = aVar.lMh;
        this.lMj = aVar.lMj;
        this.lMm = aVar.lMm;
        this.lMn = aVar.lMn;
        this.lMo = aVar.lMo;
        this.lMq = aVar.lMq;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a$a  reason: collision with other inner class name */
    public static class C0651a {
        public boolean aXs = a.lMf;
        public int gTn = 0;
        public boolean lMd = false;
        long lMe = 20000;
        public boolean lMh = a.lMg;
        public boolean lMj = a.lMi;
        public String lMm = FirebaseAnalytics.b.MEDIUM;
        public int lMn = 10;
        public boolean lMo = true;
        public boolean lMq = true;

        public final a bFn() {
            AppMethodBeat.i(144528);
            a aVar = new a(this);
            AppMethodBeat.o(144528);
            return aVar;
        }
    }

    public final String toString() {
        AppMethodBeat.i(144529);
        String str = "BleConfig{interval=" + this.gTn + ", allowDuplicatesKey=" + this.lMd + ", actionTimeOutTime=" + this.lMe + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + ", mode='" + this.lMm + '\'' + ", actionDelayTime=" + this.lMn + ", parseScanRecordManual=" + this.lMq + '}';
        AppMethodBeat.o(144529);
        return str;
    }
}
