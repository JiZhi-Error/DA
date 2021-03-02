package com.tencent.mm.plugin.expt.d.h.b;

import android.os.SystemClock;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a implements b {
    @Override // com.eclipsesource.v8.JavaCallback
    public Object invoke(V8Object v8Object, V8Array v8Array) {
        Object obj;
        if (v8Array == null) {
            return null;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Object b2 = b(v8Array);
            try {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                int type = getType();
                if (uptimeMillis2 <= 10) {
                    h.INSTANCE.idkeyStat(1409, 26, 1, false);
                } else if (uptimeMillis2 <= 100) {
                    h.INSTANCE.idkeyStat(1409, 27, 1, false);
                } else if (uptimeMillis2 <= 1000) {
                    h.INSTANCE.idkeyStat(1409, 28, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(1409, 29, 1, false);
                    if (com.tencent.mm.plugin.expt.d.f.a.syv == null) {
                        com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_edge_computing_is_monitor_performance, false));
                        Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
                    }
                    if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
                        h.INSTANCE.a(20176, "", 5, Long.valueOf(uptimeMillis2), Integer.valueOf(type));
                    }
                }
                Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime configID : %s, costTime : %d, type : %d", 0, Long.valueOf(uptimeMillis2), Integer.valueOf(type));
                return b2;
            } catch (Exception e2) {
                e = e2;
                obj = b2;
                Log.e("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke throw Exception e : " + e.getMessage());
                return obj;
            }
        } catch (Exception e3) {
            e = e3;
            obj = null;
            Log.e("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke throw Exception e : " + e.getMessage());
            return obj;
        }
    }
}
