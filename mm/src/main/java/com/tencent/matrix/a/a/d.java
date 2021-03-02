package com.tencent.matrix.a.a;

import android.os.Environment;
import android.os.SystemClock;
import com.tencent.c.a.a;
import com.tencent.matrix.report.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends com.tencent.matrix.report.d {
    final Map<String, C0203d> cQY = new HashMap();
    final Map<String, c> cQZ = new HashMap();
    final int cRa;
    private final int cRb;
    private final int cRc;
    final a cRd;
    final Runnable cRe;
    final e cRf;

    public interface a {
        void d(Runnable runnable, long j2);

        boolean isScreenOn();
    }

    public d(d.a aVar, b bVar, a aVar2) {
        super(aVar);
        this.cRa = bVar.cQF.get(a.EnumC0131a.clicfg_matrix_battery_wake_lock_hold_time_threshold.name(), 120000);
        this.cRb = bVar.cQF.get(a.EnumC0131a.clicfg_matrix_battery_wake_lock_1h_hold_time_threshold.name(), 600000);
        this.cRc = bVar.cQF.get(a.EnumC0131a.clicfg_matrix_battery_wake_lock_1h_acquire_cnt_threshold.name(), 20);
        this.cRd = aVar2;
        this.cRe = new Runnable() {
            /* class com.tencent.matrix.a.a.d.AnonymousClass1 */

            public final void run() {
                for (Map.Entry<String, c> entry : d.this.cQZ.entrySet()) {
                    entry.getValue().RX();
                }
                d.this.RU();
            }
        };
        if (bVar.RS()) {
            this.cRf = new e();
        } else {
            this.cRf = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void RU() {
        RV();
        RW();
    }

    private void RV() {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (Map.Entry<String, C0203d> entry : this.cQY.entrySet()) {
            C0203d value = entry.getValue();
            if (uptimeMillis - value.cRt >= ((long) this.cRa)) {
                String format = String.format("%s:%d", value.tag, 1);
                if (eC(format)) {
                    com.tencent.matrix.g.c.v("Matrix.detector.WakeLock", "detectWakeLockOnceHoldTime issue already published: %s", format);
                } else {
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c(1);
                    cVar.key = format;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("subTag", "wakeLock");
                        jSONObject.put("wakeLockTag", value.tag);
                        jSONObject.put("flags", value.flags);
                        jSONObject.put("holdTime", uptimeMillis - value.cRt);
                        jSONObject.put("stackHistory", value.cRn);
                    } catch (JSONException e2) {
                        com.tencent.matrix.g.c.e("Matrix.detector.WakeLock", "json content error: %s", e2);
                    }
                    com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "detected lock once too long, token:%s, tag:%s", value.cRr, value.tag);
                    cVar.cWe = jSONObject;
                    b(cVar);
                    eB(format);
                }
            }
        }
    }

    private void RW() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, c> entry : this.cQZ.entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            long j2 = currentTimeMillis - value.cRi;
            int i2 = ((int) (j2 / Util.MILLSECONDS_OF_HOUR)) + 1;
            if (i2 <= 0) {
                i2 = 1;
            }
            int i3 = value.cRm / i2;
            long j3 = value.cRk / ((long) i2);
            if (i3 > this.cRc / 2) {
                String format = String.format("%s:%d", key, 2);
                if (eC(format)) {
                    com.tencent.matrix.g.c.v("Matrix.detector.WakeLock", "detectWakeLockAggregation issue already published: %s", format);
                } else {
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c(2);
                    cVar.key = format;
                    cVar.cWe = a(value, j2);
                    b(cVar);
                    eB(format);
                }
            }
            if (j3 >= ((long) this.cRb)) {
                String format2 = String.format("%s:%d", key, 3);
                if (eC(format2)) {
                    com.tencent.matrix.g.c.v("Matrix.detector.WakeLock", "detectWakeLockAggregation issue already published: %s", format2);
                } else {
                    com.tencent.matrix.report.c cVar2 = new com.tencent.matrix.report.c(3);
                    cVar2.key = format2;
                    cVar2.cWe = a(value, j2);
                    b(cVar2);
                    eB(format2);
                }
            }
        }
    }

    private static JSONObject a(c cVar, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wakeLockTag", cVar.tag);
            jSONObject.put("subTag", "wakeLock");
            jSONObject.put("timeFrame", j2);
            jSONObject.put("acquireCnt", cVar.cRl);
            jSONObject.put("acquireCntWhenScreenOff", cVar.cRm);
            jSONObject.put("statisticalHoldTime", cVar.cRj);
            jSONObject.put("stackHistory", cVar.cRn);
        } catch (JSONException e2) {
            com.tencent.matrix.g.c.e("Matrix.detector.WakeLock", "json content error: %s", e2);
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.matrix.a.a.d$d  reason: collision with other inner class name */
    public static final class C0203d {
        b cRn = new b();
        final String cRr;
        final long cRs;
        final long cRt = SystemClock.uptimeMillis();
        final int flags;
        final String tag;

        C0203d(String str, String str2, int i2, long j2) {
            this.cRr = str;
            this.tag = str2;
            this.flags = i2;
            this.cRs = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        final long cRi = System.currentTimeMillis();
        long cRj = 0;
        long cRk = 0;
        int cRl = 0;
        int cRm = 0;
        b cRn = new b();
        final Map<String, Boolean> cRo = new HashMap();
        long cRp = -1;
        boolean cRq;
        final String tag;

        c(String str) {
            this.tag = str;
        }

        /* access modifiers changed from: package-private */
        public final void RX() {
            if (this.cRp >= 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.cRj += uptimeMillis - this.cRp;
                if (!this.cRq) {
                    this.cRk += uptimeMillis - this.cRp;
                }
                this.cRp = uptimeMillis;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        final Vector<String> cRh = new Vector<>();

        b() {
        }

        /* access modifiers changed from: package-private */
        public final void ek(String str) {
            this.cRh.add(str);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.cRh.size(); i2++) {
                sb.append(this.cRh.get(i2)).append("\t\t");
            }
            return sb.toString();
        }
    }

    static final class e {
        private final String cQv = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.c.getPackageName(), com.tencent.matrix.g.d.formatTime("yyyy-MM-dd", System.currentTimeMillis()));
        int cRu;
        final StringBuilder cRv = new StringBuilder();

        e() {
            com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "WakeLockInfoRecorder path:%s", this.cQv);
        }

        /* access modifiers changed from: package-private */
        public final void RY() {
            if (this.cRu >= 10) {
                RZ();
                this.cRu = 0;
                this.cRv.delete(0, this.cRv.length());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[SYNTHETIC, Splitter:B:18:0x0066] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0082 A[SYNTHETIC, Splitter:B:24:0x0082] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008b A[SYNTHETIC, Splitter:B:29:0x008b] */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A[Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x006c }, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A[Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x006c }, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void RZ() {
            /*
            // Method dump skipped, instructions count: 154
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.a.d.e.RZ():void");
        }
    }
}
