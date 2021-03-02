package com.tencent.matrix.a;

import android.app.Application;
import android.os.Handler;
import android.os.PowerManager;
import com.tencent.c.a.a;
import com.tencent.matrix.a.a.c;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.e.b;

public final class a extends b {
    private final c cQf;
    private boolean cQg;

    @Override // com.tencent.matrix.e.b
    public final void init(Application application, com.tencent.matrix.e.c cVar) {
        super.init(application, cVar);
    }

    @Override // com.tencent.matrix.e.b
    public final synchronized void start() {
        if (!isPluginStarted() && !this.cQg) {
            super.start();
            c cVar = this.cQf;
            com.tencent.matrix.a.c.b bVar = cVar.cQH;
            if (!bVar.started) {
                bVar.cUa = new Handler(com.tencent.matrix.g.b.TP().getLooper());
                bVar.started = true;
            }
            com.tencent.matrix.a.a.b bVar2 = cVar.cQG;
            if (bVar2 == null) {
                throw new RuntimeException("batteryConfig is null");
            }
            if (bVar2.RR()) {
                cVar.cQJ = new d(cVar, bVar2, new d.a() {
                    /* class com.tencent.matrix.a.a.c.AnonymousClass3 */

                    @Override // com.tencent.matrix.a.a.d.a
                    public final void d(Runnable runnable, long j2) {
                        c.this.cQH.cUa.postDelayed(runnable, j2);
                    }

                    @Override // com.tencent.matrix.a.a.d.a
                    public final boolean isScreenOn() {
                        return ((PowerManager) c.this.mContext.getSystemService("power")).isScreenOn();
                    }
                });
                com.tencent.matrix.a.c.d.a(cVar);
            }
            if (bVar2.cQF.get(a.EnumC0131a.clicfg_matrix_battery_detect_alarm_enable.name(), true)) {
                cVar.cQK = new com.tencent.matrix.a.a.a(cVar, cVar.cQG);
                cVar.cQH.q(new Runnable() {
                    /* class com.tencent.matrix.a.a.c.AnonymousClass4 */

                    public final void run() {
                        c.this.cQK.RO();
                    }
                });
                com.tencent.matrix.a.c.a.a(cVar);
            } else {
                com.tencent.matrix.g.c.i("Matrix.battery.detector", "isDetectAlarm == false", new Object[0]);
            }
            synchronized (cVar) {
                cVar.mIsStart = true;
            }
        }
    }

    @Override // com.tencent.matrix.e.b
    public final synchronized void stop() {
        this.cQg = false;
        if (isPluginStarted()) {
            super.stop();
            c cVar = this.cQf;
            synchronized (cVar) {
                cVar.mIsStart = false;
            }
            com.tencent.matrix.a.c.d.b(cVar);
            com.tencent.matrix.a.c.a.b(cVar);
            com.tencent.matrix.a.c.b bVar = cVar.cQH;
            if (bVar.started) {
                bVar.cUa.removeCallbacksAndMessages(null);
                bVar.started = false;
            }
            cVar.cQJ = null;
        }
    }

    @Override // com.tencent.matrix.e.b
    public final void destroy() {
        super.destroy();
    }

    @Override // com.tencent.matrix.e.b
    public final String getTag() {
        return "BatteryDetectorPlugin";
    }

    @Override // com.tencent.matrix.e.b, com.tencent.matrix.b.c
    public final synchronized void onForeground(boolean z) {
        com.tencent.matrix.g.c.i("Matrix.battery.BatteryDetectorPlugin", "onForeground:".concat(String.valueOf(z)), new Object[0]);
        super.onForeground(z);
        c cVar = this.cQf;
        if (cVar.cQK != null) {
            cVar.cQK.cQp = z;
        }
    }
}
